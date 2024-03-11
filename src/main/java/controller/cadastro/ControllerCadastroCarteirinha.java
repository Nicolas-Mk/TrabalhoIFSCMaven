/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.cadastro;

import static DAO.Persiste.carteirinhaList;
import controller.Busca.ControllerCarteirinhaView;
import controller.Busca.ControllerClienteView;
import java.awt.Component;
import view.Cadastro.CadastroCarteirinhaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bo.Carteirinha;
import model.bo.Cliente;
import view.Busca.CarteirinhaView;
import view.Busca.ClienteView;

/**
 *
 * @author joao-
 */
public class ControllerCadastroCarteirinha implements ActionListener {

    CadastroCarteirinhaView cadastroCarteirinhaView;
    public static int codigo;

    public ControllerCadastroCarteirinha(CadastroCarteirinhaView cadastroCarteirinhaView) {
        this.cadastroCarteirinhaView = cadastroCarteirinhaView;

        this.cadastroCarteirinhaView.getjButtonNovo().addActionListener(this);
        this.cadastroCarteirinhaView.getjButtonSair().addActionListener(this);
        this.cadastroCarteirinhaView.getjButtonCancelar().addActionListener(this);
        this.cadastroCarteirinhaView.getjButtonGravar().addActionListener(this);
        this.cadastroCarteirinhaView.getjButtonBuscar().addActionListener(this);
        this.cadastroCarteirinhaView.getjButtonCliente().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.cadastroCarteirinhaView.getjPanelFim());
        utilities.Utilities.limpaComponentes(false, this.cadastroCarteirinhaView.getjPanelMeio());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCarteirinhaView.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(false, this.cadastroCarteirinhaView.getjPanelFim());
            utilities.Utilities.limpaComponentes(true, this.cadastroCarteirinhaView.getjPanelMeio());
            this.cadastroCarteirinhaView.getjTextFieldID().setEnabled(false);
            this.cadastroCarteirinhaView.getjFormattedTextFieldRG1().setEnabled(false);
            this.cadastroCarteirinhaView.getjFormattedTextFieldCPF().setEnabled(false);
            this.cadastroCarteirinhaView.getNomeCliente().setEnabled(false);
            this.cadastroCarteirinhaView.getjTextFieldMatricula().setEnabled(false);
            this.cadastroCarteirinhaView.getjFormattedTextFieldDataNascimento().setEnabled(false);
            this.cadastroCarteirinhaView.getjTextFieldMatricula().setEditable(false);

        } else if (e.getSource() == this.cadastroCarteirinhaView.getjButtonSair()) {
            this.cadastroCarteirinhaView.dispose();

        } else if (e.getSource() == this.cadastroCarteirinhaView.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.cadastroCarteirinhaView.getjPanelFim());
            utilities.Utilities.limpaComponentes(false, this.cadastroCarteirinhaView.getjPanelMeio());

        } else if (e.getSource() == this.cadastroCarteirinhaView.getjButtonBuscar()) {

            codigo = 0;
            CarteirinhaView carteirinhaView = new CarteirinhaView(null, true);
            ControllerCarteirinhaView controllerCarteirinhaView = new ControllerCarteirinhaView(carteirinhaView);
            carteirinhaView.setVisible(true);

            if (codigo != 0) {
                Carteirinha carteirinha = new Carteirinha();
                carteirinha = Service.CarteirinhaService.carregar(codigo);
                utilities.Utilities.ativaDesativa(false, this.cadastroCarteirinhaView.getjPanelFim());
                utilities.Utilities.limpaComponentes(true, this.cadastroCarteirinhaView.getjPanelMeio());

                this.cadastroCarteirinhaView.getjTextFieldID().setText(carteirinha.getId() + "");
                this.cadastroCarteirinhaView.getjTextFieldCodigoDeBarra().setText(carteirinha.getCodigoBarra() + "");
                this.cadastroCarteirinhaView.getDataGeracao().setText(carteirinha.getDataGeracao() + "");
                this.cadastroCarteirinhaView.getDataCancelamento().setText(carteirinha.getDataCancelamento() + "");
                this.cadastroCarteirinhaView.getjFormattedTextFieldCPF().setText(carteirinha.getCliente().getCpf() + "");
                this.cadastroCarteirinhaView.getjFormattedTextFieldRG1().setText(carteirinha.getCliente().getRg() + "");
                this.cadastroCarteirinhaView.getjTextFieldMatricula().setText(carteirinha.getCliente().getMatricula() + "");
                this.cadastroCarteirinhaView.getjFormattedTextFieldDataNascimento().setText(carteirinha.getCliente().getDataNascimento() + "");
                this.cadastroCarteirinhaView.getNomeCliente().setText(carteirinha.getCliente().getNome() + "");
                this.cadastroCarteirinhaView.getStatus().setSelectedItem(carteirinha.getStatus() + "");

                this.cadastroCarteirinhaView.getStatus().setEnabled(true);
                this.cadastroCarteirinhaView.getjTextFieldID().setEnabled(false);
                this.cadastroCarteirinhaView.getjTextFieldCodigoDeBarra().setEnabled(true);
                this.cadastroCarteirinhaView.getDataGeracao().setEnabled(true);
                this.cadastroCarteirinhaView.getDataCancelamento().setEnabled(true);
                this.cadastroCarteirinhaView.getjFormattedTextFieldCPF().setEnabled(false);
                this.cadastroCarteirinhaView.getjFormattedTextFieldRG1().setEnabled(false);
                this.cadastroCarteirinhaView.getjTextFieldMatricula().setEnabled(false);
                this.cadastroCarteirinhaView.getjFormattedTextFieldDataNascimento().setEnabled(false);
                this.cadastroCarteirinhaView.getNomeCliente().setEnabled(false);
            }

        } else if (e.getSource() == this.cadastroCarteirinhaView.getjButtonGravar()) {
            Component componente = utilities.Utilities.campoVazios(this.cadastroCarteirinhaView.getjPanelMeio());
            if ( componente instanceof JButton) {
                Carteirinha carteirinha = new Carteirinha();
                Cliente cliente = new Cliente();

                carteirinha.setCliente(cliente);

                carteirinha.setStatus(this.cadastroCarteirinhaView.getStatus().getSelectedItem().toString());
                carteirinha.setCodigoBarra(this.cadastroCarteirinhaView.getjTextFieldCodigoDeBarra().getText());
                carteirinha.setDataGeracao(this.cadastroCarteirinhaView.getDataGeracao().getText());
                carteirinha.setDataCancelamento(this.cadastroCarteirinhaView.getDataCancelamento().getText());
                carteirinha.getCliente().setCpf(this.cadastroCarteirinhaView.getjFormattedTextFieldCPF().getText());
                carteirinha.getCliente().setRg(this.cadastroCarteirinhaView.getjFormattedTextFieldRG1().getText());
                carteirinha.getCliente().setMatricula(this.cadastroCarteirinhaView.getjTextFieldMatricula().getText());
                carteirinha.getCliente().setDataNascimento(this.cadastroCarteirinhaView.getjFormattedTextFieldDataNascimento().getText());
                carteirinha.getCliente().setNome(this.cadastroCarteirinhaView.getNomeCliente().getText());
                if (this.cadastroCarteirinhaView.getjTextFieldID().getText().equalsIgnoreCase("")) {
                    Service.CarteirinhaService.adicionar(carteirinha);

                } else {
                    carteirinha.setId(Integer.parseInt(this.cadastroCarteirinhaView.getjTextFieldID().getText()));
                    Service.CarteirinhaService.atualizar(carteirinha);
                }
                utilities.Utilities.ativaDesativa(true, this.cadastroCarteirinhaView.getjPanelFim());
                utilities.Utilities.limpaComponentes(false, this.cadastroCarteirinhaView.getjPanelMeio());
            } else {
                JOptionPane.showMessageDialog(null, "Existem campos vazios!");
                componente.requestFocus();
            }
        } else if (e.getSource() == this.cadastroCarteirinhaView.getjButtonCliente()) {
            ClienteView clienteView = new ClienteView(null, true);
            ControllerClienteView controllerClienteView = new ControllerClienteView(clienteView);
            clienteView.setVisible(true);

            this.cadastroCarteirinhaView.getNomeCliente().setText(controllerClienteView.clienteNome);
            this.cadastroCarteirinhaView.getjFormattedTextFieldCPF().setText(controllerClienteView.clienteCPF);
            this.cadastroCarteirinhaView.getjFormattedTextFieldRG1().setText(controllerClienteView.clienteRG);
            this.cadastroCarteirinhaView.getjTextFieldMatricula().setText(controllerClienteView.clienteMatricula);
            this.cadastroCarteirinhaView.getjFormattedTextFieldDataNascimento().setText(controllerClienteView.clienteDataNascimento);
        }

    }

}
