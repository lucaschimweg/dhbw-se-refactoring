package net.schimweg.dhbw.se.refactoring;

public class Movie {
    private String title;
    private MoviePriceCode priceCode;

    public Movie(String title, MoviePriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public MoviePriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(MoviePriceCode arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }
}