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
import jpa.entidades.Usuario;

/**
 *
 * @author victor
 */
@Stateless
public class UsuarioFacade implements UsuarioFacadeLocal {

    @PersistenceContext(unitName="oda-ejbPU")
    EntityManager em ;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void crear(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        em.merge(usuario) ;
    }

    @Override
    public void borrar(Usuario usuario) {
        em.remove(em.merge(usuario));
    }

    @Override
    public List<Usuario> buscarTodos() {
        Query q = em.createNamedQuery("Usuario.findAll") ;
        
        return q.getResultList() ;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        //Query q = em.createNamedQuery("Usuario.findById") ;
        //q.setParameter(":id", id) ;
        
        //return q.getResultList() ;
        return em.find(Usuario.class, id) ;
    }

    @Override
    public List<Usuario> buscarPorLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario buscarUsuarioPorLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario buscarPorApellidos(String apellido1, String apellido2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
