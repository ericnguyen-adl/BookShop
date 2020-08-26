/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import javax.servlet.http.HttpServletRequest;

/**
 * This dispatcher to dispatch to titles.jsp when user want to continue shopping
 * @author nguye
 */
public class ContinueDispatcher implements Dispatcher {

    /**
     * Override the execute() method by return titles.jsp page
     * @param request HttpServletRequest
     * @return titles.jsp page
     */
    @Override
    public String execute(HttpServletRequest request) {
        return "/jsp/titles.jsp";
    }
    
}
