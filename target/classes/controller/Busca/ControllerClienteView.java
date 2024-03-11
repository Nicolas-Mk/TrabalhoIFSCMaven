/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Busca;

import Service.ClienteService;
import controller.cadastro.ControllerCadastroCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
import view.Busca.ClienteView;

/**
 *
 * @author joao-
 */
public class ControllerClienteView implements ActionListener {

    public static String colunaFiltro;
    public String clienteNome;
    public String clienteCPF;
    public String clienteRG;
    public String clienteMatricula;
    public String clienteDataNascimento;
    public int clienteID;

    ClienteView clienteView;

    public ControllerClienteView(ClienteView clienteView) {
        this.clienteView = clienteView;

        this.clienteView.getjButtonCarregar().addActionListener(this);
        this.clienteView.getjButtonSair().addActionListener(this);
        this.clienteView.getjButtonBuscar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.clienteView.getjButtonCarregar()) {
            ControllerCadastroCliente.codigo = (int) this.clienteView.getjTable1().getValueAt(this.clienteView.getjTable1().getSelectedRow(), 0);
            clienteNome = (String) this.clienteView.getjTable1().getValueAt(this.clienteView.getjTable1().getSelectedRow(), 2);
            clienteCPF = (String) this.clienteView.getjTable1().getValueAt(this.clienteView.getjTable1().getSelectedRow(), 3);
            clienteRG = (String) this.clienteView.getjTable1().getValueAt(this.clienteView.getjTable1().getSelectedRow(), 4);
            clienteMatricula = (String) this.clienteView.getjTable1().getValueAt(this.clienteView.getjTable1().getSelectedRow(), 1);
            clienteDataNascimento = (String) this.clienteView.getjTable1().getValueAt(this.clienteView.getjTable1().getSelectedRow(), 5);
            clienteID =   (int) this.clienteView.getjTable1().getValueAt(this.clienteView.getjTable1().getSelectedRow(), 0);

            ClienteService.carregar();
            this.clienteView.dispose();

        } else if (e.getSource() == this.clienteView.getjButtonSair()) {
            this.clienteView.dispose();

        } else if (e.getSource() == this.clienteView.getjButtonBuscar()) {

            if (this.clienteView.getjTextFieldBuscar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");

            } else {
                
                
                List<Cliente> clienteList = new ArrayList<>();

                if (this.clienteView.getComboBoxFiltrar().getSelectedIndex() == 0) {
                    clienteList.add(ClienteService.carregar(Integer.parseInt(this.clienteView.getjTextFieldBuscar().getText())));
                } else {

                    colunaFiltro = this.clienteView.getComboBoxFiltrar().getSelectedItem().toString().trim();
                    clienteList = ClienteService.carregar(this.clienteView.getjTextFieldBuscar().getText().trim());
                }

                DefaultTableModel tabela = (DefaultTableModel) this.clienteView.getjTable1().getModel();
                tabela.setRowCount(0);
                for (Cliente clienteAtual : clienteList) {
                    tabela.addRow(new Object[]{clienteAtual.getId(),
                        clienteAtual.getMatricula(),
                        clienteAtual.getNome(),
                        clienteAtual.getCpf(),
                        clienteAtual.getRg(),
                        clienteAtual.getDataNascimento(),
                        clienteAtual.getFone1(),
                        clienteAtual.getFone2(),
                        clienteAtual.getEmail(),
                        clienteAtual.getStatus(),
                        clienteAtual.getEndereco().getLogradouro(),
                        clienteAtual.getEndereco().getCep(),
                        clienteAtual.getComplementoEndereco()

                    });
                }
            }

        }

    }
}
