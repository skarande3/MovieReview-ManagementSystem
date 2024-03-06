// Assignment: Arizona State University Spring 2023 CSE205 #7
// Name: Shravan Karande
// StudentID: 1225888172
// Lecture: TTH 10:30 AM
// Description: This is the main class with several test cases and all input and output are handled in the driver class Assignment7.
// It also involves several try and catch blocks to check for many exceptions. The main method also displays the menu. 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Assignment7
{
    public static void main(String[] args) {
        // Menu options
        char inputOpt = ' ';
        String inputLine;
        // Movie and Movie Genre information
        String movieName, movieGenre;
        String review = null, director, productionCompany, totalCollection;

        int rating;
        // Output information
        String outFilename, inFilename;
        String outMsg, inMsg;
        // Movie manager
        ReviewManager reviewManager = new ReviewManager();
        // Operation result
        boolean opResult;   
        
        try {
            printMenu();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                    case 'A': // Add a new Movie Review
                        System.out.print("Please enter the movie information:\n");
                        System.out.print("Enter the movie name:\n");
                        movieName = stdin.readLine().trim(); 
                        System.out.print("Enter the review:\n");
                        review = stdin.readLine().trim();
                        System.out.print("Enter the total collection:\n");
                        totalCollection = stdin.readLine().trim();
                        System.out.print("Enter the rating:\n");
                        rating = Integer.parseInt(stdin.readLine().trim());
                        System.out.print("Enter the movie genre:\n");
                        movieGenre = stdin.readLine().trim();
                        System.out.print("Enter the movie's Director:\n");
                        director = stdin.readLine().trim();
                        System.out.print("Enter the movie's production company\n");
                        productionCompany = stdin.readLine().trim();
                        
                        
                        if(reviewManager.addReview(movieName, rating, review, totalCollection, movieGenre, director, productionCompany) == true) {
                        	//This checks whether the review was added.
                        	System.out.print("Movie added to the database!\n");	
                        }
                        else {
                        	System.out.print("Movie NOT added!\n");
                        }                      
                        
                        /*********************************************************************
                        * Complete the code by calling the addReview method.                 *
                        * If the review has been added successfully, show                    *
                        * "Movie added to the database!\n" on screen, otherwise "Movie NOT added!\n" *
                        **********************************************************************/
                        
                        break;
                        
                        
                    case 'D': // Search for a movie
                        System.out.print("Please enter the Movie name to search:\n");
                        movieName = stdin.readLine().trim();
                        System.out.print("Please enter the movies's director':\n");
                        director = stdin.readLine().trim();
                        
                        /*********************************************************************
                        * Complete the code. If the movie review exists, print            *
                        * "Movie found. Here's the review:\n"                           *
                        * Otherwise, print "Movie not found. Please try again\n"        *
                        **********************************************************************/
                      
				
					if(reviewManager.movieExists(movieName, director) != -1) {
                        //This checks if the movie exists	
						System.out.print("Movie found. Here's the review:\n");
						System.out.println(reviewManager.getMovie(reviewManager.movieExists(movieName, director)).getReview());
                         //this take the index of the reviewList that is returned from movieExists method. 
						//Now this becomes a movie object so we can use the .getReview() method.  
                       }
                        else {
                        System.out.print("Movie not found. Please try again\n");
                        }
                    
					
					break;
					
                    case 'E': // Search for a Movie Genre
                        System.out.print("Please enter the movie genre to search:\n");
                        movieGenre = stdin.readLine().trim();
                        
                        /*******************************************************************************
                        * Complete the code. If a movie genre is found, show on the screen how many    *
                        * movies match that genre by printing                                          *
                        * "%d Movies matching %s type were found:\n" followed by the reviews.          *
                        * Otherwise, print "Movie Genre: %s was NOT found\n"                           *
                        ******************************************************************************/   
                        if(reviewManager.movieGenreExists(movieGenre).size() != 0) {
                        	
                        	System.out.printf("%d Movies matching %s type were found:\n", reviewManager.movieGenreExists(movieGenre).size(), movieGenre );
                        
                        
                        for (int j =0; j < (reviewManager.movieGenreExists(movieGenre).size()); j++) {
                        	//This iterates through the "numberlist" array that reviewManager.movieGenreExists(movieGenre) returns, 
                        	//this numberlist includes the Indexes of all the movies with similar genre 
                        
                        
                       System.out.print(reviewManager.getMovie(reviewManager.movieGenreExists(movieGenre).get(j)).toString());  
                       
                       // This gets the movie of the index in the numberlist and prints its review (toString method in Movie class)               
                        }
                        }
                        	
                        
                        else {
                        System.out.print("Movie Genre: "+movieGenre+" was NOT found\n");
                        }
                        
                        
                        
                        break; 
                        
                        
                    case 'L': // List movie's reviews
                        if(reviewManager.listReviews().length() > 0) {
                    	System.out.print("\n" + reviewManager.listReviews() + "\n");
                        }
                        else {
                        	System.out.print("No Reviews available \n");
                        }
                        break;
                        
                     /******************************************************************************************
                     * Complete the code by adding two cases:                                                  *
                     * case 'N': sorts the movie reviews by rating and prints "sorted by rating\n"        *
                     * case 'P': sorts the movie reviews by movie genre and prints "sorted by genre\n" *
                     ******************************************************************************************/                        
                        
                    case 'N' :
                       //sorts by rating 
                    	reviewManager.sortByRating();
                        System.out.print("sorted by rating\n");
                        break;
                    
                    case 'P' :
                    	//sorts by movie genre 
                    	reviewManager.sortByMovieGenre();
                        System.out.print("sorted by genre\n");
                        break;
                        
                        
                    case 'Q': // Quit
                        break;

                    case 'R': // Remove a review
                        System.out.print("Please enter the name of the movie for which you want the review removed:\n");
                        movieName = stdin.readLine().trim();
                        System.out.print("Please enter the name of the movie's director:\n");
                        director = stdin.readLine().trim();
                        
                       
                        /*******************************************************************************
                        * Complete the code. If a review for a certain movie directed by the given     *
                        * director is found, remove the review and print that it was removed. Otherwise*
                        * print that it was NOT removed.                                               * 
                        *******************************************************************************/
                        if (reviewManager.removeReview(movieName, director)) {
                        	//removes review looking at the movie name and director 
                            System.out.println(movieName + ", " + director + " was removed\n");
                        } else {
                            System.out.println(movieName + ", " + director + " was NOT removed\n");
                        }
                      
                        break;
                        
                    case 'T': // Close reviewList
                        reviewManager.closeReviewManager();
                        System.out.print("The movie management system was reset!\n");
                        break;

                    case 'U': // Write movies' names and reviews to a text file
                        System.out.print("Please enter a file name that we will write to:\n");
                        outFilename = stdin.readLine().trim();
                        System.out.print("Please enter the name of the movie:\n");
                        movieName = stdin.readLine().trim();
                        System.out.println("Please enter a review to save locally:\n");
                        review = stdin.readLine().trim();
                        outMsg = movieName + "\n" + review + "\n";
                        
                        /*************************************************************************************
                        * Add a try and catch block to write the string outMsg into the user-specified file  *
                        * Then, print in the screen that the file " is written\n"                            *
                        * In case of an IO Exception, print "Write string inside the file error\n"           *                                                             
                        *************************************************************************************/                    
    
                        try {
                            // This creates a new FileWriter with the file name "outFilename"
                        	
                            FileWriter write = new FileWriter(outFilename);
                            BufferedWriter writer = new BufferedWriter(write);
                            // This writes the string outMsg to the file
                            writer.write(outMsg);
                          
                            writer.close();
                            
                            System.out.println(outFilename + " is written\n");
                       
                        } catch (IOException e) {
                        	
                            System.out.println("Write string in file error\n");
                        }
                        break;
                                            
                        
                        
                    case 'V': // Read strings from a text file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                        /******************************************************************************************
                        * Add a try and catch block to read from the above text file. Confirm that the file       *
                        * " was read\n" and then print "The contents of the file are:\n" followed by the contents *
                        * In case of an IO Exception, print "Read string from file error\n"                       *  
                        * In case of a file not found exception, print that the file " was not found\n"           *                                                             
                        ******************************************************************************************/ 
                        
                        
                        try {
                            // This creates a new FileReader with the file name "inFilename"
                            FileReader read = new FileReader(inFilename);
                            BufferedReader reader = new BufferedReader(read);

                            System.out.println(inFilename + " was read\nThe contents of the file are:");

                            // This reads each line of the file and print it to the screen
                            String content;
                            while ((content = reader.readLine()) != null) {
                                System.out.println(content);
                            }

                            reader.close();

                        } catch (FileNotFoundException e) {
                          
                        	System.out.println(inFilename + " was not found\n");

                        } catch (IOException e) {
                           
                        	System.out.println("Read string from file error\n");
                        }

                        break;
                        
                    case 'W': // Serialize ReviewManager to a data file
                        System.out.print("Please enter a file name to write:\n");
                        outFilename = stdin.readLine().trim();
                        
                        /****************************************************************************
                        * Add a try and catch block to serialize ReviewManager to a data file.      *
                        * Catch two exceptions and print the corresponding messages on the screen:  *
                        * "Not serializable exception\n"                                            *
                        * "Data file written exception\n"                                           * 
                        ****************************************************************************/                    
    
                        try {
                        	FileOutputStream FileOut = new FileOutputStream(outFilename); 
                        
                        	ObjectOutputStream ObjectOut = new ObjectOutputStream(FileOut);
                        	// an ObjectOutputStream object is created to write the ReviewManager object to the file.
                        	ObjectOut.writeObject(reviewManager);
                        
                        	ObjectOut.close();
                        
                        	
                        } catch (NotSerializableException e) {
                            
                        	System.out.println("Not serializable exception\n");
                       
                        } catch (IOException e) {
                            
                        	System.out.println("Data file written exception\n");
                        }
                        
                        break;
                        
                        
                    case 'X': // Deserialize ReviewManager from a data file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                        /*****************************************************************************
                         * Add a try and catch block to deserialize ReviewManager from a data file.  *
                         * Catch three exceptions and print the corresponding messages on the screen:*
                         * "Class not found exception\n"                                             *
                         * "Not serializable exception\n"                                            * 
                         * "Data file read exception\n"                                              *
                         ****************************************************************************/  
                     
                        try { FileInputStream fileInputStream = new FileInputStream(inFilename);
                               
                        	ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); 
                            
                        	reviewManager = (ReviewManager) objectInputStream.readObject();
                        	// This reads the ReviewManager object from the file using the readObject() method
                        	//and assigns it to the reviewManager variable.
                        	 System.out.print(inFilename + " was read");   
                        	
                        	objectInputStream.close();
                           } catch (ClassNotFoundException e) {
                               
                        	   System.out.println("Class not found exception\n");
                           
                           } catch (NotSerializableException e) {
                               
                        	   System.out.println("Not serializable exception\n");
                           
                           } catch (IOException e) {
                               
                        	   System.out.println("Data file read exception\n");
                           }
                        
                       
                       
                        break;
                        
                        
                        
                    case '?': // Display help
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to YoMovies! ");
        System.out.println("Find or post reviews for your favorite (and not so favorite) movies.");

        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a review\n"
                + "D\t\tSearch for a movie\n" + "E\t\tSearch for a genre\n"
                + "L\t\tList all reviews\n" + "N\t\tSort by stars\n" + "P\t\tSort by genre\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a review\n"
                + "U\t\tAdd personal review to a local file\n" + "V\t\tRetrieve personal review from a local file\n"
                + "W\t\tSave reviews to a file\n"
                + "X\t\tUpload reviews from a file\n"
                + "T\t\t(admin) reset database\n"
                + "?\t\tDisplay Help\n");
    }
   
}
