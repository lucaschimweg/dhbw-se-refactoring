package net.schimweg.dhbw.se.refactoring.test;

import net.schimweg.dhbw.se.refactoring.Customer;
import net.schimweg.dhbw.se.refactoring.Rental;
import net.schimweg.dhbw.se.refactoring.Statement;
import net.schimweg.dhbw.se.refactoring.Movie;
import net.schimweg.dhbw.se.refactoring.MoviePriceCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementTest {

    @Test
    private void getFrequentRenterPoints1() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", MoviePriceCode.NEW_RELEASE), 5));
        assertEquals(2, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    private void getFrequentRenterPoints2() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", MoviePriceCode.CHILDREN), 5));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    private void getFrequentRenterPoints3() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", MoviePriceCode.REGULAR), 5));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    private void getFrequentRenterPoints4() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", MoviePriceCode.NEW_RELEASE), 1));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    private void getFrequentRenterPoints5() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", MoviePriceCode.CHILDREN), 1));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    private void getFrequentRenterPoints6() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", MoviePriceCode.REGULAR), 1));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    private void getFrequentRenterPoints7() {
        Customer c = new Customer("Name");
        assertEquals(0, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    private void getTotalAmount1() {
        Customer c = new Customer("Name");
        Rental r = new Rental(new Movie("Test", MoviePriceCode.CHILDREN), 5);
        c.addRental(r);
        assertEquals(r.getAmount(), new Statement(c).getTotalAmount());
    }

    @Test
    private void getTotalAmount2() {
        Customer c = new Customer("Name");
        Rental r = new Rental(new Movie("Test", MoviePriceCode.CHILDREN), 5);
        Rental r2 = new Rental(new Movie("Test2", MoviePriceCode.NEW_RELEASE), 20);
        c.addRental(r);
        c.addRental(r2);
        assertEquals(r.getAmount() + r2.getAmount(), new Statement(c).getTotalAmount());
    }

    @Test
    private void toString1() {
        Customer c = new Customer("Name");
        assertEquals("Rental Record for Name\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", new Statement(c).toString());
    }

    @Test
    private void toString2() {
        Customer c = new Customer("Name");
        Rental r = new Rental(new Movie("Test", MoviePriceCode.CHILDREN), 5);
        Rental r2 = new Rental(new Movie("Test2", MoviePriceCode.NEW_RELEASE), 20);
        c.addRental(r);
        c.addRental(r2);
        assertEquals("Rental Record for Name\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTest\t\t5\t4.5\n" +
                "\tTest2\t\t20\t60.0\n" +
                "Amount owed is 64.5\n" +
                "You earned 3 frequent renter points", new Statement(c).toString());
    }
}
