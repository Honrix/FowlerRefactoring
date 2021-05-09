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

    public void setPriceCode(int arg) {

        priceCode = arg;
    }

    public String getTitle (){

        return title;
    };
}