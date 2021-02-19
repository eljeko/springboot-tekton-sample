package hello;

public class Book {

    private final int id;
    private final String title;
    private final String description;
    private final String author;
    private final double price;

    public Book(int id, String title, String description, String author, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
