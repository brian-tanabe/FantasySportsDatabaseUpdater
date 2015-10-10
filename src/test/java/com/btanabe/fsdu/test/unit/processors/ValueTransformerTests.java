package com.btanabe.fsdu.test.unit.processors;

import com.btanabe.fsdu.processors.ValueTransformer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    private ValueTransformer nullToNegativeOneValueTransformer;

    @Test
    public void shouldBeAbleToHandleTransformationsOfNullInputs() throws Exception {
        assertThat(nullToNegativeOneValueTransformer.transformValue(null), is(equalTo(-1)));
    }

    @Test
    public void shouldBeAbleToTransformOneToOneSinceOnePlusZeroIsOne() throws Exception {
        assertThat(nullToNegativeOneValueTransformer.transformValue(1), is(equalTo(1)));
    }
}
