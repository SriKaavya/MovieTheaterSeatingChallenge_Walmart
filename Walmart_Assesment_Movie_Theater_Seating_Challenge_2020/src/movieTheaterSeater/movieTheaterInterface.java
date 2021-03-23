package movieTheaterSeater;

import java.util.List;

/* Interface which represents a theater. */

public interface movieTheaterInterface {
	
	  /* This method fills the available seats in the theater based on the availability. In order to 
	   * maintain the safety, only alternate rows are filled and a minimum gap of 3 seats is maintained
	   * between two different bookings in the same row. */
	
	  String fillRows(String reservationNumber, int numberOfSeats);

	  /* This method is used to get the total available seats in the theater. */
	  
	  int getTotalNoOfSeats();

	  /* This method is used to find the available rows and their current status of booking. */
	  
	  List<eachRow> getRow();

}
