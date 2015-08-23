package com.btanabe.fsdu.test.unit.parsers;

import com.btanabe.fsdu.models.EspnProjectionModel;
import com.btanabe.fsdu.parsers.RecordParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 7/28/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RecordParserTests {

    @Qualifier("espnPlayerProjectionRecordParserBean")
    @Autowired private RecordParser<EspnProjectionModel> eddieLacyRecordParser;

    @Test
    public void shouldBeAbleToParseEddieLacyIntoProjectionObject() {
        assertThat(eddieLacyRecordParser.parseRecord(), isA(EspnProjectionModel.class));
    }
}
