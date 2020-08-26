/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
import model.CartItem;

/**
 *
 * @author nguye
 */
public class AddToCartDispatcher implements Dispatcher {

    /**
     * This method in AddToCartDispatcher will add the selected books to books shopping cart.
     * @param request HttpServletRequest
     * @return jsp page name 
     */
    @Override
    public String execute(HttpServletRequest request) {
        String nextPage = "/jsp/titles.jsp";
        HttpSession session = request.getSession ();
   
        Map cart = (Map)session.getAttribute ("cart");
        String[] selectedBooks = request.getParameterValues("add");

        if(cart == null) {
            cart = new HashMap();
            for(int i=0; i<selectedBooks.length; i++ ) {
                String isbn = selectedBooks[i];
                int quantity = Integer.parseInt(request.getParameter(isbn));
                Book book = this.getBookFromList(isbn,session);
                CartItem item = new CartItem(book);
                item.setQuantity (quantity);
                cart.put(isbn,item);
            }  // end for
            session.setAttribute ("cart", cart);
        }   // end if // end if
        else {
            for(int i=0; i<selectedBooks.length; i++ ) {
                String isbn = selectedBooks[i];
                int quantity = Integer.parseInt(request.getParameter(isbn));
                if(cart.containsKey(isbn)) {
                    CartItem item = (CartItem)cart.get(isbn);
                    item.setQuantity (quantity);
                }    // end if
                else{
                    Book book = this.getBookFromList(isbn,session );
                    CartItem item = new CartItem(book);
                    item.setQuantity (quantity);
                    cart.put(isbn,item);
                } // end else
            } // end for
        }//end else
        return nextPage; 
    }
    
    /**
     * This method will get the List of books.
     * @param isbn the book's isbn
     * @param session HttpSesion
     * @return the book for the isbn provided. 
     */
    private Book getBookFromList(String isbn, HttpSession session) {
    List list = (List)session.getAttribute("books");
    Book aBook = null;
    for(int i=0; i<list.size(); i++) {
      aBook = (Book)list.get(i);
      if(isbn.equals(aBook.getIsbn())){
        break;
      } // end if
    } // end for
    return aBook;
  } // end getBookFromList
    
}
