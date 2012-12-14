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
import jpa.entidades.Categoria;

/**
 *
 * @author victor
 */
@Stateless
public class CategoriaFacade implements CategoriaFacadeLocal {

    @PersistenceContext(unitName="oda-ejbPU")
    EntityManager em ;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void crear(Categoria categoria) {
        em.persist(categoria);
    }

    @Override
    public void actualizar(Categoria categoria) {
        em.merge(categoria) ;
    }

    @Override
    public void borrar(Categoria categoria) {
        em.remove(em.merge(categoria));
    }

    @Override
    public List<Categoria> buscarTodos() {
        Query q = em.createNamedQuery("Categoria.findAll") ;
        return q.getResultList();
    }

    @Override
    public List<Categoria> buscarPorId(Long id) {
        Query q = em.createNamedQuery("Categoria.findById");
        q.setParameter(":id", id) ;
        return q.getResultList() ;
    }
    
}
