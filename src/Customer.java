import java.lang.*;
import java.util.*;

class Customer {

    private String name;
    private Result result;
    private CustomerRentals rentalsList = new CustomerRentals();
    private int frequentRenterPoints = 0;

    public Customer (String newname){
        name = newname;
    };

    public void addRental(Rental rental) {
        rentalsList.addRental(rental);

    };

    public String getName (){
        return name;
    };

    public String statement() {
        result = getResult();
        return result.getResult();
    }

    public Result getResult(){
        Result newResult = new Result("Rental Record for " + this.getName());
        newResult.addLine("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount");

        for(Rental rental: rentalsList.getRentals()){
            newResult.addLine("\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getPrice()));
        }

        newResult.addLine("Amount owed is " + String.valueOf(getTotalAmount()));
        newResult.addLine("You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points");

        return newResult;
    }

    public double getTotalAmount(){
        double totalAmount = 0;
        for(Rental rental: rentalsList.getRentals()){
            totalAmount += rental.getPrice();
        }
        return totalAmount;
    }

    public int getFrequentRenterPoints(){
        for(Rental rental: rentalsList.getRentals()){
            frequentRenterPoints ++;
            if (
                    (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                            rental.getDaysRented() > 1
            ) {
                frequentRenterPoints++;
            }
        }
        return frequentRenterPoints;

    }

}
    