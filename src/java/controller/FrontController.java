package controller;

import dispatchers.AddToCartDispatcher;
import dispatchers.CheckoutDispatcher;
import dispatchers.ContinueDispatcher;
import dispatchers.Dispatcher;
import dispatchers.TitlesDispatcher;
import dispatchers.UpdateCartDispatcher;
import dispatchers.ViewCartDispatcher;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
// import dispatchers.*;
import model.Book;
import model.CartItem;
import utility.AdmitBookStoreDAO;

/**
 * The FrontController will receive all request action from user in jsp. 
 * Then dispatch to respective dispatchers. 
 * @author nguye
 */
public class FrontController extends HttpServlet {

    private final HashMap<String, Dispatcher> actions = new HashMap<String, Dispatcher>();
    private AdmitBookStoreDAO dao; 

    //Initialize global variables

    /**
     * init method() -  add all dispatchers to the actions HashMap
     * @param config ServletConfig
     * @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        String url = this.getInitParameter("url"); 
//        String driver = this.getInitParameter("driver"); 
//        String user = this.getInitParameter("user"); 
//        String password = this.getInitParameter("password"); 
        dao = new AdmitBookStoreDAO();
        actions.put("titles", new TitlesDispatcher(dao));
        actions.put("add_to_cart", new AddToCartDispatcher());
        actions.put("checkout", new CheckoutDispatcher());
        actions.put("continue", new ContinueDispatcher());
        actions.put("update_cart", new UpdateCartDispatcher());
        actions.put("view_cart", new ViewCartDispatcher());
        actions.put("home", new TitlesDispatcher(dao));         
    }

    //Process the HTTP Get request

    /**
     * doGet method of FrontController Servlet
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("doGet()");
        doPost(request, response);
    }

    //Process the HTTP Post request

    /**
     * doPost method of FrontController Servlet. The method will call different dispatchers
     * depend on what action called from user. 
     * @param request HttpServletRequest
     * @param response HttpServletRequest
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String requestedAction = request.getParameter("action");
        String nextPage = "";
        Dispatcher dispatcher = null;
        if (requestedAction == null) {
            dispatcher = new TitlesDispatcher(dao);
        } else {
            dispatcher = actions.get(requestedAction);
        }
        nextPage = dispatcher.execute(request);
        this.dispatch(request, response, nextPage);
    }
    
    /**
     * dispatch method of FrontController Servlet. It uses requestDispatcher to 
     * redirect to different pages. 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param page the jsp page that FrontController will redirect to. 
     * @throws ServletException
     * @throws IOException
     */

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException,
            IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    //Get Servlet information

    /**
     * get Servlet information defined by the author  
     * @return FrontController Information
     */
    public String getServletInfo() {
        return "controller.FrontController Information";
    }
}
