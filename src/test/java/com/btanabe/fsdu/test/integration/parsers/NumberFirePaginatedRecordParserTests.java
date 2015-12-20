package com.btanabe.fsdu.test.integration.parsers;

import com.btanabe.fsdu.models.PlayerIdModel;
import com.btanabe.fsdu.parsers.PaginatedRecordParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 12/19/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class NumberFirePaginatedRecordParserTests {

    @Autowired
    @Qualifier("numberFireYearlyProjectionsPagePaginatedRecordParser")
    private PaginatedRecordParser<PlayerIdModel> numberFirePaginatedRecordParser;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsGuards")
    private String numberFireGuardsPage;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsForwards")
    private String numberFireForwardsPage;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsCenters")
    private String numberFireCentersPage;

    @Autowired
    @Qualifier("stephenCurryPlayerIdModel")
    private PlayerIdModel expectedStephenCurryModel;

    private List<PlayerIdModel> guardsYearlyProjections;
    private List<PlayerIdModel> forwardsYearlyProjections;
    private List<PlayerIdModel> centersYearlyProjections;

    @Before
    public void parseNumberFireYearlyProjections() throws Exception {
        if (guardsYearlyProjections == null) {
            guardsYearlyProjections = numberFirePaginatedRecordParser.getRecordsAsList(numberFireGuardsPage);
            forwardsYearlyProjections = numberFirePaginatedRecordParser.getRecordsAsList(numberFireForwardsPage);
            centersYearlyProjections = numberFirePaginatedRecordParser.getRecordsAsList(numberFireCentersPage);
        }
    }

    @Test
    public void shouldBeAbleToFindTwoHundredEightGuards() throws Exception {
        assertThat(guardsYearlyProjections.size(), is(equalTo(208)));
    }

    @Test
    public void shouldBeAbleToFindTwoHundredFortyFourForwards() throws Exception {
        assertThat(forwardsYearlyProjections.size(), is(equalTo(244)));
    }

    @Test
    public void shouldBeAbleToFindOneHundredTwentyCenters() throws Exception {
        assertThat(centersYearlyProjections.size(), is(equalTo(120)));
    }

    @Test
    public void shouldBeAbleToParseStephenCurry() throws Exception {
        assertThat(guardsYearlyProjections.contains(expectedStephenCurryModel), is(true));
    }
}
