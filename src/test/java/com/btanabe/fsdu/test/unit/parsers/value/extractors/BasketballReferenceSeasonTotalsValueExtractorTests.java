package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Brian on 11/22/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BasketballReferenceSeasonTotalsValueExtractorTests {

    @Autowired
    @Qualifier("basketballReferenceSeasonTotals20142015QuincyAcy")
    private String quincyAcySeasonTotals;

    @Test
    public void shouldBeAbleToExtractFullNameFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractGamesPlayedFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractGamesStartedFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractMinutesPlayedFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractFieldGoalsAttemptedFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractFieldGoalsMadeFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractFieldGoalPercentageFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractThreePointersAttemptedFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractThreePointersMadeFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractThreePointPercentageFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractTwoPointersAttemptedFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractTwoPointersMadeFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractTwoPointersPercentageFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractEffectiveFieldGoalPercentageFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractFreeThrowsAttemptedFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractFreeThrowsMadeFromSeasonsTotalsPage() {

    }
    @Test
    public void shouldBeAbleToExtractFreeThrowPercentageFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractOffensiveReboundsFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractDefensiveReboundsFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractTotalReboundsFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractAssistsFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractStealsFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractBlocksFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractTurnoversFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractPersonalFoulsFromSeasonsTotalsPage() {

    }

    @Test
    public void shouldBeAbleToExtractPointsFromSeasonsTotalsPage() {

    }
}
