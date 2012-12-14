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
import jpa.entidades.Valor;

/**
 *
 * @author victor
 */
@Stateless
public class ValorFacade implements ValorFacadeLocal {

    @PersistenceContext(unitName="oda-ejbPU")
    EntityManager em ;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void crear(Valor valor) {
        em.persist(valor);
    }

    @Override
    public void actualizar(Valor valor) {
        em.merge(valor);
    }

    @Override
    public void borrar(Valor valor) {
        em.remove(em.merge(valor));
    }

    @Override
    public List<Valor> buscarTodos() {
        Query q = em.createNamedQuery("Valor.findAll") ;
        return q.getResultList();
    }

    @Override
    public List<Valor> buscarPorId(Long id) {
        Query q = em.createNamedQuery("Valor.findById") ;
        q.setParameter(":id", id) ;
        return q.getResultList() ;
    }
    
    
}
