package com.btanabe.fsdu.test.unit.parsers.record.parser;

import com.btanabe.fsdu.models.EspnNflProjectionModel;
import com.btanabe.fsdu.parsers.RecordParser;
import org.junit.Before;
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
public class RecordParserTests {

    @Autowired
    @Qualifier("eddieLacyEspnPlayerProjectionRecordParser")
    private RecordParser<EspnNflProjectionModel> eddieLacyRecordParser;

    @Autowired
    @Qualifier("aaronRodgersEspnPlayerProjectionRecordParser")
    private RecordParser<EspnNflProjectionModel> aaronRodgersRecordParser;

    @Autowired
    @Qualifier("eddieLacyEspnProjectionModel")
    private EspnNflProjectionModel expectedEddieLacyProjectionModel;

    @Autowired
    @Qualifier("aaronRodgersEspnProjectionModel")
    private EspnNflProjectionModel expectedAaronRodgersEspnNflProjectionModel;

    private EspnNflProjectionModel eddieLacyProjectionModel;
    private EspnNflProjectionModel aaronRodgersProjectionModel;

    @Before
    public void parseEddieLacysProjections() throws Exception {
        eddieLacyProjectionModel = eddieLacyRecordParser.getRecord();
        aaronRodgersProjectionModel = aaronRodgersRecordParser.getRecord();
    }

    @Test
    public void shouldBeAbleToParseEddieLacysNameProperly() {
        assertThat(eddieLacyProjectionModel.getName(), is(equalTo(expectedEddieLacyProjectionModel.getName())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysNflTeamProperly() {
        assertThat(eddieLacyProjectionModel.getTeam(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacyIntoProjectionObject() throws Exception {
        assertThat(eddieLacyRecordParser.getRecord(), isA(EspnNflProjectionModel.class));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysFantasyPointsProperly() {
        assertThat(eddieLacyProjectionModel.getFantasyPoints(), is(equalTo(expectedEddieLacyProjectionModel.getFantasyPoints())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRankProperly() {
        assertThat(eddieLacyProjectionModel.getRank(), is(equalTo(expectedEddieLacyProjectionModel.getRank())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRushingAttemptsProperly() {
        assertThat(eddieLacyProjectionModel.getRushingAttempts(), is(equalTo(expectedEddieLacyProjectionModel.getRushingAttempts())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRushingYardsProperly() {
        assertThat(eddieLacyProjectionModel.getRushingYards(), is(equalTo(expectedEddieLacyProjectionModel.getRushingYards())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysRushingTouchdownsProperly() {
        assertThat(eddieLacyProjectionModel.getRushingTouchdowns(), is(equalTo(expectedEddieLacyProjectionModel.getRushingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysReceptionsProperly() {
        assertThat(eddieLacyProjectionModel.getReceptions(), is(equalTo(expectedEddieLacyProjectionModel.getReceptions())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysReceivingYardsProperly() {
        assertThat(eddieLacyProjectionModel.getReceivingYards(), is(equalTo(expectedEddieLacyProjectionModel.getReceivingYards())));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysReceivingTouchdownsProperly() {
        assertThat(eddieLacyProjectionModel.getReceivingTouchdowns(), is(equalTo(expectedEddieLacyProjectionModel.getReceivingTouchdowns())));
    }

    @Test
    public void shouldBeAbleToParseAaronRodgersPassingAttemptsProperly() {
        assertThat(aaronRodgersProjectionModel.getPassingAttempts(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getPassingAttempts())));
    }

    @Test
    public void shouldBeAbleToParseAaronRodgersPassingCompletionsProperly() {
        assertThat(aaronRodgersProjectionModel.getPassingCompletions(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getPassingCompletions())));
    }

    @Test
    public void shouldBeAbleToParseAaronRodgersPassingYardsProperly() {
        assertThat(aaronRodgersProjectionModel.getPassingYards(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getPassingYards())));
    }


    @Test
    public void shouldBeAbleToParseAaronRodgersInterceptionsProperly() {
        assertThat(aaronRodgersProjectionModel.getInterceptions(), is(equalTo(expectedAaronRodgersEspnNflProjectionModel.getInterceptions())));
    }
}
