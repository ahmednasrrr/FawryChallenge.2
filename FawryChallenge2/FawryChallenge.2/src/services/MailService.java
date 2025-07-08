package services;
import models.EBook;
import models.Book;

public class MailService {
    public static void sendEmail(Book book, String email) {
        EBook ebook = (EBook) book;
        System.out.println("Quantum book store: Sending '" + book.getTitle() +
                "' (" + ebook.getFileType() + ") to email: " + email);
    }
}
