# MovieTheaterSeatingChallenge_Walmart

Assessment done as part of walmart interview process

The program is design for a seating assignment that maximizes both customer satisfaction and customer safety.

## Assumptions

1. Seats will be booked in FIFO fasion i.e., on a first-come first-serve basis.
2. Initial reservations will have the seats farthest from the screen for better visibility and to ensure maximum customer satisfaction.
3. To maximise the customer satisfaction further we book all the seats in a single reservation together.
4. If the next available fartest row from the screen can't fit all the seats of a reservation then we move on to the next available row.
5. If the no.of seats requested are more than the available seats in the theater we inform the customer that the reservation is full.
6. When the requested no.of seats in a reservation is more than 20 i.e., maximum of row capacity we inform the customer to consult the box office since it will be marked as a bulk booking.
7. To ensure maximum customer safety we take a buffer of three seats and one row for each reservation.

## Running

Run the .jar file MovieSeater.jar using the below command
java -jar MovieSeater.jar /Users/srikaavya/Desktop/eclipse-workspace/Walmart_Assesment_Movie_Theater_Seating_Challenge_2020/walmart/input.txt
This will run the program and the path to the output file will be printed on the console.


## Functionalities of the program

It allows the users to book their seats and return them with the tickets or appropriate message if the seats are not available or full.

#### Classes:

1. eachRow: Class for a single row in the theater.
2. Theater: Class for theater and all the rows in it.
3. movieTheaterInterface: Interface for the theater which has the necessary methods to be implemented by all the classes extending it.
4. TheaterUnitTest: Unit test cases class to test different scenarios in the program.
5. Driver: This is where the execution of the program begins.


   
