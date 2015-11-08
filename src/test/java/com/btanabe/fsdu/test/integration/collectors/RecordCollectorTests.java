package com.btanabe.fsdu.test.integration.collectors;

import com.btanabe.fsdu.collectors.RecordCollector;
import com.btanabe.fsdu.models.EspnNbaProjectionModel;
import com.btanabe.fsdu.web.WebRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * XXX You must specify a larger-than-default thread heap size.  In it's current form this is
 * stable at -Xss40m but I haven't done testing to see what's optimal.  Alternatively I can
 * try to find a more memory efficient Regex implementation than the standard Java one.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RecordCollectorTests {

    @Autowired
    private RecordCollector espnNbaProjectionPageRecordCollector;

    @Autowired
    @Qualifier("mockEspnNbaProjectionsPageWebRequest")
    private WebRequest mockWebRequest;

    private List<EspnNbaProjectionModel> playerProjectionList;

    // Consider moving to TestNG which allows for non-static BeforeClass methods:
    @Before
    public void parseAllNbaRecords() throws Exception {
        if (playerProjectionList == null) {
            espnNbaProjectionPageRecordCollector.setWebRequest(mockWebRequest);
            playerProjectionList = espnNbaProjectionPageRecordCollector.getAllRecordsAsList("http://games.espn.go.com/fba/tools/projections?&leagueId=233928");
        }
    }

    @Test
    public void shouldBeAbleToCollectAllAvailableNbaRecords() throws Exception {
        Assert.assertThat(playerProjectionList.size(), is(equalTo(621)));
    }

    @Test
    public void shouldBeAbleToProperlyParseTopTwoHundredNbaPlayerProjections() throws Exception {

    }
}
