/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.negocio;

import java.util.Date;
import javax.ejb.Local;
import jpa.entidades.Roles;
import jpa.entidades.Usuario ;

/**
 *
 * @author victor
 */
@Local
public interface gestionUsuariosLocal {
    
    boolean insertarRol(String descripcion, String usuario) ;
    boolean modificarRol(Long idRol, Roles rol) ;
    boolean eliminarRol(Long idRol) ;
    boolean asignarRol(Long idRol, Long idUsuario) ;
    boolean insertarUsuario(String login, String nombre, String ap1, String ap2, String psswd) ;
    boolean modifiarUsuario(Long idUsuario, Usuario usuario) ;
    boolean eliminarUsuario(Long idUsuario) ;
    
    
}
