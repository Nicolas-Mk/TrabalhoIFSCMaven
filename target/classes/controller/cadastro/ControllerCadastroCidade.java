/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Cadastro.CadastroCidadesView;
import controller.Busca.ControllerCidadeView;
import model.bo.Cidade;
import static DAO.Persiste.cidadeList;
import javax.swing.JOptionPane;
import view.Busca.CidadeView;

/**
 *
 * @author joao-
 */
public class ControllerCadastroCidade implements ActionListener {

    CadastroCidadesView cadastroCidadesView;
    public static int codigo;

    public ControllerCadastroCidade(CadastroCidadesView cadastroCidadesView) {
        this.cadastroCidadesView = cadastroCidadesView;

        this.cadastroCidadesView.getjButtonNovo().addActionListener(this);
        this.cadastroCidadesView.getjButtonSair().addActionListener(this);
        this.cadastroCidadesView.getjButtonCancelar().addActionListener(this);
        this.cadastroCidadesView.getjButtonGravar().addActionListener(this);
        this.cadastroCidadesView.getjButtonBuscar().addActionListener(this);
        this.cadastroCidadesView.getjTextField1().addActionListener(this);
        this.cadastroCidadesView.getjTextField2().addActionListener(this);
        this.cadastroCidadesView.getjTextField3().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.cadastroCidadesView.getjPanelFim());
        utilities.Utilities.limpaComponentes(false, this.cadastroCidadesView.getjPanelMeio());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCidadesView.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(false, this.cadastroCidadesView.getjPanelFim());
            utilities.Utilities.limpaComponentes(true, this.cadastroCidadesView.getjPanelMeio());
            this.cadastroCidadesView.getjTextField3().setEnabled(false);

        } else if (e.getSource() == this.cadastroCidadesView.getjButtonSair()) {
            this.cadastroCidadesView.dispose();

        } else if (e.getSource() == this.cadastroCidadesView.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.cadastroCidadesView.getjPanelFim());
            utilities.Utilities.limpaComponentes(false, this.cadastroCidadesView.getjPanelMeio());

        } else if (e.getSource() == this.cadastroCidadesView.getjButtonBuscar()) {

            codigo = 0;

            CidadeView cidadeView = new CidadeView(null, true);
            ControllerCidadeView controllerCidadeView = new ControllerCidadeView(cidadeView);

            cidadeView.setVisible(true);

            if (codigo != 0) {

               

                    Cidade cidade = new Cidade();
                    cidade = Service.CidadeService.carregar(codigo);

                    utilities.Utilities.ativaDesativa(false, this.cadastroCidadesView.getjPanelFim());
                    utilities.Utilities.limpaComponentes(true, this.cadastroCidadesView.getjPanelMeio());

                    this.cadastroCidadesView.getjTextField3().setText(cidade.getId() + "");
                    this.cadastroCidadesView.getjTextField2().setText(cidade.getDescricao() + "");
                    this.cadastroCidadesView.getjTextField1().setText(cidade.getUf() + "");
                    this.cadastroCidadesView.getjTextField2().setEnabled(true);
                    this.cadastroCidadesView.getjTextField1().setEnabled(true);
                    this.cadastroCidadesView.getjTextField3().setEnabled(false);

                }

            } else if (e.getSource() == this.cadastroCidadesView.getjButtonGravar()) {
                Cidade cidade = new Cidade();
                
                
                 if (utilities.Utilities.campoVazio(this.cadastroCidadesView.getjPanelMeio()) == true) {
                    JOptionPane.showMessageDialog(null, "Existem campos vazios!");

                } else {
                

                cidade.setDescricao(this.cadastroCidadesView.getjTextField2().getText().trim());
                cidade.setUf(this.cadastroCidadesView.getjTextField1().getText().trim());

                if (this.cadastroCidadesView.getjTextField3().getText().trim().equalsIgnoreCase("")) {
                    Service.CidadeService.adicionar(cidade);
                } else {
                    cidade.setId(Integer.parseInt(this.cadastroCidadesView.getjTextField3().getText()));
                    Service.CidadeService.atualizar(cidade);
                }

                utilities.Utilities.ativaDesativa(true, this.cadastroCidadesView.getjPanelFim());
                utilities.Utilities.limpaComponentes(false, this.cadastroCidadesView.getjPanelMeio());

            }

        }
    }
}
