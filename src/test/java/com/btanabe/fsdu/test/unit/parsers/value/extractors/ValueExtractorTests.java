package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import com.btanabe.fsdu.parsers.ValueExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 7/28/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ValueExtractorTests {

    @Autowired
    @Qualifier("espnProjectionsNextPageValueExtractor")
    private ValueExtractor testStringValueExtraction;

    @Autowired
    @Qualifier("espnProjectionsRushingYardsValueExtractor")
    private ValueExtractor testIntegerValueExtraction;

    @Autowired
    @Qualifier("espnProjectionsFantasyPointsValueExtractor")
    private ValueExtractor testFloatValueExtraction;

    @Autowired
    private String espnNflProjectionsPageOne;

    @Autowired
    private String espnProjectionsPageEddieLacy;

    @Test
    public void shouldBeAbleToExtractStrings() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        testStringValueExtraction.setInputStringToSearch(espnNflProjectionsPageOne);
        assertThat(testStringValueExtraction.getValue(), equalTo("http://games.espn.go.com/ffl/tools/projections?&amp;startIndex=40"));
    }

    @Test
    public void shouldBeAbleToExtractIntegers() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        testIntegerValueExtraction.setInputStringToSearch(espnProjectionsPageEddieLacy);
        assertThat(testIntegerValueExtraction.getValue(), is(equalTo(1297)));
    }

    @Test
    public void shouldBeAbleToExtractFloats() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        testFloatValueExtraction.setInputStringToSearch(espnProjectionsPageEddieLacy);
        assertThat(testFloatValueExtraction.getValue(), is(equalTo((Object) 229.6)));
    }
}
