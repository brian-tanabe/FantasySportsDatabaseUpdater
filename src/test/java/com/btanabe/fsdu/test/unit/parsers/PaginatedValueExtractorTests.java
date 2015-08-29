package com.btanabe.fsdu.test.unit.parsers;

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
    @Qualifier("espnProjectionsPageOneFormattedBean")
    private String espnProjectionsPageOne;

    @Test
    public void shouldBeAbleToFindFortyPlayersOnOneEspnProjectionsPage() throws ClassNotFoundException {
        espnProjectionsPagePlayerValueExtractor.setInputStringToSearch(espnProjectionsPageOne);
        List<String> objectList = espnProjectionsPagePlayerValueExtractor.getValuesAsList();
        assertThat(objectList.size(), is(equalTo(40)));
    }
}
