package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Compra;
import model.bo.Produto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-08T18:47:47")
@StaticMetamodel(ItemCompra.class)
public class ItemCompra_ { 

    public static volatile SingularAttribute<ItemCompra, Float> qtdProduto;
    public static volatile SingularAttribute<ItemCompra, Compra> compra;
    public static volatile SingularAttribute<ItemCompra, Produto> produto;
    public static volatile SingularAttribute<ItemCompra, Integer> id;
    public static volatile SingularAttribute<ItemCompra, Float> valorUnitario;
    public static volatile SingularAttribute<ItemCompra, Character> status;

}