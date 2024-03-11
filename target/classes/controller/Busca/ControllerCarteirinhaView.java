/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Busca;

import Service.CarteirinhaService;
import controller.cadastro.ControllerCadastroCarteirinha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Carteirinha;
import view.Busca.CarteirinhaView;

/**
 *
 * @author joao-
 */
public class ControllerCarteirinhaView implements ActionListener {

    public static String colunaFiltro;
    CarteirinhaView carteirinhaView;

    public ControllerCarteirinhaView(CarteirinhaView carteirinhaView) {
        this.carteirinhaView = carteirinhaView;

        this.carteirinhaView.getjButtonCarregar().addActionListener(this);
        this.carteirinhaView.getjButtonSair().addActionListener(this);
        this.carteirinhaView.getjButtonBuscar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.carteirinhaView.getjButtonCarregar()) {
            ControllerCadastroCarteirinha.codigo = (int) this.carteirinhaView.getjTable1().getValueAt(this.carteirinhaView.getjTable1().getSelectedRow(), 0);

            CarteirinhaService.carregar();
            this.carteirinhaView.dispose();

        } else if (e.getSource() == this.carteirinhaView.getjButtonSair()) {
            this.carteirinhaView.dispose();

        } else if (e.getSource() == this.carteirinhaView.getjButtonBuscar()) {
            
            if (this.carteirinhaView.getjTextFieldBuscar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");
            } else {
                
                
                List<Carteirinha> carteirinhaList = new ArrayList<>();
                
                
                if(this.carteirinhaView.getComboBoxFiltrar().getSelectedIndex() == 0){
                carteirinhaList.add(CarteirinhaService.carregar(Integer.parseInt(this.carteirinhaView.getjTextFieldBuscar().getText())));
                }
                else{
                colunaFiltro = this.carteirinhaView.getComboBoxFiltrar().getSelectedItem().toString().trim();
                carteirinhaList = CarteirinhaService.carregar(this.carteirinhaView.getjTextFieldBuscar().getText().trim());
                    
                }
                

                DefaultTableModel tabela = (DefaultTableModel) this.carteirinhaView.getjTable1().getModel();
                tabela.setRowCount(0);
                for (Carteirinha carteirinhaAtual : carteirinhaList) {
                    tabela.addRow(new Object[]{carteirinhaAtual.getId(),
                        carteirinhaAtual.getCodigoBarra(),
                        carteirinhaAtual.getDataGeracao(),
                        carteirinhaAtual.getDataCancelamento(),
                        carteirinhaAtual.getCliente().getMatricula(),
                        carteirinhaAtual.getCliente().getNome(),
                        carteirinhaAtual.getCliente().getCpf(),
                        carteirinhaAtual.getCliente().getRg(),
                        carteirinhaAtual.getCliente().getDataNascimento(),
                        carteirinhaAtual.getStatus()
                            

                    });

                }

            }

        }
    }
}
