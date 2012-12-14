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
import jpa.entidades.Estadistico;

/**
 *
 * @author victor
 */
@Stateless
public class EstadisticoFacade implements EstadisticoFacadeLocal {

    @PersistenceContext(unitName="oda-ejbPU")
    EntityManager em ;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void crear(Estadistico estadistico) {
        em.persist(estadistico);
    }

    @Override
    public void actualizar(Estadistico estadistico) {
        em.merge(em.merge(estadistico)) ;
    }

    @Override
    public void borrar(Estadistico estadistico) {
        em.remove(estadistico);
    }

    @Override
    public List<Estadistico> buscarTodos() {
        Query q = em.createNamedQuery("Estadistico.findAll") ;
        
        return q.getResultList() ;
    }

    @Override
    public List<Estadistico> buscarPorId(Long id) {
        Query q = em.createNamedQuery("Estadistico.findById") ;
        q.setParameter(":id", id) ;
        
        return q.getResultList() ;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
