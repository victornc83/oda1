/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
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
@Table(name = "vfuncionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionalidad.findAll", query = "SELECT v FROM Funcionalidad v"),
    @NamedQuery(name = "Funcionalidad.findById", query = "SELECT v FROM Funcionalidad v WHERE v.id = :id"),
    @NamedQuery(name = "Funcionalidad.findByDes", query = "SELECT v FROM Funcionalidad v WHERE v.des = :des"),
    @NamedQuery(name = "Funcionalidad.findByUsuopera", query = "SELECT v FROM Funcionalidad v WHERE v.usuopera = :usuopera")})
public class Funcionalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Size(max = 50)
    @NotNull
    @Column(name = "des")
    private String des;
    @Size(max = 12)
    @Column(name = "usuopera")
    private String usuopera;
    @ManyToMany
    @JoinTable(name="permisos",
            joinColumns=@JoinColumn(name="id_funcion"),
            inverseJoinColumns=@JoinColumn(name="id_rol"))
    private Collection<Roles> roles ;

    public Funcionalidad() {
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

    public String getUsuopera() {
        return usuopera;
    }

    public void setUsuopera(String usuopera) {
        this.usuopera = usuopera;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    
}
