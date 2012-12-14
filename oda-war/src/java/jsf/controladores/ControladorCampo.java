/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import jpa.entidades.Campo;
import jpa.entidades.Valor;
import jpa.facade.CampoFacadeLocal;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author victor
 */
@Named(value = "controladorCampo")
@SessionScoped
public class ControladorCampo implements Serializable {

    @EJB
    private CampoFacadeLocal campobd ;
    
    private String descripcion ;
    private char tipo ;
    private boolean multi ;
    private boolean lista ;
    private List<Valor> listaValores ;
    private List<Campo> campos ;
    private Campo seleccionado ;
    private Boolean tengoElegido ;
    private Valor valor ;
    /**
     * Creates a new instance of ControladorCampo
     */
    public ControladorCampo() {
        // Inicializo listas  y referencias
        listaValores = new ArrayList<Valor>() ;
        campos = new ArrayList<Campo>() ;
        
        valor = new Valor();
        seleccionado = new Campo();
        tengoElegido = false ;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isLista() {
        return lista;
    }

    public void setLista(boolean lista) {
        this.lista = lista;
    }

    public List<Valor> getListaValores() {
        return listaValores;
    }

    public void setListaValores(List<Valor> listaValores) {
        this.listaValores = listaValores;
    }

    public boolean isMulti() {
        return multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    public Campo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Campo seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Boolean getTengoElegido() {
        return tengoElegido;
    }

    public void setTengoElegido(Boolean tengoElegido) {
        this.tengoElegido = tengoElegido;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }
    
    public String doAlta() {
        Campo campo = new Campo() ;
        campo.setDes(this.descripcion);
        campo.setLista(this.lista);
        campo.setMulti(this.multi);
        campo.setTipo(this.tipo);
        
        if(this.listaValores != null) {
            for (Valor item: this.listaValores){
                campo.addValor(item);
            }
        }
        
        campobd.crear(campo);

        return "alta" ;
    }
    
    public void doBaja(){
        campobd.borrar(seleccionado);
        this.seleccionado = null ;
        this.setTengoElegido(false);
    }
    
    public void listarTodos(){
        this.setCampos(campobd.buscarTodos());
    }
    
    // Funcion que pone a true la variable tengoElegido cuando se selecciona un valor en la tabla - Posibilita la aparición de objetos deshabilitados
    public void seleccionListener (SelectEvent evento){
        Campo eventoCampo = (Campo)evento.getObject() ;
        this.setTengoElegido(true) ;
    }
    
    // Funcion necesaria para resetear el valor del cuadro de dialogo tras añadir valor a la lista
    public String reiniciarValor(){
        this.valor = new Valor() ;
        
        return null ;
    }
}
