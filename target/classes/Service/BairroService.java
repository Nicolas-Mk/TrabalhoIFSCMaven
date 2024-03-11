/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import DAO.DAOBairro;
import model.bo.Bairro;

/**
 *
 * @author aluno
 */
public class BairroService {

    public static void adicionar(Bairro objeto) {
        DAOBairro bairroDAO = new DAOBairro();
        bairroDAO.create(objeto);

    }

    public static List<Bairro> carregar() {
        DAOBairro bairroDAO = new DAOBairro();
        return bairroDAO.retrieve();

    }

    public static Bairro carregar(int parPK) {
        DAOBairro bairroDAO = new DAOBairro();
        return bairroDAO.retrieve(parPK);

    }

    public static List<Bairro> carregar(String parString) {
        DAOBairro bairroDAO = new DAOBairro();
        return  bairroDAO.retrieve(parString);

    }
    
    public static void atualizar(Bairro objeto) {
        DAOBairro bairroDAO = new DAOBairro();
        bairroDAO.update(objeto);

    }
     public static void remover (Bairro objeto) {
        DAOBairro bairroDAO = new DAOBairro();
        bairroDAO.delete(objeto);

    }
     
    
}
