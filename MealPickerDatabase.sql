
-- CREATE TABLES --
CREATE TABLE meals (
  MealID INT NOT NULL AUTO_INCREMENT,
  meal_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (MealID)
);

CREATE TABLE seasons (
  SeasonID INT NOT NULL AUTO_INCREMENT,
  SeasonName VARCHAR(255) NOT NULL,
  PRIMARY KEY (SeasonID)
);

CREATE TABLE meal_times (
  MealTimeID INT NOT NULL AUTO_INCREMENT,
  MealTimeName VARCHAR(255) NOT NULL,
  PRIMARY KEY (MealTimeID)
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
  MealTimeID INT NOT NULL,
  PRIMARY KEY (MealID, MealTimeID),
  FOREIGN KEY (MealID) REFERENCES meals(MealID),
  FOREIGN KEY (MealTimeID) REFERENCES meal_times(MealTimeID)
);

-- Inserting the seasons --
INSERT INTO seasons (SeasonName) VALUES ('spring');
INSERT INTO seasons (SeasonName) VALUES ('summer');
INSERT INTO seasons (SeasonName) VALUES ('autumn');
INSERT INTO seasons (SeasonName) VALUES ('winter');

-- inserting the meal_times --
INSERT INTO meal_times (MealTimeName) VALUES ('breakfast');
INSERT INTO meal_times (MealTimeName) VALUES ('lunch');
INSERT INTO meal_times (MealTimeName) VALUES ('dinner');


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
  (1, (SELECT SeasonID FROM seasons WHERE SeasonName = 'winter')),
  (1, (SELECT SeasonID FROM seasons WHERE SeasonName = 'autumn')),
  (1, (SELECT SeasonID FROM seasons WHERE SeasonName = 'spring')),
  (2, (SELECT SeasonID FROM seasons WHERE SeasonName = 'winter')),
  (2, (SELECT SeasonID FROM seasons WHERE SeasonName = 'autumn')),
  (2, (SELECT SeasonID FROM seasons WHERE SeasonName = 'summer')),
  (2, (SELECT SeasonID FROM seasons WHERE SeasonName = 'spring')),
  (3, (SELECT SeasonID FROM seasons WHERE SeasonName = 'summer')),
  (4, (SELECT SeasonID FROM seasons WHERE SeasonName = 'winter')),
  (4, (SELECT SeasonID FROM seasons WHERE SeasonName = 'autumn')),
  (4, (SELECT SeasonID FROM seasons WHERE SeasonName = 'summer')),
  (4, (SELECT SeasonID FROM seasons WHERE SeasonName = 'spring')),
  (5, (SELECT SeasonID FROM seasons WHERE SeasonName = 'winter')),
  (5, (SELECT SeasonID FROM seasons WHERE SeasonName = 'autumn')),
  (5, (SELECT SeasonID FROM seasons WHERE SeasonName = 'summer')),
  (5, (SELECT SeasonID FROM seasons WHERE SeasonName = 'spring')),
  (6, (SELECT SeasonID FROM seasons WHERE SeasonName = 'winter')),
  (6, (SELECT SeasonID FROM seasons WHERE SeasonName = 'autumn')),
  (6, (SELECT SeasonID FROM seasons WHERE SeasonName = 'summer')),
  (6, (SELECT SeasonID FROM seasons WHERE SeasonName = 'spring')),
  (7, (SELECT SeasonID FROM seasons WHERE SeasonName = 'winter')),
  (7, (SELECT SeasonID FROM seasons WHERE SeasonName = 'autumn')),
  (7, (SELECT SeasonID FROM seasons WHERE SeasonName = 'spring')),
  (8, (SELECT SeasonID FROM seasons WHERE SeasonName = 'spring')),
  (8, (SELECT SeasonID FROM seasons WHERE SeasonName = 'summer')),
  (9, (SELECT SeasonID FROM seasons WHERE SeasonName = 'winter')),
  (9, (SELECT SeasonID FROM seasons WHERE SeasonName = 'autumn')),
  (9, (SELECT SeasonID FROM seasons WHERE SeasonName = 'spring')),
  (10, (SELECT SeasonID FROM seasons WHERE SeasonName = 'spring')),
  (10, (SELECT SeasonID FROM seasons WHERE SeasonName = 'summer')),
  (11, (SELECT SeasonID FROM seasons WHERE SeasonName = 'winter'));

-- inserting into meal_meal_times for the mealtime--
INSERT INTO meal_meal_times (MealID, MealTimeID) VALUES
(1, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'breakfast')),
(2, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'breakfast')),
(3, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'breakfast')),
(4, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'breakfast')),
(5, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'breakfast')),
(6, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'lunch')),
(6, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'dinner')),
(7, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'lunch')),
(7, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'dinner')),
(8, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'lunch')),
(8, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'dinner')),
(11, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'lunch')),
(9, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'dinner')),
(9, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'lunch')),
(10, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'lunch')),
(10, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'dinner')),
(11, (SELECT MealTimeID FROM meal_times WHERE MealTimeName = 'dinner'));
  


