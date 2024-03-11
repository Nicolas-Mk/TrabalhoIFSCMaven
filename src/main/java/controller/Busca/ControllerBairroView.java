/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Busca;

import Service.BairroService;
import controller.cadastro.ControllerCadastroBairro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import view.Busca.BairroView;

/**
 *
 * @author joao-
 */
public class ControllerBairroView implements ActionListener {
    
   
    BairroView bairroView;
    public static String bairroEndereco;

    public ControllerBairroView(BairroView bairroView) {
        this.bairroView = bairroView;
       
        this.bairroView.getjButtonCarregar().addActionListener(this);
        this.bairroView.getjButtonSair().addActionListener(this);
        this.bairroView.getjButtonBusca().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.bairroView.getjButtonCarregar()) {   
           ControllerCadastroBairro.codigo1 = (int) this.bairroView.getjTableLista().getValueAt(this.bairroView.getjTableLista().getSelectedRow(), 0);
           bairroEndereco = (String) bairroView.getjTableLista().getValueAt(this.bairroView.getjTableLista().getSelectedRow(), 1);
           
           
           this.bairroView.dispose();

        } else if (e.getSource() == this.bairroView.getjButtonSair()) {
            this.bairroView.dispose();

        } else if (e.getSource() == this.bairroView.getjButtonBusca()) {
            if (this.bairroView.getjTextBuscar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");

            } else {
                List<Bairro> bairroList = new ArrayList<>();
                if (this.bairroView.getComboBoxFiltrar().getSelectedIndex() == 0) {
                    bairroList.add(BairroService.carregar(Integer.parseInt(this.bairroView.getjTextBuscar().getText())));

                } else if (this.bairroView.getComboBoxFiltrar().getSelectedIndex() == 1) {
                    bairroList = BairroService.carregar(this.bairroView.getjTextBuscar().getText().trim());

                }

                DefaultTableModel tableLista = (DefaultTableModel) this.bairroView.getjTableLista().getModel();
                tableLista.setRowCount(0);
                for (Bairro bairroAtual : bairroList) {
                    tableLista.addRow(new Object[]{bairroAtual.getId(),
                                                   bairroAtual.getDescricao()
                    });

                }
            }

        }

    }

}
