// Assignment: Arizona State University Spring 2023 CSE205 #7
// Name: Shravan Karande
// StudentID: 1225888172
// Lecture: TTH 10:30 AM
// Description: This is a class called ReviewManager which manages a list of Movie objects. It 
// provides methods to add a new movie review, remove a movie review, sort the reviews based on 
// different criteria (Rating and Genre), and get a list of all the reviews.

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    ArrayList<Movie> reviewList;

    public ReviewManager() {
        reviewList = new ArrayList<>();
    }

    public int movieExists (String name , String director) {
    //Checks if movie exists
    	for(int i = 0; i < reviewList.size(); i++) {
    		if(reviewList.get(i).getMovieName().equals(name) && reviewList.get(i).getDirector().equals(director)) {
    		//This Iterates through the review list and checks if the movie name is equal to the given
    	    // movie name and does the same with the director. 
    			
    	
    	
    	       return i;
    		}
    	}
    	return -1;
    }
    
    public ArrayList<Integer> movieGenreExists (String genre) {
    	ArrayList<Integer> numberlist = new ArrayList <>(); 
    	//Arraylist numberlist is made to store the indexes of the same movie genre. 
    	String productionCompany = ""; 
		
    	for (int i = 0; i < reviewList.size(); i++) { 
    		if (reviewList.get(i).getMovieGenre().getGenre().equals(genre)){
    			numberlist.add(i);
    		//this loops through all the movies in the ReviewList by iterating over the 
    	    //indices using a for loop. If a movie in the ReviewList has the same genre
    	   //as the one passed in as a parameter, its index is added to the numberlist ArrayList 
    	   //using the add() method.
    		}	
    	}
	//it returns the numberlist ArrayList containing the indexes of all movies that have the
    //same genre as the one passed in as a parameter.
    	return numberlist;	
    }
    
    
    
    public Movie getMovie(int number) {
    	return reviewList.get(number);
    	
    }
    
    
    
    /**
     * Add a Movie object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two Movies are
     * considered duplicated if they have exactly the same movie name and genre.
     * 
     * @param  movieName          the name of the movie
     * @param  stars              the number of stars the movie recieved
     * @param  review             the movie review
     * @param  totalCollection    the integer total collection earned by the movie
     * @param  genre              the movie's genre
     * @param  director           the movie's director
     * @param  prodictionCompany  production comapny of the movie
     * @return                    true if the operation is successful; false otherwise
     */
    
    //Adds a movie review to the reviewList
    public boolean addReview(String movieName, int stars, String review, String totalCollection, String genre, String director, String productionCompany) {
        if (movieExists(movieName, director) == -1) {
            int collection = totalCollection.length();
            MovieGenre newGenre = new MovieGenre(genre, productionCompany);
            Movie newMovie = new Movie(movieName, stars, review, collection, director, newGenre);
            reviewList.add(newMovie);
            return true;
        }
        return false;
    }


    public boolean removeReview(String movieName, String director) {
    	for (int i = 0; i < reviewList.size(); i++) {
    		if(reviewList.get(i).getMovieName().equals(movieName) && reviewList.get(i).getDirector().equals(director)) {
    			reviewList.remove(i); 
    			return true; 
    		//This removes a review by accessing the movie name and the director of the movie
    		}
    	}
    	return false;    
    }       
 
       public void sortByRating() {
    	   ReviewRatingComparator sortbyrating = new ReviewRatingComparator();
    	   Sorts.sort(reviewList, sortbyrating); 
       }
       public void sortByMovieGenre() {
    	   ReviewMovieGenreComparator sortByMovieGenre = new ReviewMovieGenreComparator (); 
    	   Sorts.sort(reviewList, sortByMovieGenre);
       }
     
       public String listReviews() {
    	   String a = "";
   	   for (int i = 0; i < reviewList.size(); i++) {
    		 
    		 a = a + reviewList.get(i).toString();
    		// or a += reviewList.get(i).toString();
    	   }
    	  return a ; 
       }
       
       
 	  
       public void closeReviewManager() {
    	   reviewList.clear();
       }

}
