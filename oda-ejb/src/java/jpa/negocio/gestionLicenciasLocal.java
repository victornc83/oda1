/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.negocio;

import java.util.Date;
import javax.ejb.Local;
import jpa.entidades.Licencia;

/**
 *
 * @author victor
 */
@Local
public interface gestionLicenciasLocal {
    
    boolean consultarLicencia(Licencia licencia) ;
    boolean insertarLicencia (Date fini, Date ffin, String valor, String usuario) ;
    boolean modificarLicencia (Long idLicencia, Licencia datosLicencia) ;
    boolean eliminarLicencia (Long idLicencia) ;
    boolean asignarLicencia (Long idLicencia, Long idUsuario) ;
    
}
