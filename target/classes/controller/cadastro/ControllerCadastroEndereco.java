package controller.cadastro;

import com.sun.source.tree.BreakTree;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Busca.BairroView;
import view.Busca.CidadeView;
import view.Busca.EnderecoView;
import view.Cadastro.CadastroEnderecoView;
import controller.Busca.ControllerEnderecoView;
import controller.Busca.ControllerCidadeView;
import controller.Busca.ControllerBairroView;
import static controller.cadastro.ControllerCadastroBairro.codigo1;
import javax.swing.JOptionPane;

import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;

public class ControllerCadastroEndereco implements ActionListener {

    // Criando um objeto global do tipo da tela que iremos controlar
    CadastroEnderecoView cadastroEnderecoView;
    public static int codigo;

    // Passando a tela que iremos controlar como parametro de invocação
    public ControllerCadastroEndereco(CadastroEnderecoView cadastroEnderecosView) {
        // Repassando o valor da Tela que iremos controlar como parametro para o objeto global
        this.cadastroEnderecoView = cadastroEnderecosView;

        // Adicionando ouvintes(Listerners) para escutar ações nos botões da tela
        this.cadastroEnderecoView.getjButtonNovo().addActionListener(this);
        this.cadastroEnderecoView.getjButtonSair().addActionListener(this);
        this.cadastroEnderecoView.getjButtonCancelar().addActionListener(this);
        this.cadastroEnderecoView.getjButtonGravar().addActionListener(this);
        this.cadastroEnderecoView.getjButtonBuscar().addActionListener(this);
        this.cadastroEnderecoView.getjButtonBairro().addActionListener(this);
        this.cadastroEnderecoView.getjButtonCidade().addActionListener(this);

        // Executando os métodos da classe de utilitarios
        // Para ativar/desativar/limpar botões e componentes diversos na tela
        utilities.Utilities.ativaDesativa(true, this.cadastroEnderecoView.getjPanelFim());
        utilities.Utilities.limpaComponentes(false, this.cadastroEnderecoView.getjPanelMeio());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.cadastroEnderecoView.getjButtonNovo()) {
            utilities.Utilities.ativaDesativa(false, this.cadastroEnderecoView.getjPanelFim());
            utilities.Utilities.limpaComponentes(true, this.cadastroEnderecoView.getjPanelMeio());
            this.cadastroEnderecoView.getjTextFieldID().setEnabled(false);
            this.cadastroEnderecoView.getjTextFieldBairro().setEnabled(false);
            this.cadastroEnderecoView.getjTextFieldCidade().setEnabled(false);

        } else if (e.getSource() == this.cadastroEnderecoView.getjButtonSair()) {
            this.cadastroEnderecoView.dispose();

        } else if (e.getSource() == this.cadastroEnderecoView.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativa(true, this.cadastroEnderecoView.getjPanelFim());
            utilities.Utilities.limpaComponentes(false, this.cadastroEnderecoView.getjPanelMeio());

        } else if (e.getSource() == this.cadastroEnderecoView.getjButtonBuscar()) {

            codigo = 0;
            EnderecoView enderecoView = new EnderecoView(null, true);
            ControllerEnderecoView controllerEnderecoView = new ControllerEnderecoView(enderecoView);
            enderecoView.setVisible(true);

            if (codigo != 0) {
                Endereco endereco = new Endereco();
                endereco = Service.EnderecoService.carregar(codigo);

                utilities.Utilities.ativaDesativa(false, this.cadastroEnderecoView.getjPanelFim());
                utilities.Utilities.limpaComponentes(true, this.cadastroEnderecoView.getjPanelMeio());

                this.cadastroEnderecoView.getjTextFieldID().setText(endereco.getId() + "");
                this.cadastroEnderecoView.getjTextFieldLogradouro1().setText(endereco.getLogradouro() + "");
                this.cadastroEnderecoView.getjTextFieldCEP().setText(endereco.getCep() + "");
                this.cadastroEnderecoView.getjTextFieldCidade().setText(endereco.getCidade().getDescricao() + "");
                this.cadastroEnderecoView.getjTextFieldBairro().setText(endereco.getBairro().getDescricao() + "");
                this.cadastroEnderecoView.getjComboBoxStatus().setSelectedItem(endereco.getStatus() + "");

                this.cadastroEnderecoView.getjTextFieldID().setEnabled(false);
                this.cadastroEnderecoView.getjTextFieldLogradouro1().setEnabled(true);
                this.cadastroEnderecoView.getjTextFieldBairro().setEnabled(false);
                this.cadastroEnderecoView.getjTextFieldCidade().setEnabled(false);
                this.cadastroEnderecoView.getjTextFieldCEP().setEnabled(true);
                this.cadastroEnderecoView.getjComboBoxStatus().setEnabled(true);
                this.cadastroEnderecoView.getjButtonBairro().setEnabled(true);
                this.cadastroEnderecoView.getjButtonCidade().setEnabled(true);

            }

        } else if (e.getSource() == this.cadastroEnderecoView.getjButtonBairro()) {
            BairroView bairroView = new BairroView(null, true);
            ControllerBairroView controllerBairroView = new ControllerBairroView(bairroView);
            bairroView.setVisible(true);

            this.cadastroEnderecoView.getjTextFieldBairro().setText(controllerBairroView.bairroEndereco);

        } else if (e.getSource() == this.cadastroEnderecoView.getjButtonCidade()) {
            CidadeView cidadeView = new CidadeView(null, true);
            ControllerCidadeView controllerCidadeView = new ControllerCidadeView(cidadeView);
            cidadeView.setVisible(true);

            this.cadastroEnderecoView.getjTextFieldCidade().setText(controllerCidadeView.cidadeEnderenco);

        } else if (e.getSource() == this.cadastroEnderecoView.getjButtonGravar()) {

            if (utilities.Utilities.campoVazio(this.cadastroEnderecoView.getjPanelMeio()) == true) {
                JOptionPane.showMessageDialog(null, "Existem campos vazios!");

            } else {

                Endereco endereco = new Endereco();
                Cidade cidade = new Cidade();
                Bairro bairro = new Bairro();
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);

                endereco.setCep(this.cadastroEnderecoView.getjTextFieldCEP().getText());
                endereco.setLogradouro(this.cadastroEnderecoView.getjTextFieldLogradouro1().getText());
                endereco.getCidade().setDescricao(this.cadastroEnderecoView.getjTextFieldCidade().getText());
                endereco.getBairro().setDescricao(this.cadastroEnderecoView.getjTextFieldBairro().getText());
                endereco.setStatus(this.cadastroEnderecoView.getjComboBoxStatus().getSelectedItem().toString());

                if (this.cadastroEnderecoView.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {

                    Service.EnderecoService.adicionar(endereco);

                } else {
                    endereco.setId(Integer.parseInt(this.cadastroEnderecoView.getjTextFieldID().getText()));
                    Service.EnderecoService.atualizar(endereco);
                }

                utilities.Utilities.ativaDesativa(true, this.cadastroEnderecoView.getjPanelFim());
                utilities.Utilities.limpaComponentes(false, this.cadastroEnderecoView.getjPanelMeio());
            }

        }
    }
}
