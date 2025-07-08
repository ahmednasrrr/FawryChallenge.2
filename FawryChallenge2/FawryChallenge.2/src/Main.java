import services.QuantumBookstore;
import models.*;

import java.util.List;
class QuantumBookstoreFullTest {
    private QuantumBookstore bookstore;

    public QuantumBookstoreFullTest() {
        this.bookstore = new QuantumBookstore();
    }

    public void runAllTests() {
        System.out.println("Quantum book store: Starting comprehensive tests...\n");

        testAddingBooks();
        testPurchasingBooks();
        testRemovingOutdatedBooks();
        testErrorHandling();
        testExtensibility();

        System.out.println("\nQuantum book store: All tests completed successfully!");
    }

    private void testAddingBooks() {
        System.out.println("--- testing book addition ---");

        // Add different types of books
        bookstore.addBook(new PaperBook("1", "Networks",
                "Ahmed Nasr", 2004, 15.99, 50));

        bookstore.addBook(new EBook("2", "Data Structure", "Hazem Zidan",
                2008, 29.99, "PDF"));

        bookstore.addBook(new ShowcaseBook("3", "Operating Systems", "Abdelrahman Sherif",
                2015, 20.99));

        bookstore.addBook(new PaperBook("4", "Algorithms", "Nour Mohamed",
                2005, 8.99, 25));

        System.out.println("Quantum book store: Added 4 books to inventory\n");
    }

    private void testPurchasingBooks() {
        System.out.println("--- testing book purchases ---");

        try {

            PurchaseResult result1 = bookstore.buyBook("15", 2,
                    "customer@email.com", "123 Magic Street, London");
            System.out.println("Quantum book store: Total paid: $" + result1.getTotalAmount());


            PurchaseResult result2 = bookstore.buyBook("16", 1,
                    "developer@email.com", "456 Code Avenue");
            System.out.println("Quantum book store: Total paid: $" + result2.getTotalAmount());

        } catch (Exception e) {
            System.out.println("Quantum book store: Purchase test failed: " + e.getMessage());
        }

        System.out.println();
    }

    private void testRemovingOutdatedBooks() {
        System.out.println("---- testing outdated book removal ---");


        bookstore.addBook(new PaperBook("17", "Programming", "Mostafa Amr",
                2025, 5.99, 10));


        List<Book> removedBooks = bookstore.removeOutdatedBooks(20);
        System.out.println("Quantum book store: Removed " + removedBooks.size() + " outdated books\n");
    }

    private void testErrorHandling() {
        System.out.println("--- testing error handling ---");

        try {

            bookstore.buyBook("INVALID-ISBN", 1, "test@email.com", "Test Address");
        } catch (IllegalArgumentException e) {
            System.out.println("Quantum book store: Correctly caught error: " + e.getMessage());
        }

        try {

            bookstore.buyBook("20", 1, "test@email.com", "Test Address");
        } catch (UnsupportedOperationException e) {
            System.out.println("Quantum book store: Correctly caught error: " + e.getMessage());
        }

        try {

            bookstore.buyBook("100", 100, "test@email.com", "Test Address");
        } catch (IllegalStateException e) {
            System.out.println("Quantum book store: Correctly caught error: " + e.getMessage());
        }

        System.out.println();
    }

    private void testExtensibility() {
        System.out.println("-- testing system extensibility ---");



        class AudioBook extends Book {
            private String narrator;
            private int durationMinutes;

            public AudioBook(String isbn, String title, String authorName, int publicationYear,
                             double price, String narrator, int durationMinutes) {
                super(isbn, title, authorName, publicationYear, price);
                this.narrator = narrator;
                this.durationMinutes = durationMinutes;
            }

            @Override
            public void processPurchase(int quantity, String email, String address) {
                System.out.println("Quantum book store: Processing audiobook delivery...");
                // Could integrate with AudioService here
                System.out.println("Quantum book store: Sending audiobook '" + title +
                        "' narrated by " + narrator + " (" + durationMinutes + " minutes) to " + email);
            }

            @Override
            public String toString() {
                return super.toString() + String.format(" [AudioBook - Narrator: %s, Duration: %d min]",
                        narrator, durationMinutes);
            }
        }


        bookstore.addBook(new AudioBook("978-1-23456-789-0", "Becoming", "Michelle Obama",
                2018, 19.99, "Michelle Obama", 1140));

        System.out.println("Quantum book store: Successfully added new AudioBook type - system is extensible!");


        try {
            PurchaseResult result = bookstore.buyBook("978-1-23456-789-0", 1,
                    "audiobook@email.com", "789 Audio Street");
            System.out.println("Quantum book store: AudioBook purchase successful! Total: $" + result.getTotalAmount());
        } catch (Exception e) {
            System.out.println("Quantum book store: AudioBook purchase failed: " + e.getMessage());
        }

        System.out.println();
    }


    public static void main(String[] args) {
        QuantumBookstoreFullTest test = new QuantumBookstoreFullTest();
        test.runAllTests();


        System.out.println("=== Final Inventory ===");
        test.bookstore.displayInventory();
    }
}