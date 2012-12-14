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
@Table(name = "vcategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT v FROM Categoria v"),
    @NamedQuery(name = "Categoria.findById", query = "SELECT v FROM Categoria v WHERE v.id = :id"),
    @NamedQuery(name = "Categoria.findByDes", query = "SELECT v FROM Categoria v WHERE v.des = :des"),
    @NamedQuery(name = "Categoria.findByPadre", query = "SELECT v FROM Categoria v WHERE v.padre = :padre"),
    @NamedQuery(name = "Categoria.findByUsuopera", query = "SELECT v FROM Categoria v WHERE v.usuopera = :usuopera")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Size(max = 50)
    @Column(name = "des")
    @NotNull
    private String des;
    @ManyToOne
    @JoinColumn(name = "padre")
    private Categoria padre;
    @Size(max = 12)
    @Column(name = "usuopera")
    private String usuopera;
    @OneToMany(mappedBy="padre")
    Collection<Categoria> subcategorias ;

    public Categoria() {
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

    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }

    public String getUsuopera() {
        return usuopera;
    }

    public void setUsuopera(String usuopera) {
        this.usuopera = usuopera;
    }

    public Collection<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(Collection<Categoria> subcategorias) {
        this.subcategorias = subcategorias;
    }
    
    public void addSubcategoria(Categoria categoria){
        getSubcategorias().add(categoria);
        categoria.setPadre(this);
    }
    
    public void removeSubcategoria(Categoria categoria){
        getSubcategorias().remove(categoria) ;
        categoria.setPadre(null);
    }
    
    
}
