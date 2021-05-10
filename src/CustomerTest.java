import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;
    private Movie movie;
    private Rental rental;
    private CustomerRentals rentals;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        customer = new Customer("customerName");
        movie = new Movie("movieName", 2);
        rental = new Rental(movie, 2);
        rentals = new CustomerRentals();
        customer.setRentals(rentals);
    }

    @org.junit.jupiter.api.Test
    void addRental() {
        rentals.addRental(rental);
        String expectedString = "Rental Record for customerName" +
                "\n\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" +
                "\n\t" + "movieName" + "\t" + "\t" + "2" + "\t" + "1.5" +
                "\n" + "Amount owed is 1.5" +
                "\n" + "You earned 1 frequent renter points";
        assertEquals(expectedString, customer.statement());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("customerName", customer.getName());
    }

    @org.junit.jupiter.api.Test
    void statement() {
        String expectedString = "Rental Record for customerName" +
                "\n\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" +
                "\n" + "Amount owed is 0.0" +
                "\n" + "You earned 0 frequent renter points";
        assertEquals(expectedString, customer.statement());
    }

    @org.junit.jupiter.api.Test
    void getResult() {
        Result result = new Result("Rental Record for customerName\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points");
        assertEquals(result.getResult(), customer.getResult().getResult());
    }

    @org.junit.jupiter.api.Test
    void getTotalAmount() {
        assertEquals(0.0, customer.getTotalAmount());
    }

    @org.junit.jupiter.api.Test
    void getFrequentRenterPoints() {
        assertEquals(0, customer.getFrequentRenterPoints());
    }
}