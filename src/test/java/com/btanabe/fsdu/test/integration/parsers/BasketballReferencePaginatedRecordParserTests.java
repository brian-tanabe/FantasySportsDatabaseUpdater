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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    @Qualifier("basketballReferenceSeasonTotals20142015DjAugustinDet")
    private String basketballReferenceDjAugustinDetroitRow;

    @Autowired
    @Qualifier("basketballReferenceSeasonTotals20142015JeffAyers")
    private String basketballReferenceJeffAyersRow;

    @Autowired
    @Qualifier("djAugustinDet20142015SeasonTotalsPlayerModel")
    private BasketballReferenceSeasonTotalsModel expectedDjAugustinBasketballReferenceDetSeasonTotalsModel;

    @Autowired
    @Qualifier("jeffAyres20142015SeasonTotalsPlayerModel")
    private BasketballReferenceSeasonTotalsModel expectedJeffAyresModel;

    private List<BasketballReferenceSeasonTotalsModel> allBasketballReferenceSeasonTotalsRecords;

    @Before
    public void parseAllBasketballReferenceSeasonTotalsRecords() {
        try {
            allBasketballReferenceSeasonTotalsRecords = seasonTotalsPaginatedRecordParser.getRecordsAsList(basketballReferenceSeasonTotalsPage);
        } catch (Exception ex) {
           /*
            Let's swallow this exception.  This is in a @Before block since parsing this list
            takes a long time and the same output list of records is shared amongst more than
            one test.  We shouldn't cause other tests that don't rely on this list to fail
            because parsing failed!
             */
        }
    }

    @Test
    public void shouldBeAbleToFindSixHundredFiftyOneRecords() throws Exception {
        assertThat(allBasketballReferenceSeasonTotalsRecords.size(), is(equalTo(651)));
    }

    // TODO When I have Internet check if I can use stream().collect(...) to make this more efficient
    @Test
    public void shouldBeAbleToFindFourHundredNinetyTwoRecordsUniquePlayers() throws Exception {
        final Set<String> playerNames = new HashSet<>(allBasketballReferenceSeasonTotalsRecords.size());
        allBasketballReferenceSeasonTotalsRecords.stream().forEach(player -> playerNames.add(player.getName()));
        assertThat(playerNames.size(), is(equalTo(492)));
    }

    @Test
    public void shouldBeAbleToExtractAndParsePlayersWhoseTrClassNameIsItalicTextPartialRow() throws Exception {
        assertThat(seasonTotalsPaginatedRecordParser.getRecordsAsList(basketballReferenceDjAugustinDetroitRow).contains(expectedDjAugustinBasketballReferenceDetSeasonTotalsModel), is(true));
    }

    @Test
    public void shouldBeAbleToExtractAndParsePlayersWhoseNameUrisContainPsInsteadOfAs() throws Exception {
        assertThat(seasonTotalsPaginatedRecordParser.getRecordsAsList(basketballReferenceJeffAyersRow).contains(expectedJeffAyresModel), is(true));
    }
}
