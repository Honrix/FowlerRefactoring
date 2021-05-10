import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRentalsTest {

    private CustomerRentals customerRentals;
    private List<Rental> rentals = new ArrayList<>();
    private Rental rental;

    @BeforeEach
    void setUp() {
        customerRentals = new CustomerRentals();
        Movie movie = new Movie("movieName", 2);
        rental = new Rental(movie, 2);

        Rental rental2 = new Rental(new Movie("movieName2", 1), 2);
        rentals.add(rental2);
        for(Rental rental: rentals){
            customerRentals.addRental(rental);

        }
    }

    @Test
    void addRental() {
        customerRentals.addRental(rental);
        assertEquals(true, customerRentals.getRentals().contains(rental));
    }

    @Test
    void getRentals() {
        assertEquals("movieName2", customerRentals.getRentals().get(0).getMovie().getTitle());
    }
}