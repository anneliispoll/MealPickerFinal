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

Use POSTMAN to use only the server side code.

### For registering:
POST http://localhost:8080/api/v1/auth/register

Send JSON
E.g.:
{
"firstname": "Testuser",
"lastname": "Test",
"email": "Testing@gmail.com",
"password": "1234"

}

Note: you should receive the token for authentication.

### For login:
POST http://localhost:8080/api/v1/auth/authenticate

Send JSON
E.g.:
{
"email": "Testing@gmail.com",
"password": "1234"
}

Note: you should receive the token for authentication.

### Getting random meal from MealPicker
GET http://localhost:8080/api/v1/auth/random?seasonName=winter&mealTimeName=dinner

Send

Note:
seasonName can be: spring, summer, autumn, winter
mealTimeName can be: breakfast, lunch, dinner

NB! To be authenticated, you should add the Bearer token that you got from the login under the Authorization to be able to reach to the API endpoint
### Adding new meal to the database
POST http://localhost:8080/api/v1/auth/add

Send JSON

{
"name": "Pizza",
"mealTimeNames": ["dinner", "lunch"],
"seasonNames": ["spring","summer","autumn","winter"]
}
NB! To be authenticated, you should add the Bearer token that you got from the login under the Authorization to be able to reach to the API endpoint