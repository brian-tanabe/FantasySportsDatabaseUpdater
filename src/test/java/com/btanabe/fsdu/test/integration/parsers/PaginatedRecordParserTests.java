package com.btanabe.fsdu.test.integration.parsers;

import com.btanabe.fsdu.models.EspnProjectionModel;
import com.btanabe.fsdu.parsers.PaginatedRecordParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 8/29/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PaginatedRecordParserTests {

    @Autowired
    @Qualifier("testEspnPlayerProjectionPagePaginatedRecordParser")
    private PaginatedRecordParser paginatedRecordParser;

    @Autowired
    @Qualifier("eddieLacyEspnProjectionModel")
    private EspnProjectionModel expectedEddieLacyProjectionModel;

    @Autowired
    @Qualifier("aaronRodgersEspnProjectionModel")
    private EspnProjectionModel expectedAaronRodgersProjectionModel;

    @Autowired
    @Qualifier("leVeonBellEspnProjectionModel")
    private EspnProjectionModel expectedLeVeonBellEspnProjectionModel;

    @Autowired
    @Qualifier("demaryiusThomasEspnProjectionModel")
    private EspnProjectionModel expectedDemaryiusThomasEspnProjectionModel;

    @Autowired
    @Qualifier("peytonManningEspnProjectionModel")
    private EspnProjectionModel expectedPeytonManningEspnProjectionModel;

    private static List<EspnProjectionModel> playersFromRecordParser;

    @Before
    public void getTestRecords() throws Exception {
        if(playersFromRecordParser == null) {
            playersFromRecordParser = paginatedRecordParser.getRecordsAsList();
        }
    }

    @Test
    public void shouldBeAbleToExtractEspnPlayerModelsFromEspnPlayerProjectionPage() {
        assertThat(playersFromRecordParser, hasItem(isA(EspnProjectionModel.class)));
    }

    @Test
    public void shouldBeAbleToCreateFortyRecordsFromOneEspnPlayerProjectionPage() throws Exception {
        assertThat(playersFromRecordParser.size(), is(equalTo(40)));
    }

    @Test
    public void shouldBeAbleToProperlyParseAndPopulateEddieLacy() {
        EspnProjectionModel eddieLacyFromParser = playersFromRecordParser.parallelStream().filter(p -> p.getName().equals("Eddie Lacy")).findFirst().get();
        assertThat(eddieLacyFromParser, is(equalTo(expectedEddieLacyProjectionModel)));
    }

    @Test
    public void shouldBeAbleToProperlyParseAndPopulateLeVeonBell() {
        EspnProjectionModel LeVeonBellFromParser = playersFromRecordParser.parallelStream().filter(p -> p.getName().equals("Le'Veon Bell")).findFirst().get();
        assertThat(LeVeonBellFromParser, is(equalTo(expectedLeVeonBellEspnProjectionModel)));
    }

    @Test
    public void shouldBeAbleToProperlyParseAndPopulateDemaryiusThomas() {
        EspnProjectionModel demaryiusThomasFromParser = playersFromRecordParser.parallelStream().filter(p -> p.getName().equals("Demaryius Thomas")).findFirst().get();
        assertThat(demaryiusThomasFromParser, is(equalTo(expectedDemaryiusThomasEspnProjectionModel)));
    }

    @Test
    public void shouldBeAbleToProperlyParseAndPopulateAaronRodgers() {
        EspnProjectionModel aaronRodgersFromParser = playersFromRecordParser.parallelStream().filter(p -> p.getName().equals("Aaron Rodgers")).findFirst().get();
        assertThat(aaronRodgersFromParser, is(equalTo(expectedAaronRodgersProjectionModel)));
    }

    @Test
    public void shouldBeAbleToProperlyParseAndPopulatePeytonManning() {
        EspnProjectionModel peytonManningFromParser = playersFromRecordParser.parallelStream().filter(p -> p.getName().equals("Peyton Manning")).findFirst().get();
        assertThat(peytonManningFromParser, is(equalTo(expectedPeytonManningEspnProjectionModel)));
    }
}
