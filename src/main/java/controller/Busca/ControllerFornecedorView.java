/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Busca;

import Service.FornecedorService;
import controller.cadastro.ControllerCadastroFornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Fornecedor;
import view.Busca.FornecedorView;
import java.lang.Number;

/**
 *
 * @author joao-
 */
public class ControllerFornecedorView implements ActionListener {

    public static String colunaFiltro;
    FornecedorView fornecedorView;

    public ControllerFornecedorView(FornecedorView fornecedorView) {
        this.fornecedorView = fornecedorView;

        this.fornecedorView.getjButtonBuscar().addActionListener(this);
        this.fornecedorView.getjButtonCarregar().addActionListener(this);
        this.fornecedorView.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.fornecedorView.getjButtonCarregar()) {
            ControllerCadastroFornecedor.codigo = (int) this.fornecedorView.getjTable1().getValueAt(this.fornecedorView.getjTable1().getSelectedRow(), 0);

            FornecedorService.carregar();
            this.fornecedorView.dispose();

        } else if (e.getSource() == this.fornecedorView.getjButtonSair()) {
            this.fornecedorView.dispose();

        } else if (e.getSource() == this.fornecedorView.getjButtonBuscar()) {
            if (this.fornecedorView.getjTextFieldBuscar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");

            }
         else {
            List<Fornecedor> fornecedorList = new ArrayList<>();
            if (this.fornecedorView.getComboBoxFiltrar().getSelectedIndex() == 0) {

                fornecedorList.add(FornecedorService.carregar(Integer.parseInt(this.fornecedorView.getjTextFieldBuscar().getText())));
            } else {
                colunaFiltro = this.fornecedorView.getComboBoxFiltrar().getSelectedItem().toString().trim();
                fornecedorList = FornecedorService.carregar(this.fornecedorView.getjTextFieldBuscar().getText().trim());
            }

            DefaultTableModel tabela = (DefaultTableModel) this.fornecedorView.getjTable1().getModel();
            tabela.setRowCount(0);
            for (Fornecedor fornecedorAtual : fornecedorList) {
                tabela.addRow(new Object[]{
                    fornecedorAtual.getId(),
                    fornecedorAtual.getNome(),
                    fornecedorAtual.getRazaoSocial(),
                    fornecedorAtual.getCnpj(),
                    fornecedorAtual.getInscricaoEstadual(),
                    fornecedorAtual.getFone1(),
                    fornecedorAtual.getFone2(),
                    fornecedorAtual.getEmail(),
                    fornecedorAtual.getStatus(),
                    fornecedorAtual.getEndereco().getLogradouro(),
                    fornecedorAtual.getEndereco().getCidade().getDescricao(),
                    fornecedorAtual.getEndereco().getBairro().getDescricao(),
                    fornecedorAtual.getEndereco().getCep(),
                    fornecedorAtual.getComplementoEndereco()

                }
                );

            }
        }
    }
}

}
