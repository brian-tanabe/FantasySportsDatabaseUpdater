package com.btanabe.fsdu.test.integration.collectors;

import com.btanabe.fsdu.collectors.RecordCollector;
import com.btanabe.fsdu.models.EspnFantasyLeaguePlayerOwnershipModel;
import com.btanabe.fsdu.web.WebRequest;
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
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 12/6/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnPlayerRaterPageRecordCollectorTests {

    @Autowired
    @Qualifier("espnNbaPlayerRaterPageRecordCollector")
    private RecordCollector nbaPlayerRaterPageRecordCollector;

    @Autowired
    @Qualifier("mockEspnNbaPlayerRaterPageWebRequest")
    private WebRequest mockWebRequest;

    private List<EspnFantasyLeaguePlayerOwnershipModel> ownershipDataForAllPlayers;

    @Before
    public void collectAllRecords() throws Exception {
        if (ownershipDataForAllPlayers == null) {
            nbaPlayerRaterPageRecordCollector.setWebRequest(mockWebRequest);
            ownershipDataForAllPlayers = nbaPlayerRaterPageRecordCollector.getAllRecordsAsList("http://games.espn.go.com/fba/playerrater?leagueId=233928");
        }
    }

    @Test
    public void shouldBeAbleToFindSixHundredFortyThreePlayers() throws Exception {
        assertThat(ownershipDataForAllPlayers.size(), is(equalTo(643)));
    }
}
