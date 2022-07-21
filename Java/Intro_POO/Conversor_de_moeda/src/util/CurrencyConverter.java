package util;

public class CurrencyConverter {
    public double dollarPrice;
    public double dollarAmount;
    public final double taxRate = 0.06;

    public double dollarToReal() {
        return dollarPrice * dollarAmount;
    }
    public double totalDollarPrice() {
        this.dollarAmount += dollarAmount * taxRate;
        return dollarToReal();
    }
}
