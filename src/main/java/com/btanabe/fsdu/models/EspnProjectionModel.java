package com.btanabe.fsdu.models;

/**
 * Created by Brian on 7/28/15.
 */
public class EspnProjectionModel {
    private Integer rank;
    private String name;
    private String team;
    private String position;
    private Integer passingCompletions;
    private Integer passingAttempts;
    private Integer passingYards;
    private Integer passingTouchdowns;
    private Integer interceptions;
    private Integer rushingAttempts;
    private Integer rushingYards;
    private Integer rushingTouchdowns;
    private Integer receptions;
    private Integer receivingYards;
    private Integer receivingTouchdowns;
    private Double fantasyPoints;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EspnProjectionModel) {
            EspnProjectionModel rhs = (EspnProjectionModel) obj;
            return rank.equals(rhs.getRank()) && name.equals(rhs.getName()) && team.equals(rhs.getTeam()) && position.equals(rhs.getPosition()) && passingCompletions.equals(rhs.getPassingCompletions()) && passingAttempts.equals(rhs.getPassingAttempts()) && passingYards.equals(rhs.getPassingYards()) && passingTouchdowns.equals(rhs.getPassingTouchdowns()) && interceptions.equals(rhs.getInterceptions()) && rushingAttempts.equals(rhs.getRushingAttempts()) && rushingYards.equals(rhs.getRushingYards()) && rushingTouchdowns.equals(rhs.getRushingTouchdowns()) && receptions.equals(rhs.getReceptions()) && receivingYards.equals(rhs.getReceivingYards()) && receivingTouchdowns.equals(rhs.getReceivingTouchdowns()) && fantasyPoints.equals(rhs.getFantasyPoints());
        }

        return false;
    }

    @Override
    public int hashCode() {
        String hashString = rank + name + team + position + passingCompletions + passingAttempts + passingYards + passingTouchdowns + interceptions + rushingAttempts + rushingYards + rushingTouchdowns + receptions + receivingYards + receivingTouchdowns + fantasyPoints;
        return hashString.hashCode();
    }

    @Override
    public String toString() {
        return String.format("rank=[%d], name=[%s], team=[%s], position=[%s], passingCompletions=[%d], passingAttempts=[%d], passingYards=[%d], passingTouchdowns=[%d], interceptions=[%d], rushingAttempts=[%d], rushingYards=[%d], rushingTouchdowns=[%d], receptions=[%d], receivingYards=[%d], receivingTouchdowns=[%d], fantasyPoints=[%f]", rank, name, team, position, passingCompletions, passingAttempts, passingYards, passingTouchdowns, interceptions, rushingAttempts, rushingYards, rushingTouchdowns, receptions, receivingYards, receivingTouchdowns, fantasyPoints);
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPassingCompletions(Integer passingCompletions) {
        this.passingCompletions = passingCompletions;
    }

    public void setPassingAttempts(Integer passingAttempts) {
        this.passingAttempts = passingAttempts;
    }

    public void setPassingYards(Integer passingYards) {
        this.passingYards = passingYards;
    }

    public void setPassingTouchdowns(Integer passingTouchdowns) {
        this.passingTouchdowns = passingTouchdowns;
    }

    public void setInterceptions(Integer interceptions) {
        this.interceptions = interceptions;
    }

    public void setRushingAttempts(Integer rushingAttempts) {
        this.rushingAttempts = rushingAttempts;
    }

    public void setRushingYards(Integer rushingYards) {
        this.rushingYards = rushingYards;
    }

    public void setRushingTouchdowns(Integer rushingTouchdowns) {
        this.rushingTouchdowns = rushingTouchdowns;
    }

    public void setReceptions(Integer receptions) {
        this.receptions = receptions;
    }

    public void setReceivingYards(Integer receivingYards) {
        this.receivingYards = receivingYards;
    }

    public void setReceivingTouchdowns(Integer receivingTouchdowns) {
        this.receivingTouchdowns = receivingTouchdowns;
    }

    public void setFantasyPoints(Double fantasyPoints) {
        this.fantasyPoints = fantasyPoints;
    }

    public Integer getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public Integer getPassingCompletions() {
        return passingCompletions;
    }

    public Integer getPassingAttempts() {
        return passingAttempts;
    }

    public Integer getPassingYards() {
        return passingYards;
    }

    public Integer getPassingTouchdowns() {
        return passingTouchdowns;
    }

    public Integer getInterceptions() {
        return interceptions;
    }

    public Integer getRushingAttempts() {
        return rushingAttempts;
    }

    public Integer getRushingYards() {
        return rushingYards;
    }

    public Integer getRushingTouchdowns() {
        return rushingTouchdowns;
    }

    public Integer getReceptions() {
        return receptions;
    }

    public Integer getReceivingYards() {
        return receivingYards;
    }

    public Integer getReceivingTouchdowns() {
        return receivingTouchdowns;
    }

    public Double getFantasyPoints() {
        return fantasyPoints;
    }
}
