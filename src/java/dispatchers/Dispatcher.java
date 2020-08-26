/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import javax.servlet.http.HttpServletRequest;

/**
 * This is the interface. All other dispatcher need to implement this interface and override execute method. 
 * @author nguye
 */
public interface Dispatcher {

    /**
     * execute method for dispatcher
     * @param request HttpServletRequest
     * @return the jsp page name depend on requested action from user. 
     */
    public String execute(HttpServletRequest request); 
}
