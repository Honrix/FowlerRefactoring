import java.util.ArrayList;
import java.util.List;

class CustomerRentals {

    private final List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

}