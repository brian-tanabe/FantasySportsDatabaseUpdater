package com.btanabe.fsdu.test.unit.parsers.record.parser;

import com.btanabe.fsdu.models.EspnFantasyLeaguePlayerOwnershipModel;
import com.btanabe.fsdu.parsers.RecordParser;
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
 * Created by Brian on 12/6/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EspnPlayerRaterPageRecordParserTests {

    @Autowired
    @Qualifier("espnNbaPlayerRaterPagePaginatedRecordParser")
    private RecordParser<EspnFantasyLeaguePlayerOwnershipModel> playerOwnershipRecordParser;

    @Autowired
    @Qualifier("espnNbaHoopDreamsPlayerRaterPageRussellWestbrook")
    private String russellWestbrookPlayerRaterRow;

    @Autowired
    @Qualifier("espnNbaHoopDreamsPlayerRaterPageChristianWood")
    private String christianWoodPlayerRaterRow;

    @Autowired
    @Qualifier("russellWestbrookOwnedEspnPlayerRaterOwnershipModel")
    private EspnFantasyLeaguePlayerOwnershipModel expectedRussellWestbrookOwnershipModel;

    @Autowired
    @Qualifier("christianWoodUnownedEspnPlayerRaterOwnershipModel")
    private EspnFantasyLeaguePlayerOwnershipModel expectedChristianWoodOwnershipModel;

    @Test
    public void shouldBeAbleToExtractRussellWestbrookProperly() throws Exception {
        playerOwnershipRecordParser.setInputHtml(russellWestbrookPlayerRaterRow);
        assertThat(playerOwnershipRecordParser.getRecord(), is(equalTo(expectedRussellWestbrookOwnershipModel)));
    }

    @Test
    public void shouldBeAbleToExtractChristianWoodProperly() throws Exception {
        playerOwnershipRecordParser.setInputHtml(christianWoodPlayerRaterRow);
        assertThat(playerOwnershipRecordParser.getRecord(), is(equalTo(expectedChristianWoodOwnershipModel)));
    }
}
