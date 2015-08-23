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
 * Created by Brian on 7/28/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ValueExtractorTests {

    @Qualifier("espnProjectionsNextPageValueExtractor")
    @Autowired private ValueExtractor testStringValueExtraction;

    @Qualifier("espnProjectionsRushingYardsProjection")
    @Autowired private ValueExtractor testIntegerValueExtraction;

    @Qualifier("espnProjectionsFantasyPointsProjection")
    @Autowired private ValueExtractor testFloatValueExtraction;

    @Test
    public void shouldBeAbleToExtractStrings() throws ClassNotFoundException {
        assertThat((String) testStringValueExtraction.getValue() , is(equalTo("http://games.espn.go.com/ffl/tools/projections?&amp;startIndex=40")));
    }

    @Test
    public void shouldBeAbleToExtractIntegers() throws ClassNotFoundException {
        assertThat((Integer) testIntegerValueExtraction.getValue(), is(equalTo(1365)));
    }

    @Test
    public void shouldBeAbleToExtractFloats() throws ClassNotFoundException {
        assertThat((Float) testFloatValueExtraction.getValue(), is(equalTo(287.4f)));
    }
}
