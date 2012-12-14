package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Categoria;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-10-14T04:45:32")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Long> id;
    public static volatile SingularAttribute<Categoria, String> des;
    public static volatile CollectionAttribute<Categoria, Categoria> subcategorias;
    public static volatile SingularAttribute<Categoria, Categoria> padre;
    public static volatile SingularAttribute<Categoria, String> usuopera;

}