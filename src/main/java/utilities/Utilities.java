/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

/**
 *
 * @author aluno
 */
public class Utilities {

    public static void ativaDesativa(boolean ativa, JPanel jPanel) {

        Component[] componentes = jPanel.getComponents();

        for (Component componente : componentes) {

            if (componente instanceof JButton) {

                if (((JButton) componente).getActionCommand() == "0") {

                    componente.setEnabled(ativa);
                }
                
                else {
                    componente.setEnabled(!ativa);
                    
                     if (componente instanceof JTextField) {

                 
                }
            }
        }

    }
            
        }
        
    

    public static void limpaComponentes(boolean ativa, JPanel jPanel) {
        Component[] componentes = jPanel.getComponents();

        for (Component componente : componentes) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof JTextArea) {
                ((JTextArea) componente).setText("");
            } else if (componente instanceof JPasswordField) {
                ((JPasswordField) componente).setText("");
            }
            componente.setEnabled(ativa);
        }

    }

    public static boolean campoVazio(JPanel jPanel) {
        boolean aux = false;
        Component[] componentes = jPanel.getComponents();

        for (Component componente : componentes) {

            if (componente instanceof JFormattedTextField) {

                if (((JFormattedTextField) componente).getText().length() == 0) {
                    aux = true;
                }

            }
            if (componente instanceof JComboBox) {

                if (((JComboBox) componente).getSelectedIndex() == -1) {
                    aux = true;
                }

            }
            if (componente instanceof JTextField) {
                if (((JTextField) componente).getText().length() == 0) {

                    if (componente.getName() != "id") {
                        aux = true;
                    }
                }

            }

        }

        return aux;
    }
    public static Component campoVazios(JPanel jPanel) {
        Component aux = new JButton();
        Component[] componentes = jPanel.getComponents();

        for (Component componente : componentes) {

            if (componente instanceof JFormattedTextField) {

                if (((JFormattedTextField) componente).getText().length() == 2) {
                    return componente;
                }

            }
            if (componente instanceof JComboBox) {

                if (((JComboBox) componente).getSelectedIndex() == -1) {
                    return componente;
                }

            }
            if (componente instanceof JTextField) {
                if (((JTextField) componente).getText().length() == 0) {

                    if (componente.getName() != "id") {
                        return componente;
                    }
                }

            }

        }

        return aux;
    }
    
    
    
    
    public static void ativaDesativaFormatedField(boolean ativa, JPanel jPanel) {

        Component[] componentes = jPanel.getComponents();

        for (Component componente : componentes) {

            if (componente instanceof JFormattedTextField) {

                if (((JFormattedTextField) componente).getAction().equals("0")) {

                    componente.setEnabled(ativa);
                }
                
                else {
                    componente.setEnabled(!ativa);
                    
                     if (componente instanceof JTextField) {

                 
                }
            }
        }

    }
            
        }

}
