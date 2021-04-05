/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Exceptions.DoubleException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jonat
 */
public class TxtEdit2 extends JPanel {

    private JLabel lblcaption;
    private JTextField edit;

    public TxtEdit2(String caption) {

        this.lblcaption = new JLabel(caption);
        this.edit = new JTextField(15);

        super.add(lblcaption);
        super.add(edit);
    }

    public void clear() {
        edit.setText("");
    }

    public Double getValue() throws DoubleException {
        try {
            return Double.parseDouble(edit.getText());
        } catch (Exception e) {
            throw new DoubleException("Ponga una calificacion valida");
        }
    }
    
    public void setCalificacion(Double cal){
        edit.setText(Double.toString(cal));
    }
}
