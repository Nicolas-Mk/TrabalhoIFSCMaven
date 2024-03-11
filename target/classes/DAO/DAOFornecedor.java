/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Persiste.fornecedorList;
import static controller.Busca.ControllerFornecedorView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Fornecedor;

public class DAOFornecedor implements InterfaceDAO<Fornecedor> {

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO tblfornecedor "
                + "(nome,fone1,fone2,email,status,complementoEndereco,cnpj,inscricaoEstadual,razaoSocial,tblendereco_id)"
                + " VALUES(?,?,?,?,?,?,?,?,?,(SELECT id FROM tblendereco where logradouro like ?))";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus());
            pstm.setString(6, objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCnpj());
            pstm.setString(8, objeto.getInscricaoEstadual());
            pstm.setString(9, objeto.getRazaoSocial());
            pstm.setString(10, objeto.getEndereco().getLogradouro());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);

        }

    }

    @Override
    public void delete(Fornecedor objeto) {

    }

    @Override
    public void update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE tblFornecedor SET nome = ? ,"
                + "fone1 = ?,"
                + "fone2 = ?,"
                + "email = ?,"
                + "status = ?,"
                + "complementoEndereco = ?,"
                + "cnpj = ?,"
                + "inscricaoEstadual = ?,"
                + "razaoSocial = ?,"
                + "tblendereco_id = (SELECT id FROM tblendereco WHERE logradouro LIKE ?) "
                + "WHERE id = ?";
        PreparedStatement pstm = null;
        Fornecedor fornecedor = new Fornecedor();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus());
            pstm.setString(6, objeto.getComplementoEndereco());
            pstm.setString(7, objeto.getCnpj());
            pstm.setString(8, objeto.getInscricaoEstadual());
            pstm.setString(9, objeto.getRazaoSocial());
            pstm.setString(10, objeto.getEndereco().getLogradouro());
            pstm.setInt(11, objeto.getId());
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void retrieve(Fornecedor objeto) {

    }

    @Override
    public List<Fornecedor> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id,nome,fone1,fone2,"
                + "email,status,complementoEndereco,"
                + "cnpj,inscricaoEstadual,razaoSocial,(SELECT logradouro FROM tblendereco where id LIKE ?)"
                + "FROM tblfornecedor";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Fornecedor> FornecedorList = new ArrayList<>();

        try {
            Endereco endereco = new Endereco();
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + endereco.getLogradouro() + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone1"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setStatus(rst.getString("status"));
                fornecedor.setComplementoEndereco(rst.getString("complementoEndereco"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setInscricaoEstadual(rst.getString("inscricaoEstadual"));
                fornecedor.setRazaoSocial(rst.getString("razaoSocial"));
                fornecedorList.add(fornecedor);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return FornecedorList;
        }

    }

    @Override
    public Fornecedor retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT F.ID, F.NOME, F.FONE1, F.FONE2, F.EMAIL, F.STATUS, F.COMPLEMENTOENDERECO, F.CNPJ, F.INSCRICAOESTADUAL, F.RAZAOSOCIAL, E.LOGRADOURO,"
                + "C.DESCRICAO AS CIDADE,"
                + "B.DESCRICAO AS BAIRRO,"
                + "E.CEP "
                + "FROM TBLFORNECEDOR F "
                + "JOIN TBLENDERECO E ON F.TBLENDERECO_ID = E.ID "
                + "JOIN TBLCIDADE C ON E.TBLCIDADE_ID = C.ID "
                + "JOIN TBLBAIRRO B ON E.TBLBAIRRO_ID = B.ID "
                + "WHERE F.ID = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Bairro bairro = new Bairro();
        Cidade cidade = new Cidade();
        Endereco endereco = new Endereco();
        Fornecedor fornecedor = new Fornecedor();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while (rst.next()) {

                fornecedor.setEndereco(endereco);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone1"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setStatus(rst.getString("status"));
                fornecedor.setComplementoEndereco(rst.getString("complementoEndereco"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setInscricaoEstadual(rst.getString("inscricaoEstadual"));
                fornecedor.setRazaoSocial(rst.getString("razaoSocial"));
                fornecedor.getEndereco().setLogradouro(rst.getString("logradouro"));
                fornecedor.getEndereco().setCep(rst.getString("cep"));
                fornecedor.getEndereco().getBairro().setDescricao(rst.getString("BAIRRO"));
                fornecedor.getEndereco().getCidade().setDescricao(rst.getString("CIDADE"));

            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return fornecedor;

        }
    }

    @Override
    public List<Fornecedor> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "SELECT F.ID, F.NOME, F.FONE1, F.FONE2, F.EMAIL, F.STATUS, F.COMPLEMENTOENDERECO,"
                + "F.CNPJ, F.INSCRICAOESTADUAL, F.RAZAOSOCIAL, E.LOGRADOURO,E.CIDADE,E.BAIRRO, E.CEP "
                + "FROM TBLFORNECEDOR F JOIN TBLENDERECO E ON F.TBLENDERECO_ID = E.ID WHERE F." + colunaFiltro + " LIKE ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Fornecedor> fornecedorList = new ArrayList<>();

        
        Bairro bairro = new Bairro();
        Cidade cidade = new Cidade();
        Endereco endereco = new Endereco();
        Fornecedor fornecedor = new Fornecedor();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, "%" + parString + "%");
            rst = pstm.executeQuery();

          
            
            while (rst.next()) {

                fornecedor.setEndereco(endereco);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                
                fornecedor.setEndereco(endereco);
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone1"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setStatus(rst.getString("status"));
                fornecedor.setComplementoEndereco(rst.getString("complementoEndereco"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setInscricaoEstadual(rst.getString("inscricaoEstadual"));
                fornecedor.setRazaoSocial(rst.getString("razaoSocial"));
                fornecedor.getEndereco().setLogradouro(rst.getString("logradouro"));
                fornecedor.getEndereco().setCep(rst.getString("cep"));
                fornecedor.getEndereco().getCidade().setDescricao(rst.getString("cidade"));
                fornecedor.getEndereco().getBairro().setDescricao("bairro");
                fornecedorList.add(fornecedor);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return fornecedorList;
        }
    }

}
