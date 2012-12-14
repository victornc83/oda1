/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.facade;

import java.util.List;
import javax.ejb.Local;
import jpa.entidades.Categoria;

/**
 *
 * @author victor
 */
@Local
public interface CategoriaFacadeLocal {

    void crear(Categoria categoria);

    void actualizar(Categoria categoria);

    void borrar(Categoria categoria);

    List<Categoria> buscarTodos();

    List<Categoria> buscarPorId(Long id);
    
}
