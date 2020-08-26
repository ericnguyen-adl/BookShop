/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utility.AdmitBookStoreDAO;

/**
 * This is homepage to display current book list and user's current shopping cart 
 * @author nguye
 */
public class TitlesDispatcher implements Dispatcher {

    private AdmitBookStoreDAO dao; 

    /**
     * Passing the AdmitBookStoreDao object in the constructor
     * @param dao
     */
    public TitlesDispatcher(AdmitBookStoreDAO dao) {
        this.dao = dao; 
    }

    /**
     * Override execute() method to set attribute for books and return titles.jsp
     * @param request
     * @return titles.jsp page or an error
     */
    @Override
    public String execute(HttpServletRequest request) {
        // AdmitBookStoreDAO dao = new AdmitBookStoreDAO();
        List books = null;
        String nextPage = "/jsp/error.jsp";     
        HttpSession session = request.getSession ();        
        try{
            System.out.println("inside try block of ShowHomeAO.exe()");
            books = dao.getAllBooks();
            if(books != null) {
                session.setAttribute ("books", books);
                nextPage = "/jsp/titles.jsp";
            } 
        }catch(Exception ex) {
            request.setAttribute ("result",ex.getMessage ());
            nextPage= "/jsp/error.jsp";
        } // end catch
        return nextPage; 
        }
    }
