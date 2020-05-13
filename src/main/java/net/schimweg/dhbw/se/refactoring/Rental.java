package net.schimweg.dhbw.se.refactoring;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount() {
        switch (movie.getPriceCode()) {
            case REGULAR:
                return 2 + Math.max(0,  (daysRented - 2) * 1.5);
            case NEW_RELEASE:
                return daysRented * 3;
            case CHILDREN:
                return 1.5 + Math.max(0, (daysRented - 3) * 1.5);
        }
        return 0;
    }
}
