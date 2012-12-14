/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.facade;

import java.util.List;
import javax.ejb.Local;
import jpa.entidades.Funcionalidad;

/**
 *
 * @author victor
 */
@Local
public interface FuncionalidadFacadeLocal {
    
    void crear(Funcionalidad funcionalidad);

    void actualizar(Funcionalidad funcionalidad);

    void borrar(Funcionalidad funcionalidad);

    List<Funcionalidad> buscarTodos();

    List<Funcionalidad> buscarPorId(Long id);
}
