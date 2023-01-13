CREATE DATABASE olympic;
use olympic;

CREATE TABLE person(
	id INT NOT NULL AUTO_INCREMENT,
    person_name VARCHAR(45) NOT NULL,
    gender CHAR(1) NOT NULL,
    age INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE city(
	id INT NOT NULL AUTO_INCREMENT,
    city_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE country(
	id INT NOT NULL AUTO_INCREMENT,
	country_name VARCHAR(45) NOT NULL,
    region VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE games(
	id INT NOT NULL AUTO_INCREMENT,
    games_year INT NOT NULL,
    games_name VARCHAR(40) NOT NULL,
    season VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE sport(
	id INT NOT NULL AUTO_INCREMENT,
    sport_name VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE medal(
	id INT NOT NULL AUTO_INCREMENT,
    medal_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE person_country(
	id INT NOT NULL AUTO_INCREMENT,
    person_id INT NOT NULL,
    country_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (person_id) REFERENCES person (id),
    FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE games_city(
	id INT NOT NULL AUTO_INCREMENT,
    games_id INT NOT NULL,
    city_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (games_id) REFERENCES games (id),
    FOREIGN KEY (city_id) REFERENCES city (id)
);

CREATE TABLE games_competitor(
	id INT NOT NULL AUTO_INCREMENT,
    games_id INT NOT NULL,
    person_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (games_id) REFERENCES games (id),
    FOREIGN KEY (person_id) REFERENCES person (id)
);

CREATE TABLE event(
	id INT NOT NULL AUTO_INCREMENT,
    sport_id INT NOT NULL,
    event_name VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (sport_id) REFERENCES sport (id)
);

CREATE TABLE city_country(
	id INT NOT NULL AUTO_INCREMENT,
    city_id INT NOT NULL,
    country_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (city_id) REFERENCES city (id),
    FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE competitor_event(
	id INT NOT NULL AUTO_INCREMENT,
    event_id INT NOT NULL,
	competitor_id INT NOT NULL,
    medal_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (event_id) REFERENCES event (id),
    FOREIGN KEY (competitor_id) REFERENCES games_competitor (id),
    FOREIGN KEY (medal_id) REFERENCES medal (id)
);