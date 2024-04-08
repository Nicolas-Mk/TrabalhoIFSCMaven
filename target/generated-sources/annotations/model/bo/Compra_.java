package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Fornecedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-08T18:47:47")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, String> observacao;
    public static volatile SingularAttribute<Compra, Float> valorDesconto;
    public static volatile SingularAttribute<Compra, Character> flagTipoDesconto;
    public static volatile SingularAttribute<Compra, String> dataHoraCompra;
    public static volatile SingularAttribute<Compra, Integer> id;
    public static volatile SingularAttribute<Compra, Integer> numeronf;
    public static volatile SingularAttribute<Compra, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Compra, Character> status;

}