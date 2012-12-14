
package jpa.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.entidades.Licencia;


@Stateless
public class LicenciaFacade implements LicenciaFacadeLocal {

    @PersistenceContext(unitName="oda-ejbPU")
    EntityManager em ;

    Logger logger = Logger.getLogger(LicenciaFacade.class.getName()) ;

    @Override
    public void crear(Licencia licencia) {
        em.persist(licencia);
    }

    @Override
    public void actualizar(Licencia licencia) {
        em.merge(licencia) ;
    }

    @Override
    public void borrar(Licencia licencia) {
        em.remove(em.merge(licencia));
    }

    @Override
    public List<Licencia> buscarTodos() {
        Query q = em.createNamedQuery("Licencia.findAll") ;
        return q.getResultList() ;
    }

    @Override
    public Licencia buscarPorId(Long id) {
        /*Query q = em.createNamedQuery("Licencia.findById") ;
        q.setParameter(":id", id) ;
        return q.getResultList();*/
        return em.find(Licencia.class, id) ;
    }

    @Override
    public Licencia buscarLicenciaPorValor(String cadena) {
        Query q = em.createNamedQuery("Licencia.findByValor").setParameter(":valor",cadena);
        Licencia resultado = (Licencia)q.getSingleResult() ;
        
        return resultado ;
        
    }
    
    @Override
    public List<Licencia> buscarPorValor(String cadena) {
        /*Query q = em.createNamedQuery("Licencia.findByValor");
        return q.getResultList() ;*/
        
        String sql = "SELECT l FROM Licencia l WHERE l.valor LIKE '%" + cadena + "%' ORDER BY l.valor" ;
        Query q = em.createQuery(sql) ;
        return q.getResultList() ;
    }

    
}
