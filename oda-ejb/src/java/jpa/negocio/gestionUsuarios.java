/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.negocio;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jpa.entidades.Licencia;
import jpa.entidades.Roles;
import jpa.entidades.Usuario;
import jpa.facade.LicenciaFacadeLocal;
import jpa.facade.RolesFacadeLocal;
import jpa.facade.UsuarioFacadeLocal;

/**
 *
 * @author victor
 */
@Stateless
public class gestionUsuarios implements gestionUsuariosLocal {

    @EJB
    private UsuarioFacadeLocal usuariobd ;
    @EJB
    private RolesFacadeLocal rolesbd ;
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method") 

    @Override
    public boolean insertarRol(String descripcion, String usuario) {
        Roles rol = new Roles(descripcion, usuario) ;
        if ()
    }

    @Override
    public boolean modificarRol(Long idRol, Roles rol) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean eliminarRol(Long idRol) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean asignarRol(Long idRol, Long idUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean insertarUsuario(String login, String nombre, String ap1, String ap2, String psswd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean modifiarUsuario(Long idUsuario, Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean eliminarUsuario(Long idUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
