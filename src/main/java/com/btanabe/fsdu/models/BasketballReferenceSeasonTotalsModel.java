package com.btanabe.fsdu.models;

/**
 * Created by Brian on 11/22/15.
 */
public class BasketballReferenceSeasonTotalsModel {
    private String name;
    private String team;
    private Integer gamesStarted;
    private Integer gamesPlayed;
    private Integer minutesPlayed;
    private Integer fieldGoalsMade;
    private Integer fieldGoalsAttempted;
    private Double fieldGoalPercentage;
    private Integer threePointersMade;
    private Integer threePointersAttempted;
    private Double threePointPercentage;
    private Integer twoPointersMade;
    private Integer twoPointersAttempted;
    private Double twoPointPercentage;
    private Double effectiveFieldGoalPercentage;
    private Integer freeThrowsMade;
    private Integer freeThrowsAttempted;
    private Double freeThrowPercentage;
    private Integer offensiveRebounds;
    private Integer defensiveRebounds;
    private Integer totalRebounds;
    private Integer assists;
    private Integer steals;
    private Integer blocks;
    private Integer turnovers;
    private Integer points;
    private Integer personalFouls;

    @Override
    public String toString() {
        return String.format("name=[%s], team=[%s], gamesStarted=[%d], gamesPlayed=[%d], minutesPlayed=[%d], fieldGoalsMade=[%d], fieldGoalsAttempted=[%d], fieldGoalPercentage=[%d], threePointersMade=[%d], threePointersAttempted=[%d], threePointPercentage=[%d], twoPointersMade=[%d], twoPointersAttempted=[%d], twoPointPercentage=[%d], effectiveFieldGoalPercentage=[%d], freeThrowsMade=[%d], freeThrowsAttempted=[%d], freeThrowPercentage=[%d], offensiveRebounds=[%d], defensiveRebounds=[%d], totalRebounds=[%d], assists=[%d], steals=[%d], blocks=[%d], turnovers=[%d], points=[%d], personalFouls=[%d]", name, team, gamesStarted, gamesPlayed, minutesPlayed, fieldGoalsMade, fieldGoalsAttempted, fieldGoalPercentage, threePointersMade, threePointersAttempted, threePointPercentage, twoPointersMade, twoPointersAttempted, twoPointPercentage, effectiveFieldGoalPercentage, freeThrowsMade, freeThrowsAttempted, freeThrowPercentage, offensiveRebounds, defensiveRebounds, totalRebounds, assists, steals, blocks, turnovers, points, personalFouls);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasketballReferenceSeasonTotalsModel)) return false;

        BasketballReferenceSeasonTotalsModel that = (BasketballReferenceSeasonTotalsModel) o;

        if (!assists.equals(that.assists)) return false;
        if (!blocks.equals(that.blocks)) return false;
        if (!defensiveRebounds.equals(that.defensiveRebounds)) return false;
        if (!effectiveFieldGoalPercentage.equals(that.effectiveFieldGoalPercentage)) return false;
        if (!fieldGoalPercentage.equals(that.fieldGoalPercentage)) return false;
        if (!fieldGoalsAttempted.equals(that.fieldGoalsAttempted)) return false;
        if (!fieldGoalsMade.equals(that.fieldGoalsMade)) return false;
        if (!freeThrowPercentage.equals(that.freeThrowPercentage)) return false;
        if (!freeThrowsAttempted.equals(that.freeThrowsAttempted)) return false;
        if (!freeThrowsMade.equals(that.freeThrowsMade)) return false;
        if (!gamesPlayed.equals(that.gamesPlayed)) return false;
        if (!gamesStarted.equals(that.gamesStarted)) return false;
        if (!minutesPlayed.equals(that.minutesPlayed)) return false;
        if (!name.equals(that.name)) return false;
        if (!offensiveRebounds.equals(that.offensiveRebounds)) return false;
        if (!personalFouls.equals(that.personalFouls)) return false;
        if (!points.equals(that.points)) return false;
        if (!steals.equals(that.steals)) return false;
        if (!team.equals(that.team)) return false;
        if (!threePointPercentage.equals(that.threePointPercentage)) return false;
        if (!threePointersAttempted.equals(that.threePointersAttempted)) return false;
        if (!threePointersMade.equals(that.threePointersMade)) return false;
        if (!totalRebounds.equals(that.totalRebounds)) return false;
        if (!turnovers.equals(that.turnovers)) return false;
        if (!twoPointPercentage.equals(that.twoPointPercentage)) return false;
        if (!twoPointersAttempted.equals(that.twoPointersAttempted)) return false;
        if (!twoPointersMade.equals(that.twoPointersMade)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + team.hashCode();
        result = 31 * result + gamesStarted.hashCode();
        result = 31 * result + gamesPlayed.hashCode();
        result = 31 * result + minutesPlayed.hashCode();
        result = 31 * result + fieldGoalsMade.hashCode();
        result = 31 * result + fieldGoalsAttempted.hashCode();
        result = 31 * result + fieldGoalPercentage.hashCode();
        result = 31 * result + threePointersMade.hashCode();
        result = 31 * result + threePointersAttempted.hashCode();
        result = 31 * result + threePointPercentage.hashCode();
        result = 31 * result + twoPointersMade.hashCode();
        result = 31 * result + twoPointersAttempted.hashCode();
        result = 31 * result + twoPointPercentage.hashCode();
        result = 31 * result + effectiveFieldGoalPercentage.hashCode();
        result = 31 * result + freeThrowsMade.hashCode();
        result = 31 * result + freeThrowsAttempted.hashCode();
        result = 31 * result + freeThrowPercentage.hashCode();
        result = 31 * result + offensiveRebounds.hashCode();
        result = 31 * result + defensiveRebounds.hashCode();
        result = 31 * result + totalRebounds.hashCode();
        result = 31 * result + assists.hashCode();
        result = 31 * result + steals.hashCode();
        result = 31 * result + blocks.hashCode();
        result = 31 * result + turnovers.hashCode();
        result = 31 * result + points.hashCode();
        result = 31 * result + personalFouls.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(Integer gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public Integer getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }

    public void setFieldGoalsAttempted(Integer fieldGoalsAttempted) {
        this.fieldGoalsAttempted = fieldGoalsAttempted;
    }

    public Integer getFieldGoalsMade() {
        return fieldGoalsMade;
    }

    public void setFieldGoalsMade(Integer fieldGoalsMade) {
        this.fieldGoalsMade = fieldGoalsMade;
    }

    public Double getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public void setFieldGoalPercentage(Double fieldGoalPercentage) {
        this.fieldGoalPercentage = fieldGoalPercentage;
    }

    public Integer getThreePointersMade() {
        return threePointersMade;
    }

    public void setThreePointersMade(Integer threePointersMade) {
        this.threePointersMade = threePointersMade;
    }

    public Integer getThreePointersAttempted() {
        return threePointersAttempted;
    }

    public void setThreePointersAttempted(Integer threePointersAttempted) {
        this.threePointersAttempted = threePointersAttempted;
    }

    public Double getThreePointPercentage() {
        return threePointPercentage;
    }

    public void setThreePointPercentage(Double threePointPercentage) {
        this.threePointPercentage = threePointPercentage;
    }

    public Integer getTwoPointersMade() {
        return twoPointersMade;
    }

    public void setTwoPointersMade(Integer twoPointersMade) {
        this.twoPointersMade = twoPointersMade;
    }

    public Integer getTwoPointersAttempted() {
        return twoPointersAttempted;
    }

    public void setTwoPointersAttempted(Integer twoPointersAttempted) {
        this.twoPointersAttempted = twoPointersAttempted;
    }

    public Double getTwoPointPercentage() {
        return twoPointPercentage;
    }

    public void setTwoPointPercentage(Double twoPointPercentage) {
        this.twoPointPercentage = twoPointPercentage;
    }

    public Double getEffectiveFieldGoalPercentage() {
        return effectiveFieldGoalPercentage;
    }

    public void setEffectiveFieldGoalPercentage(Double effectiveFieldGoalPercentage) {
        this.effectiveFieldGoalPercentage = effectiveFieldGoalPercentage;
    }

    public Integer getFreeThrowsMade() {
        return freeThrowsMade;
    }

    public void setFreeThrowsMade(Integer freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    public Integer getFreeThrowsAttempted() {
        return freeThrowsAttempted;
    }

    public void setFreeThrowsAttempted(Integer freeThrowsAttempted) {
        this.freeThrowsAttempted = freeThrowsAttempted;
    }

    public Double getFreeThrowPercentage() {
        return freeThrowPercentage;
    }

    public void setFreeThrowPercentage(Double freeThrowPercentage) {
        this.freeThrowPercentage = freeThrowPercentage;
    }

    public Integer getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(Integer offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    public Integer getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(Integer defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public Integer getTotalRebounds() {
        return totalRebounds;
    }

    public void setTotalRebounds(Integer totalRebounds) {
        this.totalRebounds = totalRebounds;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getSteals() {
        return steals;
    }

    public void setSteals(Integer steals) {
        this.steals = steals;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(Integer turnovers) {
        this.turnovers = turnovers;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(Integer personalFouls) {
        this.personalFouls = personalFouls;
    }
}
