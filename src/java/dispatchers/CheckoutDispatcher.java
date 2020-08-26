/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import javax.servlet.http.HttpServletRequest;

/**
 * This dispatcher use to dispatch to checkout.jsp page
 * @author nguye
 */
public class CheckoutDispatcher implements Dispatcher{

    /**
     * Override the execute() method by return checkout.jsp page
     * @param request HttpServletRequest
     * @return checkout.jsp page
     */
    @Override
    public String execute(HttpServletRequest request) {
        return "/jsp/checkout.jsp";
    }
    
}
