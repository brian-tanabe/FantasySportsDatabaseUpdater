package com.btanabe.fsdu.test.unit.parsers;

import com.btanabe.fsdu.models.EspnProjectionModel;
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

    @Qualifier("espnProjectionsPageEddieLacyBean")
    @Autowired
    private String eddieLacyEspnProjectionPageHtml;

    @Qualifier("espnProjectionsPageAaronRodgersBean")
    @Autowired
    private String aaronRodgersEspnProjectionPageHtml;

    @Autowired
    @Qualifier("eddieLacyEspnProjectionModel")
    private EspnProjectionModel expectedEddieLacyProjectionModel;

    @Qualifier("aaronRodgersEspnProjectionModel")
    @Autowired
    private EspnProjectionModel expectedAaronRodgersProjectionModel;

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

    @Test
    public void shouldBeAbleToExtractNamesFromEspnProjectionPages() throws ClassNotFoundException {
        espnProjectionsNameValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsNameValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getName())));
    }

    @Test
    public void shouldBeAbleToExtractNflTeamNamesFromEspnProjectionPages() throws ClassNotFoundException {
        espnProjectionsNflTeamValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsNflTeamValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToExtractPositionFromEspnProjectionPages() throws ClassNotFoundException {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeAbleToExtractPassingAttemptsFromEspnProjectionPages() throws ClassNotFoundException {
        espnProjectionsPassingAttemptsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingAttemptsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingAttempts())));
    }

    @Test
    public void shouldBeAbleToExtractPassingCompletionsFromEspnProjectionPage() throws ClassNotFoundException {
        espnProjectionsPassingCompletionsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingCompletionsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingCompletions())));
    }

    @Test
    public void shouldBeAbleToExtractPassingYardsFromEspnProjectionPage() throws ClassNotFoundException {
        espnProjectionsPassingYardsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingYardsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingYards())));
    }

    @Test
    public void shouldBeAbleToExtractPassingTouchdownsFromEspnProjectionPage() throws ClassNotFoundException {
        espnProjectionsPassingTouchdownsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingTouchdownsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getPassingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToExtractInterceptionsFromEspnProjectionPage() throws ClassNotFoundException {
        espnProjectionsInterceptionsValueExtractor.setInputStringToSearch(aaronRodgersEspnProjectionPageHtml);
        assertThat(espnProjectionsInterceptionsValueExtractor.getValue(), is(equalTo((Object) expectedAaronRodgersProjectionModel.getInterceptions())));
    }

    @Test
    public void shouldBeAbleToExtractRushingAttemptsFromEspnProjectionPage() throws ClassNotFoundException {
        espnProjectionsRushingAttemptsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingAttemptsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRushingAttempts())));
    }

    @Test
    public void shouldBeAbleToExtractRushingYardsFromEspnProjectionPage() throws ClassNotFoundException {
        espnProjectionsRushingYardsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingYardsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRushingYards())));
    }

    @Test
    public void shouldBeAbleToExtractRushingTouchdownsFromEspnProjectionPage() throws ClassNotFoundException {
        espnProjectionsRushingTouchdownsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsRushingTouchdownsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getRushingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToExtractReceptionsFromEspnProjectionPage() throws ClassNotFoundException {
        espnProjectionsReceptionsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsReceptionsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getReceptions())));
    }

    @Test
    public void shuoldBeAbleToExtractReceivingYardsFromEspnProjectionPage() throws ClassNotFoundException {
        espnProjectionsReceivingYardsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsReceivingYardsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getReceivingYards())));
    }
}
