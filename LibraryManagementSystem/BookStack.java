public class BookStack {

    private int bookID;
    private String subject;
    private String title;
    private String author;
    private String publisher;
    private String edition;
    private double price;
    private int quantity;

    public BookStack(int bookID, String subject, String title, String author, String publisher,
            String edition, double price, int quantity) {

        this.bookID = bookID;
        this.subject = subject;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.price = price;
        this.quantity = quantity;
    }

    public int getBookID() {
        return bookID;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getEdition() {
        return edition;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String printDetails() {
        return "Book ID: " + bookID + "Subject: " + subject + "Title: " + title + "Author: "
                + author + "Publisher: " + publisher + "Edition: " + edition + "Price: " + price
                + "Quantity: " + quantity;
    }
}