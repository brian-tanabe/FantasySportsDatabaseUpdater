package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import com.btanabe.fsdu.models.EspnNbaProjectionModel;
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
    @Qualifier("espnNbaHoopDreamsProjectionsPageSixteen")
    private String espnNbaProjectionsPageSixteen;

    @Autowired
    @Qualifier("espnNbaHoopDreamsProjectionsPageTwo")
    private String espnNbaProjectionPageTwo;

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
    @Qualifier("espnProjectionsPageAnthonyDavis")
    private String anthonyDavisEspnProjectionPageHtml;

    @Autowired
    @Qualifier("espnProjectionsPageKyrieIrving")
    private String kyrieIrvingEspnProjectionPageHtml;

    @Autowired
    @Qualifier("espnProjectionsPageEltonBrand")
    private String eltonBrandEspnProjectionPageHtml;

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
    @Qualifier("anthonyDavisEspnProjectionModel")
    private EspnNbaProjectionModel expectedAnthonyDavisEspnNbaProjectionModel;

    @Autowired
    @Qualifier("kyrieIrvingEspnProjectionModel")
    private EspnNbaProjectionModel expectedKyrieIrvingEspnNbaProjectionModel;

    @Autowired
    @Qualifier("eltonBrandEspnProjectionModel")
    private EspnNbaProjectionModel expectedEltonBrandEspnNbaProjectionModel;

    @Autowired
    private ValueExtractor espnProjectionsPlayerIdValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsRankValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsNameValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsTeamValueExtractor;

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

    @Autowired
    private ValueExtractor espnPlayerPageFieldGoalPercentageValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageFreeThrowPercentageValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageThreePointersPerGameValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageReboundsPerGameValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageAssistsPerGameValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageStealsPerGameValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageBlocksPerGameValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageTurnoversPerGameValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPagePointsPerGameValueExtractor;

    @Test
    public void shouldBeAbleToExtractNflPlayerPlayerIdProperlyFromEspnProjectionPage() throws Exception {
        espnProjectionsPlayerIdValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsPlayerIdValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getPlayerId())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerPlayeIdProperlyFromEspnProjectionPage() throws Exception {
        espnProjectionsPlayerIdValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnProjectionsPlayerIdValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getPlayerId())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerRankFromEspnProjectionPages() throws Exception {
        espnProjectionsRankValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRankValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRank())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerRankFromEspnProjectionPages() throws Exception {
        espnProjectionsRankValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnProjectionsRankValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getRank())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerNamesFromEspnProjectionPages() throws Exception {
        espnProjectionsNameValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsNameValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getName())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerNamesFromEspnProjectionPage() throws Exception {
        espnProjectionsNameValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnProjectionsNameValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getName())));
    }

    @Test
    public void shouldBeAbleToExtractNflTeamNamesFromEspnProjectionPages() throws Exception {
        espnProjectionsTeamValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsTeamValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToExtractNbaTeamNamesFromEspnProjectionPage() throws Exception {
        espnProjectionsTeamValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnProjectionsTeamValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerPositionFromEspnProjectionPages() throws Exception {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerPositionFromEspnProjectionPages() throws Exception {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerPassingAttemptsFromEspnProjectionPages() throws Exception {
        espnProjectionsPassingAttemptsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingAttemptsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingAttempts())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerPassingCompletionsFromEspnProjectionPage() throws Exception {
        espnProjectionsPassingCompletionsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingCompletionsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingCompletions())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerPassingYardsFromEspnProjectionPage() throws Exception {
        espnProjectionsPassingYardsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingYardsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingYards())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerPassingTouchdownsFromEspnProjectionPage() throws Exception {
        espnProjectionsPassingTouchdownsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingTouchdownsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerInterceptionsFromEspnProjectionPage() throws Exception {
        espnProjectionsInterceptionsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsInterceptionsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getInterceptions())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerRushingAttemptsFromEspnProjectionPage() throws Exception {
        espnProjectionsRushingAttemptsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingAttemptsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRushingAttempts())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerRushingYardsFromEspnProjectionPage() throws Exception {
        espnProjectionsRushingYardsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingYardsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRushingYards())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerRushingTouchdownsFromEspnProjectionPage() throws Exception {
        espnProjectionsRushingTouchdownsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingTouchdownsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRushingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerReceptionsFromEspnProjectionPage() throws Exception {
        espnProjectionsReceptionsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsReceptionsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getReceptions())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerReceivingYardsFromEspnProjectionPage() throws Exception {
        espnProjectionsReceivingYardsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsReceivingYardsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getReceivingYards())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerReceivingTouchdownsFromEspnProjectionPage() throws Exception {
        espnProjectionsReceivingTouchdownsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsReceivingTouchdownsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getReceivingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerFantasyPointsFromEspnProjectionPage() throws Exception {
        espnProjectionsFantasyPointsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsFantasyPointsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getFantasyPoints())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerFieldGoalPercentageFromEspnProjectionPage() throws Exception {
        espnPlayerPageFieldGoalPercentageValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnPlayerPageFieldGoalPercentageValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getFieldGoalPercentage())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerFreeThrowPercentageFromEspnProjectionPage() throws Exception {
        espnPlayerPageFreeThrowPercentageValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnPlayerPageFreeThrowPercentageValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getFreeThrowPercentage())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerThreePointsPerGameFromEspnProjectionPage() throws Exception {
        espnPlayerPageThreePointersPerGameValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnPlayerPageThreePointersPerGameValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getThreePointMadePerGame())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerReboundsPerGameFromEspnProjectionPage() throws Exception {
        espnPlayerPageReboundsPerGameValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnPlayerPageReboundsPerGameValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getReboundsPerGame())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerAssistsPerGameFromEspnProjectionPage() throws Exception {
        espnPlayerPageAssistsPerGameValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnPlayerPageAssistsPerGameValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getAssistsPerGame())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerStealsPerGameFromEspnProjectionPage() throws Exception {
        espnPlayerPageStealsPerGameValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnPlayerPageStealsPerGameValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getStealsPerGame())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerBlocksPerGameFromEspnProjectionPage() throws Exception {
        espnPlayerPageBlocksPerGameValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnPlayerPageBlocksPerGameValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getBlocksPerGame())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerTurnoversPerGameFromEspnProjectionPage() throws Exception {
        espnPlayerPageTurnoversPerGameValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnPlayerPageTurnoversPerGameValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getTurnoversPerGame())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerPointsPerGameFromEspnProjectionPage() throws Exception {
        espnPlayerPagePointsPerGameValueExtractor.setInputStringToSearch(anthonyDavisEspnProjectionPageHtml);
        assertThat(espnPlayerPagePointsPerGameValueExtractor.getValue(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel.getPointsPerGame())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerTeamNameFromProjectionPageWhenThePlayerIsSuspended() throws Exception {
        espnProjectionsTeamValueExtractor.setInputStringToSearch(leVeonBellEspnProjectionPageHtml);
        assertThat(espnProjectionsTeamValueExtractor.getValue(), is(equalTo((Object) expectedLeVeonBellEspnNflProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerPositionsFromProjectionPageWhenThePlayerIsSuspendedOrInjured() throws Exception {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(leVeonBellEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedLeVeonBellEspnNflProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeABleToExtractNflPlayerFantasyPointsWhenThePlayersProjectionDoesNotContainFractionalPoints() throws Exception {
        espnProjectionsFantasyPointsValueExtractor.setInputStringToSearch(demaryiusThomasEspnProjectionPageHtml);
        assertThat(espnProjectionsFantasyPointsValueExtractor.getValue(), is(equalTo((Object) expectedDemaryiusThomasEspnNflProjectionModel.getFantasyPoints())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerNegativeRushingYardsFromEspnProjectionPage() throws Exception {
        espnProjectionsRushingYardsValueExtractor.setInputStringToSearch(peytonManningEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingYardsValueExtractor.getValue(), is(equalTo((Object) expectedPeytonManningEspnNflProjectionModel.getRushingYards())));
    }

    @Test
    public void shouldBeAbleToExtractNflPlayerPositionWhenDirectlyFollowedByAnotherLinkTag() throws Exception {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(peytonManningEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedPeytonManningEspnNflProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerPositionsWhenThePlayerIsOut() throws Exception {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(kyrieIrvingEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedKyrieIrvingEspnNbaProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeAbleToExtractNbaPlayerTeamWhenThePlayerIsOut() throws Exception {
        espnProjectionsTeamValueExtractor.setInputStringToSearch(kyrieIrvingEspnProjectionPageHtml);
        assertThat(espnProjectionsTeamValueExtractor.getValue(), is(equalTo((Object) expectedKyrieIrvingEspnNbaProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToFindTheNextPageLinkOnEspnsNflProjectionsPage() throws Exception {
        espnProjectionsNextPageValueExtractor.setInputStringToSearch(espnNflProjectionsPageOne);
        assertThat(espnProjectionsNextPageValueExtractor.getValue(), is(equalTo((Object) "http://games.espn.go.com/ffl/tools/projections?&startIndex=40")));
    }

    @Test
    public void shouldBeAbleToFindTheNextPageLinkOnEspnsNbaProjectionsPage() throws Exception {
        espnProjectionsNextPageValueExtractor.setInputStringToSearch(espnNbaProjectionsPageOne);
        assertThat(espnProjectionsNextPageValueExtractor.getValue(), is(equalTo((Object) "http://games.espn.go.com/fba/tools/projections?&leagueId=233928&startIndex=40")));
    }

    @Test
    public void shouldBeAbleToProperlyExtractNextPageLinksFromInnerPages() throws Exception {
        espnProjectionsNextPageValueExtractor.setInputStringToSearch(espnNbaProjectionPageTwo);
        assertThat(espnProjectionsNextPageValueExtractor.getValue(), is(equalTo((Object) "http://games.espn.go.com/fba/tools/projections?&leagueId=233928&startIndex=80")));
    }

    @Test
    public void shouldBeAbleToReturnEmptyStringWhenNoNextPageLinkExists() throws Exception {
        espnProjectionsNextPageValueExtractor.setInputStringToSearch(espnNbaProjectionsPageSixteen);
        assertThat(espnProjectionsNextPageValueExtractor.getValue(), is(equalTo("")));
    }

    @Test
    public void shouldBeAbleToTransformIllegalFieldGoalPercentagesIntoZero() throws Exception {
        espnPlayerPageFieldGoalPercentageValueExtractor.setInputStringToSearch(eltonBrandEspnProjectionPageHtml);
        assertThat(espnPlayerPageFieldGoalPercentageValueExtractor.getValue(), is(equalTo((Object) expectedEltonBrandEspnNbaProjectionModel.getFieldGoalPercentage())));
    }

    @Test
    public void shouldBeAbleToTransformIllegalFreeThrowPercentagesIntoZero() throws Exception {
        espnPlayerPageFreeThrowPercentageValueExtractor.setInputStringToSearch(eltonBrandEspnProjectionPageHtml);
        assertThat(espnPlayerPageFreeThrowPercentageValueExtractor.getValue(), is(equalTo((Object) expectedEltonBrandEspnNbaProjectionModel.getFreeThrowPercentage())));
    }

    @Test
    public void shouldBeAbleToTransformIllegalThreePointsMadeIntoZero() throws Exception {
        espnPlayerPageThreePointersPerGameValueExtractor.setInputStringToSearch(eltonBrandEspnProjectionPageHtml);
        assertThat(espnPlayerPageThreePointersPerGameValueExtractor.getValue(), is(equalTo((Object) expectedEltonBrandEspnNbaProjectionModel.getThreePointMadePerGame())));
    }

    @Test
    public void shouldBeAbleToTransformIllegalReboundsIntoZero() throws Exception {
        espnPlayerPageReboundsPerGameValueExtractor.setInputStringToSearch(eltonBrandEspnProjectionPageHtml);
        assertThat(espnPlayerPageReboundsPerGameValueExtractor.getValue(), is(equalTo((Object) expectedEltonBrandEspnNbaProjectionModel.getReboundsPerGame())));
    }

    @Test
    public void shouldBeAbleToTransformIllegalAssistsIntoZero() throws Exception {
        espnPlayerPageAssistsPerGameValueExtractor.setInputStringToSearch(eltonBrandEspnProjectionPageHtml);
        assertThat(espnPlayerPageAssistsPerGameValueExtractor.getValue(), is(equalTo((Object) expectedEltonBrandEspnNbaProjectionModel.getAssistsPerGame())));
    }

    @Test
    public void shouldBeAbleToTransformIllegalStealsIntoZero() throws Exception {
        espnPlayerPageStealsPerGameValueExtractor.setInputStringToSearch(eltonBrandEspnProjectionPageHtml);
        assertThat(espnPlayerPageStealsPerGameValueExtractor.getValue(), is(equalTo((Object) expectedEltonBrandEspnNbaProjectionModel.getStealsPerGame())));
    }

    @Test
    public void shouldBeAbleToTransformIllegalBlocksIntoZero() throws Exception {
        espnPlayerPageBlocksPerGameValueExtractor.setInputStringToSearch(eltonBrandEspnProjectionPageHtml);
        assertThat(espnPlayerPageBlocksPerGameValueExtractor.getValue(), is(equalTo((Object) expectedEltonBrandEspnNbaProjectionModel.getBlocksPerGame())));
    }

    @Test
    public void shouldBeAbleToTransformIllegalTurnoversIntoNegativeOne() throws Exception {
        espnPlayerPageTurnoversPerGameValueExtractor.setInputStringToSearch(eltonBrandEspnProjectionPageHtml);
        assertThat(espnPlayerPageTurnoversPerGameValueExtractor.getValue(), is(equalTo((Object) expectedEltonBrandEspnNbaProjectionModel.getTurnoversPerGame())));
    }

    @Test
    public void shouldBeAbleToTransformIllegalPointsIntoZero() throws Exception {
        espnPlayerPagePointsPerGameValueExtractor.setInputStringToSearch(eltonBrandEspnProjectionPageHtml);
        assertThat(espnPlayerPagePointsPerGameValueExtractor.getValue(), is(equalTo((Object) expectedEltonBrandEspnNbaProjectionModel.getPointsPerGame())));
    }
}