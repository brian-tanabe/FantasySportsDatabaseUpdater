package com.btanabe.fsdu.models;

/**
 * Created by brian on 9/20/15.
 */
public class EspnPlayerPageModel {
    private Integer playerId;
    private String height;
    private Integer weightInPounds;
    private String birthday;
    private Integer experienceInYears;
    private String college;
    private String draftPickTaken;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  EspnPlayerPageModel) {
            EspnPlayerPageModel rhs = (EspnPlayerPageModel) obj;
            return playerId.equals(rhs.getPlayerId()) && height.equals(rhs.getHeight()) && weightInPounds.equals(rhs.getWeightInPounds()) && birthday.equals(rhs.getBirthday()) && experienceInYears.equals(rhs.getExperienceInYears()) && college.equals(rhs.getCollege()) && draftPickTaken.equals(rhs.getDraftPickTaken());
        }

        return false;
    }

    @Override
    public int hashCode() {
        String hashString = playerId + height + weightInPounds + birthday + experienceInYears + college + draftPickTaken;
        return hashString.hashCode();
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(Integer weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(Integer experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDraftPickTaken() {
        return draftPickTaken;
    }

    public void setDraftPickTaken(String draftPickTaken) {
        this.draftPickTaken = draftPickTaken;
    }
}
