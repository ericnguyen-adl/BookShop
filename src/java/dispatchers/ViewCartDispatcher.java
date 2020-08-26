/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * View the current shopping cart 
 * @author nguye
 */
public class ViewCartDispatcher implements Dispatcher{

    /**
     * Override execute() method to display current shopping cart
     * @param request
     * @return cart.jsp
     */
    @Override
    public String execute(HttpServletRequest request) {
        String nextPage = "/jsp/cart.jsp";
        HttpSession session = request.getSession ();
        Map cart = (Map)session.getAttribute ("cart");
        if(cart == null) {
            nextPage = "/jsp/titles.jsp";
        }
        return nextPage; 
    }
    
}
