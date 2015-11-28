package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import com.btanabe.fsdu.models.BasketballReferenceSeasonTotalsModel;
import com.btanabe.fsdu.parsers.ValueExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Brian on 11/22/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BasketballReferenceSeasonTotalsValueExtractorTests {

    @Autowired
    @Qualifier("basketballReferenceSeasonTotals20142015QuincyAcy")
    private String quincyAcySeasonTotals;

    @Autowired
    @Qualifier("qunicyAcy20142015SeasonTotalsPlayerModel")
    private BasketballReferenceSeasonTotalsModel expectedQuincyAcyModel;

    @Autowired
    @Qualifier("basketballReferenceNameValueExtractor")
    private ValueExtractor nameValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceTeamNameValueExtractor")
    private ValueExtractor teamNameValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceGamesPlayedValueExtractor")
    private ValueExtractor gamesPlayedValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceGamesStartedValueExtractor")
    private ValueExtractor gamesStartedValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceMinutesPlayedValueExtractor")
    private ValueExtractor minutesPlayedValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceFieldGoalsAttemptedValueExtractor")
    private ValueExtractor fieldGoalsAttemptedValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceFieldGoalsMadeValueExtractor")
    private ValueExtractor fieldGoalsMadeValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceFieldGoalPercentageValueExtractor")
    private ValueExtractor fieldGoalPercentageValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceThreePointersAttemptedValueExtractor")
    private ValueExtractor threePointersAttemptedValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceThreePointersMadeValueExtractor")
    private ValueExtractor threePointersMadeValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceThreePointPercentageValueExtractor")
    private ValueExtractor threePointPercentageValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceTwoPointersAttemptedValueExtractor")
    private ValueExtractor twoPointersAttemptedValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceTwoPointersMadeValueExtractor")
    private ValueExtractor twoPointersMadeValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceTwoPointersPercentageValueExtractor")
    private ValueExtractor twoPointerPercentageValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceEffectiveFieldGoalPercentageValueExtractor")
    private ValueExtractor effectiveFieldGoalPercentageValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceFreeThrowsAttemptedValueExtractor")
    private ValueExtractor freeThrowsAttemptedValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceFreeThrowsMadeValueExtractor")
    private ValueExtractor freeThrowsMadeValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceFreeThrowPercentageValueExtractor")
    private ValueExtractor freeThrowsPercentageValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceOffensiveReboundsValueExtractor")
    private ValueExtractor offensiveReboundsValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceDefensiveReboundsValueExtractor")
    private ValueExtractor defensiveReboundsValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceTotalReboundsValueExtractor")
    private ValueExtractor totalReboundsValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceAssistsValueExtractor")
    private ValueExtractor assistsValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceStealsValueExtractor")
    private ValueExtractor stealsValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceBlocksValueExtractor")
    private ValueExtractor blocksValueExtractor;

    @Autowired
    @Qualifier("basketballReferenceTurnoversValueExtractor")
    private ValueExtractor turnoversValueExtractor;

    @Autowired
    @Qualifier("basketballReferencePersonalFoulsValueExtractor")
    private ValueExtractor personalFoulsValueExtractor;

    @Autowired
    @Qualifier("basketballReferencePointsValueExtractor")
    private ValueExtractor pointsValueExtractor;


    @Test
    public void shouldBeAbleToExtractFullNameFromSeasonsTotalsPage() throws Exception {
        nameValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(nameValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getName())));
    }

    @Test
    public void shouldBeAbleToExtractTeamAbbreviationFromSeasonTotalsPage() throws Exception {
        teamNameValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(teamNameValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToExtractGamesPlayedFromSeasonsTotalsPage() throws Exception {
        gamesPlayedValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(gamesPlayedValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getGamesPlayed())));
    }

    @Test
    public void shouldBeAbleToExtractGamesStartedFromSeasonsTotalsPage() throws Exception {
        gamesStartedValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(gamesStartedValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getGamesStarted())));
    }

    @Test
    public void shouldBeAbleToExtractMinutesPlayedFromSeasonsTotalsPage() throws Exception {
        minutesPlayedValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(minutesPlayedValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getMinutesPlayed())));
    }

    @Test
    public void shouldBeAbleToExtractFieldGoalsAttemptedFromSeasonsTotalsPage() throws Exception {
        fieldGoalsAttemptedValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(fieldGoalsAttemptedValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getFieldGoalsAttempted())));
    }

    @Test
    public void shouldBeAbleToExtractFieldGoalsMadeFromSeasonsTotalsPage() throws Exception {
        fieldGoalsMadeValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(fieldGoalsMadeValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getFieldGoalsMade())));
    }

    @Test
    public void shouldBeAbleToExtractFieldGoalPercentageFromSeasonsTotalsPage() throws Exception {
        fieldGoalPercentageValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(fieldGoalPercentageValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getFieldGoalPercentage())));
    }

    @Test
    public void shouldBeAbleToExtractThreePointersAttemptedFromSeasonsTotalsPage() throws Exception {
        threePointersAttemptedValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(threePointersAttemptedValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getThreePointersAttempted())));
    }

    @Test
    public void shouldBeAbleToExtractThreePointersMadeFromSeasonsTotalsPage() throws Exception {
        threePointersMadeValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(threePointersMadeValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getThreePointersMade())));
    }

    @Test
    public void shouldBeAbleToExtractThreePointPercentageFromSeasonsTotalsPage() throws Exception {
        threePointPercentageValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(threePointPercentageValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getThreePointPercentage())));
    }

    @Test
    public void shouldBeAbleToExtractTwoPointersAttemptedFromSeasonsTotalsPage() throws Exception {
        twoPointersAttemptedValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(twoPointersAttemptedValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getTwoPointersAttempted())));
    }

    @Test
    public void shouldBeAbleToExtractTwoPointersMadeFromSeasonsTotalsPage() throws Exception {
        twoPointersMadeValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(twoPointersMadeValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getTwoPointersMade())));
    }

    @Test
    public void shouldBeAbleToExtractTwoPointersPercentageFromSeasonsTotalsPage() throws Exception {
        twoPointerPercentageValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(twoPointerPercentageValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getTwoPointPercentage())));
    }

    @Test
    public void shouldBeAbleToExtractEffectiveFieldGoalPercentageFromSeasonsTotalsPage() throws Exception {
        effectiveFieldGoalPercentageValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(effectiveFieldGoalPercentageValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getEffectiveFieldGoalPercentage())));
    }

    @Test
    public void shouldBeAbleToExtractFreeThrowsAttemptedFromSeasonsTotalsPage() throws Exception {
        freeThrowsAttemptedValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(freeThrowsAttemptedValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getFreeThrowsAttempted())));
    }

    @Test
    public void shouldBeAbleToExtractFreeThrowsMadeFromSeasonsTotalsPage() throws Exception {
        freeThrowsMadeValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(freeThrowsMadeValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getFreeThrowsMade())));
    }

    @Test
    public void shouldBeAbleToExtractFreeThrowPercentageFromSeasonsTotalsPage() throws Exception {
        freeThrowsPercentageValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(freeThrowsPercentageValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getFreeThrowPercentage())));
    }

    @Test
    public void shouldBeAbleToExtractOffensiveReboundsFromSeasonsTotalsPage() throws Exception {
        offensiveReboundsValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(offensiveReboundsValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getOffensiveRebounds())));
    }

    @Test
    public void shouldBeAbleToExtractDefensiveReboundsFromSeasonsTotalsPage() throws Exception {
        defensiveReboundsValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(defensiveReboundsValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getDefensiveRebounds())));
    }

    @Test
    public void shouldBeAbleToExtractTotalReboundsFromSeasonsTotalsPage() throws Exception {
        totalReboundsValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(totalReboundsValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getTotalRebounds())));
    }

    @Test
    public void shouldBeAbleToExtractAssistsFromSeasonsTotalsPage() throws Exception {
        assistsValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(assistsValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getAssists())));
    }

    @Test
    public void shouldBeAbleToExtractStealsFromSeasonsTotalsPage() throws Exception {
        stealsValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(stealsValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getSteals())));
    }

    @Test
    public void shouldBeAbleToExtractBlocksFromSeasonsTotalsPage() throws Exception {
        blocksValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(blocksValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getBlocks())));
    }

    @Test
    public void shouldBeAbleToExtractTurnoversFromSeasonsTotalsPage() throws Exception {
        turnoversValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(turnoversValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getTurnovers())));
    }

    @Test
    public void shouldBeAbleToExtractPersonalFoulsFromSeasonsTotalsPage() throws Exception {
        personalFoulsValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(personalFoulsValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getPersonalFouls())));
    }

    @Test
    public void shouldBeAbleToExtractPointsFromSeasonsTotalsPage() throws Exception {
        pointsValueExtractor.setInputStringToSearch(quincyAcySeasonTotals);
        assertThat(pointsValueExtractor.getValue(), is(equalTo((Object) expectedQuincyAcyModel.getPoints())));
    }
}
