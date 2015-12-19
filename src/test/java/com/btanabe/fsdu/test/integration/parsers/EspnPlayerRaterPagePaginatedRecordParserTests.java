package com.btanabe.fsdu.test.integration.parsers;

import com.btanabe.fsdu.models.EspnFantasyLeaguePlayerOwnershipModel;
import com.btanabe.fsdu.parsers.PaginatedRecordParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 12/6/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnPlayerRaterPagePaginatedRecordParserTests {

    @Autowired
    @Qualifier("espnNbaPlayerRaterPagePaginatedRecordParser")
    private PaginatedRecordParser<EspnFantasyLeaguePlayerOwnershipModel> playerOwnershipRecordParser;

    @Autowired
    @Qualifier("espnNbaHoopDreamsPlayerRaterPageOne")
    private String playerRaterPageOne;

    @Autowired
    @Qualifier("espnNbaHoopDreamsPlayerRaterPageSeven")
    private String playerRaterPageSeven;

    @Autowired
    @Qualifier("russellWestbrookOwnedEspnPlayerRaterOwnershipModel")
    private EspnFantasyLeaguePlayerOwnershipModel expectedRussellWestbrookOwnershipModel;

    @Autowired
    @Qualifier("christianWoodUnownedEspnPlayerRaterOwnershipModel")
    private EspnFantasyLeaguePlayerOwnershipModel expectedChristianWoodOwnershipModel;

    private List<EspnFantasyLeaguePlayerOwnershipModel> playerOwnershipModelListPageOne;
    private List<EspnFantasyLeaguePlayerOwnershipModel> playerOwnershipModelListPageSeven;

    @Before
    public void parsePlayerRaterPages() throws Exception {
        playerOwnershipModelListPageOne = playerOwnershipRecordParser.getRecordsAsList(playerRaterPageOne);

        playerOwnershipModelListPageSeven = playerOwnershipRecordParser.getRecordsAsList(playerRaterPageSeven);
    }

    @Test
    public void shouldBeAbleToFindFiftyPlayersOnOnePage() throws Exception {
        assertThat(playerOwnershipModelListPageOne.size(), is(equalTo(50)));
        assertThat(playerOwnershipModelListPageSeven.size(), is(equalTo(50)));
    }

    @Test
    public void shouldBeAbleToParseRussellWestbrookProperly() throws Exception {
        assertThat(playerOwnershipModelListPageOne.contains(expectedRussellWestbrookOwnershipModel), is(true));
    }

    @Test
    public void shouldBeAbleToParseChristianWoodProperly() throws Exception {
        assertThat(playerOwnershipModelListPageSeven.contains(expectedChristianWoodOwnershipModel), is(true));
    }

    @Test
    public void shouldBeAbleToPopulateAllModelFieldsForPageOneProperly() throws Exception {
        assertThat(playerOwnershipModelListPageOne.stream().map(EspnFantasyLeaguePlayerOwnershipModel::getEspnPlayerId).collect(Collectors.toSet()).contains(null), is(false));
        assertThat(playerOwnershipModelListPageOne.stream().map(EspnFantasyLeaguePlayerOwnershipModel::getEspnFantasyLeagueId).collect(Collectors.toSet()).contains(null), is(false));
        assertThat(playerOwnershipModelListPageOne.stream().map(EspnFantasyLeaguePlayerOwnershipModel::getEspnFantasyOwnerTeamName).collect(Collectors.toList()).contains(null), is(false));
    }

    @Test
    public void shouldBeAbleToPopulateAllModelFieldsForPageSevenProperly() throws Exception {
        assertThat(playerOwnershipModelListPageSeven.stream().map(EspnFantasyLeaguePlayerOwnershipModel::getEspnPlayerId).collect(Collectors.toSet()).contains(null), is(false));
        assertThat(playerOwnershipModelListPageSeven.stream().map(EspnFantasyLeaguePlayerOwnershipModel::getEspnFantasyLeagueId).collect(Collectors.toSet()).contains(null), is(false));
        assertThat(playerOwnershipModelListPageSeven.stream().map(EspnFantasyLeaguePlayerOwnershipModel::getEspnFantasyOwnerTeamName).collect(Collectors.toList()).contains(null), is(false));
    }
}
