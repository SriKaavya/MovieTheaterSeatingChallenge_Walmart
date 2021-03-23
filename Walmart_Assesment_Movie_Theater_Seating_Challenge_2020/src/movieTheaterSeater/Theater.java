package movieTheaterSeater;

/* all the packages needed */
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;


/* Theater class which extends the TheatreInterface and implements all it's methods. It will create
 * a theater with 10 rows and fills them to achieve the maximum customer satisfaction and safety.
 */

public class Theater implements movieTheaterInterface {


  private List<eachRow> rows;
  private List<eachRow> sortedList;
  private AtomicInteger totalSeats;

  /* This is a constructor which initializes a theater with 10 rows and 100 empty seats that can be filled. */
  
  public Theater(int numberOfRows) {
    rows = new ArrayList<eachRow>();
    int actualRows = (numberOfRows + 1) / 2;
    totalSeats = new AtomicInteger(actualRows * 20);
    for (char ch = 'J'; ch > 'J' - numberOfRows; ch--) {
      rows.add(new eachRow(ch));
    }
  }


  public String fillRows(String reservationNumber, int numberOfSeats) {
    StringBuilder result = new StringBuilder();
    if (numberOfSeats < 0 || reservationNumber == null) {

      result.append("Wrong input; either reservation number is null or number of seats is negative\n");
      return result.toString();
    }
    List<String> assignedSeats = new ArrayList<>();
    if (numberOfSeats > 20) {
      result.append(reservationNumber + " ").append("For bulk bookings, contact the box office directly\n");
      return result.toString();
    }

    if (totalSeats.intValue() < numberOfSeats) {
      result.append(reservationNumber + " ").append("Sorry, the requested number of seats are not available at the moment in theater\n");
      return result.toString();
    }

    // To maximize the customer satisfaction further we book all the seats in a single reservation together and farthest from the screen.
    for (int i = 1; i < rows.size() + 1; i = i + 2) {
      if (rows.get(i).getEmptySeats() >= numberOfSeats) {
        assignedSeats.add(rows.get(i).fillSeats(numberOfSeats, reservationNumber, totalSeats));
        break;
      }
    }

    // When seats are not available in same row we split the seats.
    if (assignedSeats.isEmpty()) {
      sortedList = rows.stream().filter(row -> row.getName() % 2 != 0)
              .collect(Collectors.toList());
      Collections.sort(sortedList, (a, b) -> b.getEmptySeats() - a.getEmptySeats());
      int j = 0;

      while (j < sortedList.size() && numberOfSeats > 0) {
        if (!sortedList.get(j).isFilled()) {
          int temp = sortedList.get(j).getEmptySeats();
          assignedSeats.add(sortedList.get(j).fillSeats(numberOfSeats, reservationNumber,
                  totalSeats));
          numberOfSeats = numberOfSeats - Math.min(temp, numberOfSeats);
        }
        j++;
      }
    }
    result.append(reservationNumber).append(" ")
            .append(String.join(",", assignedSeats))
            .append("\n");
    return result.toString();

  }

  /* method to get the list of all rows in a theater.  */
  public List<eachRow> getRow() {
    return rows;
  }

  /* method to get total available seats in the theater.  */
  public int getTotalNoOfSeats() {
    return totalSeats.intValue();
  }

}
