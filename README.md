Summer intership Java programming trial task for Fujitsu

A subfuncionality for a delivery app that calculates a delivery fee based on the city, vehicle type and weather conditions that have been fetched from
https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php, onto which business rules have been applied.

To use the app:
1) clone the repo
2) Build and run the application

To use the funcionality of the app, http request have to be made (using port 8080 as an example, if the apps run on any other port, switch accordingly)
1) use "localhost:8080/swagger-ui", test the "delivery-fee-controller"
2) request straight through url, as in "localhost:8080/delivery-fee/{city}/{vehicleType}"

an example request would be: http://localhost:8080/delivery-fee/tartu/car


The response might change because it is dependant on the weather, specially now, with it being unstable. Besides that, it should respond with a double in the range of 2.0 - 6.0 or with a message describing, that it is forbidden to use such types of transport for deliveries at the current time.


Possible cities to request from, in both lower and upper case: Tallinn, Tartu, Pärnu
Possible vehicles types to request with: Car, Scooter, Bike

The request will show a calculated delivery fee, which is based on the vehicle's type in the city, and if the weather conditions are bad, extra fees may apply for scooters and bikes. In case they are really bad, scooter and bike requests will be met with a message saying that these kind of deliveries are forbidden due to the weather conditions.

Any other cities and vehicles not supported at this moment

More information about the project can be found in a file called "document".
