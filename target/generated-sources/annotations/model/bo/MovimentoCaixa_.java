package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Caixa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-08T20:54:44")
@StaticMetamodel(MovimentoCaixa.class)
public class MovimentoCaixa_ { 

    public static volatile SingularAttribute<MovimentoCaixa, Character> flagTipoMovimento;
    public static volatile SingularAttribute<MovimentoCaixa, String> observacao;
    public static volatile SingularAttribute<MovimentoCaixa, Caixa> caixa;
    public static volatile SingularAttribute<MovimentoCaixa, String> dataHoraMovimento;
    public static volatile SingularAttribute<MovimentoCaixa, Integer> id;
    public static volatile SingularAttribute<MovimentoCaixa, Float> valorMovimento;
    public static volatile SingularAttribute<MovimentoCaixa, Character> status;

}