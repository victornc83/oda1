/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.facade;

import java.util.List;
import javax.ejb.Local;
import jpa.entidades.Usuario;

/**
 *
 * @author victor
 */
@Local
public interface UsuarioFacadeLocal {
    
    void crear(Usuario usuario);

    void actualizar(Usuario usuario);

    void borrar(Usuario usuario);

    List<Usuario> buscarTodos();
    
    List<Usuario> buscarPorLogin(String login);
    
    Usuario buscarUsuarioPorLogin(String login) ;
    
    Usuario buscarPorApellidos(String apellido1, String apellido2) ;

    Usuario buscarPorId(Long id);
    
}
