package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Valor;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-10-14T04:45:32")
@StaticMetamodel(Campo.class)
public class Campo_ { 

    public static volatile SingularAttribute<Campo, Long> id;
    public static volatile SingularAttribute<Campo, String> des;
    public static volatile SingularAttribute<Campo, Character> tipo;
    public static volatile SingularAttribute<Campo, Boolean> multi;
    public static volatile CollectionAttribute<Campo, Valor> valores;
    public static volatile SingularAttribute<Campo, Boolean> lista;
    public static volatile SingularAttribute<Campo, String> usuopera;

}