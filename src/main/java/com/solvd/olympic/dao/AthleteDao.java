package com.solvd.olympic.dao;

import com.solvd.olympic.connection.ConnectionPool;
import com.solvd.olympic.model.Athlete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AthleteDao implements IDao<Athlete> {

    @Override
    public Athlete select(int id) {
        String query = "SELECT * FROM athlete WHERE id = " + id;
        Athlete athlete;

        try{
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int athleteId = resultSet.getInt("idathlete");
            String name = resultSet.getString("athlete_name");
            int age = resultSet.getInt("age");
            int sportId = resultSet.getInt("sport_id");
            int countryId = resultSet.getInt("country_id");
            int coachId = resultSet.getInt("coach_id");
            int competitionId = resultSet.getInt("competition_id");

            athlete = new Athlete(athleteId, name, age, sportId, countryId, coachId, competitionId);

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        return athlete;
    };


    @Override
    public List<Athlete> selectAll() {
        String query = "SELECT * FROM athlete";
        List<Athlete> athletes = new ArrayList<>();
        Athlete athlete;

        try{
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int athleteId = resultSet.getInt("idathlete");
            String name = resultSet.getString("athlete_name");
            int age = resultSet.getInt("age");
            int sportId = resultSet.getInt("sport_id");
            int countryId = resultSet.getInt("country_id");
            int coachId = resultSet.getInt("coach_id");
            int competitionId = resultSet.getInt("competition_id");

            athlete = new Athlete(athleteId, name, age, sportId, countryId, coachId, competitionId);
            athletes.add(athlete);

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        return athletes;
    }

    @Override
    public void insert(Athlete athlete) {
        String query = "INSERT INTO athlete (athlete_name, age, sport_id, country_id, coach_id, competition_id) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, athlete.getName());
            statement.setInt(2, athlete.getAge());
            statement.setInt(3, athlete.getSportId());
            statement.setInt(4, athlete.getCountryId());
            statement.setInt(5, athlete.getCoachId());
            statement.setInt(6, athlete.getCompetitionId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Athlete athlete, int id) {
        String query = "UPDATE athlete SET athlete_name = ?, age = ? WHERE id = " + id;

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, athlete.getName());
            statement.setInt(2, athlete.getAge());
            statement.setInt(3, athlete.getSportId());
            statement.setInt(4, athlete.getCountryId());
            statement.setInt(5, athlete.getCoachId());
            statement.setInt(6, athlete.getCompetitionId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Athlete athlete) {
        String query = "DELETE FROM athlete WHERE id = ?";

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, athlete.getAthleteId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
