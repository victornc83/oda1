/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.facade;

import java.util.List;
import javax.ejb.Local;
import jpa.entidades.Estadistico;

/**
 *
 * @author victor
 */
@Local
public interface EstadisticoFacadeLocal {

    void crear(Estadistico estadistico) ;
    
    void actualizar(Estadistico estadistico) ;
    
    void borrar(Estadistico estadistico) ;
    
    List<Estadistico> buscarTodos() ;
    
    List<Estadistico> buscarPorId(Long id) ;
    
}
