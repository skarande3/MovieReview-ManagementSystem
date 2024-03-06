// Assignment: Arizona State University Spring 2023 CSE205 #7
// Name: Shravan Karande
// StudentID: 1225888172
// Lecture: TTH 10:30 AM
// Description: This class compares 2 movie objects (first and second). It is used to sort Movie 
// objects based on multiple criteria: rating, movie name, director, and review.

import java.util.Comparator;

public class ReviewRatingComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie first, Movie second) {
    
		//the method returns the difference in rating 
		int rating = first.getStars() - second.getStars(); 
		if(rating !=0) {
			return rating;
		}
		
		
		int compareMoviename = (first.getMovieName().compareTo(second.getMovieName())); 
		if(compareMoviename !=0) {
			return compareMoviename; 
		
		}
		
		
		int Moviedirector = (first.getDirector().compareTo(second.getDirector()));
		if(Moviedirector != 0) {
			return Moviedirector;
		}
		
		int compareReview  = (first.getReview().compareTo(second.getReview()));
		   if (compareReview != 0) {
			   return compareReview; 
		   }
		
		   
		   
		   return 0;
	}

	
	

}

