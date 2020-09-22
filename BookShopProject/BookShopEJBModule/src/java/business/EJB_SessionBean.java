/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Tbooks;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author nguye
 */
@Stateless
public class EJB_SessionBean implements EJB_SessionBeanRemote {
    @PersistenceContext(unitName = "BookShopEJBModulePU")
    private EntityManager em;
    public void persist(Object object) {
        em.persist(object);
    }
    @Override
    public List<Tbooks> getAllBooks() {
            Query query = em.createQuery("SELECT t FROM Tbooks t"); 
            List<Tbooks> bookList = new ArrayList<Tbooks>();  
            bookList = query.getResultList(); 
            return bookList; 
    }       
}
