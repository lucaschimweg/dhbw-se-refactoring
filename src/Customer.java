
import java.lang.*;
import java.util.*;

class Customer {
    private String name;

    private final Vector<Rental> rentals = new Vector<>();

    public Customer(String newname) {
        name = newname;
    }

    public Vector<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new Statement(this).toString();
    }

}
    