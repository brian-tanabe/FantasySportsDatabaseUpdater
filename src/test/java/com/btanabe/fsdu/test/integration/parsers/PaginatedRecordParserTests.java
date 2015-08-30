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

    private List<EspnProjectionModel> playersFromRecordParser;

    @Before
    public void getTestRecords() throws Exception {
        playersFromRecordParser = paginatedRecordParser.getRecordsAsList();
    }

    @Test
    public void shouldBeAbleToExtractEspnPlayerModelsFromEspnPlayerProjectionPage() {
        assertThat(playersFromRecordParser, hasItem(isA(EspnProjectionModel.class)));
    }

    @Test
    public void shouldBeAbleToCreateFortyRecordsFromOneEspnPlayerProjectionPage() throws Exception {
        assertThat(playersFromRecordParser.size(), is(equalTo(40)));
    }
}
