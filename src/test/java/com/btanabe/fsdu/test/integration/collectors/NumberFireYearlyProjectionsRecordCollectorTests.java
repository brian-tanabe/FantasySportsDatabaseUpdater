package com.btanabe.fsdu.test.integration.collectors;

import com.btanabe.fsdu.collectors.RecordCollector;
import com.btanabe.fsdu.web.WebRequest;
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
 * Created by Brian on 12/21/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class NumberFireYearlyProjectionsRecordCollectorTests {

    @Autowired
    @Qualifier("numberFireYearlyProjectionsPageRecordCollector")
    private RecordCollector numberFireYearlyProjectionsRecordCollector;

    @Autowired
    @Qualifier("mockNumberFireYearlyProjectionsWebRequest")
    private WebRequest mockWebRequest;

    @Test
    public void shouldBeAbleToCollectFourHundredSeventeenPlayers() throws Exception {
        assertThat(numberFireYearlyProjectionsRecordCollector.apply("https://www.numberfire.com/nba/fantasy/yearly-projections/guards", mockWebRequest).size(), is(equalTo(417)));
    }
}
