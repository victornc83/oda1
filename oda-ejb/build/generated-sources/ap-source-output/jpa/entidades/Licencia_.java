package jpa.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Usuario;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-10-14T04:45:32")
@StaticMetamodel(Licencia.class)
public class Licencia_ { 

    public static volatile SingularAttribute<Licencia, Long> id;
    public static volatile SingularAttribute<Licencia, String> valor;
    public static volatile SingularAttribute<Licencia, Date> fechaIni;
    public static volatile SingularAttribute<Licencia, Date> fechaFin;
    public static volatile SingularAttribute<Licencia, String> usuopera;
    public static volatile CollectionAttribute<Licencia, Usuario> usuarios;

}