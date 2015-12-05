package com.btanabe.fsdu.test.unit.processors;

import com.btanabe.fsdu.models.BasketballReferenceSeasonTotalsModel;
import com.btanabe.fsdu.processors.RecordCombiner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Brian on 11/27/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RecordCombinerTests {

    @Autowired
    @Qualifier("basketballReferenceSeasonTotalsRecordCombiner")
    private RecordCombiner seasonTotalsRecordCombiner;

    @Resource(name= "basketballReferenceSeasonTotalsTwoTeamsInOneSeasonModelList")
    private List<BasketballReferenceSeasonTotalsModel> twoTeamPlayerList;

    @Resource(name = "basketballReferenceSeasonTotalsThreeTeamsInOneSeasonModelList")
    private List<BasketballReferenceSeasonTotalsModel> threeTeamPlayerList;

    @Resource(name = "basketballReferenceSeasonTotalsMultiplePlayersModelList")
    private List<BasketballReferenceSeasonTotalsModel> multiplePlayersList;

    @Test
    public void shouldBeAbleToFlattenTeamsIntoCommaSeparatedList() throws Exception {
        seasonTotalsRecordCombiner.setUncombinedRecordList(twoTeamPlayerList);
        List<BasketballReferenceSeasonTotalsModel> combinedRecords = seasonTotalsRecordCombiner.combineRecords();

        assertThat(combinedRecords.size(), is(equalTo(3)));
        assertThat(combinedRecords.stream().filter(t -> t.getTeam().equals("TOT")).count(), is(equalTo(0L)));
        assertThat(combinedRecords.stream().filter(t -> t.getTeam().equals("DEN,POR")).count(), is(equalTo(1L)));
        assertThat(combinedRecords.stream().filter(t -> t.getTeam().equals("DEN")).count(), is(equalTo(1L)));
        assertThat(combinedRecords.stream().filter(t -> t.getTeam().equals("POR")).count(), is(equalTo(1L)));
    }

    @Test
    public void shouldBeAbleToFlattenMoreThanTwoTeamsIntoCommaSeparatedList() throws Exception {
        seasonTotalsRecordCombiner.setUncombinedRecordList(threeTeamPlayerList);
        List<BasketballReferenceSeasonTotalsModel> combinedRecords = seasonTotalsRecordCombiner.combineRecords();

        assertThat(combinedRecords.size(), is(equalTo(4)));
        assertThat(combinedRecords.stream().filter(t -> t.getTeam().equals("TOT")).count(), is(equalTo(0L)));
        assertThat(combinedRecords.stream().filter(t -> t.getTeam().equals("HOU,MIN,CHO")).count(), is(equalTo(1L)));
        assertThat(combinedRecords.stream().filter(t -> t.getTeam().equals("HOU")).count(), is(equalTo(1L)));
        assertThat(combinedRecords.stream().filter(t -> t.getTeam().equals("MIN")).count(), is(equalTo(1L)));
        assertThat(combinedRecords.stream().filter(t -> t.getTeam().equals("CHO")).count(), is(equalTo(1L)));
    }

    @Test
    public void shouldNotCombineNonMatchingRecords() throws Exception {
        seasonTotalsRecordCombiner.setUncombinedRecordList(multiplePlayersList);
        List<BasketballReferenceSeasonTotalsModel> combinedRecords = seasonTotalsRecordCombiner.combineRecords();

        assertThat(combinedRecords.size(), is(equalTo(8)));

        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Tony Daniels")).count(), is(equalTo(4L)));
        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Tony Daniels") && player.getTeam().equals("TOT")).count(), is(equalTo(0L)));
        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Tony Daniels") && player.getTeam().equals("HOU,MIN,CHO")).count(), is(equalTo(1L)));
        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Tony Daniels") && player.getTeam().equals("HOU")).count(), is(equalTo(1L)));
        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Tony Daniels") && player.getTeam().equals("MIN")).count(), is(equalTo(1L)));
        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Tony Daniels") && player.getTeam().equals("CHO")).count(), is(equalTo(1L)));

        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Arron Afflalo")).count(), is(equalTo(3L)));
        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Arron Afflalo") && player.getTeam().equals("TOT")).count(), is(equalTo(0L)));
        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Arron Afflalo") && player.getTeam().equals("DEN")).count(), is(equalTo(1L)));
        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Arron Afflalo") && player.getTeam().equals("POR")).count(), is(equalTo(1L)));

        assertThat(combinedRecords.stream().filter(player -> player.getName().equals("Quincy Acy")).count(), is(equalTo(1L)));
    }
}
