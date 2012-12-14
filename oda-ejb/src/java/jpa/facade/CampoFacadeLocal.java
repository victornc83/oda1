/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.facade;

import java.util.List;
import javax.ejb.Local;
import jpa.entidades.Campo;

/**
 *
 * @author victor
 */
@Local
public interface CampoFacadeLocal {

    void crear(Campo campo);

    void actualizar(Campo campo);

    void borrar(Campo campo);

    List<Campo> buscarTodos();

    Campo buscarPorId(Long id);
    
    
    
}
