package com.solvd.olympic.model;

public class Coach {

    private int coachId;
    private String coachName;
    private int age;
    private int countryId;

    public Coach (){

    };

    public Coach(int coachId, String coachName, int age, int countryId) {
        this.coachName = coachName;
        this.age = age;
        this.countryId = countryId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coachName='" + coachName + '\'' +
                ", age=" + age +
                ", countryId=" + countryId +
                '}';
    }
}
