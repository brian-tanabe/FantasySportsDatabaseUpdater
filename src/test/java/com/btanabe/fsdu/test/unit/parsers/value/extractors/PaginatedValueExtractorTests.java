package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import com.btanabe.fsdu.parsers.PaginatedValueExtractor;
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
 * Created by Brian on 8/29/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PaginatedValueExtractorTests {

    @Autowired
    @Qualifier("espnProjectionsPagePlayerValueExtractor")
    private PaginatedValueExtractor espnProjectionsPagePlayerValueExtractor;

    @Autowired
    @Qualifier("nflPositionPageRunningbacksValueExtractor")
    private PaginatedValueExtractor nflPositionPagePlayerValueExtractor;

    @Autowired
    @Qualifier("espnNflProjectionsPageOneFormatted")
    private String espnProjectionsPageOne;

    @Autowired
    @Qualifier("nflRunningBacksPageOneFormatted")
    private String nflRunningbacksPageOne;

    @Test
    public void shouldBeAbleToFindFortyPlayersOnOneEspnProjectionsPage() throws Exception {
        espnProjectionsPagePlayerValueExtractor.setInputStringToSearch(espnProjectionsPageOne);
        List<String> objectList = espnProjectionsPagePlayerValueExtractor.getValuesAsList();
        assertThat(objectList.size(), is(equalTo(40)));
    }

    @Test
    public void shouldBeAbleToFindSeventyFivePlayersOnOneNflPositionPage() throws Exception {
        nflPositionPagePlayerValueExtractor.setInputStringToSearch(nflRunningbacksPageOne);
        List<String> objectList = nflPositionPagePlayerValueExtractor.getValuesAsList();
        assertThat(objectList.size(), is(equalTo(75)));
    }
}
