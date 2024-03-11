/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import DAO.DAOFuncionario;
import model.bo.Funcionario;

/**
 *
 * @author aluno
 */
public class FuncionarioService {

    public static void adicionar(Funcionario objeto) {
        DAOFuncionario funcionarioDAO = new DAOFuncionario();
        funcionarioDAO.create(objeto);

    }

    public static List<Funcionario> carregar() {
        DAOFuncionario funcionarioDAO = new DAOFuncionario();
        return funcionarioDAO.retrieve();

    }

    public static Funcionario carregar(int parPK) {
        DAOFuncionario funcionarioDAO = new DAOFuncionario();
        return funcionarioDAO.retrieve(parPK);

    }

    public static List<Funcionario> carregar(String parString) {
        DAOFuncionario funcionarioDAO = new DAOFuncionario();
        return  funcionarioDAO.retrieve(parString);

    }
    
    public static void atualizar(Funcionario objeto) {
        DAOFuncionario funcionarioDAO = new DAOFuncionario();
        funcionarioDAO.update(objeto);

    }
     public static void remover (Funcionario objeto) {
        DAOFuncionario funcionarioDAO = new DAOFuncionario();
        funcionarioDAO.delete(objeto);

    }
     
    
}
