/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import controller.Busca.ControllerCarteirinhaView;
import static controller.Busca.ControllerCarteirinhaView.colunaFiltro;
import controller.Compra.ControllerPontoDeVenda;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bo.Carteirinha;
import model.bo.Cliente;
import model.bo.Funcionario;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;
import view.Busca.CarteirinhaView;
import view.Compra.PontoDeVendaView;

/**
 *
 * @author eduar
 */
public class DAOVenda implements InterfaceDAO<Venda> {

    @Override
    public void create(Venda objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO TBLVENDA "
                + "(VALORVENDA,DATAVENDA,HORAVENDA,OBSERVACAO,STATUS,TBLFUNCIONARIO_ID,TBLCARTEIRINHA_ID) "
                + "VALUES (?,?,?,?,?,?,(SELECT ID FROM TBLCARTEIRINHA WHERE TBLCLIENTE_ID = ?))";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setFloat(1, objeto.getValorVenda());
            pstm.setString(2, objeto.getDataVenda());
            pstm.setString(3, objeto.getHoraVenda());
            pstm.setString(4, objeto.getObservacao());
            pstm.setString(5, objeto.getStatus());
            pstm.setInt(6,objeto.getFuncionario().getId());
            pstm.setInt(7,objeto.getCliente().getId());
            
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);

        }
    }

    @Override
    public void retrieve(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Venda objeto) {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE tblvenda SET observacao = ? , status = ?,"
                + "TBLFuncionario_ID = ? , TBLCARTEIRINHA_ID = (SELECT ID FROM TBLCARTEIRINHA WHERE TBLCLIENTE_ID = ?),"
                + "dataVenda = ?, horaVenda = ?, valorVenda = ?";
        PreparedStatement pstm = null;
        Venda  venda = new Venda();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, objeto.getObservacao());
            pstm.setString(2, objeto.getStatus());
            pstm.setInt(3, objeto.getFuncionario().getId());
            pstm.setInt(4, objeto.getCliente().getId());
            pstm.setString(5, objeto.getDataVenda());
            pstm.setString(6, objeto.getHoraVenda());
            pstm.setFloat(7, objeto.getValorVenda());
            
            
            
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void delete(Venda objeto) {
        
    }

    @Override
    public List<Venda> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venda retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Venda> retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String retornoNome(String info) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

}
