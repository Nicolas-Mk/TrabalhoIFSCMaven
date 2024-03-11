/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Cadastro;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.Templates.*;

/**
 *
 * @author aluno
 */
public class CadastroFornecedorView extends javax.swing.JDialog {
    
    /**
     * Creates new form TemplateCadastro
     */
    public CadastroFornecedorView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        utilities.Utilities.ativaDesativa(true, jPanelFim);
    }

    public JFormattedTextField getCEP() {
        return CEP;
    }

    public void setCEP(JFormattedTextField CEP) {
        this.CEP = CEP;
    }

    public JTextField getComplemento() {
        return Complemento;
    }

    public void setComplemento(JTextField Complemento) {
        this.Complemento = Complemento;
    }

  

    public JTextField getEmail() {
        return Email;
    }

    public void setEmail(JTextField Email) {
        this.Email = Email;
    }

    public JTextField getEnderecoLogradouro() {
        return EnderecoLogradouro;
    }

    public void setEnderecoLogradouro(JTextField Endereco) {
        this.EnderecoLogradouro = Endereco;
    }

    public JTextField getID() {
        return ID;
    }

    public void setID(JTextField ID) {
        this.ID = ID;
    }


    public JTextField getNome() {
        return Nome;
    }

    public void setNome(JTextField Nome) {
        this.Nome = Nome;
    }

    public JComboBox<String> getStatus() {
        return Status;
    }

    public void setStatus(JComboBox<String> Status) {
        this.Status = Status;
    }

    public JFormattedTextField getCelular() {
        return Celular;
    }

    public void setCelular(JFormattedTextField Celular) {
        this.Celular = Celular;
    }

    public JFormattedTextField getTelefone() {
        return Telefone;
    }

    public void setTelefone(JFormattedTextField Telefone) {
        this.Telefone = Telefone;
    }

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public void setjButtonBuscar(JButton jButtonBuscar) {
        this.jButtonBuscar = jButtonBuscar;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JButton getjButtonEndereco() {
        return jButtonEndereco;
    }

    public void setjButtonEndereco(JButton jButtonEndereco) {
        this.jButtonEndereco = jButtonEndereco;
    }

    public JButton getjButtonGravar() {
        return jButtonGravar;
    }

    public void setjButtonGravar(JButton jButtonGravar) {
        this.jButtonGravar = jButtonGravar;
    }

    public JButton getjButtonNovo() {
        return jButtonNovo;
    }

    public void setjButtonNovo(JButton jButtonNovo) {
        this.jButtonNovo = jButtonNovo;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public void setjButtonSair(JButton jButtonSair) {
        this.jButtonSair = jButtonSair;
    }

    public JPanel getjPanelFim() {
        return jPanelFim;
    }

    public void setjPanelFim(JPanel jPanelFim) {
        this.jPanelFim = jPanelFim;
    }

    public JPanel getjPanelMeio() {
        return jPanelMeio;
    }

    public void setjPanelMeio(JPanel jPanelMeio) {
        this.jPanelMeio = jPanelMeio;
    }

    public JPanel getjPanelTitulo() {
        return jPanelTitulo;
    }

    public void setjPanelTitulo(JPanel jPanelTitulo) {
        this.jPanelTitulo = jPanelTitulo;
    }

    public JFormattedTextField getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(JFormattedTextField CNPJ) {
        this.CNPJ = CNPJ;
    }

    public JTextField getInscricaoEstadual() {
        return InscricaoEstadual;
    }

    public void setInscricaoEstadual(JTextField InscricaoEstadual) {
        this.InscricaoEstadual = InscricaoEstadual;
    }

    public JTextField getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(JTextField RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public JButton getjButtonCadastroEndereco1() {
        return jButtonCadastroEndereco1;
    }

    public void setjButtonCadastroEndereco1(JButton jButtonCadastroEndereco1) {
        this.jButtonCadastroEndereco1 = jButtonCadastroEndereco1;
    }

    public JTextField getBairro() {
        return Bairro;
    }

    public void setBairro(JTextField Bairro) {
        this.Bairro = Bairro;
    }

    public JTextField getCidade() {
        return Cidade;
    }

    public void setCidade(JTextField Cidade) {
        this.Cidade = Cidade;
    }
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        jLtitulo = new javax.swing.JLabel();
        jPanelMeio = new javax.swing.JPanel();
        jButtonEndereco = new javax.swing.JButton();
        Nome = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        EnderecoLogradouro = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        Status = new javax.swing.JComboBox<>();
        CEP = new javax.swing.JFormattedTextField();
        Telefone = new javax.swing.JFormattedTextField();
        Celular = new javax.swing.JFormattedTextField();
        jLabelStaus = new javax.swing.JLabel();
        jLabelCelular = new javax.swing.JLabel();
        jLabelCEP = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelNome1 = new javax.swing.JLabel();
        Complemento = new javax.swing.JTextField();
        jLabelComplemento = new javax.swing.JLabel();
        jLabelRazaoSocial = new javax.swing.JLabel();
        RazaoSocial = new javax.swing.JTextField();
        jLabelInscricaoEstadual = new javax.swing.JLabel();
        InscricaoEstadual = new javax.swing.JTextField();
        CNPJ = new javax.swing.JFormattedTextField();
        jLabelCNPJ = new javax.swing.JLabel();
        jButtonCadastroEndereco1 = new javax.swing.JButton();
        Bairro = new javax.swing.JTextField();
        jLabelCidade = new javax.swing.JLabel();
        Cidade = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jPanelFim = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        jPanelTitulo.setBackground(new java.awt.Color(0, 102, 153));
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(394, 56));

        jLtitulo.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLtitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLtitulo.setText("Cadastro de Fornecedor");
        jPanelTitulo.add(jLtitulo);

        jPanelMeio.setPreferredSize(new java.awt.Dimension(800, 530));
        jPanelMeio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jButtonEndereco.setActionCommand("5");
        jButtonEndereco.setPreferredSize(new java.awt.Dimension(5, 19));
        jButtonEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnderecoActionPerformed(evt);
            }
        });
        jPanelMeio.add(jButtonEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 30, 30));

        Nome.setActionCommand("5");
        Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeActionPerformed(evt);
            }
        });
        jPanelMeio.add(Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 387, -1));
        jPanelMeio.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 387, -1));

        EnderecoLogradouro.setActionCommand("5");
        jPanelMeio.add(EnderecoLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 387, -1));

        jLabelEmail.setText("Email");
        jPanelMeio.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        jLabelEndereco.setText("Endereço");
        jPanelMeio.add(jLabelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabelID.setText("ID");
        jPanelMeio.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 20, 20));

        ID.setActionCommand("5");
        ID.setName("id"); // NOI18N
        jPanelMeio.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, -1));

        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        Status.setActionCommand("5");
        Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusActionPerformed(evt);
            }
        });
        jPanelMeio.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 31, 159, -1));

        try {
            CEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEPActionPerformed(evt);
            }
        });
        jPanelMeio.add(CEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 159, 160, -1));

        try {
            Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Telefone.setActionCommand("5");
        jPanelMeio.add(Telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 119, 159, -1));

        try {
            Celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Celular.setActionCommand("5");
        jPanelMeio.add(Celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 79, 159, -1));

        jLabelStaus.setText("Status");
        jPanelMeio.add(jLabelStaus, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 32, -1, 20));

        jLabelCelular.setText("Celular");
        jPanelMeio.add(jLabelCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, 20));

        jLabelCEP.setText("CEP");
        jPanelMeio.add(jLabelCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 160, -1, 20));

        jLabelTelefone.setText("Telefone");
        jPanelMeio.add(jLabelTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 120, -1, 20));

        jLabelNome1.setText("Nome");
        jPanelMeio.add(jLabelNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));

        Complemento.setActionCommand("5");
        Complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplementoActionPerformed(evt);
            }
        });
        jPanelMeio.add(Complemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 159, -1));

        jLabelComplemento.setText("Complemento");
        jPanelMeio.add(jLabelComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabelRazaoSocial.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRazaoSocial.setText("Razão Social");
        jPanelMeio.add(jLabelRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        RazaoSocial.setActionCommand("7");
        RazaoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RazaoSocialActionPerformed(evt);
            }
        });
        jPanelMeio.add(RazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 159, -1));

        jLabelInscricaoEstadual.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInscricaoEstadual.setText("Inscrição Estadual");
        jPanelMeio.add(jLabelInscricaoEstadual, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 105, 20));

        InscricaoEstadual.setActionCommand("7");
        InscricaoEstadual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscricaoEstadualActionPerformed(evt);
            }
        });
        jPanelMeio.add(InscricaoEstadual, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 173, -1));

        try {
            CNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CNPJ.setActionCommand("7");
        jPanelMeio.add(CNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 160, -1));

        jLabelCNPJ.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCNPJ.setText("CNPJ");
        jPanelMeio.add(jLabelCNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 50, -1));

        jButtonCadastroEndereco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/New.png"))); // NOI18N
        jButtonCadastroEndereco1.setActionCommand("5");
        jButtonCadastroEndereco1.setPreferredSize(new java.awt.Dimension(5, 19));
        jPanelMeio.add(jButtonCadastroEndereco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 30, 30));

        Bairro.setActionCommand("5");
        Bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BairroActionPerformed(evt);
            }
        });
        jPanelMeio.add(Bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 159, -1));

        jLabelCidade.setText("Cidade");
        jPanelMeio.add(jLabelCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        Cidade.setActionCommand("5");
        Cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CidadeActionPerformed(evt);
            }
        });
        jPanelMeio.add(Cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 159, -1));

        jLabelBairro.setText("Bairro");
        jPanelMeio.add(jLabelBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        jPanelFim.setBackground(new java.awt.Color(0, 102, 153));
        jPanelFim.setForeground(new java.awt.Color(255, 255, 0));
        jPanelFim.setPreferredSize(new java.awt.Dimension(631, 55));

        jButtonNovo.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.setActionCommand("0");
        jButtonNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonNovo.setMaximumSize(new java.awt.Dimension(50, 80));
        jButtonNovo.setMinimumSize(new java.awt.Dimension(50, 80));
        jButtonNovo.setName(""); // NOI18N
        jButtonNovo.setPreferredSize(new java.awt.Dimension(120, 50));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanelFim.add(jButtonNovo);

        jButtonCancelar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancel.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setActionCommand("1");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(120, 50));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelFim.add(jButtonCancelar);

        jButtonGravar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Go.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setActionCommand("1");
        jButtonGravar.setPreferredSize(new java.awt.Dimension(120, 50));
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        jPanelFim.add(jButtonGravar);

        jButtonBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setActionCommand("0");
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(120, 50));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelFim.add(jButtonBuscar);

        jButtonSair.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setActionCommand("0");
        jButtonSair.setPreferredSize(new java.awt.Dimension(120, 50));
        jPanelFim.add(jButtonSair);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMeio, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMeio, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFim, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnderecoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEnderecoActionPerformed

    private void NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeActionPerformed

    private void StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusActionPerformed

    private void CEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CEPActionPerformed

    private void ComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComplementoActionPerformed

    private void RazaoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RazaoSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RazaoSocialActionPerformed

    private void InscricaoEstadualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscricaoEstadualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InscricaoEstadualActionPerformed

    private void BairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BairroActionPerformed

    private void CidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CidadeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroFornecedorView dialog = new CadastroFornecedorView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Bairro;
    private javax.swing.JFormattedTextField CEP;
    private javax.swing.JFormattedTextField CNPJ;
    private javax.swing.JFormattedTextField Celular;
    private javax.swing.JTextField Cidade;
    private javax.swing.JTextField Complemento;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField EnderecoLogradouro;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField InscricaoEstadual;
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField RazaoSocial;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JFormattedTextField Telefone;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCadastroEndereco1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEndereco;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelCelular;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInscricaoEstadual;
    private javax.swing.JLabel jLabelNome1;
    private javax.swing.JLabel jLabelRazaoSocial;
    private javax.swing.JLabel jLabelStaus;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLtitulo;
    private javax.swing.JPanel jPanelFim;
    private javax.swing.JPanel jPanelMeio;
    private javax.swing.JPanel jPanelTitulo;
    // End of variables declaration//GEN-END:variables
}
