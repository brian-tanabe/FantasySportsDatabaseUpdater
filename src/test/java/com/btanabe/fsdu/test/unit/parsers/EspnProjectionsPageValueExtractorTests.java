package com.btanabe.fsdu.test.unit.parsers;

import com.btanabe.fsdu.parsers.ValueExtractor;
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
 * Created by brian on 8/23/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnProjectionsPageValueExtractorTests {

    @Qualifier("espnProjectionsEddieLacyNameValueExtractor")
    @Autowired
    private ValueExtractor testEspnProjectionsNameValueExtractor;

    @Test
    public void shouldBeAbleToExtractNamesFromEspnProjectionPages() throws ClassNotFoundException {
        assertThat(testEspnProjectionsNameValueExtractor.getValue(), is(equalTo("Eddie Lacy")));
    }
}
