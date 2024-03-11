/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

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
import model.bo.Funcionario;
import view.Compra.AbreCaixaView;


/**
 *
 * @author eduar
 */
public class DAOAbreCaixa implements InterfaceDAO<Object> {

    @Override
    public void create(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void retrieve(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object retrieve(int parPK) {
        
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        
//        Connection conexao = ConnectionFactory.getConnection();
//        //String sqlExecutar = "SELECT id,cep,logradouro,status FROM tblendereco WHERE id = ? ";
//        String sqlExecutar = "SELECT ID FROM TBLFUNCIONARIO WHERE ID = ?";
//        
//        PreparedStatement pstm = null;
//        ResultSet rst = null;
//        
//        Endereco endereco = new Endereco();
//        Bairro bairro = new Bairro();
//        Cidade cidade = new Cidade();
//        try {
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setInt(1, parPK);
//            rst = pstm.executeQuery();
//
//            while(rst.next()){
//                List<AbreCaixaView> abreCaixaViews = new ArrayList<>();
//                Funcionario funcionario = new Funcionario();
//                
//                funcionario.setId(rst.getInt("ID"));
//             
//                abreCaixaViews.add(funcionario)
//            }
//            
//            
//        } catch (SQLException ex) {
//
//            ex.printStackTrace();
//        } finally {
//            ConnectionFactory.closeConnection(conexao, pstm, rst);
//            return endereco;
//
//        }
//    
    
    }

    @Override
    public List<Object> retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
