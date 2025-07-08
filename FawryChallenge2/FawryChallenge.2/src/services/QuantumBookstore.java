package services;
import java.util.*;
import models.Book;
import models.PurchaseResult;

public class QuantumBookstore {
    private Map<String, Book> inventory;

    public QuantumBookstore() {
        this.inventory = new HashMap<>();
    }


    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book - " + book);
    }


    public List<Book> removeOutdatedBooks(int yearsThreshold) {
        List<Book> outdatedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        System.out.println("Quantum book store: Checking for outdated books (older than " +
                yearsThreshold + " years)...");

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();

            if (book.isOutdated(yearsThreshold)) {
                outdatedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book);
            }
        }

        if (outdatedBooks.isEmpty()) {
            System.out.println("Quantum book store: No outdated books found.");
        }

        return outdatedBooks;
    }


    public PurchaseResult buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Quantum book store: Book with ISBN '" + isbn + "' not found in inventory!");
        }

        try {
            book.processPurchase(quantity, email, address);
            double totalAmount = book.getPrice() * quantity;

            String message = String.format("Quantum book store: Successfully purchased %d copy(ies) of '%s'",
                    quantity, book.getTitle());
            System.out.println(message);

            return new PurchaseResult(totalAmount, message);

        } catch (Exception e) {
            System.out.println("Quantum book store: Purchase failed - " + e.getMessage());
            throw e;
        }
    }


    public void displayInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        System.out.println("=====================================");

        if (inventory.isEmpty()) {
            System.out.println("Quantum book store: No books in inventory.");
            return;
        }

        for (Book book : inventory.values()) {
            System.out.println("Quantum book store: " + book);
        }
    }


    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }


    public int getTotalBooks() {
        return inventory.size();
    }
}