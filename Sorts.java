import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Assignment: Arizona State University Spring 2023 CSE205 #7
// Name: Shravan Karande
// StudentID: 1225888172
// Lecture: TTH 10:30 AM
// Description: This class defines a static method sort, which takes an ArrayList of
// Movie objects and a Comparator<Movie> object as parameters. The Collections.sort method is called with
// these parameters to sort the ArrayList according to the compare method of the provided Comparator.

public class Sorts {

	public static void sort(ArrayList<Movie> reviewList, Comparator<Movie> xComparator) {
 	 
		Collections.sort(reviewList, xComparator); 
	
	
	}
	

}
