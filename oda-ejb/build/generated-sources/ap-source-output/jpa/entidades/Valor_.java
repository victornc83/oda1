package jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Campo;
import jpa.entidades.Estadistico;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-10-14T04:45:32")
@StaticMetamodel(Valor.class)
public class Valor_ { 

    public static volatile SingularAttribute<Valor, Long> id;
    public static volatile CollectionAttribute<Valor, Estadistico> estadisticos;
    public static volatile SingularAttribute<Valor, Campo> campo;
    public static volatile SingularAttribute<Valor, String> valor;
    public static volatile SingularAttribute<Valor, String> usuopera;

}