/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import DAO.DAOCidade;
import DAO.DAOItemVenda;
import model.bo.Cidade;
import model.bo.ItemVenda;

/**
 *
 * @author aluno
 */
public class ItemVendaService {

    public static void adicionar(ItemVenda objeto) {
        DAOItemVenda itemVendaDAO = new DAOItemVenda();
        itemVendaDAO.create(objeto);

    }
    
  

    public static List<ItemVenda> carregar() {
        DAOItemVenda itemVendaDAO = new DAOItemVenda();
        return itemVendaDAO.retrieve();

    }

    public static ItemVenda carregar(int parPK) {
        DAOItemVenda itemVendaDAO = new DAOItemVenda();
        return itemVendaDAO.retrieve(parPK);

    }

    public static List<ItemVenda> carregar(String parString) {
        DAOItemVenda itemVendaDAO = new DAOItemVenda();
        return itemVendaDAO.retrieve(parString);

    }
    
    public static void atualizar(ItemVenda objeto) {
        DAOItemVenda itemVendaDAO = new DAOItemVenda();
        itemVendaDAO.update(objeto);

    }
     public static void remover (ItemVenda objeto) {
        DAOItemVenda itemVendaDAO = new DAOItemVenda();
        itemVendaDAO.delete(objeto);

    }
     
}