package com.btanabe.fsdu.test.unit.parsers.record.parser;

import com.btanabe.fsdu.models.BasketballReferenceSeasonTotalsModel;
import com.btanabe.fsdu.parsers.RecordParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 11/27/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BasketballSeasonTotalsReferenceRecordParserTests {

    @Autowired
    @Qualifier("basketballReferenceSeasonTotalsRecordParser")
    private RecordParser<BasketballReferenceSeasonTotalsModel> basketballReferenceSeasonTotalsModelRecordParser;

    @Autowired
    @Qualifier("basketballReferenceSeasonTotals20142015QuincyAcy")
    private String basketballReferenceSeasonTotalsPageQuincyAcy;

    @Autowired
    @Qualifier("basketballReferenceSeasonTotals20142015ArronAfflaloTot")
    private String basketballReferenceSeasonsTotalsPageArronAfflaloTotalRow;

    @Autowired
    @Qualifier("qunicyAcy20142015SeasonTotalsPlayerModel")
    private BasketballReferenceSeasonTotalsModel expectedQuincyAcyBasketballReferenceSeasonTotalsModel;

    @Autowired
    @Qualifier("arronAfflalo20142015SeasonTotalsTotalPlayerModel")
    private BasketballReferenceSeasonTotalsModel expectedArronAfflaloBasketballReferenceSeasonTotalsModel;

    @Test
    public void shouldBeAbleToParseBasketballReferenceSeasonTotalsProperly() throws Exception {
        basketballReferenceSeasonTotalsModelRecordParser.setInputHtml(basketballReferenceSeasonTotalsPageQuincyAcy);
        assertThat(basketballReferenceSeasonTotalsModelRecordParser.getRecord(), is(equalTo(expectedQuincyAcyBasketballReferenceSeasonTotalsModel)));
    }

    @Test
    public void shouldBeAbleToParseBasketballReferenceSeasonTotalsProperlyWhenThePlayerHasBeenTraded() throws Exception {
        basketballReferenceSeasonTotalsModelRecordParser.setInputHtml(basketballReferenceSeasonsTotalsPageArronAfflaloTotalRow);
        assertThat(basketballReferenceSeasonTotalsModelRecordParser.getRecord(), is(equalTo(expectedArronAfflaloBasketballReferenceSeasonTotalsModel)));
    }
}
