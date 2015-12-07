package com.btanabe.fsdu.models;

/**
 * Created by Brian on 12/4/15.
 */
public class EspnFantasyLeaguePlayerOwnershipModel {
    private Integer espnPlayerId;
    private Integer espnFantasyLeagueId;
    private String espnFantasyOwnerTeamName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EspnFantasyLeaguePlayerOwnershipModel)) return false;

        EspnFantasyLeaguePlayerOwnershipModel that = (EspnFantasyLeaguePlayerOwnershipModel) o;

        if (!espnFantasyLeagueId.equals(that.espnFantasyLeagueId)) return false;
        if (espnFantasyOwnerTeamName != null ? !espnFantasyOwnerTeamName.equals(that.espnFantasyOwnerTeamName) : that.espnFantasyOwnerTeamName != null)
            return false;
        if (!espnPlayerId.equals(that.espnPlayerId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = espnPlayerId.hashCode();
        result = 31 * result + espnFantasyLeagueId.hashCode();
        result = 31 * result + (espnFantasyOwnerTeamName != null ? espnFantasyOwnerTeamName.hashCode() : 0);
        return result;
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
}
