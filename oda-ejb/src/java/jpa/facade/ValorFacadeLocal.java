/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.facade;

import java.util.List;
import javax.ejb.Local;
import jpa.entidades.Valor;

/**
 *
 * @author victor
 */
@Local
public interface ValorFacadeLocal {

    void crear(Valor valor);

    void actualizar(Valor valor);

    void borrar(Valor valor);

    List<Valor> buscarTodos();

    List<Valor> buscarPorId(Long id);
    
}
