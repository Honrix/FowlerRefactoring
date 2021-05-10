package movie;

public class Movie extends MovieSuper {

    private String title;
    private int priceCode;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }

    public int getPriceCode() {

        return priceCode;
    }

    public String getTitle (){

        return title;
    };
}