package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import com.btanabe.fsdu.models.EspnNflProjectionModel;
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
 * Created by brian on 8/23/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnProjectionsPageValueExtractorTests {

    @Autowired
    private String espnNflProjectionsPageOne;

    @Autowired
    private String espnNbaProjectionsPageOne;

    @Autowired
    @Qualifier("espnProjectionsPageEddieLacy")
    private String eddieLacyEspnProjectionPageHtml;

    @Autowired
    @Qualifier("espnProjectionsPageAaronRodgers")
    private String aaronRodgersEspnProjectionPageHtml;

    @Autowired
    @Qualifier("espnProjectionsPageLeVeonBell")
    private String leVeonBellEspnProjectionPageHtml;

    @Autowired
    @Qualifier("espnProjectionsPageDemaryiusThomas")
    private String demaryiusThomasEspnProjectionPageHtml;

    @Autowired
    @Qualifier("espnProjectionsPagePeytonManning")
    private String peytonManningEspnProjectionPageHtml;

    @Autowired
    @Qualifier("eddieLacyEspnProjectionModel")
    private EspnNflProjectionModel expectedEddieLacyProjectionModel;

    @Autowired
    @Qualifier("aaronRodgersEspnProjectionModel")
    private EspnNflProjectionModel expectedAaronRodgersProjectionModel;

    @Autowired
    @Qualifier("leVeonBellEspnProjectionModel")
    private EspnNflProjectionModel expectedLeVeonBellEspnNflProjectionModel;

    @Autowired
    @Qualifier("demaryiusThomasEspnProjectionModel")
    private EspnNflProjectionModel expectedDemaryiusThomasEspnNflProjectionModel;

    @Autowired
    @Qualifier("peytonManningEspnProjectionModel")
    private EspnNflProjectionModel expectedPeytonManningEspnNflProjectionModel;

    @Autowired
    private ValueExtractor espnProjectionsPlayerIdValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsRankValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsNameValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsNflTeamValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsPositionValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsPassingAttemptsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsPassingCompletionsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsPassingYardsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsPassingTouchdownsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsInterceptionsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsRushingAttemptsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsRushingYardsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsRushingTouchdownsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsReceptionsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsReceivingYardsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsReceivingTouchdownsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsFantasyPointsValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsNextPageValueExtractor;

    @Test
    public void shouldBeAbleToExtractPlayerIdProperlyFromEspnProjectionPage() throws Exception {
        espnProjectionsPlayerIdValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsPlayerIdValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getPlayerId())));
    }

    @Test
    public void shouldBeAbleToExtractRankFromEspnProjectionPages() throws Exception {
        espnProjectionsRankValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRankValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRank())));
    }

    @Test
    public void shouldBeAbleToExtractNamesFromEspnProjectionPages() throws Exception {
        espnProjectionsNameValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsNameValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getName())));
    }

    @Test
    public void shouldBeAbleToExtractNflTeamNamesFromEspnProjectionPages() throws Exception {
        espnProjectionsNflTeamValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsNflTeamValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToExtractPositionFromEspnProjectionPages() throws Exception {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeAbleToExtractPassingAttemptsFromEspnProjectionPages() throws Exception {
        espnProjectionsPassingAttemptsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingAttemptsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingAttempts())));
    }

    @Test
    public void shouldBeAbleToExtractPassingCompletionsFromEspnProjectionPage() throws Exception {
        espnProjectionsPassingCompletionsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingCompletionsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingCompletions())));
    }

    @Test
    public void shouldBeAbleToExtractPassingYardsFromEspnProjectionPage() throws Exception {
        espnProjectionsPassingYardsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingYardsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingYards())));
    }

    @Test
    public void shouldBeAbleToExtractPassingTouchdownsFromEspnProjectionPage() throws Exception {
        espnProjectionsPassingTouchdownsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingTouchdownsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToExtractInterceptionsFromEspnProjectionPage() throws Exception {
        espnProjectionsInterceptionsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsInterceptionsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getInterceptions())));
    }

    @Test
    public void shouldBeAbleToExtractRushingAttemptsFromEspnProjectionPage() throws Exception {
        espnProjectionsRushingAttemptsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingAttemptsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRushingAttempts())));
    }

    @Test
    public void shouldBeAbleToExtractRushingYardsFromEspnProjectionPage() throws Exception {
        espnProjectionsRushingYardsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingYardsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRushingYards())));
    }

    @Test
    public void shouldBeAbleToExtractRushingTouchdownsFromEspnProjectionPage() throws Exception {
        espnProjectionsRushingTouchdownsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingTouchdownsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRushingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToExtractReceptionsFromEspnProjectionPage() throws Exception {
        espnProjectionsReceptionsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsReceptionsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getReceptions())));
    }

    @Test
    public void shouldBeAbleToExtractReceivingYardsFromEspnProjectionPage() throws Exception {
        espnProjectionsReceivingYardsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsReceivingYardsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getReceivingYards())));
    }

    @Test
    public void shouldBeAbleToExtractReceivingTouchdownsFromEspnProjectionPage() throws Exception {
        espnProjectionsReceivingTouchdownsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsReceivingTouchdownsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getReceivingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToExtractFantasyPointsFromEspnProjectionPage() throws Exception {
        espnProjectionsFantasyPointsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsFantasyPointsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getFantasyPoints())));
    }

    @Test
    public void shouldBeAbleToExtractTeamNameFromProjectionPageWhenThePlayerIsSuspended() throws Exception {
        espnProjectionsNflTeamValueExtractor.setInputStringToSearch(leVeonBellEspnProjectionPageHtml);
        assertThat(espnProjectionsNflTeamValueExtractor.getValue(), is(equalTo((Object) expectedLeVeonBellEspnNflProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToExtractPositionsFromProjectionPageWhenThePlayerIsSuspendedOrInjured() throws Exception {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(leVeonBellEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedLeVeonBellEspnNflProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeABleToExtractFantasyPointsWhenThePlayersProjectionDoesNotContainFractionalPoints() throws Exception {
        espnProjectionsFantasyPointsValueExtractor.setInputStringToSearch(demaryiusThomasEspnProjectionPageHtml);
        assertThat(espnProjectionsFantasyPointsValueExtractor.getValue(), is(equalTo((Object) expectedDemaryiusThomasEspnNflProjectionModel.getFantasyPoints())));
    }

    @Test
    public void shouldBeAbleToExtractNegativeRushingYardsFromEspnProjectionPage() throws Exception {
        espnProjectionsRushingYardsValueExtractor.setInputStringToSearch(peytonManningEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingYardsValueExtractor.getValue(), is(equalTo((Object) expectedPeytonManningEspnNflProjectionModel.getRushingYards())));
    }

    @Test
    public void shouldBeAbleToExtractPositionWhenDirectlyFollowedByAnotherLinkTag() throws Exception {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(peytonManningEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedPeytonManningEspnNflProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeAbleToFindTheNextPageLinkOnEspnsNflProjectionsPage() throws Exception {
        espnProjectionsNextPageValueExtractor.setInputStringToSearch(espnNflProjectionsPageOne);
        assertThat(espnProjectionsNextPageValueExtractor.getValue(), is(equalTo((Object) "http://games.espn.go.com/ffl/tools/projections?&amp;startIndex=40")));
    }

    @Test
    public void shouldBeAbleToFindTheNextPageLinkOnEspnsNbaProjectionsPage() throws Exception {
        espnProjectionsNextPageValueExtractor.setInputStringToSearch(espnNbaProjectionsPageOne);
        assertThat(espnProjectionsNextPageValueExtractor.getValue(), is(equalTo((Object) "http://games.espn.go.com/fba/tools/projections?&amp;leagueId=233928&amp;startIndex=40")));
    }
}