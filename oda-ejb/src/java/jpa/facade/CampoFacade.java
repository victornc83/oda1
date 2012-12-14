/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.entidades.Campo;

/**
 *
 * @author victor
 */
@Stateless
public class CampoFacade implements CampoFacadeLocal {

    @PersistenceContext(unitName="oda-ejbPU")
    EntityManager em ;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void crear(Campo campo) {
        em.persist(campo);
    }

    @Override
    public void actualizar(Campo campo) {
        em.merge(campo) ;
    }

    @Override
    public void borrar(Campo campo) {
        em.remove(em.merge(campo));
    }

    @Override
    public List<Campo> buscarTodos() {
        Query q = em.createNamedQuery("Campo.findAll") ;
        
        return q.getResultList() ;
    }

    @Override
    public Campo buscarPorId(Long id) {
        //Query q = em.createNamedQuery("Campo.findById") ;
       
        //q.setParameter(":id", id) ;
        
        //return q.getResultList() ;
        return em.find(Campo.class, id) ;
    }
    
}
