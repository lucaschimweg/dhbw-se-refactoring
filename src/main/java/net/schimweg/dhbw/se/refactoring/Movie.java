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

    public String getTitle() {
        return title;
    }
}