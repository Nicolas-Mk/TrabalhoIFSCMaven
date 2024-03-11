/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Compra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Compra.AbreCaixaView;
import view.Compra.PontoDeVendaView;

public class ControllerAbrirCaixa implements ActionListener {

    AbreCaixaView abreCaixaView;

    public ControllerAbrirCaixa(AbreCaixaView abreCaixaView) {
        this.abreCaixaView = abreCaixaView;
        
        this.abreCaixaView.getBotaoAbrirCaixa().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.abreCaixaView.getBotaoAbrirCaixa()) {
            PontoDeVendaView pontoDeVendaView = new PontoDeVendaView(null, true);
            ControllerPontoDeVenda controllerPontoDeVenda = new ControllerPontoDeVenda(pontoDeVendaView);
            pontoDeVendaView.getIdFuncionario().setText(this.abreCaixaView.getIdFuncionario().getText().toString().trim());
            abreCaixaView.dispose();
            pontoDeVendaView.setVisible(true);
            
        }

    }

}
