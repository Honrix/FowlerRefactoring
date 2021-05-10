package customer;

import rental.Rental;

import java.util.ArrayList;
import java.util.List;

public class CustomerRentals {

    private final List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

}