package com.btanabe.fsdu.models;

/**
 * Created by Brian on 12/4/15.
 */
public class EspnFantasyLeaguePlayerOwnershipModel {
    private Integer espnPlayerId;
    private Integer espnFantasyLeagueId;
    private String espnFantasyOwnerTeamName;
    private String playerFullName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EspnFantasyLeaguePlayerOwnershipModel that = (EspnFantasyLeaguePlayerOwnershipModel) o;

        if (!espnFantasyLeagueId.equals(that.espnFantasyLeagueId)) return false;
        if (!espnFantasyOwnerTeamName.equals(that.espnFantasyOwnerTeamName)) return false;
        if (!espnPlayerId.equals(that.espnPlayerId)) return false;
        if (!playerFullName.equals(that.playerFullName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = espnPlayerId.hashCode();
        result = 31 * result + espnFantasyLeagueId.hashCode();
        result = 31 * result + espnFantasyOwnerTeamName.hashCode();
        result = 31 * result + playerFullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("playerFullName=[%s], espnPlayerId=[%d], espnFantasyLeagueId=[%d], espnFantasyOwnerTeamName=[%s]", playerFullName, espnPlayerId, espnFantasyLeagueId, espnFantasyOwnerTeamName);
    }

    public Integer getEspnPlayerId() {
        return espnPlayerId;
    }

    public void setEspnPlayerId(Integer espnPlayerId) {
        this.espnPlayerId = espnPlayerId;
    }

    public Integer getEspnFantasyLeagueId() {
        return espnFantasyLeagueId;
    }

    public void setEspnFantasyLeagueId(Integer espnFantasyLeagueId) {
        this.espnFantasyLeagueId = espnFantasyLeagueId;
    }

    public String getEspnFantasyOwnerTeamName() {
        return espnFantasyOwnerTeamName;
    }

    public void setEspnFantasyOwnerTeamName(String espnFantasyOwnerTeamName) {
        this.espnFantasyOwnerTeamName = espnFantasyOwnerTeamName;
    }

    public String getPlayerFullName() { return playerFullName; }

    public void setPlayerFullName(String playerFullName) {
        this.playerFullName = playerFullName;
    }
}
