package com.btanabe.fsdu.test.integration.collectors;

import com.btanabe.fsdu.collectors.RecordCollector;
import com.btanabe.fsdu.models.EspnNbaProjectionModel;
import com.btanabe.fsdu.web.WebRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * XXX You must specify a larger-than-default thread heap size.  In it's current form this is
 * stable at -Xss40m but I haven't done testing to see what's optimal.  Alternatively I can
 * try to find a more memory efficient Regex implementation than the standard Java one.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnProjectionsPageRecordCollectorTests {

    @Autowired
    @Qualifier("espnNbaProjectionPageRecordCollector")
    private RecordCollector nbaProjectionPageRecordCollector;

    @Autowired
    @Qualifier("mockEspnNbaProjectionsPageWebRequest")
    private WebRequest mockWebRequest;

    @Autowired
    @Qualifier("kyrieIrvingEspnProjectionModel")
    private EspnNbaProjectionModel expectedKyrieIrvingRecord;

    @Autowired
    @Qualifier("eltonBrandEspnProjectionModel")
    private EspnNbaProjectionModel expectedEltonBrandRecord;

    private Set<EspnNbaProjectionModel> playerProjectionList;

    // Consider moving to TestNG which allows for non-static BeforeClass methods:
    @Before
    public void parseAllNbaRecords() throws Exception {
        if (playerProjectionList == null) {
            nbaProjectionPageRecordCollector.setWebRequest(mockWebRequest);
            playerProjectionList = (Set<EspnNbaProjectionModel>) nbaProjectionPageRecordCollector.apply("http://games.espn.go.com/fba/tools/projections?&leagueId=233928", mockWebRequest);
        }
    }

    @Test
    public void shouldBeAbleToCollectAllAvailableNbaRecords() throws Exception {
        assertThat(playerProjectionList.size(), is(equalTo(621)));
    }

    @Test
    public void shouldBeAbleToProperlyParseTopTwoHundredNbaPlayerProjections() throws Exception {
        EspnNbaProjectionModel collectedKyreeIrvingRecord = playerProjectionList.stream().filter(player -> player.getName().equals(expectedKyrieIrvingRecord.getName())).findFirst().get();
        assertThat(collectedKyreeIrvingRecord, is(not(nullValue())));
        assertThat(collectedKyreeIrvingRecord, is(equalTo(expectedKyrieIrvingRecord)));
    }

    @Test
    public void shouldBeAbleToProperlyParseNonTopTwoHundredNbaPlayerProjections() throws Exception {
        EspnNbaProjectionModel collectedEltonBrandRecord = playerProjectionList.stream().filter(player -> player.getName().equals(expectedEltonBrandRecord.getName())).findFirst().get();
        assertThat(collectedEltonBrandRecord, is(not(nullValue())));
        assertThat(collectedEltonBrandRecord, is(equalTo(collectedEltonBrandRecord)));
    }
}
