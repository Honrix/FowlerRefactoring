import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private Movie movie;
    private String title = "movieTitle";
    private int priceCode = 1;

    @BeforeEach
    void setUp() {
        movie = new Movie(title, priceCode);
    }

    @Test
    void getPriceCode() {
        assertEquals(1, movie.getPriceCode());
    }

    @Test
    void getTitle() {
        assertEquals("movieTitle", movie.getTitle());
    }
}