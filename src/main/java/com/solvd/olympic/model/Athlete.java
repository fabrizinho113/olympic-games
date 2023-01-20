package com.solvd.olympic.model;

public class Athlete {

    private int athleteId;
    private String name;
    private int age;
    private int sportId;
    private int countryId;
    private int coachId;
    private int competitionId;

    public Athlete (){

    };

    public Athlete(int athleteId, String name, int age, int sportId, int countryId, int coachId, int competitionId) {
        this.athleteId = athleteId;
        this.name = name;
        this.age = age;
        this.sportId = sportId;
        this.countryId = countryId;
        this.coachId = coachId;
        this.competitionId = competitionId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(int athleteId) {
        this.athleteId = athleteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteId=" + athleteId +
                ", name='" + name + '\'' +
                ", sportId=" + sportId +
                ", countryId=" + countryId +
                ", coachId=" + coachId +
                ", competitionId=" + competitionId +
                '}';
    }
}
