package com.btanabe.fsdu.test.unit.parsers;

import com.btanabe.fsdu.models.EspnProjectionModel;
import com.btanabe.fsdu.parsers.RecordParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 7/28/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RecordParserTests {

    @Qualifier("espnPlayerProjectionRecordParserBean")
    @Autowired
    private RecordParser<EspnProjectionModel> eddieLacyRecordParser;

    @Autowired
    @Qualifier("eddieLacyEspnProjectionModel")
    private EspnProjectionModel expectedEddieLacyProjectionModel;

    private EspnProjectionModel eddieLacyProjectionModel;

    @Before
    public void parseEddieLacysProjections() throws Exception {
        eddieLacyProjectionModel = eddieLacyRecordParser.parseRecord();
    }

    @Test
    public void shouldBeAbleToParseEddieLacyIntoProjectionObject() throws Exception {
        assertThat(eddieLacyRecordParser.parseRecord(), isA(EspnProjectionModel.class));
    }

    @Test
    public void shouldBeAbleToParseEddieLacysNameProperly() {
        assertThat(eddieLacyProjectionModel.getName(), is(equalTo(expectedEddieLacyProjectionModel.getName())));
    }
}
