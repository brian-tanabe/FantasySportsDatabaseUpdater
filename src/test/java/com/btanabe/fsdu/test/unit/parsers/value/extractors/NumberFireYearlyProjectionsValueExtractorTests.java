package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import com.btanabe.fsdu.parsers.ValueExtractor;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by brian on 12/19/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class NumberFireYearlyProjectionsValueExtractorTests {

    @Autowired
    @Qualifier("numberFireYearlyProjectionsPagePlayerValueExtractor")
    private ValueExtractor<String> numberFireYearlyProjectionsPlayerValueExtractor;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsGuards")
    private String numberFireGuardsPage;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsForwards")
    private String numberFireForwardsPage;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsCenters")
    private String numberFireCentersPage;


    @Test
    public void shouldBeAbleToFindTwoHundredEightGuardsOnNumberFiresYearlyGuardProjectionsPage() throws Exception {
        String playerObjects = numberFireYearlyProjectionsPlayerValueExtractor.apply(numberFireGuardsPage);

        assertThat(playerObjects, is(notNullValue()));

        JSONObject jsonArray = new JSONObject(playerObjects);
        jsonArray.keySet().forEach(key -> System.out.println(String.format("[[[%s]]] ", jsonArray.get(key))));
        assertThat(jsonArray.keySet().size(), is(equalTo(208)));

//        assertThat(playerObjects.size(), is(equalTo(208)));
    }

    @Test
    public void shouldBeAbleToExtractFirstNamesFromNumberFireYearlyProjectionsPage() throws Exception {
        fail("Not yet implemented!");
    }

    @Test
    public void shouldBeAbleToExtractLastNameFromNumberFireYearlyProjectionsPage() throws Exception {
        fail("Not yet implemented!");
    }

    @Test
    public void shouldBeAbleToExtractFullNameFromNumberFireYearlyProjectionsPage() throws Exception {
        fail("Not yet implemented!");
    }

    @Test
    public void shouldBeAbleToExtractEspnIdFromNumberFireYearlyProjectionsPage() throws Exception {
        fail("Not yet implemented!");
    }

    @Test
    public void shouldBeAbleToExtractBasketballReferenceIdFromNumberFireYearlyProjectionsPage() throws Exception {
        fail("Not yet implemented!");
    }

    @Test
    public void shouldBeAbleToExtractYahooIdFromNumberFireYearlyProjectionsPage() throws Exception {
        fail("Not yet implemented!");
    }
}
