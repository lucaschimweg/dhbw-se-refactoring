package net.schimweg.dhbw.se.refactoring;

import java.util.function.Function;

public enum MoviePriceCode {
    CHILDREN(daysRented -> 1.5 + Math.max(0, (daysRented - 3) * 1.5)),
    REGULAR(daysRented -> 2 + Math.max(0,  (daysRented - 2d) * 1.5d)),
    NEW_RELEASE(daysRented -> daysRented * 3d);

    private final Function<Integer, Double> priceFunction;
    MoviePriceCode(Function<Integer, Double> priceFunction) {
        this.priceFunction = priceFunction;
    }

    public Function<Integer, Double> getPriceFunction() {
        return priceFunction;
    }
}
