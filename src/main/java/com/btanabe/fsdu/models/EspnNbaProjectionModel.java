package com.btanabe.fsdu.models;

/**
 * Created by Brian on 10/10/15.
 */
public class EspnNbaProjectionModel {
    private Integer playerId;
    private Integer rank;
    private String name;
    private String team;
    private String position;
    private Double fieldGoalPercentage;
    private Double freeThrowPercentage;
    private Double threePointMadePerGame;
    private Double reboundsPerGame;
    private Double assistsPerGame;
    private Double stealsPerGame;
    private Double blocksPerGame;
    private Double turnoversPerGame;
    private Double pointsPerGame;

    @Override
    public String toString() {
        return String.format("rank=[%s], name=[%s], team=[%s], position=[%s], fieldGoalPercentage=[%s], freeThrowPercentage=[%s], threePointMadePerGame=[%s], reboundsPerGame=[%s], assistsPerGame=[%s], stealsPerGam[%s], blocksPerGame=[%s], turnoversPerGame=[%s], pointsPerGame=[%s]", rank, name, team, position, fieldGoalPercentage, freeThrowPercentage, threePointMadePerGame, reboundsPerGame, assistsPerGame, stealsPerGame, blocksPerGame, turnoversPerGame, pointsPerGame);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EspnNbaProjectionModel)) return false;

        EspnNbaProjectionModel that = (EspnNbaProjectionModel) o;

        if (!assistsPerGame.equals(that.assistsPerGame)) return false;
        if (!blocksPerGame.equals(that.blocksPerGame)) return false;
        if (!fieldGoalPercentage.equals(that.fieldGoalPercentage)) return false;
        if (!freeThrowPercentage.equals(that.freeThrowPercentage)) return false;
        if (!name.equals(that.name)) return false;
        if (!playerId.equals(that.playerId)) return false;
        if (!pointsPerGame.equals(that.pointsPerGame)) return false;
        if (!position.equals(that.position)) return false;
        if (!rank.equals(that.rank)) return false;
        if (!reboundsPerGame.equals(that.reboundsPerGame)) return false;
        if (!stealsPerGame.equals(that.stealsPerGame)) return false;
        if (!team.equals(that.team)) return false;
        if (!threePointMadePerGame.equals(that.threePointMadePerGame)) return false;
        if (!turnoversPerGame.equals(that.turnoversPerGame)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playerId.hashCode();
        result = 31 * result + rank.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + team.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + fieldGoalPercentage.hashCode();
        result = 31 * result + freeThrowPercentage.hashCode();
        result = 31 * result + threePointMadePerGame.hashCode();
        result = 31 * result + reboundsPerGame.hashCode();
        result = 31 * result + assistsPerGame.hashCode();
        result = 31 * result + stealsPerGame.hashCode();
        result = 31 * result + blocksPerGame.hashCode();
        result = 31 * result + turnoversPerGame.hashCode();
        result = 31 * result + pointsPerGame.hashCode();
        return result;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public void setFieldGoalPercentage(Double fieldGoalPercentage) {
        this.fieldGoalPercentage = fieldGoalPercentage;
    }

    public Double getFreeThrowPercentage() {
        return freeThrowPercentage;
    }

    public void setFreeThrowPercentage(Double freeThrowPercentage) {
        this.freeThrowPercentage = freeThrowPercentage;
    }

    public Double getThreePointMadePerGame() {
        return threePointMadePerGame;
    }

    public void setThreePointMadePerGame(Double threePointMadePerGame) {
        this.threePointMadePerGame = threePointMadePerGame;
    }

    public Double getReboundsPerGame() {
        return reboundsPerGame;
    }

    public void setReboundsPerGame(Double reboundsPerGame) {
        this.reboundsPerGame = reboundsPerGame;
    }

    public Double getAssistsPerGame() {
        return assistsPerGame;
    }

    public void setAssistsPerGame(Double assistsPerGame) {
        this.assistsPerGame = assistsPerGame;
    }

    public Double getStealsPerGame() {
        return stealsPerGame;
    }

    public void setStealsPerGame(Double stealsPerGame) {
        this.stealsPerGame = stealsPerGame;
    }

    public Double getBlocksPerGame() {
        return blocksPerGame;
    }

    public void setBlocksPerGame(Double blocksPerGame) {
        this.blocksPerGame = blocksPerGame;
    }

    public Double getTurnoversPerGame() {
        return turnoversPerGame;
    }

    public void setTurnoversPerGame(Double turnoversPerGame) {
        this.turnoversPerGame = turnoversPerGame;
    }

    public Double getPointsPerGame() {
        return pointsPerGame;
    }

    public void setPointsPerGame(Double pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }
}
