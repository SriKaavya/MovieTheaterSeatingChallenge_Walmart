package movieTheaterSeaterTest;

import movieTheaterSeater.Theater;
import movieTheaterSeater.eachRow;
import movieTheaterSeater.movieTheaterInterface;

public class TheaterUnitTest {
	movieTheaterInterface theater;

  
  public void testAllCases() {
    testConstructor();
    testTotalNoOfSeats();
    testGetRow();
    testNotEnoughSeats();
    testRowCreation();
    testIllegalArgs();
    testFilling();
    testFillingInDifferentRows();
    testBulkSeats();
    testFillingToCapacity();
    testSeatsOver();
  }

  public void testConstructor() {
    theater = new Theater(10);
    System.out.println(theater.getTotalNoOfSeats()+"\n");
  }

  public void testTotalNoOfSeats() {
	  theater = new Theater(10);
    theater.fillRows("R001", 15);
    System.out.println(theater.getTotalNoOfSeats()+"\n");
  }

  public void testGetRow() {
	theater = new Theater(10);
	theater.fillRows("R001", 15);
    System.out.println(theater.getRow().get(0).getEmptySeats()+"\n");
  }

  public void testFilling() {
	theater = new Theater(10);
    System.out.println(theater.fillRows("R001", 15));
  }

  public void testBulkSeats() {
	theater = new Theater(10);
    System.out.println(theater.fillRows("R001", 200));
  }

  public void testFillingInDifferentRows() {
	theater = new Theater(10);
	theater.fillRows("R001", 15);
	theater.fillRows("R002", 16);
	theater.fillRows("R003", 17);
	theater.fillRows("R004", 16);
	theater.fillRows("R005", 16);
    System.out.println(theater.fillRows("R001", 4));
  }


  public void testSeatsOver() {
	theater = new Theater(10);

	theater.fillRows("R001", 15);
	theater.fillRows("R002", 15);
	theater.fillRows("R003", 15);
	theater.fillRows("R004", 15);
	theater.fillRows("R005", 15);
    theater.fillRows("R006", 4);
    theater.fillRows("R007", 4);
    theater.fillRows("R008", 2);
    System.out.println(theater.fillRows("R001",6 ));
  }


  public void testNotEnoughSeats() {
	theater = new Theater(10);
	theater.fillRows("R001", 16);
	theater.fillRows("R002", 13);
	theater.fillRows("R003", 14);
	theater.fillRows("R004", 16);
	theater.fillRows("R005", 2);
	theater.fillRows("R006", 4);
	theater.fillRows("R007", 4);
    System.out.println(theater.fillRows("R008",8 ));
  }


  public void testFillingToCapacity() {
	theater = new Theater(10);
	theater.fillRows("R001", 20);
	theater.fillRows("R002", 20);
	theater.fillRows("R003", 20);
	theater.fillRows("R004", 20);
	theater.fillRows("R005", 20);
    System.out.println(theater.fillRows("R001",1 ));
  }


  public void testRowCreation() {
    eachRow row = new eachRow('J');
    System.out.println(row.getEmptySeats()+"\n");
  }


  public void testIllegalArgs() {
	theater = new Theater(10);
    try {
      System.out.println(theater.fillRows("R001", -200));
    } catch (IllegalStateException e) {
      System.out.println("Illegal input exception");
    }

  }
}
