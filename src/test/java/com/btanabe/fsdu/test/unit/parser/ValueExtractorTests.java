package com.btanabe.fsdu.test.unit.parser;

import com.btanabe.fsdu.parser.ValueExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

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
    @Qualifier("espnProjectionsRushingYardsProjection")
    private ValueExtractor testIntegerValueExtraction;

    @Autowired
    @Qualifier("espnProjectionsFantasyPointsProjection")
    private ValueExtractor testFloatValueExtraction;

    @Test
    public void shouldBeAbleToExtractStrings() throws ClassNotFoundException {
        assertEquals("http://games.espn.go.com/ffl/tools/projections?&leagueId=84978&startIndex=40", testStringValueExtraction.getValue());
    }

    @Test
    public void shouldBeAbleToExtractIntegers() throws ClassNotFoundException {
        assertEquals(1365, testIntegerValueExtraction.getValue());
    }

    @Test
    public void shouldBeAbleToExtractFloats() throws ClassNotFoundException {
        assertEquals(287.4f, testFloatValueExtraction.getValue());
    }
}
