package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import com.btanabe.fsdu.models.PlayerIdModel;
import com.btanabe.fsdu.parsers.ValueExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by brian on 12/19/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class NumberFireYearlyProjectionsValueExtractorTests {

    @Autowired
    @Qualifier("numberFireFullNameValueExtractor")
    private ValueExtractor fullNameValueExtractor;

    @Autowired
    @Qualifier("numberFireFirstNameValueExtractor")
    private ValueExtractor firstNameValueExtractor;

    @Autowired
    @Qualifier("numberFireLastNameValueExtractor")
    private ValueExtractor lastNameValueExtractor;

    @Autowired
    @Qualifier("numberFireEspnIdValueExtractor")
    private ValueExtractor espnIdValueExtractor;

    @Autowired
    @Qualifier("numberFireYahooIdValueExtractor")
    private ValueExtractor yahooIdValueExtractor;

    @Autowired
    @Qualifier("numberFireBasketballReferenceIdValueExtractor")
    private ValueExtractor basketballReferenceIdValueExtractor;

    @Autowired
    @Qualifier("numberFireNextPageValueExtractor")
    private ValueExtractor nextPageValueExtractor;

    @Autowired
    @Qualifier("stephenCurryPlayerIdModel")
    private PlayerIdModel expectedStephenCurryModel;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsStephenCurry")
    private String numberFireYearlyProjectionsStephenCurry;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsGuards")
    private String numberFireYearlyProjectionsGuardsPage;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsForwards")
    private String numberFireYearlyProjectionsForwardsPage;

    @Autowired
    @Qualifier("numberFireYearlyProjectionsCenters")
    private String numberFireYearlyProjectionsCentersPage;

    @Test
    public void shouldBeAbleToExtractFirstNamesFromNumberFireYearlyProjectionsPage() throws Exception {
        assertThat(firstNameValueExtractor.apply(numberFireYearlyProjectionsStephenCurry), is(equalTo(expectedStephenCurryModel.getFirstName())));
    }

    @Test
    public void shouldBeAbleToExtractLastNameFromNumberFireYearlyProjectionsPage() throws Exception {
        assertThat(lastNameValueExtractor.apply(numberFireYearlyProjectionsStephenCurry), is(equalTo(expectedStephenCurryModel.getLastName())));
    }

    @Test
    public void shouldBeAbleToExtractFullNameFromNumberFireYearlyProjectionsPage() throws Exception {
        assertThat(fullNameValueExtractor.apply(numberFireYearlyProjectionsStephenCurry), is(equalTo(expectedStephenCurryModel.getFullName())));
    }

    @Test
    public void shouldBeAbleToExtractEspnIdFromNumberFireYearlyProjectionsPage() throws Exception {
        assertThat(espnIdValueExtractor.apply(numberFireYearlyProjectionsStephenCurry), is(equalTo(expectedStephenCurryModel.getEspnId())));
    }

    @Test
    public void shouldBeAbleToExtractBasketballReferenceIdFromNumberFireYearlyProjectionsPage() throws Exception {
        assertThat(basketballReferenceIdValueExtractor.apply(numberFireYearlyProjectionsStephenCurry), is(equalTo(expectedStephenCurryModel.getBasketballReferenceId())));
    }

    @Test
    public void shouldBeAbleToExtractYahooIdFromNumberFireYearlyProjectionsPage() throws Exception {
        assertThat(yahooIdValueExtractor.apply(numberFireYearlyProjectionsStephenCurry), is(equalTo(expectedStephenCurryModel.getYahooId())));
    }

    @Test
    public void shouldBeAbleToFindTheSecondPagesLinkFromTheGuardsPage() throws Exception {
        assertThat(nextPageValueExtractor.apply(numberFireYearlyProjectionsGuardsPage), is(equalTo("https://www.numberfire.com/nba/fantasy/yearly-projections/forwards")));
    }

    @Test
    public void shouldBeAbleToFindTheThirdPagesLinkFromTheForwardsPage() throws Exception {
        assertThat(nextPageValueExtractor.apply(numberFireYearlyProjectionsForwardsPage), is(equalTo("https://www.numberfire.com/nba/fantasy/yearly-projections/centers")));
    }

    @Test
    public void shouldNotFindAnotherLinkFromTheCentersPage() throws Exception {
        assertThat(nextPageValueExtractor.apply(numberFireYearlyProjectionsCentersPage), is(equalTo("")));
    }
}
