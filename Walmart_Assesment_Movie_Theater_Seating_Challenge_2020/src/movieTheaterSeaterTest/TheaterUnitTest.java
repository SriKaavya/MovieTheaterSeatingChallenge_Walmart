package movieTheaterSeaterTest;

import java.util.concurrent.atomic.AtomicInteger;

import movieTheaterSeater.Theater;
import movieTheaterSeater.eachRow;
import movieTheaterSeater.movieTheaterInterface;

public class TheaterUnitTest {
	movieTheaterInterface theater;

  public void testAll() {
    testConstructor();
    testFilling();
    testFillingInDifferentRows();
    testFillingMoreThanRemainingSeats();
    testFillingToCapacity();
    testSeatsGettingOver();
    testTotalNoOfSeats();
    testGetRow();
    testNotEnoughSeats();
    testNodeCreation();
    testFillInNode();
    testIllegalArguments();
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
    System.out.println(theater.getRow().get(0).getSeatsEmpty()+"\n");
  }

  public void testFilling() {
	theater = new Theater(10);
    System.out.println(theater.fillRows("R001", 15));
  }

  public void testFillingMoreThanRemainingSeats() {
	theater = new Theater(10);
    System.out.println(theater.fillRows("R001", 200));
  }

  public void testFillingInDifferentRows() {
	theater = new Theater(10);
	theater.fillRows("R001", 15);
	theater.fillRows("R002", 15);
	theater.fillRows("R003", 15);
	theater.fillRows("R004", 15);
	theater.fillRows("R005", 15);
    System.out.println(theater.fillRows("R001", 4));
  }


  public void testSeatsGettingOver() {
	theater = new Theater(10);

	theater.fillRows("R001", 15);
	theater.fillRows("R002", 15);
	theater.fillRows("R003", 15);
	theater.fillRows("R004", 15);
	theater.fillRows("R005", 15);
    theater.fillRows("R006", 4);
    theater.fillRows("R007", 4);
    theater.fillRows("R008", 2);
    System.out.println(theater.fillRows("R001",1 ));
  }


  public void testNotEnoughSeats() {
	theater = new Theater(10);
	theater.fillRows("R001", 15);
	theater.fillRows("R001", 15);
	theater.fillRows("R001", 15);
	theater.fillRows("R001", 15);
	theater.fillRows("R001", 15);
	theater.fillRows("R001", 4);
	theater.fillRows("R001", 4);
    System.out.println(theater.fillRows("R001",4 ));
  }


  public void testFillingToCapacity() {
	theater = new Theater(10);
	theater.fillRows("R001", 20);
	theater.fillRows("R001", 20);
	theater.fillRows("R001", 20);
	theater.fillRows("R001", 20);
	theater.fillRows("R001", 20);
    System.out.println(theater.fillRows("R001",1 ));
  }


  public void testNodeCreation() {
    eachRow row = new eachRow('J');
    System.out.println(row.getSeatsEmpty()+"\n");
  }

  public void testFillInNode() {
	eachRow row = new eachRow('J');
    System.out.println(row.fillSeats(2,"R001",new AtomicInteger(20))+"\n");
  }

  public void testIllegalArguments() {
	theater = new Theater(10);
    try {
      System.out.println(theater.fillRows("R001", -200));
    } catch (IllegalStateException e) {
      System.out.println("Illegal argument exception");
    }

  }
}
