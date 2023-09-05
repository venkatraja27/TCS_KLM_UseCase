
# Flight Information Search API

This application will handles the requests from users and display the flight informations available in the database.

Base URL
The base URL for all API requests is: https://localhost:8080/

Endpoints
GET /FlightInfos
Returns a list of all FlightInfos in the database.

GET /FlightInfo/{flight_number}
Returns FlightInfo for the particular flight_number in the 
database.

POST /FlightInfo
Create new flight record in the database.

PUT /FlightInfos/{flight_number}
Update the existing  flight record in the database.

DELETE / FlightInfo/{flight_number}
Delete the FlightInfo record for the matching flight_number in the database

GET /FlightInfo?param1&param2
Returns a list of flightInfo records which matches the parameter 1 and parameter 2. If there is more than one result, it will sorted based on flight with shortest duration.
