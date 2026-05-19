package util;

public class PriceCalculator {

    // Calculate Rental Cost
    public static double calculateRentalCost(double dailyPrice, int days) {
        if (dailyPrice <= 0 || days <= 0) {
            return 0;
        }
        return dailyPrice * days;
    }

    // Calculate Discount
    public static double calculateDiscount(double amount, double discountPercent) {
        if (amount <= 0 || discountPercent < 0) {
            return 0;
        }
        return amount - (amount * discountPercent / 100);
    }

    // Calculate Final Amount
    public static double calculateFinalAmount(double dailyPrice,int days,double discountPercent) {
        double total = calculateRentalCost(dailyPrice, days);
        return calculateDiscount(total, discountPercent);
    }
}