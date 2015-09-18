package com.btanabe.fsdu.test.integration.web;

import com.btanabe.fsdu.web.WebRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 8/30/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WebRequestTests {

    @Test
    public void shouldBeAbleToDownloadNumberFireSource() throws Exception {
        WebRequest webRequest = new WebRequest();
        String htmlFromFunction = webRequest.downloadWebPageSource("http://games.espn.go.com/ffl/tools/projections?");
        assertThat(htmlFromFunction, containsString("<title>2015 Fantasy Football Rankings &amp; Projections - Free Fantasy Football - ESPN</title>"));
    }
}
