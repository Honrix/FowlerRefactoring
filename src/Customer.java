import java.lang.*;
import java.util.*;

class Customer {

    private String name;
    private Result result;
    private CustomerRentals rentalsList = new CustomerRentals();

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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Result newResult = new Result("Rental Record for " + this.getName());
        newResult.addLine("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount");

        for(Rental rental: rentalsList.getRentals()) {
            double thisAmount = 0;
            thisAmount = amountFor(rental);
            frequentRenterPoints ++;
            if (
                    (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                            rental.getDaysRented() > 1
            ) {
                frequentRenterPoints++;
            }
            newResult.addLine("\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(thisAmount));
            totalAmount += thisAmount;
        }
        newResult.addLine("Amount owed is " + String.valueOf(totalAmount));
        newResult.addLine("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");

        return newResult;
    }

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

}
    