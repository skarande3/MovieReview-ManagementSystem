// Assignment: Arizona State University Spring 2023 CSE205 #7
// Name: Shravan Karande
// StudentID: 1225888172
// Lecture: TTH 10:30 AM
// Description: This class compares 2 movies (first and second).  It is used to sort Movie 
// objects based on multiple criteria: Movie genre, Total collection ,  Movie name, Movie director, and review. 

import java.util.Comparator;

public class ReviewMovieGenreComparator implements Comparator<Movie>{


	@Override
	public int compare(Movie first, Movie second) {
		
		int comparemoviegenre =  (first.getMovieGenre().getGenre().compareTo(second.getMovieGenre().getGenre())); 
			if (comparemoviegenre != 0) {
				return comparemoviegenre; 
			}
		 
			int compareTotalCollection =  first.getTotalCollection() - second.getTotalCollection(); 
		  if (compareTotalCollection != 0) {
			  return compareTotalCollection;
		  }
		 
		int comparemoviename = (first.getMovieName().compareTo(second.getMovieName()));
		if (comparemoviename != 0) {
			return comparemoviename;
		
		}
	   int comparemoviedirector = (first.getDirector().compareTo(second.getDirector()));
	   if (comparemoviedirector != 0) {
		   return comparemoviedirector; 
	   }
		
	   int compareReview  = (first.getReview().compareTo(second.getReview()));
	   if (compareReview != 0) {
		   return compareReview; 
	   }
	   return 0;

	}
}
