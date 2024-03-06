import java.io.Serializable;

// Assignment: Arizona State University Spring 2023 CSE205 #7
// Name: Shravan Karande
// StudentID: 1225888172
// Lecture: TTH 10:30 AM
// Description: This class also implements the Serializable interface so that its objects can be stored. 
// This class has the getter methods for the instance variable and it has an overridden toString()
// method that returns a string representation of the movie object.  



public class Movie implements Serializable {
   
	private static final long serialVersionUID = 205L; 
    private String movieName; 
    private int stars;
    private String review; 
    private int totalCollection; 
    private String director; 
    MovieGenre movieGenre; 
    
    
    public Movie(String movieName, int stars, String review, int totalCollection, String director, MovieGenre moviegenre) {
    	this.movieName = movieName; 
    	this.stars = stars;
    	this.review = review;
    	this.totalCollection = totalCollection; 
    	this.director = director; 
    	this.movieGenre = moviegenre; 
    }
    
    public String getMovieName() {
    	return movieName; 
    }
    
    public int getStars() {
    	return stars; 
    }
    
    public int getTotalCollection() {
    	return  totalCollection; 
    }
    
    public String getDirector() {
    	return  director; 
 
    }
    
    public MovieGenre getMovieGenre() {
    	return movieGenre; 
    }
    
    public String getReview() {
		return review;
    	
    }
    
    @Override
    public String toString() {
    	//This was done to convert number to "*"
    	String star = "" ;
        for(int i=0; i < stars; i++) {
        	star += "*";
        	
        }
      //This was done to convert number to "$"
        String total = ""; 
        for(int i=0; i < totalCollection; i++)
        	total += "$"; 
        
    	return movieName + " Movie\n" + star + "\n" + "Total Collection earned: " +  total + "\n" +  movieGenre.toString() + "Director: " + director + "\n" + "Review:\t" + review + "\n\n";
    }

}
