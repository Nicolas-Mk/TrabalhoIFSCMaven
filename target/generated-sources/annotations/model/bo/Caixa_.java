package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Funcionario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-04-08T20:54:44")
@StaticMetamodel(Caixa.class)
public class Caixa_ { 

    public static volatile SingularAttribute<Caixa, Float> valorFechamento;
    public static volatile SingularAttribute<Caixa, String> observacao;
    public static volatile SingularAttribute<Caixa, String> dataHoraAbertura;
    public static volatile SingularAttribute<Caixa, Float> valorAbertura;
    public static volatile SingularAttribute<Caixa, Integer> id;
    public static volatile SingularAttribute<Caixa, String> dataHoraFechamento;
    public static volatile SingularAttribute<Caixa, Funcionario> funcionario;
    public static volatile SingularAttribute<Caixa, Character> status;

}