package com.btanabe.fsdu.test.integration.parsers;

import com.btanabe.fsdu.models.BasketballReferenceSeasonTotalsModel;
import com.btanabe.fsdu.parsers.PaginatedRecordParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 11/29/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BasketballReferencePaginatedRecordParserTests {

    @Autowired
    @Qualifier("basketballReferenceSeasonTotalsPagePaginatedRecordParser")
    private PaginatedRecordParser<BasketballReferenceSeasonTotalsModel> seasonTotalsPaginatedRecordParser;

    @Autowired
    @Qualifier("basketballReferenceSeasonTotals20142015Season")
    private String basketballReferenceSeasonTotalsPage;

    private List<BasketballReferenceSeasonTotalsModel> playerSeasonTotalsList;

    @Before
    public void parseInputHtml() throws Exception {
        if(playerSeasonTotalsList == null) {
            seasonTotalsPaginatedRecordParser.setInputHtml(basketballReferenceSeasonTotalsPage);
            playerSeasonTotalsList = seasonTotalsPaginatedRecordParser.getRecordsAsList();
        }
    }

    @Test
    public void shouldBeAbleToFindFourHundredNinetyTwoRecords() throws Exception {
        assertThat(playerSeasonTotalsList.size(), is(equalTo(492)));
    }
}
