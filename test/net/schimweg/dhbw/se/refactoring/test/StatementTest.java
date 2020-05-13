package net.schimweg.dhbw.se.refactoring.test;

import net.schimweg.dhbw.se.refactoring.Customer;
import net.schimweg.dhbw.se.refactoring.Movie;
import net.schimweg.dhbw.se.refactoring.Rental;
import net.schimweg.dhbw.se.refactoring.Statement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementTest {

    @Test
    void getFrequentRenterPoints1() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", Movie.NEW_RELEASE), 5));
        assertEquals(2, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    void getFrequentRenterPoints2() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", Movie.CHILDRENS), 5));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    void getFrequentRenterPoints3() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", Movie.REGULAR), 5));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    void getFrequentRenterPoints4() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", Movie.NEW_RELEASE), 1));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    void getFrequentRenterPoints5() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", Movie.CHILDRENS), 1));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    void getFrequentRenterPoints6() {
        Customer c = new Customer("Name");
        c.addRental(new Rental(new Movie("Test", Movie.REGULAR), 1));
        assertEquals(1, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    void getFrequentRenterPoints7() {
        Customer c = new Customer("Name");
        assertEquals(0, new Statement(c).getFrequentRenterPoints());
    }

    @Test
    void getTotalAmount1() {
        Customer c = new Customer("Name");
        Rental r = new Rental(new Movie("Test", Movie.CHILDRENS), 5);
        c.addRental(r);
        assertEquals(r.getAmount(), new Statement(c).getTotalAmount());
    }

    @Test
    void getTotalAmount2() {
        Customer c = new Customer("Name");
        Rental r = new Rental(new Movie("Test", Movie.CHILDRENS), 5);
        Rental r2 = new Rental(new Movie("Test2", Movie.NEW_RELEASE), 20);
        c.addRental(r);
        c.addRental(r2);
        assertEquals(r.getAmount() + r2.getAmount(), new Statement(c).getTotalAmount());
    }

    @Test
    void toString1() {
        Customer c = new Customer("Name");
        assertEquals("Rental Record for Name\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", new Statement(c).toString());
    }

    @Test
    void toString2() {
        Customer c = new Customer("Name");
        Rental r = new Rental(new Movie("Test", Movie.CHILDRENS), 5);
        Rental r2 = new Rental(new Movie("Test2", Movie.NEW_RELEASE), 20);
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
