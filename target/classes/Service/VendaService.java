/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;


import DAO.DAOVenda;
import java.util.List;

import model.bo.Venda;

/**
 *
 * @author eduar
 */
public class VendaService {

    public static void adicionar(Venda objeto) {
        DAOVenda vendaDAO = new DAOVenda();
        vendaDAO.create(objeto);

    }

    public static List<Venda> carregar() {
        DAOVenda vendaDAO = new DAOVenda();
        return vendaDAO.retrieve();

    }

    public static Venda carregar(int parPK) {
        DAOVenda vendaDAO = new DAOVenda();
        return vendaDAO.retrieve(parPK);

    }

    public static List<Venda> carregar(String parString) {
        DAOVenda vendaDAO = new DAOVenda();
        return  vendaDAO.retrieve(parString);

    }
    
    public static void atualizar(Venda objeto) {
        DAOVenda vendaDAO = new DAOVenda();
        vendaDAO.update(objeto);

    }
     public static void remover (Venda objeto) {
        DAOVenda vendaDAO = new DAOVenda();
        vendaDAO.delete(objeto);

    }
     
     public static  String carregaDeLadinho(String info){
     DAOVenda vendaDAO = new DAOVenda();
     return vendaDAO.retornoNome(info);
     
     }
     
    
}
