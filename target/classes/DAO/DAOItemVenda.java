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
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;
import view.Busca.CarteirinhaView;
import view.Compra.PontoDeVendaView;

/**
 *
 * @author eduar
 */
public class DAOItemVenda implements InterfaceDAO<ItemVenda> {

    @Override
    public void create(ItemVenda objeto) {

        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " INSERT INTO TBLITEMVENDA (QTDPRODUTO,VALORUNITARIO,STATUS,"
                + " TBLCARTEIRINHA_ID, TBLPRODUTO_ID, TBLVENDA_ID) VALUES"
                + " (?,?,?,"
                + " (SELECT A.id from tblcarteirinha A join tblcliente C on A.tblcliente_id = C.id Where A.tblcliente_id = ? limit 1 )"
                + " ,?, ?)" ;

        PreparedStatement pstm = null;

        Venda venda = new Venda();
        Carteirinha carterinha = new Carteirinha();
        Cliente cliente = new Cliente();
        Produto produto = new Produto();
        
        objeto.setVenda(venda);
        objeto.setProduto(produto);
        objeto.setCarteirinha(carterinha);
        
        carterinha.setCliente(cliente);
        venda.setCliente(cliente);
        
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
                pstm.setInt(1, (int) objeto.getQtdProduto());
                pstm.setFloat(2, objeto.getValorUnitario());
                pstm.setString(3, objeto.getStatus());
                pstm.setInt(4, objeto.getVenda().getCliente().getId());
                pstm.setInt(5, objeto.getProduto().getId());
                pstm.setInt(6, objeto.getVenda().getId());

                
//            PontoDeVendaView pontoDeVendaView = new PontoDeVendaView(null, true);
//            ControllerPontoDeVenda controllerPontoDeVenda = new ControllerPontoDeVenda(pontoDeVendaView);
//
//            
//            for (int i = 0; i < pontoDeVendaView.getTabelaListaProduto().getRowCount(); i++) {
//                
//                int quant = (int) pontoDeVendaView.getTabelaListaProduto().getValueAt(i, 3);
//                
//                
//                pstm.setInt(1,(int) pontoDeVendaView.getTabelaListaProduto().getValueAt(i, 3));
//                pstm.setFloat(2, (float) pontoDeVendaView.getTabelaListaProduto().getValueAt(i, 2) / quant);
//                pstm.setString(3, (String) pontoDeVendaView.getTabelaListaProduto().getValueAt(i, 4));          
//                pstm.setInt(4, objeto.getVenda().getCliente().getId());
//                pstm.setInt(5, objeto.getVenda().getProduto().getId());
//                pstm.setInt(6, objeto.getVenda().getId());
//           
               pstm.execute();
            
            

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);

        }}

    

    @Override
    public void retrieve(ItemVenda objeto) {

    }

    @Override
    public void update(ItemVenda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ItemVenda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ItemVenda> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public ItemVenda retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ItemVenda> retrieve(String parString) {

        Connection conexao = ConnectionFactory.getConnection();
        PontoDeVendaView pontoDeVendaView = new PontoDeVendaView(null, true);
        ControllerPontoDeVenda controllerPontoDeVenda = new ControllerPontoDeVenda(pontoDeVendaView);
        // String coluna = produtoView.getComboBoxFiltrar().getSelectedItem().toString().trim();

        String sqlExecutar = "SELECT  descricao "
                + "FROM tblproduto "
                + "WHERE codigoBarra LIKE ?";  // Usando LIKE para busca de substring

        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<ItemVenda> itemVendaList = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);

            //pstm.setString(1,colunaFiltro); 
            pstm.setString(1, "%" + parString + "%");  // Usando parString diretamente

            rst = pstm.executeQuery();

            while (rst.next()) {
                ItemVenda itemVenda = new ItemVenda();
                Produto produto = new Produto();

                itemVenda.setProduto(produto);

                itemVenda.getProduto().setDescricao(rst.getString("descricao"));

                itemVendaList.add(itemVenda);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }

        return itemVendaList;

    }
}
