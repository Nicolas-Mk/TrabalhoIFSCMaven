/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import DAO.DAOEndereco;
import model.bo.Bairro;


import model.bo.Endereco;

/**
 *
 * @author aluno
 */
public class EnderecoService {

    public static void adicionar(Endereco objeto) {
        DAOEndereco enderecoDAO = new DAOEndereco();
        enderecoDAO.create(objeto);

    }

    public static List<Endereco> carregar() {
        DAOEndereco enderecoDAO = new DAOEndereco();
        return enderecoDAO.retrieve();

    }

    public static Endereco carregar(int parPK) {
        DAOEndereco enderecoDAO = new DAOEndereco();
        return enderecoDAO.retrieve(parPK);

    }

    public static List<Endereco> carregar(String parString) {
        DAOEndereco enderecoDAO = new DAOEndereco();
        return enderecoDAO.retrieve(parString);

    }
    
    public static void atualizar(Endereco objeto) {
        DAOEndereco enderecoDAO = new DAOEndereco();
        enderecoDAO.update(objeto);

    }
     public static void remover (Endereco objeto) {
        DAOEndereco enderecoDAO = new DAOEndereco();
        enderecoDAO.delete(objeto);

    }
     
     

//
}
