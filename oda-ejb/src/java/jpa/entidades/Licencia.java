/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "vlicencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licencia.findAll", query = "SELECT v FROM Licencia v"),
    @NamedQuery(name = "Licencia.findById", query = "SELECT v FROM Licencia v WHERE v.id = :id"),
    @NamedQuery(name = "Licencia.findByFechaIni", query = "SELECT v FROM Licencia v WHERE v.fechaIni = :fechaIni"),
    @NamedQuery(name = "Licencia.findByFechaFin", query = "SELECT v FROM Licencia v WHERE v.fechaFin = :fechaFin"),
    @NamedQuery(name = "Licencia.findByValor", query = "SELECT v FROM Licencia v WHERE v.valor = :valor"),
    @NamedQuery(name = "Licencia.findByUsuopera", query = "SELECT v FROM Licencia v WHERE v.usuopera = :usuopera")})
public class Licencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "fecha_ini")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 2147483647)
    @NotNull 
    @Column(name = "valor")
    private String valor;
    @Size(max = 12)
    @Column(name = "usuopera")
    private String usuopera;
    @OneToMany(mappedBy="licencia")
    private Collection<Usuario> usuarios ;

    public Licencia() {
        this.usuarios = new ArrayList<Usuario>() ;
    }
    
    public Licencia(Date fini, Date ffin, String valor, String usuopera){
        this.fechaIni = fini ;
        this.fechaFin = ffin ;
        this.valor = valor ;
        this.usuopera = usuopera ;
        this.usuarios = new ArrayList<Usuario>() ;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUsuopera() {
        return usuopera;
    }

    public void setUsuopera(String usuopera) {
        this.usuopera = usuopera;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void addUsuario (Usuario usuario){
        getUsuarios().add(usuario);
        usuario.setLicencia(this);
    }
    
    public void removeUsuario(Usuario usuario){
        getUsuarios().remove(usuario);
        usuario.setLicencia(null);
    }
    
}
