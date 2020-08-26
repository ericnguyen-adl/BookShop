package model;

import java.text.DecimalFormat;
import java.io.*;

/**
 * Book class
 *
 * @author nguye
 */
public class Book implements Serializable {

    String isbn = "";
    String title = "";
    String author = "";
    double price = 0.00;

    /**
     * getter for isbn
     *
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * getter for title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter for author
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * getter for price
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    public String toString() {
        return ("Title: " + title + "  ");
    }

    /**
     * method to format the price
     *
     * @return
     */
    public String getDollarPrice() {
        DecimalFormat price = new DecimalFormat("0.00");
        return ("$" + price.format(this.price));
    }

    /**
     * all-args Constructor for Book
     *
     * @param isbn
     * @param title
     * @param author
     * @param price
     */
    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }
}
