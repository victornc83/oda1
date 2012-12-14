/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.test;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entidades.Campo;
import jpa.entidades.Valor;
import jpa.facade.CampoFacadeLocal;

/**
 *
 * @author victor
 */
public class CampoTest {
    
    
    /*public static void main(String[] args) throws Exception {
        
        Campo campo = new Campo() ;
        Valor valor1 = new Valor() ;
        List<Valor> valores = new ArrayList() ;
        
        // Defino Campo
        campo.setDes("Campo Prueba") ;
        campo.setTipo('C');
        campo.setMulti(false);
        campo.setLista(false);
        campo.setUsuopera("Admin");
        
        //Creo valores 
        valor1.setValor("Prueba1");
        valor1.setUsuopera("Admin");
        valor1.setEstadisticos(null);
        valor1.setCampo(campo);
        valores.add(valor1);
        
        Valor valor2 = new Valor() ;
        valor2.setValor("Prueba2");
        valor2.setUsuopera("Admin");
        valor2.setEstadisticos(null);
        valor2.setCampo(campo);
        valores.add(valor2);
        
        campo.setValores(valores);
        
        em.persist(campo); 
        
    }*/
    
}
