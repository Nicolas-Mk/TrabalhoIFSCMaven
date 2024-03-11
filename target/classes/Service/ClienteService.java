/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import DAO.DAOCliente;
import model.bo.Cliente;

/**
 *
 * @author aluno
 */
public class ClienteService {

    public static void adicionar(Cliente objeto) {
        DAOCliente clienteDAO = new DAOCliente();
        clienteDAO.create(objeto);

    }

    public static List<Cliente> carregar() {
        DAOCliente clienteDAO = new DAOCliente();
        return clienteDAO.retrieve();

    }

    public static Cliente carregar(int parPK) {
        DAOCliente clienteDAO = new DAOCliente();
        return clienteDAO.retrieve(parPK);

    }

    public static List<Cliente> carregar(String parString) {
        DAOCliente clienteDAO = new DAOCliente();
        return clienteDAO.retrieve(parString);

    }
    
    public static void atualizar(Cliente objeto) {
        DAOCliente clienteDAO = new DAOCliente();
        clienteDAO.update(objeto);

    }
     public static void remover (Cliente objeto) {
        DAOCliente clienteDAO = new DAOCliente();
        clienteDAO.delete(objeto);

    }
    
    
}
