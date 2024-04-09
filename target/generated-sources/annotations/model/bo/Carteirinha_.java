package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Cliente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-08T20:54:44")
@StaticMetamodel(Carteirinha.class)
public class Carteirinha_ { 

    public static volatile SingularAttribute<Carteirinha, Cliente> cliente;
    public static volatile SingularAttribute<Carteirinha, String> codigoBarra;
    public static volatile SingularAttribute<Carteirinha, Integer> id;
    public static volatile SingularAttribute<Carteirinha, String> dataGeracao;
    public static volatile SingularAttribute<Carteirinha, String> dataCancelamento;
    public static volatile SingularAttribute<Carteirinha, String> status;

}