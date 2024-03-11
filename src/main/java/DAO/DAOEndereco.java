/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Persiste.enderecoList;
import static controller.Busca.ControllerEnderecoView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import model.bo.Endereco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bo.Bairro;
import model.bo.Cidade;

public class DAOEndereco implements InterfaceDAO<Endereco> {

    @Override
    public void create(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        //String sqlExecutar = "INSERT INTO tblendereco(cep,logradouro,status) VALUES(?,?,?)";
        
          String sqlExecutar = "INSERT INTO TBLENDERECO "
                  + "(cep, logradouro, status, tblcidade_id, tblbairro_id) "
                  + "VALUES (?, ?, ?, (SELECT id FROM tblcidade WHERE descricao LIKE ?), "
                  + "(SELECT id FROM tblbairro WHERE descricao LIKE ?))";

         
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradouro());
            pstm.setString(3, objeto.getStatus());
            pstm.setString(4,objeto.getCidade().getDescricao());
            pstm.setString(5, objeto.getBairro().getDescricao());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);

        }

    }

    @Override
    public void delete(Endereco objeto) {

    }

    @Override
    public void update(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE tblendereco SET cep = ?, logradouro = ?,status = ? WHERE id = ?";
        PreparedStatement pstm = null;
        Endereco endereco = new Endereco();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradouro());
            pstm.setString(3, objeto.getStatus());
            
            pstm.setInt(4, objeto.getId());
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void retrieve(Endereco objeto) {

    }

    @Override
    public List<Endereco> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cep,logradouro,status FROM tblendereco";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Endereco> EnderecioList = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();

            while (rst.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setStatus(rst.getString("status"));
                enderecoList.add(endereco);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return enderecoList;
        }

    }

    @Override
    public Endereco retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        //String sqlExecutar = "SELECT id,cep,logradouro,status FROM tblendereco WHERE id = ? ";
        String sqlExecutar = "SELECT E.ID,E.CEP , E.LOGRADOURO, E.STATUS, C.DESCRICAO AS CIDADE ,B.DESCRICAO AS BAIRRO "
                + "FROM TBLENDERECO E JOIN TBLCIDADE C "
                + "ON E.TBLCIDADE_ID = C.ID "
                + "JOIN TBLBAIRRO B  "
                + "ON E.TBLBAIRRO_ID = B.ID "
                + "WHERE E.ID = ?";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        Endereco endereco = new Endereco();
        Bairro bairro = new Bairro();
        Cidade cidade = new Cidade();
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while(rst.next()){
                
                bairro.setDescricao(rst.getString("BAIRRO"));
                cidade.setDescricao(rst.getString("CIDADE"));
                
                
                endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                endereco.setStatus(rst.getString("status"));
                
            }
            
            
        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return endereco;

        }
    }

    @Override
    public List<Endereco> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
       
        String sqlExecutar = "SELECT E.ID,E.CEP , E.LOGRADOURO, E.STATUS, C.DESCRICAO AS CIDADE ,B.DESCRICAO AS BAIRRO "
                + "FROM TBLENDERECO E JOIN TBLCIDADE C "
                + "ON E.TBLCIDADE_ID = C.ID "
                + "JOIN TBLBAIRRO B  "
                + "ON E.TBLBAIRRO_ID = B.ID "
                + "WHERE "+ colunaFiltro +" LIKE ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Endereco> enderecoList = new ArrayList<>();
        
        

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + parString + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                Endereco endereco = new Endereco();
                Cidade cidade = new Cidade();
                Bairro bairro = new Bairro();
                
                endereco.setCidade(cidade);
                endereco.setBairro(bairro);
                endereco.setId(rst.getInt("id"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setCep(rst.getString("cep"));
                endereco.setStatus(rst.getString("status"));
                endereco.getCidade().setDescricao(rst.getString("cidade"));
                endereco.getBairro().setDescricao(rst.getString("bairro"));
                enderecoList.add(endereco);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return enderecoList;
        }
    }
   
    
    
    
    
}
