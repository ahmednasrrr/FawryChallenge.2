package models;

import services.MailService;

public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, String authorName, int publicationYear,
                 double price, String fileType) {
        super(isbn, title, authorName, publicationYear, price);
        this.fileType = fileType;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        System.out.println("Quantum book store: Processing digital book delivery...");
        for (int i = 0; i < quantity; i++) {
            MailService.sendEmail(this, email);
        }
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [EBook - Format: %s]", fileType);
    }
}
