/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "vvalor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vvalor.findAll", query = "SELECT v FROM Valor v"),
    @NamedQuery(name = "Vvalor.findById", query = "SELECT v FROM Valor v WHERE v.id = :id"),
    @NamedQuery(name = "Vvalor.findByValor", query = "SELECT v FROM Valor v WHERE v.valor = :valor"),
    //@NamedQuery(name = "Vvalor.findByIdCampo", query = "SELECT v FROM Valor v WHERE v.idCampo = :idCampo"),
    @NamedQuery(name = "Vvalor.findByUsuopera", query = "SELECT v FROM Valor v WHERE v.usuopera = :usuopera")})
public class Valor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="valor_id_seq")
    @SequenceGenerator(name="valor_id_seq", sequenceName="valor_id_seq", allocationSize = 1, initialValue=39 )
    private Long id;
    @Size(max = 50)
    @NotNull
    @Column(name = "valor")
    private String valor;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_campo",referencedColumnName = "id")
    private Campo campo;
    @Size(max = 12)
    @Column(name = "usuopera")
    private String usuopera;
    @ManyToMany
    @JoinTable(name="est_valor",
            joinColumns=@JoinColumn(name="id_valor"),
            inverseJoinColumns=@JoinColumn(name="id_est"))
    private Collection<Estadistico> estadisticos ;

    public Valor() {
        this.estadisticos = new ArrayList<Estadistico>() ;
    }
    
    public Valor(String val, Campo campo, String usu){
        this.valor = val ;
        this.usuopera = usu ;
        this.campo = campo ;
        this.estadisticos = new ArrayList<Estadistico>() ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public String getUsuopera() {
        return usuopera;
    }

    public void setUsuopera(String usuopera) {
        this.usuopera = usuopera;
    }

    public Collection<Estadistico> getEstadisticos() {
        return estadisticos;
    }

    public void setEstadisticos(Collection<Estadistico> estadisticos) {
        this.estadisticos = estadisticos;
    }
    
    public void addEstadistico(Estadistico est){
        getEstadisticos().add(est);
    }
    
    public void removeEstadistico(Estadistico est){
        getEstadisticos().remove(est) ;
    }
    
}
