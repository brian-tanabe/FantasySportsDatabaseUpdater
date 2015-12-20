package com.btanabe.fsdu.models;

/**
 * Created by brian on 12/19/15.
 */
public class PlayerIdModel {
    private String firstName;
    private String lastName;
    private String fullName;

    private String basketballReferenceId;
    private Integer yahooId;
    private Integer espnId;

    @Override
    public String toString() {
        return String.format("fullName=[%s], firstName=[%s], lastName=[%s], basketballReferenceId=[%s], espnId=[%d], yahooId=[%d]", fullName, firstName, lastName, basketballReferenceId, espnId, yahooId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerIdModel)) return false;

        PlayerIdModel that = (PlayerIdModel) o;

        if (!basketballReferenceId.equals(that.basketballReferenceId)) return false;
        if (!espnId.equals(that.espnId)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!fullName.equals(that.fullName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!yahooId.equals(that.yahooId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + basketballReferenceId.hashCode();
        result = 31 * result + yahooId.hashCode();
        result = 31 * result + espnId.hashCode();
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBasketballReferenceId() {
        return basketballReferenceId;
    }

    public void setBasketballReferenceId(String basketballReferenceId) {
        this.basketballReferenceId = basketballReferenceId;
    }

    public Integer getYahooId() {
        return yahooId;
    }

    public void setYahooId(Integer yahooId) {
        this.yahooId = yahooId;
    }

    public Integer getEspnId() {
        return espnId;
    }

    public void setEspnId(Integer espnId) {
        this.espnId = espnId;
    }
}
