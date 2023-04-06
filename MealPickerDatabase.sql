
-- CREATE TABLES --
CREATE TABLE meals (
  MealID INT NOT NULL AUTO_INCREMENT,
  meal_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (MealID)
);

CREATE TABLE seasons (
  SeasonID INT NOT NULL AUTO_INCREMENT,
  season_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (SeasonID)
);

CREATE TABLE meal_times (
  MealTimeID INT NOT NULL AUTO_INCREMENT,
  meal_time_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (meal_timeid)
);

CREATE TABLE meal_seasons (
  MealID INT NOT NULL,
  SeasonID INT NOT NULL,
  PRIMARY KEY (MealID, SeasonID),
  FOREIGN KEY (MealID) REFERENCES meals(MealID),
  FOREIGN KEY (SeasonID) REFERENCES seasons(SeasonID)
);

CREATE TABLE meal_meal_times (
  MealID INT NOT NULL,
  meal_timeid INT NOT NULL,
  PRIMARY KEY (MealID, meal_timeid),
  FOREIGN KEY (MealID) REFERENCES meals(MealID),
  FOREIGN KEY (meal_timeid) REFERENCES meal_times(meal_timeid)
);

-- Inserting the seasons --
INSERT INTO seasons (season_name) VALUES ('spring');
INSERT INTO seasons (season_name) VALUES ('summer');
INSERT INTO seasons (season_name) VALUES ('autumn');
INSERT INTO seasons (season_name) VALUES ('winter');

-- inserting the meal_times --
INSERT INTO meal_times (meal_time_name) VALUES ('breakfast');
INSERT INTO meal_times (meal_time_name) VALUES ('lunch');
INSERT INTO meal_times (meal_time_name) VALUES ('dinner');


-- inserting meals --
INSERT INTO meals (meal_name) VALUES ('Porridge');
INSERT INTO meals (meal_name) VALUES ('Fried eggs');
INSERT INTO meals (meal_name) VALUES ('Muesli');
INSERT INTO meals (meal_name) VALUES ('Pancakes');
INSERT INTO meals (meal_name) VALUES ('Sandwiches');
INSERT INTO meals (meal_name) VALUES ('Pasta');
INSERT INTO meals (meal_name) VALUES ('Soup');
INSERT INTO meals (meal_name) VALUES ('Salat');
INSERT INTO meals (meal_name) VALUES ('Mashed potatoes with meatballs');
INSERT INTO meals (meal_name) VALUES ('Hamburger');
INSERT INTO meals (meal_name) VALUES ('Casserole');


-- inserting into meal_seasons for the season--
INSERT INTO meal_seasons (MealID, SeasonID) VALUES
  (1, (SELECT SeasonID FROM seasons WHERE season_name = 'winter')),
  (1, (SELECT SeasonID FROM seasons WHERE season_name = 'autumn')),
  (1, (SELECT SeasonID FROM seasons WHERE season_name = 'spring')),
  (2, (SELECT SeasonID FROM seasons WHERE season_name = 'winter')),
  (2, (SELECT SeasonID FROM seasons WHERE season_name = 'autumn')),
  (2, (SELECT SeasonID FROM seasons WHERE season_name = 'summer')),
  (2, (SELECT SeasonID FROM seasons WHERE season_name = 'spring')),
  (3, (SELECT SeasonID FROM seasons WHERE season_name = 'summer')),
  (4, (SELECT SeasonID FROM seasons WHERE season_name = 'winter')),
  (4, (SELECT SeasonID FROM seasons WHERE season_name = 'autumn')),
  (4, (SELECT SeasonID FROM seasons WHERE season_name = 'summer')),
  (4, (SELECT SeasonID FROM seasons WHERE season_name = 'spring')),
  (5, (SELECT SeasonID FROM seasons WHERE season_name = 'winter')),
  (5, (SELECT SeasonID FROM seasons WHERE season_name = 'autumn')),
  (5, (SELECT SeasonID FROM seasons WHERE season_name = 'summer')),
  (5, (SELECT SeasonID FROM seasons WHERE season_name = 'spring')),
  (6, (SELECT SeasonID FROM seasons WHERE season_name = 'winter')),
  (6, (SELECT SeasonID FROM seasons WHERE season_name = 'autumn')),
  (6, (SELECT SeasonID FROM seasons WHERE season_name = 'summer')),
  (6, (SELECT SeasonID FROM seasons WHERE season_name = 'spring')),
  (7, (SELECT SeasonID FROM seasons WHERE season_name = 'winter')),
  (7, (SELECT SeasonID FROM seasons WHERE season_name = 'autumn')),
  (7, (SELECT SeasonID FROM seasons WHERE season_name = 'spring')),
  (8, (SELECT SeasonID FROM seasons WHERE season_name = 'spring')),
  (8, (SELECT SeasonID FROM seasons WHERE season_name = 'summer')),
  (9, (SELECT SeasonID FROM seasons WHERE season_name = 'winter')),
  (9, (SELECT SeasonID FROM seasons WHERE season_name = 'autumn')),
  (9, (SELECT SeasonID FROM seasons WHERE season_name = 'spring')),
  (10, (SELECT SeasonID FROM seasons WHERE season_name = 'spring')),
  (10, (SELECT SeasonID FROM seasons WHERE season_name = 'summer')),
  (11, (SELECT SeasonID FROM seasons WHERE season_name = 'winter'));

-- inserting into meal_meal_times for the mealtime--
INSERT INTO meal_meal_times (MealID, meal_timeid) VALUES
(1, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'breakfast')),
(2, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'breakfast')),
(3, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'breakfast')),
(4, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'breakfast')),
(5, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'breakfast')),
(6, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'lunch')),
(6, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'dinner')),
(7, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'lunch')),
(7, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'dinner')),
(8, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'lunch')),
(8, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'dinner')),
(9, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'dinner')),
(9, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'lunch')),
(10, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'lunch')),
(10, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'dinner')),
(11, (SELECT meal_timeid FROM meal_times WHERE meal_time_name = 'dinner'));


