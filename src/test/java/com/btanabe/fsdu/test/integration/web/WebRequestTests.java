package com.btanabe.fsdu.test.integration.web;

import com.btanabe.fsdu.collectors.RecordCollector;
import com.btanabe.fsdu.web.WebRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 8/30/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WebRequestTests {
    private static final int TEN_SECONDS = 10000;

    @Autowired
    @Qualifier("espnNbaPlayerRaterPageRecordCollector")
    private RecordCollector nbaPlayerRaterPageRecordCollector;

    @Test(timeout = TEN_SECONDS)
    public void shouldBeAbleToDownloadEspnProjectionsSource() throws Exception {
        WebRequest webRequest = new WebRequest();
        String htmlFromFunction = webRequest.downloadWebPageSource("http://games.espn.go.com/ffl/tools/projections?");
        assertThat(htmlFromFunction, containsString("<title>2015 Fantasy Football Rankings &amp; Projections - Free Fantasy Football - ESPN</title>"));
    }

    @Test(timeout = TEN_SECONDS)
    public void shouldBeAbleToDownloadMoreThanOnePageSourceAtOnce() {}

    public void shouldBeAbleToDownloadLeagueSpecificContentFromEspn() throws Exception {
        WebRequest webRequest = new WebRequest();
        assertThat(nbaPlayerRaterPageRecordCollector.apply("http://games.espn.go.com/fba/playerrater?leagueId=233928", webRequest).size(), is(equalTo(643)));
    }
}
