Description:
An api wrapper that takes a UK postal code and returns the latitude and longitude coordinates for that location.

Direction of use:
- Run the Spring-boot application
- Submit a request via "http://localhost:8080/postcodes/{postcode}"

Responses:
- 200 = Success, contains postcode, latitude, longitude
- 400 = Invalid formatting
- 404 = Postcode cannot be found

Successful response schema:
{
"postcode": "SW1A 1AA",
"latitude": 51.50101,
"longitude": -0.141563
}