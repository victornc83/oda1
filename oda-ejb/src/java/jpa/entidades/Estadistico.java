/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "vestadistico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadistico.findAll", query = "SELECT v FROM Estadistico v"),
    @NamedQuery(name = "Estadistico.findById", query = "SELECT v FROM Estadistico v WHERE v.id = :id"),
    @NamedQuery(name = "Estadistico.findByFechaIni", query = "SELECT v FROM Estadistico v WHERE v.fechaIni = :fechaIni"),
    @NamedQuery(name = "Estadistico.findByFechaFin", query = "SELECT v FROM Estadistico v WHERE v.fechaFin = :fechaFin"),
    @NamedQuery(name = "Estadistico.findByDes", query = "SELECT v FROM Estadistico v WHERE v.des = :des"),
    @NamedQuery(name = "Estadistico.findByValor", query = "SELECT v FROM Estadistico v WHERE v.valor = :valor"),
    //@NamedQuery(name = "Estadistico.findByIdCat", query = "SELECT v FROM Estadistico v WHERE v.idCat = :idCat"),
    @NamedQuery(name = "Estadistico.findByUsuopera", query = "SELECT v FROM Estadistico v WHERE v.usuopera = :usuopera")})
public class Estadistico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date fechaFin;
    @Size(max = 35)
    @Column(name = "des")
    @NotNull
    private String des;
    @Column(name = "valor")
    @NotNull
    private Long valor;
    @ManyToOne
    @JoinColumn(name = "id_cat")
    private Categoria categoria;
    @Size(max = 12)
    @Column(name = "usuopera")
    private String usuopera;
    @ManyToMany
    @JoinTable(name="est_valor",
            joinColumns=@JoinColumn(name="id_est"),
            inverseJoinColumns=@JoinColumn(name="id_valor"))
    private Collection<Valor> valores ;

    public Estadistico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getUsuopera() {
        return usuopera;
    }

    public void setUsuopera(String usuopera) {
        this.usuopera = usuopera;
    }

    public Collection<Valor> getValores() {
        return valores;
    }

    public void setValores(Collection<Valor> valores) {
        this.valores = valores;
    }
    
    public void addValor(Valor valor){
        getValores().add(valor);
    }
    
    public void removeValor(Valor valor){
        getValores().remove(valor);
    }
    
}
