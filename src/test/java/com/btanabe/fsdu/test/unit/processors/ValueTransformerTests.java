package com.btanabe.fsdu.test.unit.processors;

import com.btanabe.fsdu.processors.ValueTransformer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by brian on 9/23/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ValueTransformerTests {

    @Autowired
    @Qualifier("nullToNegativeOneAsIntegerValueTransformer")
    private ValueTransformer nullToNegativeOneValueTransformer;

    @Autowired
    @Qualifier("unescapeAmpersandsValueTransformer")
    private ValueTransformer unescapeAmpersandsValueTransformer;

    @Autowired
    @Qualifier("commaSeparatedStringConcatenatorValueTransformer")
    private ValueTransformer commaSeparatedStringConcatenatorValueTransformer;

    @Autowired
    @Qualifier("nullToFaStringValueTransformer")
    private ValueTransformer nullToFaValueTransformer;

    @Test
    public void shouldBeAbleToHandleTransformationsOfNullInputs() throws Exception {
        assertThat(nullToNegativeOneValueTransformer.transformValue(null), is(equalTo(-1)));
    }

    @Test
    public void shouldBeAbleToTransformOneToOneSinceOnePlusZeroIsOne() throws Exception {
        assertThat(nullToNegativeOneValueTransformer.transformValue(1), is(equalTo(1)));
    }

    @Test
    public void shouldBeAbleToUnescapeAmpersandsUsingValueTransformers() throws Exception {
        assertThat(unescapeAmpersandsValueTransformer.transformValue("http://games.espn.go.com/fba/tools/projections?&amp;leagueId=233928&amp;startIndex=600"), is(equalTo(new String("http://games.espn.go.com/fba/tools/projections?&leagueId=233928&startIndex=600"))));
    }

    @Test
    public void shouldBeAbleToConcatenateTwoStringsUsingValueTransformers() throws Exception {
        List<String> teamList = new ArrayList<>();
        teamList.add("CHI");
        teamList.add("DEN");

        assertThat(commaSeparatedStringConcatenatorValueTransformer.transformValues(teamList), is(equalTo((Object) "CHI,DEN")));
    }

    @Test
    public void shouldBeAbleToTransformNullToFaAsString() throws Exception {
        assertThat(nullToFaValueTransformer.transformValue(null), is(equalTo("FA")));
    }

    @Test
    public void shouldNotTransformNonNullInputStringsWhenAttemptingToUseTheNullToFaStringValueTransformer() throws Exception {
        assertThat(nullToFaValueTransformer.transformValue(new String("SOME-STRING")), is(equalTo("SOME-STRING")));
    }
}
