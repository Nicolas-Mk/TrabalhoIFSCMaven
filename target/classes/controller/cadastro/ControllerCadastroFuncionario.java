/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.cadastro;

import controller.Busca.ControllerEnderecoView;
import controller.Busca.ControllerFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Endereco;
import model.bo.Funcionario;
import view.Busca.EnderecoView;
import view.Busca.FuncionarioView;
import view.Cadastro.CadastroEnderecoView;
import view.Cadastro.CadastroFuncionarioView;

/**
 *
 * @author WMW
 */
public class ControllerCadastroFuncionario implements ActionListener {

    CadastroFuncionarioView cadastroFuncionarioView;

    public static int codigo;

    public ControllerCadastroFuncionario(CadastroFuncionarioView cadastroFuncionarioView) {

        this.cadastroFuncionarioView = cadastroFuncionarioView;

        this.cadastroFuncionarioView.getjButtonNovo().addActionListener(this);
        this.cadastroFuncionarioView.getjButtonSair().addActionListener(this);
        this.cadastroFuncionarioView.getjButtonCancelar().addActionListener(this);
        this.cadastroFuncionarioView.getjButtonGravar().addActionListener(this);
        this.cadastroFuncionarioView.getjButtonBuscar().addActionListener(this);
        this.cadastroFuncionarioView.getjButtonEndereco().addActionListener(this);
        this.cadastroFuncionarioView.getjButtonCadastroEndereco1().addActionListener(this);

        utilities.Utilities.ativaDesativa(true, this.cadastroFuncionarioView.getjPanelFim());
        utilities.Utilities.limpaComponentes(false, this.cadastroFuncionarioView.getjPanelMeio());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroFuncionarioView.getjButtonNovo()) {

            utilities.Utilities.ativaDesativa(false, this.cadastroFuncionarioView.getjPanelFim());
            utilities.Utilities.limpaComponentes(true, this.cadastroFuncionarioView.getjPanelMeio());

            this.cadastroFuncionarioView.getEnderecoLogradouro().setEnabled(false);
            this.cadastroFuncionarioView.getCEP().setEnabled(false);
            this.cadastroFuncionarioView.getID().setEnabled(false);

        } else if (e.getSource() == this.cadastroFuncionarioView.getjButtonSair()) {
            this.cadastroFuncionarioView.dispose();

        } else if (e.getSource() == this.cadastroFuncionarioView.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.cadastroFuncionarioView.getjPanelFim());
            utilities.Utilities.limpaComponentes(false, this.cadastroFuncionarioView.getjPanelMeio());

        } else if (e.getSource() == this.cadastroFuncionarioView.getjButtonEndereco()) {
            EnderecoView enderecoView = new EnderecoView(null, true);
            ControllerEnderecoView controllerEnderecoView = new ControllerEnderecoView(enderecoView);
            enderecoView.setVisible(true);

            this.cadastroFuncionarioView.getEnderecoLogradouro().setText(controllerEnderecoView.logradouroEndereco);
            this.cadastroFuncionarioView.getCEP().setText(controllerEnderecoView.enderecoCEP);
        } else if (e.getSource() == this.cadastroFuncionarioView.getjButtonBuscar()) {

            codigo = 0;

            FuncionarioView funcionarioView = new FuncionarioView(null, true);
            ControllerFuncionarioView controllerFuncionarioView = new ControllerFuncionarioView(funcionarioView);
            funcionarioView.setVisible(true);

            if (codigo != 0) {

                Funcionario funcionario = new Funcionario();
                funcionario = Service.FuncionarioService.carregar(codigo);

                utilities.Utilities.ativaDesativa(false, this.cadastroFuncionarioView.getjPanelFim());
                utilities.Utilities.limpaComponentes(true, this.cadastroFuncionarioView.getjPanelMeio());

                this.cadastroFuncionarioView.getID().setText(funcionario.getId() + "");
                this.cadastroFuncionarioView.getNome().setText(funcionario.getNome() + "");
                this.cadastroFuncionarioView.getCelular().setText(funcionario.getFone1() + "");
                this.cadastroFuncionarioView.getTelefone().setText(funcionario.getFone2() + "");
                this.cadastroFuncionarioView.getEmail().setText(funcionario.getEmail() + "");
                this.cadastroFuncionarioView.getStatus().setSelectedItem(funcionario.getStatus().toString() + "");
                this.cadastroFuncionarioView.getComplemento().setText(funcionario.getComplementoEndereco() + "");
                this.cadastroFuncionarioView.getEnderecoLogradouro().setText(funcionario.getEndereco().getLogradouro() + "");
                this.cadastroFuncionarioView.getCEP().setText(funcionario.getEndereco().getCep() + "");
                this.cadastroFuncionarioView.getCPF().setText(funcionario.getCpf() + "");
                this.cadastroFuncionarioView.getRG().setText(funcionario.getRg() + "");
                this.cadastroFuncionarioView.getUsuario().setText(funcionario.getUsuario() + "");
                this.cadastroFuncionarioView.getSenha().setText(funcionario.getSenha());

                this.cadastroFuncionarioView.getID().setEnabled(false);
                this.cadastroFuncionarioView.getNome().setEnabled(true);
                this.cadastroFuncionarioView.getCelular().setEnabled(true);
                this.cadastroFuncionarioView.getTelefone().setEnabled(true);
                this.cadastroFuncionarioView.getEmail().setEnabled(true);
                this.cadastroFuncionarioView.getStatus().setEnabled(true);
                this.cadastroFuncionarioView.getComplemento().setEnabled(true);
                this.cadastroFuncionarioView.getEnderecoLogradouro().setEnabled(false);
                this.cadastroFuncionarioView.getCEP().setEnabled(false);
                this.cadastroFuncionarioView.getCPF().setEnabled(true);
                this.cadastroFuncionarioView.getRG().setEnabled(true);
                this.cadastroFuncionarioView.getUsuario().setEnabled(true);
                this.cadastroFuncionarioView.getSenha().setEnabled(true);
            }

        } else if (e.getSource() == this.cadastroFuncionarioView.getjButtonGravar()) {

            if(utilities.Utilities.campoVazio(this.cadastroFuncionarioView.getjPanelMeio()) == true)
            {
                JOptionPane.showMessageDialog(null, "Existem campos vazios!");
               
            }
            else{
            Funcionario funcionario = new Funcionario();
            Endereco endereco = new Endereco();
            
            
            funcionario.setEndereco(endereco);
            funcionario.setNome(this.cadastroFuncionarioView.getNome().getText());
            funcionario.setFone1(this.cadastroFuncionarioView.getCelular().getText());
            funcionario.setFone2(this.cadastroFuncionarioView.getTelefone().getText());
            funcionario.setEmail(this.cadastroFuncionarioView.getEmail().getText());
            funcionario.setStatus(this.cadastroFuncionarioView.getStatus().getSelectedItem().toString());
            funcionario.setComplementoEndereco(this.cadastroFuncionarioView.getComplemento().getText());
            funcionario.getEndereco().setLogradouro(this.cadastroFuncionarioView.getEnderecoLogradouro().getText());
            funcionario.getEndereco().setCep(this.cadastroFuncionarioView.getCEP().getText());
            funcionario.setCpf(this.cadastroFuncionarioView.getCPF().getText());
            funcionario.setRg(this.cadastroFuncionarioView.getRG().getText());
            funcionario.setUsuario(this.cadastroFuncionarioView.getUsuario().getText());
            funcionario.setSenha(this.cadastroFuncionarioView.getSenha().getPassword().toString());

            if (this.cadastroFuncionarioView.getID().getText().trim().equalsIgnoreCase("")) {
                //Codigo para incluir
                Service.FuncionarioService.adicionar(funcionario);

            } else {
                funcionario.setId(Integer.parseInt(this.cadastroFuncionarioView.getID().getText().trim()));
                Service.FuncionarioService.atualizar(funcionario);
            }
            
            utilities.Utilities.ativaDesativa(true, this.cadastroFuncionarioView.getjPanelFim());
            utilities.Utilities.limpaComponentes(false, this.cadastroFuncionarioView.getjPanelMeio());
            }


        }
        
        else if(e.getSource() == this.cadastroFuncionarioView.getjButtonCadastroEndereco1()){
            CadastroEnderecoView cadastroEnderecoView = new CadastroEnderecoView(null, true);
            ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(cadastroEnderecoView);
            cadastroEnderecoView.setVisible(true);
        }

    }
}
