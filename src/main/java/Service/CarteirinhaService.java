/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import DAO.DAOCarteirinha;
import model.bo.Carteirinha;

/**
 *
 * @author aluno
 */
public class CarteirinhaService {

    public static void adicionar(Carteirinha objeto) {
        DAOCarteirinha carteirinhaDAO = new DAOCarteirinha();
        carteirinhaDAO.create(objeto);

    }

    public static List<Carteirinha> carregar() {
        DAOCarteirinha carteirinhaDAO = new DAOCarteirinha();
        return carteirinhaDAO.retrieve();

    }

    public static Carteirinha carregar(int parPK) {
        DAOCarteirinha carteirinhaDAO = new DAOCarteirinha();
        return carteirinhaDAO.retrieve(parPK);

    }

    public static List<Carteirinha> carregar(String parString) {
        DAOCarteirinha carteirinhaDAO = new DAOCarteirinha();
        return carteirinhaDAO.retrieve(parString);

    }
    
    public static void atualizar(Carteirinha objeto) {
        DAOCarteirinha carteirinhaDAO = new DAOCarteirinha();
        carteirinhaDAO.update(objeto);

    }
     public static void remover (Carteirinha objeto) {
        DAOCarteirinha carteirinhaDAO = new DAOCarteirinha();
        carteirinhaDAO.delete(objeto);

    }
    
    
}
