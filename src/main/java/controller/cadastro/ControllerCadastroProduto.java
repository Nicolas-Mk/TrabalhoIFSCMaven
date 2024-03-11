/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Busca.ProdutoView;
import view.Cadastro.CadastroProdutoView;
import controller.Busca.ControllerProdutoView;
import javax.swing.JOptionPane;
import model.bo.Produto;

/**
 *
 * @author joao-
 */
public class ControllerCadastroProduto implements ActionListener {

    public static int codigo;
    ProdutoView produtoView = new ProdutoView(null, true);
    CadastroProdutoView cadastroProdutoView;

    public ControllerCadastroProduto(CadastroProdutoView cadastroProdutoView) {
        this.cadastroProdutoView = cadastroProdutoView;

        this.cadastroProdutoView.getjButtonNovo().addActionListener(this);
        this.cadastroProdutoView.getjButtonSair().addActionListener(this);
        this.cadastroProdutoView.getjButtonCancelar().addActionListener(this);
        this.cadastroProdutoView.getjButtonGravar().addActionListener(this);
        this.cadastroProdutoView.getjButtonBuscar().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.cadastroProdutoView.getjPanelFim());
        utilities.Utilities.limpaComponentes(false, this.cadastroProdutoView.getjPanelMeio());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.cadastroProdutoView.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(false, this.cadastroProdutoView.getjPanelFim());
            utilities.Utilities.limpaComponentes(true, this.cadastroProdutoView.getjPanelMeio());
            this.cadastroProdutoView.getjTextFieldID2().setEnabled(false);

        } else if (e.getSource() == this.cadastroProdutoView.getjButtonSair()) {
            this.cadastroProdutoView.dispose();

        } else if (e.getSource() == this.cadastroProdutoView.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.cadastroProdutoView.getjPanelFim());
            utilities.Utilities.limpaComponentes(false, this.cadastroProdutoView.getjPanelMeio());

        } else if (e.getSource() == this.cadastroProdutoView.getjButtonBuscar()) {
            codigo = 0;

            ControllerProdutoView controllerProdutoView = new ControllerProdutoView(produtoView);
            produtoView.setVisible(true);

            if (codigo != 0) {
                Produto produto = new Produto();
                produto = Service.ProdutoService.carregar(codigo);

                utilities.Utilities.ativaDesativa(false, this.cadastroProdutoView.getjPanelFim());
                utilities.Utilities.limpaComponentes(true, this.cadastroProdutoView.getjPanelMeio());

                this.cadastroProdutoView.getjTextFieldID2().setText(produto.getId() + "");
                this.cadastroProdutoView.getjTextFieldDescricao().setText(produto.getDescricao() + "");
                this.cadastroProdutoView.getjTextFieldCodigoBarra().setText(produto.getCodigoBarra() + "");
                this.cadastroProdutoView.getjComboBoxStatus().setSelectedItem(produto.getStatus().toString() + "");

                this.cadastroProdutoView.getjTextFieldID2().setEnabled(false);
                this.cadastroProdutoView.getjTextFieldDescricao().setEnabled(true);
                this.cadastroProdutoView.getjTextFieldCodigoBarra().setEnabled(true);
                this.cadastroProdutoView.getjTextFieldQuantidade().setEnabled(true);
                this.cadastroProdutoView.getjComboBoxStatus().setEnabled(true);
                this.cadastroProdutoView.getjComboBoxTipoUnidade().setEnabled(true);
            }

        } else if (e.getSource() == this.cadastroProdutoView.getjButtonGravar()) {

            if (utilities.Utilities.campoVazio(this.cadastroProdutoView.getjPanelMeio()) == true) {
                JOptionPane.showMessageDialog(null, "Existem campos vazios!");

            } else {

                Produto produto = new Produto();

                produto.setDescricao(this.cadastroProdutoView.getjTextFieldDescricao().getText());
                produto.setCodigoBarra(this.cadastroProdutoView.getjTextFieldCodigoBarra().getText());
                produto.setStatus(this.cadastroProdutoView.getjComboBoxStatus().getSelectedItem().toString());

                if (this.cadastroProdutoView.getjTextFieldID2().getText().trim().equalsIgnoreCase("")) {

                    Service.ProdutoService.adicionar(produto);
                } else {
                    produto.setId(Integer.parseInt(this.cadastroProdutoView.getjTextFieldID2().getText()));
                    Service.ProdutoService.atualizar(produto);
                }
                utilities.Utilities.ativaDesativa(true, this.cadastroProdutoView.getjPanelFim());
                utilities.Utilities.limpaComponentes(false, this.cadastroProdutoView.getjPanelMeio());
            }
        }
    }

}
