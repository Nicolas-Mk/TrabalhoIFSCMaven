/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static controller.Busca.ControllerClienteView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bo.Cliente;
import model.bo.Endereco;

public class DAOCliente implements InterfaceDAO<Cliente> {

    @Override
    public void create(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();       
        String sqlExecutar = "INSERT INTO tblcliente "
                + "(nome,fone1,fone2,email,status,complementoEndereco,cpf,rg,matricula,dataNascimento,tblendereco_id) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,(SELECT id FROM TBLENDERECO WHERE logradouro LIKE ?))";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2,objeto.getFone1());
            pstm.setString(3,objeto.getFone2());
            pstm.setString(4,objeto.getEmail());
            pstm.setString(5,objeto.getStatus());
            pstm.setString(6,objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCpf());
            pstm.setString(8,objeto.getRg());
            pstm.setString(9,objeto.getMatricula());
            pstm.setString(10,objeto.getDataNascimento());
            pstm.setString(11,objeto.getEndereco().getLogradouro());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);

        }

    }

    @Override
    public void delete(Cliente objeto) {

    }

    @Override
    public void update(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE tblcliente SET nome = ? ,"
                                                 +"fone1 = ?,"
                                                 +"fone2 = ?,"
                                                 +"email = ?,"
                                                 +"status = ?,"
                                                 +"complementoEndereco = ?,"
                                                 +"cpf = ?,"
                                                 +"rg = ?,"
                                                 +"matricula = ?,"
                                                 +"dataNascimento = ?,"
                                                 +"tblendereco_id = (SELECT id FROM TBLENDERECO WHERE logradouro LIKE ?)"
                                                 +"WHERE id = ?";
        PreparedStatement pstm = null;
        Cliente cliente = new Cliente();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2,objeto.getFone1());
            pstm.setString(3,objeto.getFone2());
            pstm.setString(4,objeto.getEmail());
            pstm.setString(5,objeto.getStatus());
            pstm.setString(6,objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCpf());
            pstm.setString(8,objeto.getRg());
            pstm.setString(9,objeto.getMatricula());
            pstm.setString(10,objeto.getDataNascimento());
            pstm.setString(11, objeto.getEndereco().getLogradouro());
            pstm.setInt(12, objeto.getId());
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void retrieve(Cliente objeto) {

    }

    @Override
    public List<Cliente> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT C.id,C.nome,C.fone1,C.fone2,C.email,C.status,C.complementoEndereco,"
                + "C.cpf,C.rg,C.matricula, C.dataNascimento, E.logradouro, E.cep FROM tblcliente C join tblendereco E "
                + "on C.tblendereco_id = E.id where C.nome = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        List<Cliente> clienteList = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + cliente.getNome() + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
               
                cliente.setEndereco(endereco);
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setEmail(rst.getString("email"));
                cliente.setStatus(rst.getString("status"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setRg(rst.getString("rg"));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setDataNascimento(rst.getString("dataNascimento"));
                cliente.getEndereco().setLogradouro(rst.getString("logradouro"));
                cliente.getEndereco().setCep(rst.getString("cep"));
                clienteList.add(cliente);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return clienteList;
        }

    }

    @Override
    public Cliente retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT C.id,C.nome,C.fone1,C.fone2,C.email,C.status,"
                + "C.complementoEndereco,C.cpf,C.rg,C.matricula,C.dataNascimento,"
                + "E.logradouro, E.cep "
                + " FROM tblcliente C join tblendereco E "
                + "on C.tblendereco_id = E.id "
                + " WHERE C.id = ? ";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while(rst.next()){
                
                cliente.setEndereco(endereco);
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setEmail(rst.getString("email"));
                cliente.setStatus(rst.getString("status"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setRg(rst.getString("rg"));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setDataNascimento(rst.getString("dataNascimento"));
                cliente.getEndereco().setLogradouro(rst.getString("logradouro"));
                cliente.getEndereco().setCep(rst.getString("cep"));
                cliente.setCpf(rst.getString("cpf"));
                
            }
            
            
        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cliente;

        }
    }

    @Override
    public List<Cliente> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
       
        String sqlExecutar = "SELECT C.id,C.nome,C.fone1,C.fone2,C.email,C.status,"
                + "C.complementoEndereco,C.cpf,C.rg,C.matricula,C.dataNascimento,"
                + "E.logradouro, E.cep "
                + " FROM tblcliente C join tblendereco E "
                + "on C.tblendereco_id = E.id "
                + " WHERE "+colunaFiltro+" LIKE ? ";
                
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> clienteList = new ArrayList<>();
        
        

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + parString + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                Cliente cliente = new Cliente();
                Endereco endereco = new Endereco();
                
                cliente.setEndereco(endereco);
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setEmail(rst.getString("email"));
                cliente.setStatus(rst.getString("status"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setRg(rst.getString("rg"));
                cliente.setMatricula(rst.getString("matricula"));
                cliente.setDataNascimento(rst.getString("dataNascimento"));
                cliente.getEndereco().setLogradouro(rst.getString("logradouro"));
                cliente.getEndereco().setCep(rst.getString("cep"));
                cliente.setCpf(rst.getString("cpf"));
                clienteList.add(cliente);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return clienteList;
        }
    }
   

}
