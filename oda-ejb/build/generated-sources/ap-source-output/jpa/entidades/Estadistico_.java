package jpa.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Categoria;
import jpa.entidades.Valor;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-10-14T04:45:32")
@StaticMetamodel(Estadistico.class)
public class Estadistico_ { 

    public static volatile SingularAttribute<Estadistico, Long> id;
    public static volatile SingularAttribute<Estadistico, Categoria> categoria;
    public static volatile SingularAttribute<Estadistico, String> des;
    public static volatile SingularAttribute<Estadistico, Long> valor;
    public static volatile CollectionAttribute<Estadistico, Valor> valores;
    public static volatile SingularAttribute<Estadistico, Date> fechaIni;
    public static volatile SingularAttribute<Estadistico, Date> fechaFin;
    public static volatile SingularAttribute<Estadistico, String> usuopera;

}