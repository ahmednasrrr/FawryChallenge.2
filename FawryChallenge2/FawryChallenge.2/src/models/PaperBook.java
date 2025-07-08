package models;
import services.ShippingService;

public class PaperBook extends Book {
    private int stockQuantity;

    public PaperBook(String isbn, String title, String authorName, int publicationYear, double price, int stockQuantity) {
        super(isbn, title, authorName, publicationYear, price);
        this.stockQuantity = stockQuantity;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        if (stockQuantity < quantity) {
            throw new IllegalStateException("Quantum book store: Sorry, Not enough stock available. " +
                    "Requested: " + quantity + ", Available: " + stockQuantity);
        }

        stockQuantity -= quantity;
        System.out.println("Quantum book store: Processing paper book shipment...");
        ShippingService.ship(this, quantity, address);
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Paper Book - Stock: %d]", stockQuantity);
    }
}
