package com.solvd.olympic.dao;

import com.solvd.olympic.connection.ConnectionPool;
import com.solvd.olympic.model.Coach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoachDao implements IDao<Coach>{

    @Override
    public Coach select(int id) {

        String query = "SELECT * FROM coach WHERE id = " + id;
        Coach coach;

        try{
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int coachId = resultSet.getInt("idcoach");
            String name = resultSet.getString("coach_name");
            int age = resultSet.getInt("age");
            int countryId = resultSet.getInt("country_id");

            coach = new Coach(coachId, name, age, countryId);

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        return coach;
    }

    @Override
    public List<Coach> selectAll() {
        String query = "SELECT * FROM athlete";
        List<Coach> coaches = new ArrayList<>();
        Coach coach;

        try{
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int coachId = resultSet.getInt("idcoach");
            String name = resultSet.getString("coach_name");
            int age = resultSet.getInt("age");
            int countryId = resultSet.getInt("country_id");

            coach = new Coach(coachId, name, age, countryId);
            coaches.add(coach);

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        return coaches;
    }

    @Override
    public void insert(Coach coach) {
        String query = "INSERT INTO coach (coach_name, age) VALUES ( ?, ?, ?)";

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, coach.getCoachName());
            statement.setInt(2, coach.getAge());
            statement.setInt(3, coach.getCountryId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Coach coach, int id) {
        String query = "UPDATE coach SET coach_name = ?, age = ? WHERE id = " + id;

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, coach.getCoachName());
            statement.setInt(2, coach.getAge());
            statement.setInt(3, coach.getCountryId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Coach coach) {
        String query = "DELETE FROM coach WHERE id = ?";

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, coach.getCoachId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
