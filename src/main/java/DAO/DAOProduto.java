/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Persiste.produtoList;
import controller.Busca.ControllerProdutoView;
import static controller.Busca.ControllerProdutoView.colunaFiltro;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import model.bo.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.Busca.ProdutoView;

public class DAOProduto implements InterfaceDAO<Produto> {

    @Override
    public void create(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO tblproduto "
                + "(descricao,codigoBarra,status) "
                + "VALUES(?,?,?,)";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigoBarra());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);

        }

    }

    @Override
    public void delete(Produto objeto) {

    }

    @Override
    public void update(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE tblproduto SET "
                + "descricao = ?, "
                + "codigoBarra = ?,"
                + "status = ?, "
                + "WHERE id = ?";
        PreparedStatement pstm = null;
        Produto produto = new Produto();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigoBarra());
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
    public void retrieve(Produto objeto) {

    }

    @Override
    public List<Produto> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id,descricao,codigoBarra,status FROM tblproduto";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Produto> produtoList = new ArrayList<>();

        try {
            Produto produto = new Produto();
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();

            while (rst.next()) {

                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigoBarra(rst.getString("codigoBarra"));

                produto.setStatus(rst.getString("status"));

                produtoList.add(produto);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return produtoList;
        }

    }

    @Override
    public Produto retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id,descricao,codigoBarra,status FROM tblproduto WHERE id = ? ";
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Produto produto = new Produto();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();

            while (rst.next()) {
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigoBarra(rst.getString("codigoBarra"));

                produto.setStatus(rst.getString("status"));
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return produto;

        }
    }

    @Override
    public List<Produto> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        ProdutoView produtoView = new ProdutoView(null, true);
        ControllerProdutoView controllerProdutoView = new ControllerProdutoView(produtoView);
        // String coluna = produtoView.getComboBoxFiltrar().getSelectedItem().toString().trim();

        String sqlExecutar = "SELECT id,descricao,codigoBarra,status "
                + "FROM tblproduto "
                + "WHERE " + colunaFiltro + " LIKE ?";  // Usando LIKE para busca de substring

        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Produto> produtoList = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);

            //pstm.setString(1,colunaFiltro); 
            pstm.setString(1, "%" + parString + "%");  // Usando parString diretamente

            rst = pstm.executeQuery();

            while (rst.next()) {
                Produto produto = new Produto();
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setCodigoBarra(rst.getString("codigoBarra"));
                produto.setStatus(rst.getString("status"));

                produtoList.add(produto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }

        return produtoList;  // Retornar a lista fora do bloco finally
    }

    public Produto RetornaDeLadinho(String cod) {
        Connection conexao = ConnectionFactory.getConnection();
        ProdutoView produtoView = new ProdutoView(null, true);
        ControllerProdutoView controllerProdutoView = new ControllerProdutoView(produtoView);
        // String coluna = produtoView.getComboBoxFiltrar().getSelectedItem().toString().trim();

        String sqlExecutar = "SELECT id,descricao "
                + "FROM tblproduto "
                + "WHERE codigoBarra LIKE ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        Produto produto = new Produto();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);

            //pstm.setString(1,colunaFiltro); 
            pstm.setString(1, "%" + cod + "%");  // Usando parString diretamente

            rst = pstm.executeQuery();

            while (rst.next()) {
                
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }

        return produto;
    }

//    public Produto RetornaIDproduto(String cod) {
//        Connection conexao = ConnectionFactory.getConnection();
//        ProdutoView produtoView = new ProdutoView(null, true);
//        ControllerProdutoView controllerProdutoView = new ControllerProdutoView(produtoView);
//        // String coluna = produtoView.getComboBoxFiltrar().getSelectedItem().toString().trim();
//
//        String sqlExecutar = "SELECT ID "
//                + "FROM tblproduto "
//                + "WHERE codigoBarra LIKE ?";
//
//        PreparedStatement pstm = null;
//        ResultSet rst = null;
//        Produto produto = new Produto();
//
//        try {
//            pstm = conexao.prepareStatement(sqlExecutar);
//
//            //pstm.setString(1,colunaFiltro); 
//            pstm.setString(1, "%" + cod + "%");  // Usando parString diretamente
//
//            rst = pstm.executeQuery();
//
//            while (rst.next()) {
//
//                produto.setDescricao(rst.getString("ID"));
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//        }
//
//        return produto;
//    }
}
