// Assignment: Arizona State University Spring 2023 CSE205 #7
// Name: Shravan Karande
// StudentID: 1225888172
// Lecture: TTH 10:30 AM
// Description: The class provides a getter method for the genre variable and overrides
// the toString() method to return a string representation of the object, which includes the genre
// and production company.

import java.io.Serializable;

public class MovieGenre implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L; 
    private String genre;
    private String productionCompany;

    public MovieGenre(String genre, String productionCompany) {
        this.genre = genre;
        this.productionCompany = productionCompany;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return genre + " Movie\n" +
                "Production Company:\t" + productionCompany + '\n';
    }
}

