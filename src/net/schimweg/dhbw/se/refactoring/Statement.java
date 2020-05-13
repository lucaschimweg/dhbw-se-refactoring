package net.schimweg.dhbw.se.refactoring;

public class Statement {

    private final Customer customer;

    public Statement(Customer cust) {
        this.customer = cust;
    }

    public int getFrequentRenterPoints() {
        return customer.getRentals().stream().parallel().mapToInt(rental -> {
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                return 2;
            }
            return 1;
        }).sum();
    }

    public double getTotalAmount() {
        return customer.getRentals().stream().parallel().mapToDouble(Rental::getAmount).sum();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("net.schimweg.dhbw.se.refactoring.Rental Record for " + customer.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental each : customer.getRentals()) {
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(each.getAmount()).append("\n");
        }

        //add footer lines
        result.append("Amount owed is ").append(getTotalAmount()).append("\n");
        result.append("You earned ").append(getFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }
}
