package com.btanabe.fsdu.test.unit.processors;

import com.btanabe.fsdu.processors.HtmlTidier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Brian on 8/22/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HtmlTidierTests {

    @Qualifier("espnProjectionsPageOneUnformatted")
    @Autowired
    private String poorlyFormattedHtmlString;

    @Qualifier("espnProjectionsPageOneFormatted")
    @Autowired
    private String wellFormattedHtmlString;

    @Test
    public void formattingHtmlFilesShouldModifyTheFile() {
        assertThat(poorlyFormattedHtmlString, is(not(equalTo(wellFormattedHtmlString))));
    }

    @Test
    public void shouldBeAbleToCleanUpIncorrectIndentations() {
        assertThat(HtmlTidier.tidyHtmlAndConvertToXhtml(poorlyFormattedHtmlString), is(equalTo(wellFormattedHtmlString)));
    }

    @Test
    public void shouldBeAbleToReplaceAllNbspReferences() {
        assertThat(HtmlTidier.tidyHtmlAndConvertToXhtml(poorlyFormattedHtmlString), not(containsString("&nbsp")));
    }
}
