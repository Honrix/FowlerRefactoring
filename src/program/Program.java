package program;

import customer.Customer;
import movie.Movie;
import rental.Rental;

import java.lang.*;

public class Program {

    public static void main(String args[])
    {
        int[] numbers = {10, 5};

        String result;
        System.out.println("Welcome to the movie.Movie Store");

        Customer c1 = new Customer("joe");

        for(int i = 0; i < 2; i++){
            Movie m = new Movie("movie" + (i + 1), (i+1));
            Rental r = new Rental(m, numbers[i]);
            c1.addRental(r);

        }

        System.out.println("Let's get the Statement");

        result = c1.statement();
        System.out.println(result);
    }

}


