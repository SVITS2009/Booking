# Booking
Creating restaurant booking API to get the list of Booking and create the new booking by Customer

Booking-service Application

muserver lib to implement the Rest end point (https://muserver.io/)

To the setup booking-service application locally

JDK 11

Maven 3

Clone the project - git clone [https://github.com/SVITS2009/account-service.git] Go to project directory and run the below commands.

Clean - mvn clean

Run the test cases - mvn test

Run install - mvn install

Running the application locally

There are several ways to run a application on your local machine. One way is to

1.) Run the main method in the com.booking.BookingApp class from your IDE.

User information - Currently Application supports 2 user.

Admin - admin/admin123 (who can perform get the booking list using - http://localhost:8081/booking/ url which is a get method and return the list of booking )
User - user/user123 (who can book the appointment using http://localhost:8081/booking/  url which is a post request with basic auth and booking information )

Request body for Post request - {
    "firstName":"Sanish",
    "lastName":"gupta",
    "emailId":"sanish2009@gmail.com",
    "contactNumber":"8147526034",
    "tableSize":4
}
Authentication mechanism

Basic auth Login with Role based. 
