/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Compra;

import controller.Busca.ControllerProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Venda;
import view.Busca.VendaView;
import view.Busca.ProdutoView;

/**
 *
 * @author eduar
 */
public class ControllerVendaView implements ActionListener {

    VendaView buscaCompraView;
    public static boolean vendaToProduto = false;

    public ControllerVendaView(VendaView buscaCompraView) {
        this.buscaCompraView = buscaCompraView;
        // this.buscaCompraView.getm

        this.buscaCompraView.getjButtonBuscar().addActionListener(this);
        this.buscaCompraView.getjButtonCarregar().addActionListener(this);
        this.buscaCompraView.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaCompraView.getjButtonCarregar()) {
        } else if (e.getSource() == this.buscaCompraView.getjButtonSair()) {

            this.buscaCompraView.dispose();
        } else if (e.getSource() == this.buscaCompraView.getjButtonBuscar()) {

            List<Venda> vendaList = new ArrayList<>();

            DefaultTableModel tableLista = (DefaultTableModel) this.buscaCompraView.getjTable1().getModel();
            for (Venda vendaAtual : vendaList) {
                tableLista.addRow(new Object[]{
                    vendaAtual.getId(),
                    vendaAtual.getCarteirinha().getCliente().getNome(),
                    vendaAtual.getValorVenda(),
                    //                    //vendaAtual.getFlagTipoDesconto(),
                    //                    //vendaAtual.getDataHoraVenda(),
                    //                    //vendaAtual.getValorDesconto(),
                    vendaAtual.getDataVenda(),
                    vendaAtual.getHoraVenda(),
                    vendaAtual.getObservacao(),
                    vendaAtual.getFuncionario().getId(),
                    vendaAtual.getStatus()

                });

            }
        }

    }

}
