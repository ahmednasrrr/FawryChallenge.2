package models;

public class PurchaseResult {
    private double totalAmount;
    private String message;

    public PurchaseResult(double totalAmount, String message) {
        this.totalAmount = totalAmount;
        this.message = message;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public String getMessage() {
        return message;
    }
}
