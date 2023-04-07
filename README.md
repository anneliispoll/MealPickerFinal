# MealPickerFinal

This is back-end/server side Java project called MealPicker. Front end side React application can be found [here](https://github.com/anneliispoll/MealPickerFront). 
It's my final project to SDA Java course.

This project uses:
Spring Boot 3.0,
Spring Security 6.0,
Hibernate,
Maven,
MySQL.

## About the MealPicker

Idea to create MealPicker application came from a real life. Our family always struggled with the question "What should we eat?".
We usually do grocery shopping once a week and we always have basics at home, but what should we cook? Should we make lasagne or pasta Bolognese.. or chilli con carne?
We know how to cook, so we didn't need a recipes but rather a decision maker. And this is what this application does - it tells you what you should eat. 

You can add your own meals to the database and MealPicker chooses randomly between those. You can also choose between the time and season. 
As we all prefer different things on different seasons.

## How to start
This project is built with using Maven.
Clone the repo form GitHub to IntelliJ (or similar application).
It also uses MySQL as database server.
You should create a new MYSQL database and add its name, your username and password to connect with the database. This can be done under the resources-> application.properties file.
SQL queries are also added to this repo.
SQL queries to create '_user' table to store user information and 'MealPicker' database queries to create default database with some test data.

## Program overview
Using API calls you can store user data in the database and get the user data for the authentication.
Non-authenticated user cannot reach to the API endpoint and use the MealPicker application.
With the API calls authenticated user can get random meals from MealPicker database and also can add new meals to the database.



