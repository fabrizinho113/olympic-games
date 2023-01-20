package com.solvd.olympic.dao;

import com.solvd.olympic.connection.ConnectionPool;
import com.solvd.olympic.model.Athlete;
import com.solvd.olympic.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements IDao<City>{
    @Override
    public City select(int id) {
        String query = "SELECT * FROM city WHERE id = " + id;
        City city;

        try{
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int cityId = resultSet.getInt("idcity");
            String name = resultSet.getString("city_name");
            int stadiumId = resultSet.getInt("stadium_id");

            city = new City(cityId, name, stadiumId);

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        return city;
    }

    @Override
    public List<City> selectAll() {
        String query = "SELECT * FROM city";
        List<City> cities = new ArrayList<>();
        City city;

        try{
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int cityId = resultSet.getInt("idcity");
            String name = resultSet.getString("city_name");
            int stadiumId = resultSet.getInt("stadium_id");

            city = new City(cityId, name, stadiumId);
            cities.add(city);
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        return cities;
    }

    @Override
    public void insert(City city) {
        String query = "INSERT INTO city (city_name, stadium_id) VALUES ( ?, ?)";

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, city.getCity_name());
            statement.setInt(2, city.getStadiumId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(City city, int id) {
        String query = "UPDATE city SET city_name = ?, stadium_id = ? WHERE id = " + id;

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, city.getCity_name());
            statement.setInt(2, city.getStadiumId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(City city) {
        String query = "DELETE FROM city WHERE id = ?";

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, city.getCityId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
