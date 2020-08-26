package model;

import java.text.DecimalFormat;
import java.io.*;

/**
 * CartItem class will contain of a book, cart item's cost and it's quantity in the cart 
 * @author nguye
 */
public class CartItem implements Serializable{
  private Book book;
  private int quantity=0;
  private double costOfItem =0.00;

    /**
     * 1-arg Constructor for CartItem
     * @param book Book
     */
    public CartItem(Book book){
    this.book = book;
  }

    /**
     * Set quantity for a cartItem
     * @param aQuantity
     */
    public void setQuantity(int aQuantity) {
    quantity+=aQuantity;
    calculateOrderCost();
  }

    /**
     * Update quantity for a cartItem
     * @param newQuantity int
     */
    public void updateQuantity(int newQuantity) {
    quantity = newQuantity;
    calculateOrderCost();
  }

   private void calculateOrderCost() {
    costOfItem = (quantity * book.getPrice ());
  }

    /**
     * Format the item's cost (include quantity)
     * @return costOfItem in currency format
     */
    public String getDollarOrderCost() {
    DecimalFormat cost = new DecimalFormat("0.00");
    return ("$" + cost.format (this.costOfItem));
  }

  public String toString() {
    return  (book + "          " + "quantity: " + quantity);
  }

    /**
     * get a book
     * @return book
     */
    public Book getBook() {
    return book;
  }

    /**
     * get the cost of cartItem
     * @return costOfItem
     */
    public double getOrderCost() {
    return costOfItem;
  }

    /**
     * get the quantity of cartItem
     * @return quantity
     */
    public int getQuantity() {
    return quantity;
  }

} 