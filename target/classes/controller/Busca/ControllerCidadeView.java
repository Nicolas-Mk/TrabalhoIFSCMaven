/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Busca;

import Service.CidadeService;
import Service.EnderecoService;
import controller.cadastro.ControllerCadastroCidade;
import static controller.cadastro.ControllerCadastroCidade.codigo;
import controller.cadastro.ControllerCadastroEndereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Cidade;
import view.Busca.CidadeView;
import view.Cadastro.CadastroEnderecoView;

/**
 *
 * @author joao-
 */
public class ControllerCidadeView implements ActionListener {

    public static String colunaFiltro;
    public static String cidadeEnderenco;
  
    CidadeView cidadeView;
    

    public ControllerCidadeView(CidadeView cidadeView) {

        this.cidadeView = cidadeView;
        this.cidadeView.getjButtonCarregar().addActionListener(this);
        this.cidadeView.getjButtonSair().addActionListener(this);
        this.cidadeView.getjButtonBusca().addActionListener(this);

    }

        @Override
        public void actionPerformed
        (ActionEvent e
        
            ) {
        if (e.getSource() == this.cidadeView.getjButtonCarregar()) {

                ControllerCadastroCidade.codigo = (int) this.cidadeView.getjTable1().getValueAt(this.cidadeView.getjTable1().getSelectedRow(), 0);
                cidadeEnderenco = (String) this.cidadeView.getjTable1().getValueAt(this.cidadeView.getjTable1().getSelectedRow(), 1);
                
                
                
                
                this.cidadeView.dispose();

            } else if (e.getSource() == this.cidadeView.getjButtonSair()) {
                this.cidadeView.dispose();

            } else if (e.getSource() == cidadeView.getjButtonBusca()) {

                if (this.cidadeView.getjTextFieldBuscar().getText().trim().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");
                } else {
                    List<Cidade> cidadeList = new ArrayList<>();

                    if (this.cidadeView.getComboBoxFiltrar().getSelectedIndex() == 0) {
                        cidadeList.add(CidadeService.carregar(Integer.parseInt(this.cidadeView.getjTextFieldBuscar().getText())));
                    } else  {
                        colunaFiltro = this.cidadeView.getComboBoxFiltrar().getSelectedItem().toString().trim();
                        cidadeList = CidadeService.carregar(this.cidadeView.getjTextFieldBuscar().getText());
                    }
                    
                    DefaultTableModel tabela = (DefaultTableModel) this.cidadeView.getjTable1().getModel();
                    tabela.setRowCount(0);
                    for (Cidade cidadeAtual : cidadeList) {
                        tabela.addRow(new Object[]{cidadeAtual.getId(),
                            cidadeAtual.getDescricao(),
                            cidadeAtual.getUf()
                        });
                    }

                }

            }

        }

    }
