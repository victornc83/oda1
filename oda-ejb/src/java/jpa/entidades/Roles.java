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
@Table(name = "vroles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT v FROM Roles v"),
    @NamedQuery(name = "Roles.findById", query = "SELECT v FROM Roles v WHERE v.id = :id"),
    @NamedQuery(name = "Roles.findByDes", query = "SELECT v FROM Roles v WHERE v.des = :des"),
    @NamedQuery(name = "Roles.findByUsuopera", query = "SELECT v FROM Roles v WHERE v.usuopera = :usuopera")})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Size(max = 25)
    @Column(name = "des")
    @NotNull
    private String des;
    @Size(max = 12)
    @Column(name = "usuopera")
    private String usuopera;
    @OneToMany(mappedBy="rol")
    private Collection<Usuario> usuarios ;
    @ManyToMany
    @JoinTable(name="permisos",
            joinColumns=@JoinColumn(name="id_rol"),
            inverseJoinColumns=@JoinColumn(name="id_funcion"))
    private Collection<Funcionalidad> funcionalidades ;

    public Roles() {
        this.usuarios = new ArrayList<Usuario>() ;
        this.funcionalidades = new ArrayList<Funcionalidad>() ;
    }
    
    public Roles(String des, String usuario){
        this.des = des ;
        this.usuopera = usuario ;
        this.usuarios = new ArrayList<Usuario>() ;
        this.funcionalidades = new ArrayList<Funcionalidad>() ;
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

    public Collection<Funcionalidad> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(Collection<Funcionalidad> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }
    
    public void addFuncionalidad(Funcionalidad funcion){
        getFuncionalidades().add(funcion);
    }
    
    public void removeFuncionalidad(Funcionalidad funcion){
        getFuncionalidades().remove(funcion);
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void addUsuario (Usuario usuario){
        usuarios.add(usuario);
        usuario.setRol(this);
    }
    
    public void removeUsuario(Usuario usuario){
        getUsuarios().remove(usuario);
        usuario.setRol(null);
    }
    
}
