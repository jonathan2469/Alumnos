/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jonat
 */
public class TxtEdit extends JPanel {

    private JLabel lblcaption;
    private JTextField edit;

    public TxtEdit(String caption) {
        this.lblcaption = new JLabel(caption);
        this.edit = new JTextField(15);
        
        super.add(lblcaption);
        super.add(edit);
    }

    public void clear() {
        edit.setText("");
    }

    public String getValue() {
        return edit.getText();
    }
    
    public void setTexto(String texto){
        edit.setText(texto);
    }
}
