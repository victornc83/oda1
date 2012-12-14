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
import jpa.entidades.Roles;

/**
 *
 * @author victor
 */
@Stateless
public class RolesFacade implements RolesFacadeLocal {

    @PersistenceContext(unitName="oda-ejbPU")
    EntityManager em ;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void crear(Roles rol) {
        em.persist(rol);
    }

    @Override
    public void actualizar(Roles rol) {
        em.merge(rol) ;
    }

    @Override
    public void borrar(Roles rol) {
        em.remove(em.merge(rol));
    }

    @Override
    public List<Roles> buscarTodos() {
        Query q = em.createNamedQuery("Roles.findAll") ;
        
        return q.getResultList() ;
    }

    @Override
    public Roles buscarPorId(Long id) {
        /*Query q = em.createNamedQuery("Usuario.findById") ;
        q.setParameter(":id", id) ;
        q.setParameter(1,"paco") ;
        
        return q.getResultList() ;*/
        return em.find(Roles.class, id) ;
    }

    @Override
    public List<Roles> buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM Roles WHERE des LIKE %nombre%" ;
        Query q = em.createNativeQuery(sql) ;
        return q.getResultList() ;
    }
    
    @Override
    public Roles buscarRolPorNombre(String nombre) {
        Query q = em.createNamedQuery("Roles.findByDes") ;
        
        return (Roles)q.getSingleResult() ;
    }
    
}
