package services;
import models.Book;
public class ShippingService {
    public static void ship(Book book, int quantity, String address) {
        System.out.println("Quantum book store: Shipping " + quantity + " copy(ies) of '" +
                book.getTitle() + "' to address: " + address);
    }
}