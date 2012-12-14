/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.facade;

import java.util.List;
import javax.ejb.Local;
import jpa.entidades.Roles;

/**
 *
 * @author victor
 */
@Local
public interface RolesFacadeLocal {
    
    void crear(Roles rol);

    void actualizar(Roles rol);

    void borrar(Roles rol);

    List<Roles> buscarTodos();

    Roles buscarPorId(Long id);
    
    List<Roles> buscarPorNombre(String nombre) ;
    
    Roles buscarRolPorNombre(String nombre);
    
    
}
