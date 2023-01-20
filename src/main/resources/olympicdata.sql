use olympic;

-- Insertion of data

-- Athletes
INSERT into athlete (athlete_name, age, sport_id, country_id, coach_id, competition_id) VALUES ('Kim Woo-Jin', 30,  1, 1, 1, 1);
INSERT into athlete (athlete_name, age, sport_id, country_id, coach_id, competition_id) VALUES ('Mete Gazos', 23, 1, 2, 1, 1);
INSERT into athlete (athlete_name, age, sport_id, country_id, coach_id, competition_id) VALUES ('Daiki Hashimoto', 30, 1, 2, 1, 1);

-- Coach
INSERT into coach (coach_name, age, country_idcountry) VALUES ('Jim Woo-Jin', 45, 3);
INSERT into coach (coach_name, age, country_idcountry) VALUES ('Raul De La Fuente', 57, 2);
INSERT into coach (coach_name, age, country_idcountry) VALUES ('Ryuji Sakamoto', 40, 1);

-- Countries
INSERT into country (country_name, region) VALUES ('Japan', 'Asia');
INSERT into country (country_name, region) VALUES ('Spain', 'Europe'); 
INSERT into country (country_name, region) VALUES ('South Korea', 'Asia');

-- Sports

INSERT into sport (sport_name) VALUES ('Archery');
INSERT into sport (sport_name) VALUES ('Handball');

-- Seasons

INSERT into season (season_name, year) VALUES ("Winter", 2010);
INSERT into season (season_name, year) VALUES ("Summer", 2016);

-- Judge

INSERT into judge (judge_name, age) VALUES ("Cid", 40);

-- Stadium

INSERT into stadium (stadium_name, capacity) VALUES ("Big Air Shougang", 45000);

-- City

INSERT into city (city_name, stadium_idstadium) VALUES ("New York", 1);

-- Medals

INSERT into medal (medal_name) VALUES ('Gold');
INSERT into medal (medal_name) VALUES ('Silver');
INSERT into medal (medal_name) VALUES ('Bronze');

-- Competition

INSERT into competition (competition_name, sport_id, athlete_id, season_id, judge_id, stadium_id) VALUES ('Single Sport Men Category', 1, 1, 1, 1, 1);


-- See athletes
SELECT * FROM athlete;

-- Renaming 

