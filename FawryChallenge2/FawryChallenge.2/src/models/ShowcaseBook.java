package models;

public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, String authorName, int publicationYear,
                        double price) {
        super(isbn, title, authorName, publicationYear, price);
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Quantum book store: This is a showcase book and cannot be purchased");
    }

    @Override
    public String toString() {
        return super.toString() + " [Showcase Book - Not for Sale]";
    }
}
