/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.cadastro;

import controller.Busca.ControllerEnderecoView;
import controller.Busca.ControllerFornecedorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Endereco;
import model.bo.Fornecedor;
import view.Busca.EnderecoView;
import view.Busca.FornecedorView;
import view.Cadastro.CadastroEnderecoView;
import view.Cadastro.CadastroFornecedorView;

/**
 *
 * @author WMW
 */
public class ControllerCadastroFornecedor implements ActionListener {
    
    CadastroFornecedorView cadastroFornecedorView;
    
    public static int codigo;
    
    public ControllerCadastroFornecedor(CadastroFornecedorView cadastroFornecedorView) {
        
        this.cadastroFornecedorView = cadastroFornecedorView;
        
        this.cadastroFornecedorView.getjButtonNovo().addActionListener(this);
        this.cadastroFornecedorView.getjButtonSair().addActionListener(this);
        this.cadastroFornecedorView.getjButtonCancelar().addActionListener(this);
        this.cadastroFornecedorView.getjButtonGravar().addActionListener(this);
        this.cadastroFornecedorView.getjButtonBuscar().addActionListener(this);
        this.cadastroFornecedorView.getjButtonEndereco().addActionListener(this);
        this.cadastroFornecedorView.getjButtonCadastroEndereco1().addActionListener(this);
        
        utilities.Utilities.ativaDesativa(true, this.cadastroFornecedorView.getjPanelFim());
        utilities.Utilities.limpaComponentes(false, this.cadastroFornecedorView.getjPanelMeio());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroFornecedorView.getjButtonNovo()) {
            
            utilities.Utilities.ativaDesativa(false, this.cadastroFornecedorView.getjPanelFim());
            utilities.Utilities.limpaComponentes(true, this.cadastroFornecedorView.getjPanelMeio());
            
            this.cadastroFornecedorView.getCidade().setEnabled(false);
            this.cadastroFornecedorView.getBairro().setEnabled(false);
            this.cadastroFornecedorView.getEnderecoLogradouro().setEnabled(false);
            this.cadastroFornecedorView.getCEP().setEnabled(false);
            this.cadastroFornecedorView.getID().setEnabled(false);
            
            
            
        } else if (e.getSource() == this.cadastroFornecedorView.getjButtonSair()) {
            this.cadastroFornecedorView.dispose();
            
        } else if (e.getSource() == this.cadastroFornecedorView.getjButtonCancelar()) {
            
            utilities.Utilities.ativaDesativa(true, this.cadastroFornecedorView.getjPanelFim());
            utilities.Utilities.limpaComponentes(false, this.cadastroFornecedorView.getjPanelMeio());
            
        } else if (e.getSource() == this.cadastroFornecedorView.getjButtonEndereco()) {
            
            EnderecoView enderecoView = new EnderecoView(null, true);
            ControllerEnderecoView controllerEnderecoView = new ControllerEnderecoView(enderecoView);
            enderecoView.setVisible(true);
            
            this.cadastroFornecedorView.getEnderecoLogradouro().setText(controllerEnderecoView.logradouroEndereco);
            this.cadastroFornecedorView.getCEP().setText(controllerEnderecoView.enderecoCEP);
            this.cadastroFornecedorView.getCidade().setText(controllerEnderecoView.enderecoCidade);
            this.cadastroFornecedorView.getBairro().setText(controllerEnderecoView.enderecoBairro);
            
        } else if (e.getSource() == this.cadastroFornecedorView.getjButtonBuscar()) {
            
            codigo = 0;
            
            FornecedorView fornecedorView = new FornecedorView(null, true);
            ControllerFornecedorView controllerFornecedorView = new ControllerFornecedorView(fornecedorView);
            fornecedorView.setVisible(true);
            
            if (codigo != 0) {
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor = Service.FornecedorService.carregar(codigo);
                
                utilities.Utilities.ativaDesativa(false, this.cadastroFornecedorView.getjPanelFim());
                utilities.Utilities.limpaComponentes(true, this.cadastroFornecedorView.getjPanelMeio());
                
                this.cadastroFornecedorView.getID().setText(fornecedor.getId() + "");
                this.cadastroFornecedorView.getNome().setText(fornecedor.getNome() + "");
                this.cadastroFornecedorView.getCelular().setText(fornecedor.getFone1() + "");
                this.cadastroFornecedorView.getTelefone().setText(fornecedor.getFone2() + "");
                this.cadastroFornecedorView.getEmail().setText(fornecedor.getEmail() + "");
                this.cadastroFornecedorView.getStatus().setSelectedItem(fornecedor.getStatus().toString() + "");                
                this.cadastroFornecedorView.getComplemento().setText(fornecedor.getComplementoEndereco() + "");
                this.cadastroFornecedorView.getCNPJ().setText(fornecedor.getCnpj().toString() + "");
                this.cadastroFornecedorView.getInscricaoEstadual().setText(fornecedor.getInscricaoEstadual().toString() + "");
                this.cadastroFornecedorView.getRazaoSocial().setText(fornecedor.getRazaoSocial().toString() + "");
                this.cadastroFornecedorView.getEnderecoLogradouro().setText(fornecedor.getEndereco().getLogradouro() + "");
                this.cadastroFornecedorView.getCEP().setText(fornecedor.getEndereco().getCep() + "");
                this.cadastroFornecedorView.getBairro().setText(fornecedor.getEndereco().getBairro().getDescricao() + "");
                this.cadastroFornecedorView.getCidade().setText(fornecedor.getEndereco().getCidade().getDescricao() + "");
           
                
                this.cadastroFornecedorView.getID().setEnabled(false);
                this.cadastroFornecedorView.getNome().setEnabled(true);
                this.cadastroFornecedorView.getCelular().setEnabled(true);
                this.cadastroFornecedorView.getTelefone().setEnabled(true);
                this.cadastroFornecedorView.getEmail().setEnabled(true);
                this.cadastroFornecedorView.getStatus().setEnabled(true);
                this.cadastroFornecedorView.getComplemento().setEnabled(true);
                this.cadastroFornecedorView.getCNPJ().setEnabled(true);
                this.cadastroFornecedorView.getRazaoSocial().setEnabled(true);
                this.cadastroFornecedorView.getInscricaoEstadual().setEnabled(true);
                this.cadastroFornecedorView.getEnderecoLogradouro().setEnabled(false);
                this.cadastroFornecedorView.getCEP().setEnabled(false);
                this.cadastroFornecedorView.getCidade().setEnabled(false);
                this.cadastroFornecedorView.getBairro().setEnabled(false);
                
            }
            
        } else if (e.getSource() == this.cadastroFornecedorView.getjButtonGravar()) {
            
            if (utilities.Utilities.campoVazio(this.cadastroFornecedorView.getjPanelMeio()) == true) {
                JOptionPane.showMessageDialog(null, "Existem campos vazios!");
                
            } else {
                Fornecedor fornecedor = new Fornecedor();
                Endereco endereco = new Endereco();
                
                fornecedor.setEndereco(endereco);
                fornecedor.setNome(this.cadastroFornecedorView.getNome().getText());
                fornecedor.setFone1(this.cadastroFornecedorView.getCelular().getText());
                fornecedor.setFone2(this.cadastroFornecedorView.getTelefone().getText());
                fornecedor.setEmail(this.cadastroFornecedorView.getEmail().getText());
                fornecedor.setStatus(this.cadastroFornecedorView.getStatus().getSelectedItem().toString());
                fornecedor.setCnpj(this.cadastroFornecedorView.getCNPJ().getText());
                fornecedor.setInscricaoEstadual(this.cadastroFornecedorView.getInscricaoEstadual().getText());
                fornecedor.setRazaoSocial(this.cadastroFornecedorView.getRazaoSocial().getText());
                fornecedor.setComplementoEndereco(this.cadastroFornecedorView.getComplemento().getText());
                
                fornecedor.getEndereco().setLogradouro(this.cadastroFornecedorView.getEnderecoLogradouro().getText());
                fornecedor.getEndereco().setCep(this.cadastroFornecedorView.getCEP().getText());
                
                if (this.cadastroFornecedorView.getID().getText().trim().equalsIgnoreCase("")) {
                    //Codigo para incluir
                    Service.FornecedorService.adicionar(fornecedor);
                    
                } else {
                    fornecedor.setId(Integer.parseInt(this.cadastroFornecedorView.getID().getText()));
                    Service.FornecedorService.atualizar(fornecedor);
                }
                
                utilities.Utilities.ativaDesativa(true, this.cadastroFornecedorView.getjPanelFim());
                utilities.Utilities.limpaComponentes(false, this.cadastroFornecedorView.getjPanelMeio());
            }
            
        } else if (e.getSource() == this.cadastroFornecedorView.getjButtonCadastroEndereco1()) {
            CadastroEnderecoView cadastroEnderecoView = new CadastroEnderecoView(null, true);
            ControllerCadastroEndereco controllerCadastroEndereco = new ControllerCadastroEndereco(cadastroEnderecoView);
            cadastroEnderecoView.setVisible(true);
            
        }
    }
}
