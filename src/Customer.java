import java.lang.*;
import java.util.*;

class Customer {

    private String name;
    private Vector rentals = new Vector();
    private Result result;

    public Customer (String newname){
        name = newname;
    };

    public void addRental(Rental arg) {

        rentals.addElement(arg);
    };

    public String getName (){
        return name;
    };

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();

        result = new Result("Rental Record for " + this.getName());
        result.addLine("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount");

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = amountFor(each);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if (
                    (each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                            each.getDaysRented() > 1
            ) {
                frequentRenterPoints++;
            }
            //show figures for this rental
            result.addLine("\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(thisAmount));
            totalAmount += thisAmount;
        }
        //add footer lines
        result.addLine("Amount owed is " + String.valueOf(totalAmount));
        result.addLine("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        return result.getResult();
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
    