package com.btanabe.fsdu.test.unit.parsers.value.extractors;

import com.btanabe.fsdu.models.EspnPlayerPageModel;
import com.btanabe.fsdu.parsers.ValueExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by brian on 9/20/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnPlayerPageValueExtractorTests {

    @Autowired
    private String espnPlayerPageEddieLacy;

    @Autowired
    private String espnPlayerPageBrandonMcManus;

    @Autowired
    private EspnPlayerPageModel eddieLacyEspnPlayerPageModel;

    @Autowired
    private EspnPlayerPageModel brandonMcManusEspnPlayerPageModel;

    @Autowired
    private ValueExtractor espnPlayerPagePlayerIdValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageHeightValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageWeightValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageBirthdayValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageExperienceValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageCollegeValueExtractor;

    @Autowired
    private ValueExtractor espnPlayerPageDraftPickValueExtractor;

    @Test
    public void shouldBeAbleToExtractPlayerIdFromEspnPlayerPage() throws Exception {
        espnPlayerPagePlayerIdValueExtractor.setInputStringToSearch(espnPlayerPageEddieLacy);
        assertThat(espnPlayerPagePlayerIdValueExtractor.getValue(), is(equalTo(eddieLacyEspnPlayerPageModel.getPlayerId())));
    }

    @Test
    public void shouldBeAbleToExtractPlayerHeightFromEspnPlayerPage() throws Exception {
        espnPlayerPageHeightValueExtractor.setInputStringToSearch(espnPlayerPageEddieLacy);
        assertThat(espnPlayerPageHeightValueExtractor.getValue(), is(equalTo(eddieLacyEspnPlayerPageModel.getHeight())));
    }

    @Test
    public void shouldBeAbleToExtractPlayerWeightFromEspnPlayerPage() throws Exception {
        espnPlayerPageWeightValueExtractor.setInputStringToSearch(espnPlayerPageEddieLacy);
        assertThat(espnPlayerPageWeightValueExtractor.getValue(), is(equalTo(eddieLacyEspnPlayerPageModel.getWeightInPounds())));
    }

    @Test
    public void shouldBeAbleToExtractBirthdayFromEspnPlayerPage() throws Exception {
        espnPlayerPageBirthdayValueExtractor.setInputStringToSearch(espnPlayerPageEddieLacy);
        assertThat(espnPlayerPageBirthdayValueExtractor.getValue(), is(equalTo(eddieLacyEspnPlayerPageModel.getBirthday())));
    }

    @Test
    public void shouldBeAbleToExtractExperienceFromEspnPlayerPage() throws Exception {
        espnPlayerPageExperienceValueExtractor.setInputStringToSearch(espnPlayerPageEddieLacy);
        assertThat(espnPlayerPageExperienceValueExtractor.getValue(), is(equalTo(eddieLacyEspnPlayerPageModel.getExperienceInYears())));
    }

    @Test
    public void shouldBeAbleToExtractCollegeFromEspnPlayerPage() throws Exception {
        espnPlayerPageCollegeValueExtractor.setInputStringToSearch(espnPlayerPageEddieLacy);
        assertThat(espnPlayerPageCollegeValueExtractor.getValue(), is(equalTo(eddieLacyEspnPlayerPageModel.getCollege())));
    }

    @Test
    public void shouldBeAbleToExtractDraftPickFromEspnPlayerPage() throws Exception {
        espnPlayerPageDraftPickValueExtractor.setInputStringToSearch(espnPlayerPageEddieLacy);
        assertThat(espnPlayerPageDraftPickValueExtractor.getValue(), is(equalTo(eddieLacyEspnPlayerPageModel.getDraftPickTaken())));
    }

    @Test
    public void shouldBeAbleToExtractDraftPickFromUndraftedPlayersAsNegativeOne() throws Exception {
        espnPlayerPageDraftPickValueExtractor.setInputStringToSearch(espnPlayerPageBrandonMcManus);
        assertThat(espnPlayerPageDraftPickValueExtractor.getValue(), is(equalTo(brandonMcManusEspnPlayerPageModel.getDraftPickTaken())));
    }
}
