import java.lang.*;
import java.util.*;
/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line.
 * Java console applications can not be previewed in the Compilr IDE, only applets can.
 */
public class Program {
    /**
     * This is the main entry point for the application
     */

    public static void main(String args[])
    {
        String result;
        System.out.println("Welcome to the Movie Store");

        Customer c1 = new Customer("joe");

        for(int i = 0; i < 2; i++){
            Movie m = new Movie("movie" + (i + 1), (i+1));
            Rental r = new Rental(m, (i < 1? 10 : 5));
            c1.addRental(r);

        }

        System.out.println("Let's get the Statement");

        result = c1.statement();
        System.out.println(result);
    }

}


