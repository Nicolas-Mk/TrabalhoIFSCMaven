/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.cadastro;

import controller.Busca.ControllerClienteView;
import controller.Busca.ControllerEnderecoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Cliente;
import model.bo.Endereco;
import view.Busca.ClienteView;
import view.Cadastro.CadastroClienteView;
import view.Cadastro.CadastroEnderecoView;
import view.Busca.EnderecoView;

/**
 *
 * @author WMW
 */
public class ControllerCadastroCliente implements ActionListener {

    CadastroClienteView cadastroClienteView;

    public static int codigo;

    public ControllerCadastroCliente(CadastroClienteView cadastroClienteView) {

        this.cadastroClienteView = cadastroClienteView;

        this.cadastroClienteView.getjButtonNovo().addActionListener(this);
        this.cadastroClienteView.getjButtonSair().addActionListener(this);
        this.cadastroClienteView.getjButtonCancelar().addActionListener(this);
        this.cadastroClienteView.getjButtonGravar().addActionListener(this);
        this.cadastroClienteView.getjButtonBuscar().addActionListener(this);
        this.cadastroClienteView.getjButtonEndereco().addActionListener(this);
        this.cadastroClienteView.getjButtonCadastroEndereco().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.cadastroClienteView.getjPanelFim());
        utilities.Utilities.limpaComponentes(false, this.cadastroClienteView.getjPanelMeio());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroClienteView.getjButtonNovo()) {

            utilities.Utilities.ativaDesativa(false, this.cadastroClienteView.getjPanelFim());
            utilities.Utilities.limpaComponentes(true, this.cadastroClienteView.getjPanelMeio());

            this.cadastroClienteView.getID().setEnabled(false);
            this.cadastroClienteView.getEnderecoLogradouro().setEnabled(false);
            this.cadastroClienteView.getCEP().setEnabled(false);

        } else if (e.getSource() == this.cadastroClienteView.getjButtonSair()) {
            this.cadastroClienteView.dispose();

        } else if (e.getSource() == this.cadastroClienteView.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.cadastroClienteView.getjPanelFim());
            utilities.Utilities.limpaComponentes(false, this.cadastroClienteView.getjPanelMeio());

        } else if (e.getSource() == this.cadastroClienteView.getjButtonEndereco()) {

            EnderecoView enderecoView = new EnderecoView(null, true);
            ControllerEnderecoView controllerEnderecoView = new ControllerEnderecoView(enderecoView);
            enderecoView.setVisible(true);

            this.cadastroClienteView.getEnderecoLogradouro().setText(controllerEnderecoView.logradouroEndereco);
            this.cadastroClienteView.getCEP().setText(controllerEnderecoView.enderecoCEP);

        } else if (e.getSource() == this.cadastroClienteView.getjButtonBuscar()) {

            codigo = 0;

            ClienteView clienteView = new ClienteView(null, true);
            ControllerClienteView controllerClienteView = new ControllerClienteView(clienteView);
            clienteView.setVisible(true);

            if (codigo != 0) {

                Cliente cliente = new Cliente();
                cliente = Service.ClienteService.carregar(codigo);
                utilities.Utilities.ativaDesativa(false, this.cadastroClienteView.getjPanelFim());
                utilities.Utilities.limpaComponentes(true, this.cadastroClienteView.getjPanelMeio());

                this.cadastroClienteView.getID().setText(cliente.getId() + "");
                this.cadastroClienteView.getMatricula().setText(cliente.getMatricula() + "");
                this.cadastroClienteView.getNome().setText(cliente.getNome() + "");
                this.cadastroClienteView.getCPF().setText(cliente.getCpf() + "");
                this.cadastroClienteView.getRG().setText(cliente.getRg() + "");
                this.cadastroClienteView.getDataNascismento().setText(cliente.getDataNascimento() + "");
                this.cadastroClienteView.getCelular().setText(cliente.getFone1() + "");
                this.cadastroClienteView.getTelefone().setText(cliente.getFone2() + "");
                this.cadastroClienteView.getEmail().setText(cliente.getEmail() + " ");
                this.cadastroClienteView.getStatus().setSelectedItem(cliente.getStatus().toString() + "");
                this.cadastroClienteView.getComplemento().setText(cliente.getComplementoEndereco() + "");
                this.cadastroClienteView.getEnderecoLogradouro().setText(cliente.getEndereco().getLogradouro() + "");
                this.cadastroClienteView.getCEP().setText(cliente.getEndereco().getCep() + "");

                this.cadastroClienteView.getID().setEnabled(false);
                this.cadastroClienteView.getMatricula().setEnabled(true);
                this.cadastroClienteView.getNome().setEnabled(true);
                this.cadastroClienteView.getCPF().setEnabled(true);
                this.cadastroClienteView.getRG().setEnabled(true);
                this.cadastroClienteView.getDataNascismento().setEnabled(true);
                this.cadastroClienteView.getCelular().setEnabled(true);
                this.cadastroClienteView.getTelefone().setEnabled(true);
                this.cadastroClienteView.getEmail().setEnabled(true);
                this.cadastroClienteView.getStatus().setEnabled(true);
                this.cadastroClienteView.getComplemento().setEnabled(true);
                this.cadastroClienteView.getEnderecoLogradouro().setEnabled(false);
                this.cadastroClienteView.getCEP().setEnabled(false);

            }

        } else if (e.getSource() == this.cadastroClienteView.getjButtonGravar()) {

            if (utilities.Utilities.campoVazio(this.cadastroClienteView.getjPanelMeio()) == true) {
                JOptionPane.showMessageDialog(null, "Existem campos vazios!");

            } else {

                Endereco endereco = new Endereco();
                Cliente cliente = new Cliente();

                cliente.setEndereco(endereco);
                cliente.setMatricula(this.cadastroClienteView.getMatricula().getText());
                cliente.setNome(this.cadastroClienteView.getNome().getText());
                cliente.setCpf(this.cadastroClienteView.getCPF().getText());
                cliente.setRg(this.cadastroClienteView.getRG().getText());

                cliente.setDataNascimento(this.cadastroClienteView.getDataNascismento().getText());

                cliente.setFone1(this.cadastroClienteView.getCelular().getText());
                cliente.setFone2(this.cadastroClienteView.getTelefone().getText());
                cliente.setEmail(this.cadastroClienteView.getEmail().getText());
                cliente.setStatus(this.cadastroClienteView.getStatus().getSelectedItem().toString());
                cliente.setComplementoEndereco(this.cadastroClienteView.getComplemento().getText());
                cliente.getEndereco().setLogradouro(this.cadastroClienteView.getEnderecoLogradouro().getText());
                cliente.getEndereco().setCep(this.cadastroClienteView.getCEP().getText());

                if (this.cadastroClienteView.getEnderecoLogradouro().getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Informe o Endereco do Cliente!");
                } else {

                    if (this.cadastroClienteView.getID().getText().trim().equalsIgnoreCase("")) {
                        //Codigo para incluir
                        Service.ClienteService.adicionar(cliente);

                    } else {
                        cliente.setId(Integer.parseInt(this.cadastroClienteView.getID().getText()));
                        Service.ClienteService.atualizar(cliente);

                    }
                    utilities.Utilities.ativaDesativa(true, this.cadastroClienteView.getjPanelFim());
                    utilities.Utilities.limpaComponentes(false, this.cadastroClienteView.getjPanelMeio());
                }
            }

        }
        
        
        
        else if(e.getSource() == this.cadastroClienteView.getjButtonCadastroEndereco()){
            CadastroEnderecoView cadastroEnderecoView = new CadastroEnderecoView(null, true);
            ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(cadastroEnderecoView);
            cadastroEnderecoView.setVisible(true);
            
        
        }

    }

}
