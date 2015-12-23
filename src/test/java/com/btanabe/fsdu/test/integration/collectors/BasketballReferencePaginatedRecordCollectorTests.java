package com.btanabe.fsdu.test.integration.collectors;

import com.btanabe.fsdu.collectors.RecordCollector;
import com.btanabe.fsdu.models.BasketballReferenceSeasonTotalsModel;
import com.btanabe.fsdu.web.WebRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by brian on 12/19/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BasketballReferencePaginatedRecordCollectorTests {

    @Autowired
    @Qualifier("basketballReferenceSeasonTotalsPageRecordCollector")
    private RecordCollector basketballReferenceSeasonTotalsPageRecordCollector;

    @Autowired
    @Qualifier("mockBasketballReferenceSeasonsTotalsWebRequest")
    private WebRequest mockWebRequest;

    private Set<BasketballReferenceSeasonTotalsModel> allBasketballReferenceSeasonTotalsRecords;

    @Before
    public void parseAllBasketballReferenceSeasonTotalsRecords() {
        try {
            allBasketballReferenceSeasonTotalsRecords = (Set<BasketballReferenceSeasonTotalsModel>) basketballReferenceSeasonTotalsPageRecordCollector.apply("http://www.basketball-reference.com/leagues/NBA_2015_totals.html", mockWebRequest);
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
    public void shouldBeAbleToFindFourHundredNinetyTwoRecordsUniquePlayers() throws Exception {
        assertThat(allBasketballReferenceSeasonTotalsRecords.stream().map(player -> player.getName()).collect(Collectors.toSet()).size(), is(equalTo(492)));
    }
}
