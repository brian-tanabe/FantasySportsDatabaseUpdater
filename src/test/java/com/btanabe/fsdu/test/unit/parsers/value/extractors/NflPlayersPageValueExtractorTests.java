package com.btanabe.fsdu.test.unit.parsers.value.extractors;

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
 * Created by brian on 9/19/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class NflPlayersPageValueExtractorTests {

    @Autowired
    @Qualifier("nflRunningBacksAmeerAbdullahFormatted")
    private String ameerAbdullahNflRosterPageHtml;

    @Autowired
    private ValueExtractor nflPositionPagePositionValueExtractor;

    @Autowired
    private ValueExtractor nflPositionPageFirstNameValueExtractor;

    @Autowired
    private ValueExtractor nflPositionPageLastNameValueExtractor;

    @Autowired
    private ValueExtractor nflPositionPageCompleteNameValueExtractor;

    @Autowired
    private ValueExtractor nflPositionPageNflTeamValueExtractor;

    @Autowired
    private ValueExtractor nflPositionPagePlayerProfilePageLinkValueExtractor;

    @Test
    public void shouldBeAbleToExtractPositionFromNflPositionPages() throws Exception {
        nflPositionPagePositionValueExtractor.setInputStringToSearch(ameerAbdullahNflRosterPageHtml);
        assertThat(nflPositionPagePositionValueExtractor.getValue(), is(equalTo("RB")));
    }

    @Test
    public void shouldBeAbleToExtractFirstNameFromNflPositionPages() throws Exception {
        nflPositionPageFirstNameValueExtractor.setInputStringToSearch(ameerAbdullahNflRosterPageHtml);
        assertThat(nflPositionPageFirstNameValueExtractor.getValue(), is(equalTo("Ameer")));
    }

    @Test
    public void shouldBeAbleToExtractLastNameFromNflPositionPages() throws Exception {
        nflPositionPageLastNameValueExtractor.setInputStringToSearch(ameerAbdullahNflRosterPageHtml);
        assertThat(nflPositionPageLastNameValueExtractor.getValue(), is(equalTo("Abdullah")));
    }

    @Test
    public void shouldBeAbleToExtractCompleteNameFromNflPositionPages() throws Exception {
        nflPositionPageCompleteNameValueExtractor.setInputStringToSearch(ameerAbdullahNflRosterPageHtml);
        assertThat(nflPositionPageCompleteNameValueExtractor.getValue(), is(equalTo("Abdullah, Ameer")));
    }

    @Test
    public void shouldBeAbleToExtractNflTeamFromNflPositionPages() throws Exception {
        nflPositionPageNflTeamValueExtractor.setInputStringToSearch(ameerAbdullahNflRosterPageHtml);
        assertThat(nflPositionPageNflTeamValueExtractor.getValue(), is(equalTo("DET")));
    }

    @Test
    public void shouldBeAbleToExtractPlayerProfilePageLinkFromNflPositionPages() throws Exception {
        nflPositionPagePlayerProfilePageLinkValueExtractor.setInputStringToSearch(ameerAbdullahNflRosterPageHtml);
        assertThat(nflPositionPagePlayerProfilePageLinkValueExtractor.getValue(), is(equalTo("/player/ameerabdullah/2552374/profile")));
    }
}
