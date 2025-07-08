package models;

 public abstract class Book {
    protected String isbn;
    protected String title;
    protected String authorName;
    protected int publicationYear;
    protected double price;

    public Book(String isbn, String title, String authorName, int publicationYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
        this.price = price;
    }


    public abstract void processPurchase(int quantity, String email, String address);


    public boolean isOutdated(int yearsThreshold) {
        return (2024 - publicationYear) > yearsThreshold;
    }


    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthorName() {
        return authorName;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("'%s' by %s (ISBN: %s, Year: %d, Price: $%.2f)",
                title, authorName, isbn, publicationYear, price);
    }
}