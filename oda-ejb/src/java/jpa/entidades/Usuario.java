/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entidades;

import java.io.Serializable;
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
@Table(name = "vusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT v FROM Usuario v"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT v FROM Usuario v WHERE v.id = :id"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT v FROM Usuario v WHERE v.login = :login"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT v FROM Usuario v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido1", query = "SELECT v FROM Usuario v WHERE v.apellido1 = :apellido1"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT v FROM Usuario v WHERE v.password = :password"),
    @NamedQuery(name = "Usuario.findByFUltacceso", query = "SELECT v FROM Usuario v WHERE v.fUltacceso = :fUltacceso"),
    //@NamedQuery(name = "Usuario.findByIdRol", query = "SELECT v FROM Usuario v WHERE v.idRol = :idRol"),
    //@NamedQuery(name = "Usuario.findByIdLicencia", query = "SELECT v FROM Usuario v WHERE v.idLicencia = :idLicencia"),
    @NamedQuery(name = "Usuario.findByUsuopera", query = "SELECT v FROM Usuario v WHERE v.usuopera = :usuopera")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Size(max = 12)
    @Column(name = "login")
    @NotNull
    private String login;
    @Size(max = 20)
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @NotNull
    @Column(name= "apellido1")
    private String apellido1 ;
    @Size(max = 20)
    @Column(name = "apellido2")
    private String apellido2 ;
    @Size(max = 2147483647)
    @NotNull
    @Column(name = "password")
    private String password;
    @Column(name = "f_ultacceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fUltacceso;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Roles rol ;
    @ManyToOne
    @JoinColumn(name = "id_licencia")
    private Licencia licencia;
    @Size(max = 12)
    @Column(name = "usuopera")
    private String usuopera;

    public Usuario() {
    }
    
    public Usuario(String login, String nombre, String ap1, String ap2, String psswd) {
        this.login = login ;
        this.nombre = nombre ;
        this.apellido1 = ap1 ;
        this.apellido2 = ap2 ;
        this.password = psswd ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getfUltacceso() {
        return fUltacceso;
    }

    public void setfUltacceso(Date fUltacceso) {
        this.fUltacceso = fUltacceso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public String getUsuopera() {
        return usuopera;
    }

    public void setUsuopera(String usuopera) {
        this.usuopera = usuopera;
    }
    
}
