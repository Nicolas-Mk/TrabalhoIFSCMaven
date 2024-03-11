/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Busca;

import static DAO.Persiste.funcionarioList;
import Service.FuncionarioService;
import controller.cadastro.ControllerCadastroFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Funcionario;
import view.Busca.FuncionarioView;

/**
 *
 * @author joao-
 */
public class ControllerFuncionarioView implements ActionListener {
    
    
    public static String colunaFiltro;
    FuncionarioView funcionarioView;
    
    public ControllerFuncionarioView(FuncionarioView funcionarioView) {
        this.funcionarioView = funcionarioView;

        this.funcionarioView.getjButtonCarregar().addActionListener(this);
        this.funcionarioView.getjButtonSair().addActionListener(this);
        this.funcionarioView.getjButtonBuscar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.funcionarioView.getjButtonCarregar()) {
            ControllerCadastroFuncionario.codigo = (int) this.funcionarioView.getjTable1().getValueAt(this.funcionarioView.getjTable1().getSelectedRow(), 0);
            FuncionarioService.carregar();
            this.funcionarioView.dispose();
            

        } else if (e.getSource() == this.funcionarioView.getjButtonSair()) {
            this.funcionarioView.dispose();

        } else if (e.getSource() == this.funcionarioView.getjButtonBuscar()) {
            if (this.funcionarioView.getjTextFieldBuscar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");
            }
            else{
                List<Funcionario> funcionarioList = new ArrayList<>();
                if(this.funcionarioView.getComboBoxFiltrar().getSelectedIndex() == 0){
                    funcionarioList.add(FuncionarioService.carregar(Integer.parseInt(this.funcionarioView.getjTextFieldBuscar().getText())));
                } else {
                    colunaFiltro = this.funcionarioView.getComboBoxFiltrar().getSelectedItem().toString().trim();
                    funcionarioList = FuncionarioService.carregar(this.funcionarioView.getjTextFieldBuscar().getText().trim());
                    
                }
                

            DefaultTableModel tabela = (DefaultTableModel) this.funcionarioView.getjTable1().getModel();
            tabela.setRowCount(0);
            for (Funcionario funcionarioAtual : funcionarioList) {
                tabela.addRow(new Object[]{funcionarioAtual.getId(),
                    funcionarioAtual.getNome(),
                    funcionarioAtual.getCpf(),
                    funcionarioAtual.getRg(),
                    funcionarioAtual.getUsuario(),
                    funcionarioAtual.getSenha(),
                    funcionarioAtual.getFone1(),
                    funcionarioAtual.getFone2(),
                    funcionarioAtual.getEmail(),
                    funcionarioAtual.getStatus(),
                    funcionarioAtual.getEndereco().getLogradouro(),
                    funcionarioAtual.getEndereco().getCep(),
                    funcionarioAtual.getComplementoEndereco()

                });
            }
            }
        }

    }

}
