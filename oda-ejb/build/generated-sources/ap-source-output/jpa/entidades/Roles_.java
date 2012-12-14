package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Funcionalidad;
import jpa.entidades.Usuario;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-10-14T04:45:32")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, Long> id;
    public static volatile SingularAttribute<Roles, String> des;
    public static volatile SingularAttribute<Roles, String> usuopera;
    public static volatile CollectionAttribute<Roles, Funcionalidad> funcionalidades;
    public static volatile CollectionAttribute<Roles, Usuario> usuarios;

}