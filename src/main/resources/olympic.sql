CREATE DATABASE olympic;
use olympic;

SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE athlete (
    idathlete INT NOT NULL AUTO_INCREMENT,
    athlete_name VARCHAR(45) NOT NULL,
    age INT NOT NULL,
    sport_id INT NOT NULL,
    country_id INT NOT NULL,
    coach_id INT NOT NULL,
    competition_id INT NOT NULL,
    PRIMARY KEY (idathlete),
    FOREIGN KEY (sport_id) REFERENCES sport (idsport),
    FOREIGN KEY (country_id) REFERENCES country (idcountry),
    FOREIGN KEY (coach_id) REFERENCES coach (idcoach),
    FOREIGN KEY (competition_id) REFERENCES competition (idcompetition)
);

CREATE TABLE sport (
    idsport INT NOT NULL AUTO_INCREMENT,
    sport_name VARCHAR(40) NOT NULL,
    PRIMARY KEY (idsport)
);

CREATE TABLE country(
    idcountry INT NOT NULL AUTO_INCREMENT,
    country_name VARCHAR(40) NOT NULL,
    region VARCHAR(20) NOT NULL,
    PRIMARY KEY (idcountry)
);

CREATE TABLE coach (
    idcoach INT NOT NULL AUTO_INCREMENT,
    coach_name VARCHAR(45) NOT NULL,
    age INT NOT NULL,
    country_idcountry INT NOT NULL,
    PRIMARY KEY (idcoach),
    FOREIGN KEY (country_idcountry) REFERENCES country (idcountry)
);

CREATE TABLE season(
    idseason INT NOT NULL AUTO_INCREMENT,
    season_name VARCHAR(45) NOT NULL,
    year INT NOT NULL,
    PRIMARY KEY (idseason)
);

CREATE TABLE judge (
    idjudge INT NOT NULL AUTO_INCREMENT,
    judge_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (idjudge)
);

CREATE TABLE stadium (
    idstadium INT NOT NULL AUTO_INCREMENT,
    stadium_name VARCHAR(45) NOT NULL,
    capacity INT NOT NULL,
    PRIMARY KEY (idstadium)  
);

CREATE TABLE city (
    idcity INT NOT NULL AUTO_INCREMENT,
    city_name VARCHAR(45) NOT NULL,
    stadium_idstadium INT NOT NULL,
    PRIMARY KEY (idcity),
    FOREIGN KEY (stadium_idstadium) REFERENCES stadium (idstadium)
);

CREATE TABLE medals (
    idmedal INT NOT NULL AUTO_INCREMENT,
    medal_name VARCHAR(10) NOT NULL,
    PRIMARY KEY (idmedal)
);

CREATE TABLE competition (
    idcompetition INT NOT NULL AUTO_INCREMENT,
    competition_name VARCHAR(40) NOT NULL,
    sport_id INT NOT NULL,
    athlete_id INT NOT NULL,
    season_id INT NOT NULL,
    judge_id INT NOT NULL,
    stadium_id INT NOT NULL,
    PRIMARY KEY (idcompetition),
    FOREIGN KEY (sport_id) REFERENCES sport (idsport),
    FOREIGN KEY (athlete_id) REFERENCES athlete (idathlete),
    FOREIGN KEY (season_id) REFERENCES season (idseason),
    FOREIGN KEY (judge_id) REFERENCES judge (idjudge),
    FOREIGN KEY (stadium_id) REFERENCES stadium (idstadium)
);

CREATE TABLE competition_winners (
    idcompetition_winners INT NOT NULL AUTO_INCREMENT,
    medals_id INT NOT NULL,
    athlete_id INT NOT NULL,
    PRIMARY KEY (idcompetition_winners),
    FOREIGN KEY (medals_id) REFERENCES medal (idmedal),
    FOREIGN KEY (athlete_id) REFERENCES athlete (idathlete)
);