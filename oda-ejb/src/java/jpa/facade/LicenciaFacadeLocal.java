/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.facade;

import java.util.List;
import javax.ejb.Local;
import jpa.entidades.Licencia;

/**
 *
 * @author victor
 */
@Local
public interface LicenciaFacadeLocal {

    void crear(Licencia licencia);

    void actualizar(Licencia licencia);

    void borrar(Licencia licencia);

    List<Licencia> buscarTodos();

    Licencia buscarPorId(Long id);
    
    Licencia buscarLicenciaPorValor(String cadena) ;
    
    List<Licencia> buscarPorValor(String cadena) ;
    
}
