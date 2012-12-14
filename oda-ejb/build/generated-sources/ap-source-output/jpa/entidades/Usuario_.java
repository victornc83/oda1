package jpa.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entidades.Licencia;
import jpa.entidades.Roles;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-10-14T04:45:32")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Long> id;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> apellido2;
    public static volatile SingularAttribute<Usuario, Licencia> licencia;
    public static volatile SingularAttribute<Usuario, String> apellido1;
    public static volatile SingularAttribute<Usuario, Date> fUltacceso;
    public static volatile SingularAttribute<Usuario, String> login;
    public static volatile SingularAttribute<Usuario, Roles> rol;
    public static volatile SingularAttribute<Usuario, String> usuopera;
    public static volatile SingularAttribute<Usuario, String> password;

}