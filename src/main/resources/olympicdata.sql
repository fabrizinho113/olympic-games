use olympic;

-- Insertion of data

-- Athletes
INSERT into person (person_name, gender, age) VALUES ('Kim Woo-Jin', 'M', 30);
INSERT into person (person_name, gender, age) VALUES ('Mete Gazoz', 'M', 23);
INSERT into person (person_name, gender, age) VALUES ('Daiki Hashimoto', 'M', 22);

-- Cities

INSERT into city(city_name) VALUES ('Tokyo');
INSERT into city(city_name) VALUES ('Barcelona');
INSERT into city(city_name) VALUES ('Seoul');

-- Countries

INSERT into country(country_name, region) VALUES ('Japan', 'Asia');
INSERT into country(country_name, region) VALUES ('Spain', 'Europe');
INSERT into country(country_name, region) VALUES ('South Korea', 'Asia');

-- Games (info). Using season according to each country

INSERT into games(games_year, games_name, season) VALUES (2020, "Olympic Games Tokyo", "Summer");
INSERT into games(games_year, games_name, season) VALUES (1998, "XXV Olympiad", "Winter");
INSERT into games(games_year, games_name, season) VALUES (1981, "Summer Olympics", "Summer");

-- Sports

INSERT into sport(sport_name) VALUES ("Archery");
INSERT into sport(sport_name) VALUES ("Handball");
INSERT into sport(sport_name) VALUES ("Volley");

-- Medals

INSERT into medal(medal_name) VALUES ("Gold");
INSERT into medal(medal_name) VALUES ("Silver");
INSERT into medal(medal_name) VALUES ("Bronze");

-- Defining person country

INSERT into person_country(person_id, country_id) VALUES (1, 3);
INSERT into person_country(person_id, country_id) VALUES (2, 2);
INSERT into person_country(person_id, country_id) VALUES (3, 1);

-- Game city

INSERT into games_city(games_id, city_id) VALUES (1, 1);
INSERT into games_city(games_id, city_id) VALUES (2, 2);
INSERT into games_city(games_id, city_id) VALUES (3, 3);

-- Competitors per game

INSERT into games_competitor(games_id, person_id) VALUES (1, 3);
INSERT into games_competitor(games_id, person_id) VALUES (2, 2);
INSERT into games_competitor(games_id, person_id) VALUES (3, 1);

-- Event

INSERT into event(sport_id, event_name) VALUES (1, 'Archery (Men)');
INSERT into event(sport_id, event_name) VALUES (2, 'Handball (Men)');
INSERT into event(sport_id, event_name) VALUES (3, 'Volleyball (Men)');

-- Country and City

INSERT into city_country(city_id, country_id) VALUES (1, 1);
INSERT into city_country(city_id, country_id) VALUES (2, 2);
INSERT into city_country(city_id, country_id) VALUES (3, 3);

-- Competitor per event

INSERT into competitor_event(event_id, competitor_id, medal_id) VALUES (1, 1, 3);
INSERT into competitor_event(event_id, competitor_id, medal_id) VALUES (2, 2, 1);
INSERT into competitor_event(event_id, competitor_id, medal_id) VALUES (3, 3, 2);


-- Show data (Athletes and cities)

SELECT * FROM person;
SELECT * from city;