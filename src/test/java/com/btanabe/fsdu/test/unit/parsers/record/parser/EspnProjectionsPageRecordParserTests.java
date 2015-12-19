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
public class EspnProjectionsPageRecordParserTests {

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
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getName(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getName())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysNflTeamProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getTeam(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacyIntoProjectionObject() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy), isA(EspnNflProjectionModel.class));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysFantasyPointsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getFantasyPoints(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getFantasyPoints())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRankProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getRank(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getRank())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRushingAttemptsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getRushingAttempts(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getRushingAttempts())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRushingYardsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getRushingYards(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getRushingYards())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRushingTouchdownsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getRushingTouchdowns(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getRushingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysReceptionsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getReceptions(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getReceptions())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysReceivingYardsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getReceivingYards(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getReceivingYards())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysReceivingTouchdownsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy).getReceivingTouchdowns(), is(equalTo(expectedEddieLacyEspnNflProjectionModel.getReceivingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToParseAaronRodgersPassingAttemptsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageAaronRodgers).getPassingAttempts(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getPassingAttempts())));
    }

    @Test
    public void shouldBeAbleToParseAaronRodgersPassingCompletionsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageAaronRodgers).getPassingCompletions(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getPassingCompletions())));
    }

    @Test
    public void shouldBeAbleToParseAaronRodgersPassingYardsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageAaronRodgers).getPassingYards(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getPassingYards())));
    }


    @Test
    public void shouldBeAbleToParseAaronRodgersInterceptionsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageAaronRodgers).getInterceptions(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getInterceptions())));
    }

    @Test
    public void shouldBeAbleToParseNflRunningBacksProjectionsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageEddieLacy), is(equalTo((Object) expectedEddieLacyEspnNflProjectionModel)));
    }

    @Test
    public void shouldBeAbleToParseNflQuarterbacksProjectionsProperly() throws Exception {
        assertThat(nflProjectionPageRecordParser.apply(espnProjectionsPageAaronRodgers), is(equalTo((Object) expectedAaronRodgersEspnNflProjectionModel)));
    }

    @Test
    public void shouldBeAbleToParseNbaPlayerProjectionsProperly() throws Exception {
        assertThat(nbaProjectionPageRecordParser.apply(espnProjectionsPageAnthonyDavis), is(equalTo((Object) expectedAnthonyDavisEspnNbaProjectionModel)));
    }
}
