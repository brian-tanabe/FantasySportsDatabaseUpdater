package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import com.btanabe.fsdu.models.EspnFantasyLeaguePlayerOwnershipModel;
import com.btanabe.fsdu.parsers.ValueExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 12/4/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnPlayerRaterPageValueExtractorTests {

    @Autowired
    @Qualifier("espnNbaHoopDreamsPlayerRaterPageRussellWestbrook")
    private String russellWestbrookPlayerRaterRow;

    @Autowired
    @Qualifier("espnNbaHoopDreamsPlayerRaterPageChristianWood")
    private String christianWoodPlayerRaterRow;

    @Autowired
    @Qualifier("espnProjectionsPlayerIdValueExtractor")
    private ValueExtractor playerIdValueExtractor;

    @Autowired
    @Qualifier("espnPlayerRaterPageLeagueIdValueExtractor")
    private ValueExtractor leagueIdValueExtractor;

    @Autowired
    @Qualifier("espnPlayerRaterPageOwnerTeamNameValueExtractor")
    private ValueExtractor ownerTeamNameValueExtractor;

    @Autowired
    @Qualifier("espnProjectionsNameValueExtractor")
    private ValueExtractor nameValueExtractor;

    @Autowired
    @Qualifier("russellWestbrookOwnedEspnPlayerRaterOwnershipModel")
    private EspnFantasyLeaguePlayerOwnershipModel expectedRussellWestbrookOwnershipModel;

    @Autowired
    @Qualifier("christianWoodUnownedEspnPlayerRaterOwnershipModel")
    private EspnFantasyLeaguePlayerOwnershipModel expectedChristianWoodOwnershipModel;

    @Test
    public void shouldBeAbleToExtractPlayerIdFromPlayerRaterRow() throws Exception {
        assertThat(playerIdValueExtractor.apply(russellWestbrookPlayerRaterRow), is(equalTo(expectedRussellWestbrookOwnershipModel.getEspnPlayerId())));
    }

    @Test
    public void shouldBeAbleToExtractLeagueIdFromPlayerRaterRow() throws Exception {
        assertThat(leagueIdValueExtractor.apply(russellWestbrookPlayerRaterRow), is(equalTo(expectedRussellWestbrookOwnershipModel.getEspnFantasyLeagueId())));
    }

    @Test
    public void shouldBeAbleToExtractFullNameFromPlayerRaterRow() throws Exception {
        assertThat(nameValueExtractor.apply(christianWoodPlayerRaterRow), is(equalTo(expectedChristianWoodOwnershipModel.getPlayerFullName())));
    }

    @Test
    public void shouldBeAbleToExtractOwnerTeamIdFromPlayerRaterRowForPlayersWhichAreOwned() throws Exception {
        assertThat(ownerTeamNameValueExtractor.apply(russellWestbrookPlayerRaterRow), is(equalTo(expectedRussellWestbrookOwnershipModel.getEspnFantasyOwnerTeamName())));
    }

    @Test
    public void shouldBeAbleToExtractOwnerTeamIdFromPlayerRaterRowForPlayersWhichAreNotOwned() throws Exception {
        assertThat(ownerTeamNameValueExtractor.apply(christianWoodPlayerRaterRow), is(equalTo(expectedChristianWoodOwnershipModel.getEspnFantasyOwnerTeamName())));
    }
}
