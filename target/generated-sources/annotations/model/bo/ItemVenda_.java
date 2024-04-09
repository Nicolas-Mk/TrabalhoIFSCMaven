package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Produto;
import model.bo.Venda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-08T20:54:44")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, Float> qtdProduto;
    public static volatile SingularAttribute<ItemVenda, Venda> venda;
    public static volatile SingularAttribute<ItemVenda, Produto> produto;
    public static volatile SingularAttribute<ItemVenda, Integer> id;
    public static volatile SingularAttribute<ItemVenda, Float> valorUnitario;
    public static volatile SingularAttribute<ItemVenda, String> status;

}