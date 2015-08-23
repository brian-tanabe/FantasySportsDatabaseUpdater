package com.btanabe.fsdu.test.unit.parsers;

import com.btanabe.fsdu.models.EspnProjectionModel;
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
 * Created by brian on 8/23/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnProjectionsPageValueExtractorTests {

    @Qualifier("espnProjectionsPageEddieLacyBean")
    @Autowired
    private String eddieLacyEspnProjectionPageHtml;

    @Autowired
    @Qualifier("eddieLacyEspnProjectionModel")
    private EspnProjectionModel expectedEddieLacyProjectionModel;

    @Autowired
    private ValueExtractor espnProjectionsNameValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsNflTeamValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsPositionValueExtractor;

    @Autowired
    private ValueExtractor espnProjectionsPassingAttemptsValueExtractor;

    @Test
    public void shouldBeAbleToExtractNamesFromEspnProjectionPages() throws ClassNotFoundException {
        espnProjectionsNameValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsNameValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getName())));
    }

    @Test
    public void shouldBeAbleToExtractNflTeamNamesFromEspnProjectionPages() throws ClassNotFoundException {
        espnProjectionsNflTeamValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsNflTeamValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getTeam())));
    }

    @Test
    public void shouldBeAbleToExtractPositionFromEspnProjectionPages() throws ClassNotFoundException {
        espnProjectionsPositionValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsPositionValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getPosition())));
    }

    @Test
    public void shouldBeAbleToExtractPassingAttemptsFromEspnProjectionPages() throws ClassNotFoundException {
        espnProjectionsPassingAttemptsValueExtractor.setInputStringToSearch(eddieLacyEspnProjectionPageHtml);
        assertThat(espnProjectionsPassingAttemptsValueExtractor.getValue(), is(equalTo((Object) expectedEddieLacyProjectionModel.getPassingCompletions())));
    }
}
