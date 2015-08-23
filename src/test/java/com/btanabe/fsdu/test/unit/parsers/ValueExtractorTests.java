package com.btanabe.fsdu.test.unit.parsers;

import com.btanabe.fsdu.parsers.ValueExtractor;
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

    @Qualifier("espnProjectionsNextPageValueExtractor")
    @Autowired private ValueExtractor testStringValueExtraction;

    @Qualifier("espnProjectionsRushingYardsProjection")
    @Autowired private ValueExtractor testIntegerValueExtraction;

    @Qualifier("espnProjectionsFantasyPointsProjection")
    @Autowired private ValueExtractor testFloatValueExtraction;

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
