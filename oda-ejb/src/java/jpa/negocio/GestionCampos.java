/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.negocio;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import jpa.facade.CampoFacadeLocal;
import jpa.facade.ValorFacadeLocal;

/**
 *
 * @author victor
 */
@Stateless
public class GestionCampos implements GestionCamposLocal {

    @EJB
    private CampoFacadeLocal campobd ;
    
    @EJB
    private ValorFacadeLocal valorbd ;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
