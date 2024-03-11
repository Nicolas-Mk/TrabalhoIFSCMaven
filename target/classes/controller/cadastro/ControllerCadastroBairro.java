/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Cadastro.CadastroBairrosView;
import view.Busca.BairroView;
import controller.Busca.ControllerBairroView;
import javax.swing.JOptionPane;
import model.bo.Bairro;

/**
 *
 * @author aluno
 */
public class ControllerCadastroBairro implements ActionListener {

    //Criando um objeto global do tipo da tela que iremos controllar
    CadastroBairrosView cadastroBairrosView;

    //contador
    public static int codigo1;

    //Passando a tela que iremos controlar como parametro de invocação
    public ControllerCadastroBairro(CadastroBairrosView cadastroBairrosView) {
        //Repassando o valor da Tela que iremos controlar como parametro paara o objeto global
        this.cadastroBairrosView = cadastroBairrosView;

        //Adicionando ouvintes(Listerners) para escutar ações nos botões da tela
        this.cadastroBairrosView.getjButtonNovo().addActionListener(this);
        this.cadastroBairrosView.getjButtonSair().addActionListener(this);
        this.cadastroBairrosView.getjButtonCancelar().addActionListener(this);
        this.cadastroBairrosView.getjButtonGravar().addActionListener(this);
        this.cadastroBairrosView.getjButtonBuscar().addActionListener(this);
        this.cadastroBairrosView.getjTextFieldDescricao().addActionListener(this);

        //Executando os métodos da classe de utilitarios 
        //Para ativar/desativar/limpar botões e componentes diversos na tela
        utilities.Utilities.ativaDesativa(true, this.cadastroBairrosView.getjPanelFim());
        utilities.Utilities.limpaComponentes(false, this.cadastroBairrosView.getjPanelMeio());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.cadastroBairrosView.getjButtonNovo()) {

            utilities.Utilities.ativaDesativa(false, this.cadastroBairrosView.getjPanelFim());
            utilities.Utilities.limpaComponentes(true, this.cadastroBairrosView.getjPanelMeio());

            this.cadastroBairrosView.getjTextField1().setEnabled(false);

        } else if (e.getSource() == this.cadastroBairrosView.getjButtonSair()) {
            this.cadastroBairrosView.dispose();

        } else if (e.getSource() == this.cadastroBairrosView.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.cadastroBairrosView.getjPanelFim());
            utilities.Utilities.limpaComponentes(false, this.cadastroBairrosView.getjPanelMeio());

        } else if (e.getSource() == this.cadastroBairrosView.getjButtonBuscar()) {

            codigo1 = 0;

            BairroView bairroView = new BairroView(null, true);
            ControllerBairroView controllerBairroView = new ControllerBairroView(bairroView);
            bairroView.setVisible(true);

            if (codigo1 != 0) {

                Bairro bairro = new Bairro();
                bairro = Service.BairroService.carregar(codigo1);
                utilities.Utilities.ativaDesativa(false, this.cadastroBairrosView.getjPanelFim());
                utilities.Utilities.limpaComponentes(true, this.cadastroBairrosView.getjPanelMeio());

                this.cadastroBairrosView.getjTextField1().setText(bairro.getId() + "");
                this.cadastroBairrosView.getjTextFieldDescricao().setText(bairro.getDescricao() + "");
                this.cadastroBairrosView.getjTextField1().setEnabled(false);
                this.cadastroBairrosView.getjTextFieldDescricao().setEnabled(true);
            }

        } else if (e.getSource() == this.cadastroBairrosView.getjButtonGravar()) {

            if (utilities.Utilities.campoVazio(this.cadastroBairrosView.getjPanelMeio()) == true) {
                JOptionPane.showMessageDialog(null, "Existem campos vazios!");

            } else {

                Bairro bairro = new Bairro();

                bairro.setDescricao(this.cadastroBairrosView.getjTextFieldDescricao().getText());

                if (this.cadastroBairrosView.getjTextField1().getText().trim().equalsIgnoreCase("")) {
                    //Codigo para incluir
                    Service.BairroService.adicionar(bairro);

                } else {
                    bairro.setId(Integer.parseInt(this.cadastroBairrosView.getjTextField1().getText()));
                    Service.BairroService.atualizar(bairro);
                }

                utilities.Utilities.ativaDesativa(true, this.cadastroBairrosView.getjPanelFim());
                utilities.Utilities.limpaComponentes(false, this.cadastroBairrosView.getjPanelMeio());

            }
        }

    }
}
