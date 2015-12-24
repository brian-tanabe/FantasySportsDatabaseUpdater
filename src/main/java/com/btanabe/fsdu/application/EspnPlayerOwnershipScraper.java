package com.btanabe.fsdu.application;

import com.btanabe.fsdu.collectors.RecordCollector;
import com.btanabe.fsdu.models.EspnFantasyLeaguePlayerOwnershipModel;
import com.btanabe.fsdu.web.WebRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

/**
 * Created by Brian on 12/23/15.
 */

public class EspnPlayerOwnershipScraper {

    @Autowired
    @Qualifier("espnNbaPlayerRaterPageRecordCollector")
    private RecordCollector nbaPlayerRaterPageRecordCollector;

    public void printPlayersOwnedByTheParameterizedTeam(String espnTeamName) {
        Set<EspnFantasyLeaguePlayerOwnershipModel> allPlayersOwnershipInformation = (Set<EspnFantasyLeaguePlayerOwnershipModel>) nbaPlayerRaterPageRecordCollector.apply("http://games.espn.go.com/fba/playerrater?leagueId=233928", new WebRequest());
        allPlayersOwnershipInformation.stream().filter(player -> player.getEspnFantasyLeagueId().equals(espnTeamName)).forEach(System.out::println);
    }
}
