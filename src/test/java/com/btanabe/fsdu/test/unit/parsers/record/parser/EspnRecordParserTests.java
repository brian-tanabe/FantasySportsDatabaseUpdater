package com.btanabe.fsdu.test.unit.parsers.record.parser;

import com.btanabe.fsdu.models.EspnNbaProjectionModel;
import com.btanabe.fsdu.models.EspnNflProjectionModel;
import com.btanabe.fsdu.parsers.RecordParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 7/28/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnRecordParserTests {

    @Autowired
    @Qualifier("espnNflPlayerProjectionPagePaginatedRecordParser")
    private RecordParser<EspnNflProjectionModel> nflProjectionPageRecordParser;

    @Autowired
    @Qualifier("espnNbaPlayerProjectionPagePaginatedRecordParser")
    private RecordParser<EspnNbaProjectionModel> nbaProjectionPageRecordParser;

    @Autowired
    @Qualifier("espnProjectionsPageAnthonyDavis")
    private String espnProjectionsPageAnthonyDavis;

    @Autowired
    @Qualifier("espnProjectionsPageAaronRodgers")
    private String espnProjectionsPageAaronRodgers;

    @Autowired
    @Qualifier("espnProjectionsPageEddieLacy")
    private String espnProjectionsPageEddieLacy;

    @Autowired
    @Qualifier("eddieLacyEspnProjectionModel")
    private EspnNflProjectionModel expectedEddieLacyEspnNflProjectionModel;

    @Autowired
    @Qualifier("aaronRodgersEspnProjectionModel")
    private EspnNflProjectionModel expectedAaronRodgersEspnNflProjectionModel;

    @Autowired
    @Qualifier("anthonyDavisEspnProjectionModel")
    private EspnNbaProjectionModel expectedAnthonyDavisEspnNbaProjectionModel;


    @Test
    public void shouldBeAbleToParseEddieLacysNameProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getName(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getName())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysNflTeamProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getTeam(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacyIntoProjectionObject() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord(), isA(EspnNflProjectionModel.class));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysFantasyPointsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getFantasyPoints(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getFantasyPoints())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRankProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getRank(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getRank())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRushingAttemptsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getRushingAttempts(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getRushingAttempts())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRushingYardsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getRushingYards(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getRushingYards())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRushingTouchdownsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getRushingTouchdowns(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getRushingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysReceptionsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getReceptions(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getReceptions())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysReceivingYardsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getReceivingYards(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getReceivingYards())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysReceivingTouchdownsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord().getReceivingTouchdowns(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getReceivingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToParseAaronRodgersPassingAttemptsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageAaronRodgers);
        assertThat(nflProjectionPageRecordParser.getRecord().getPassingAttempts(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getPassingAttempts())));
    }

    @Test
    public void shouldBeAbleToParseAaronRodgersPassingCompletionsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageAaronRodgers);
        assertThat(nflProjectionPageRecordParser.getRecord().getPassingCompletions(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getPassingCompletions())));
    }

    @Test
    public void shouldBeAbleToParseAaronRodgersPassingYardsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageAaronRodgers);
        assertThat(nflProjectionPageRecordParser.getRecord().getPassingYards(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getPassingYards())));
    }


    @Test
    public void shouldBeAbleToParseAaronRodgersInterceptionsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageAaronRodgers);
        assertThat(nflProjectionPageRecordParser.getRecord().getInterceptions(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getInterceptions())));
    }

    @Test
    public void shouldBeAbleToParseNflRunningBacksProjectionsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageEddieLacy);
        assertThat(nflProjectionPageRecordParser.getRecord(), is(equalTo((Object) expectedEddieLacyEspnNflProjectionModel)));
    }

    @Test
    public void shouldBeAbleToParseNflQuarterbacksProjectionsProperly() throws Exception {
        nflProjectionPageRecordParser.setInputHtml(espnProjectionsPageAaronRodgers);
        assertThat(nflProjectionPageRecordParser.getRecord(), is(equalTo((Object) expectedAaronRodgersEspnNflProjectionModel)));
    }

    @Test
    public void shouldBeAbleToParseNbaPlayerProjectionsProperly() throws Exception {
        nbaProjectionPageRecordParser.setInputHtml(espnProjectionsPageAnthonyDavis);
        assertThat(nbaProjectionPageRecordParser.getRecord(), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel)));
    }
}
