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
import jpa.entidades.Funcionalidad;

/**
 *
 * @author victor
 */
@Stateless
public class FuncionalidadFacade implements FuncionalidadFacadeLocal {

    @PersistenceContext(unitName="oda-ejbPU")
    EntityManager em ;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void crear(Funcionalidad funcionalidad) {
        em.persist(funcionalidad);
    }

    @Override
    public void actualizar(Funcionalidad funcionalidad) {
        em.merge(funcionalidad) ;
    }

    @Override
    public void borrar(Funcionalidad funcionalidad) {
        em.remove(em.merge(funcionalidad));
    }

    @Override
    public List<Funcionalidad> buscarTodos() {
        Query q = em.createNamedQuery("Funcionalidad.findAll") ;
        
        return q.getResultList() ;
    }

    @Override
    public List<Funcionalidad> buscarPorId(Long id) {
        Query q = em.createNamedQuery("Funcionalidad.findById") ;
        q.setParameter(":id", id) ;
        
        return q.getResultList() ;
    }
    
}
