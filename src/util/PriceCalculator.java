package util;

public class PriceCalculator {

    public static double calculateRentalPrice(double dailyPrice, long days, double discount, double deposit) {
        double total = (dailyPrice * days);
        total = total - discount + deposit;
        return total;
    }

    public static double applyDiscount(double price, double discountPercent) {
        return price - (price * discountPercent / 100);
    }
}