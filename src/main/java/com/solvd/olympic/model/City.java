package com.solvd.olympic.model;

public class City {

    private int cityId;
    private String city_name;
    private int stadiumId;

    public City(){

    }

    public City(int cityId, String city_name, int stadiumId) {
        this.cityId = cityId;
        this.city_name = city_name;
        this.stadiumId = stadiumId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(int stadiumId) {
        this.stadiumId = stadiumId;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city_name='" + city_name + '\'' +
                ", stadiumId=" + stadiumId +
                '}';
    }
}
