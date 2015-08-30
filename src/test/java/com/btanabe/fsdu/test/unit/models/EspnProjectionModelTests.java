package com.btanabe.fsdu.test.unit.models;

import com.btanabe.fsdu.models.EspnProjectionModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 7/28/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnProjectionModelTests {
    @Autowired
    @Qualifier("eddieLacyEspnProjectionModel")
    private EspnProjectionModel lhs;

    @Autowired
    @Qualifier("eddieLacyEspnProjectionModel")
    private EspnProjectionModel rhs;

    @Test
    public void shouldBeAbleDetermineEquality() {
        assertEquals(lhs, rhs);
    }

    @Test
    public void shouldBeAbleToCorrectlyFormatItsStringRepresentation() {
        assertThat(lhs.toString(), is(equalTo("rank=[3], name=[Eddie Lacy], team=[GB], position=[RB], passingCompletions=[0], passingAttempts=[0], passingYards=[0], passingTouchdowns=[0], interceptions=[0], rushingAttempts=[293], rushingYards=[1297], rushingTouchdowns=[9], receptions=[46], receivingYards=[323], receivingTouchdowns=[3], fantasyPoints=[229.600000]")));
    }
}
