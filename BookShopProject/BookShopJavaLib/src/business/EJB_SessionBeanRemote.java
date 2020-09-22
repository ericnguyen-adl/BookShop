/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Tbooks;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author nguye
 */
@Remote
public interface EJB_SessionBeanRemote {
    List<Tbooks> getAllBooks();    
}
