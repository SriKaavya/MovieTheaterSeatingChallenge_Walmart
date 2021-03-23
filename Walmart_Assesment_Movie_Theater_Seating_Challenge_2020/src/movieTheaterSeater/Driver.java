package movieTheaterSeater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import movieTheaterSeaterTest.TheaterUnitTest;

/* This is the starting point of execution which has main method */
public class Driver {

  /* It reads input fills the theater and passes the output to output file  */

  // input path is : /Users/srikaavya/Desktop/eclipse-workspace/Walmart_Assesment_Movie_Theater_Seating_Challenge_2020/walmart/input.txt
	
  public static void main(String[] args) {
	final String input = args[0];
//final String input = "/Users/srikaavya/Desktop/eclipse-workspace/Walmart_Assesment_Movie_Theater_Seating_Challenge_2020/walmart/input.txt";
    //To read the contents of a file
    try (BufferedReader br = new BufferedReader(new FileReader(input))) {
      movieTheaterInterface theatre = new Theater(10);
      StringBuilder result = new StringBuilder();
      String line = br.readLine();
      while (line != null) {
        String[] parse = line.split(" ");
        int noOfSeats = Integer.parseInt(parse[1]);
        String reservationNo = parse[0];
        result.append(theatre.fillRows(reservationNo, noOfSeats));
        line = br.readLine();
      }

      File file = new File("/Users/srikaavya/Desktop/eclipse-workspace/Walmart_Assesment_Movie_Theater_Seating_Challenge_2020/walmart/output.txt");
      BufferedWriter bwr = new BufferedWriter(new FileWriter(file));
      //writes the contents of StringBuffer to a file
      bwr.write(result.toString());
      //flushing the stream
      bwr.flush();
      //closing the stream
      bwr.close();
      System.out.println("\nOutput is at: "+file.getAbsoluteFile());
      System.out.println("\n*********** UNIT TEST CASES ************* //\n");
      new TheaterUnitTest().testAllCases();
    }
    catch (FileNotFoundException e) {
      System.out.println("Caught Exception: File not found");
      e.printStackTrace();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }
}

