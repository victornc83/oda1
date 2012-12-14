/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "vcampo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campo.findAll", query = "SELECT v FROM Campo v"),
    @NamedQuery(name = "Campo.findById", query = "SELECT v FROM Campo v WHERE v.id = :id"),
    @NamedQuery(name = "Campo.findByDes", query = "SELECT v FROM Campo v WHERE v.des = :des"),
    @NamedQuery(name = "Campo.findByUsuopera", query = "SELECT v FROM Campo v WHERE v.usuopera = :usuopera")})
public class Campo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="campo_id_seq")
    @SequenceGenerator(name="campo_id_seq", sequenceName="campo_id_seq", allocationSize=1, initialValue=55)
    private Long id;
    @Size(max = 25)
    @Column(name = "des")
    @NotNull
    private String des;
    @Column(name = "tipo")
    @NotNull
    private char tipo ;
    @Column (name = "multi")
    @NotNull
    private boolean multi ;
    @Column (name = "lista")
    @NotNull
    private boolean lista ;
    @Size(max = 12)
    @Column(name = "usuopera")
    private String usuopera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="campo", targetEntity=Valor.class, orphanRemoval=true)
    private Collection<Valor> valores ;
    
    public Campo() {
        this.valores = new ArrayList<Valor>() ;
    }
    
    public Campo(String des, char tipo, boolean multi, boolean lista){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isLista() {
        return lista;
    }

    public void setLista(boolean lista) {
        this.lista = lista;
    }

    public boolean isMulti() {
        return multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    public String getUsuopera() {
        return usuopera;
    }

    public void setUsuopera(String usuopera) {
        this.usuopera = usuopera;
    }
    
    public Collection<Valor> getValores() {
        if (valores == null) {
            this.valores = new ArrayList<Valor>() ;
        }
        return valores;
    }

    public void setValores(Collection<Valor> valores) {
        this.valores = valores;
    }
    
    public void addValor(Valor valor){
        getValores().add(valor);
        valor.setCampo(this);
    }
    
    public void removeValor(Valor valor){
        getValores().remove(valor);
        valor.setCampo(null);
    }
    
    public boolean tipoEsCadena(){
        boolean cadena = false ;
        if (this.tipo == 'C') {
            cadena = true ;
        }
        
        return cadena ;
    }
    
}
