package tests;

import movie.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rental.Rental;

import static org.junit.Assert.assertEquals;


public class RentalTest {

    private Rental rental;
    private Movie movie;
    private int daysRented;

    @BeforeEach
    void setUp() {
        movie = new Movie("movieName", 1);
        daysRented = 2;
        rental = new Rental(movie, daysRented);
    }

    @Test
    void getPrice() {
        assertEquals(1, rental.getPrice());
    }

    @Test
    void getDaysRented() {
        assertEquals(2, rental.getDaysRented());
    }

    @Test
    void getMovie() {
        assertEquals(movie, rental.getMovie());
    }
}