package net.schimweg.dhbw.se.refactoring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.schimweg.dhbw.se.refactoring.Movie;
import net.schimweg.dhbw.se.refactoring.MoviePriceCode;
import net.schimweg.dhbw.se.refactoring.Rental;
import org.junit.jupiter.api.Test;

public class RentalTest {

    @Test
    void getAmount1() {
        Rental r = new Rental(new Movie("Test", MoviePriceCode.NEW_RELEASE), 5);
        assertEquals(15, r.getAmount());
    }

    @Test
    void getAmount2() {
        Rental r = new Rental(new Movie("Test", MoviePriceCode.CHILDREN), 5);
        assertEquals(4.5, r.getAmount());
    }

    @Test
    void getAmount3() {
        Rental r = new Rental(new Movie("Test", MoviePriceCode.REGULAR), 5);
        assertEquals(6.5, r.getAmount());
    }

    @Test
    void getAmount4() {
        Rental r = new Rental(new Movie("Test", MoviePriceCode.NEW_RELEASE), 1);
        assertEquals(3, r.getAmount());
    }

    @Test
    void getAmount5() {
        Rental r = new Rental(new Movie("Test", MoviePriceCode.CHILDREN), 1);
        assertEquals(1.5, r.getAmount());
    }

    @Test
    void getAmount6() {
        Rental r = new Rental(new Movie("Test", MoviePriceCode.REGULAR), 1);
        assertEquals(2, r.getAmount());
    }
}
