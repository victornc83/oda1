/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.negocio;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jpa.entidades.Licencia;
import jpa.entidades.Usuario;
import jpa.facade.LicenciaFacadeLocal;
import jpa.facade.UsuarioFacadeLocal;

/**
 *
 * @author victor
 */
@Stateless
public class gestionLicencias implements gestionLicenciasLocal {

    @EJB
    private LicenciaFacadeLocal licenciabd ;
    @EJB
    private UsuarioFacadeLocal usuariobd ;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public boolean consultarLicencia(Licencia licencia) {
        return licenciabd.buscarPorId(licencia.getId())!=null ;   
    }
    
    public Licencia consultarLicenciaPorValor(String valor){
        return licenciabd.buscarLicenciaPorValor(valor) ;
    }
    
    @Override
    public boolean insertarLicencia(Date fini, Date ffin, String valor, String usuario) {
        
        Licencia licencia = new Licencia(fini,ffin,valor,usuario) ;
        if(!consultarLicencia(licencia)){
            return false ;
        }else{
            licenciabd.crear(licencia);
            return true ;
        }
    }

    @Override
    public boolean modificarLicencia(Long idLicencia, Licencia datosLicencia) {
        if(licenciabd.buscarPorId(idLicencia)==null){  // No existe licencia
            return false ;
        }else{
            licenciabd.actualizar(datosLicencia);
            return true ;
        }
    }

    @Override
    public boolean eliminarLicencia(Long idLicencia) {
        Licencia licencia = licenciabd.buscarPorId(idLicencia) ;
        
        if(licencia==null){
            return false ;
        }else{
            licenciabd.borrar(licencia);
            return true ;
        }
    }

    @Override
    public boolean asignarLicencia(Long idLicencia, Long idUsuario) {
        
        Licencia licencia = licenciabd.buscarPorId(idLicencia) ;
        Usuario usuario = usuariobd.buscarPorId(idUsuario) ;
        
        if((licencia==null)||(usuario==null)){
            return false ;
        }else{
            usuario.setLicencia(licencia);
            usuariobd.actualizar(usuario);
            return true ;
        }
        
    }
    
}
