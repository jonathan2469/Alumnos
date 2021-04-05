/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jonat
 */
public class Eliminar extends JDialog{
    
    private TxtEdit edtEliminar;
    private JButton btnEliminar;
    
    private EliminarListener listener;
    
    public Eliminar(JFrame parent){
        super(parent, true);
        super.setSize(350, 150);
        super.setLayout(new FlowLayout());
        super.setLocationRelativeTo(parent);
        
        edtEliminar = new TxtEdit("Dame el numero de control");
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.eliminar(edtEliminar.getValue());
                edtEliminar.clear();
            }
        });
        
        super.add(edtEliminar);
        super.add(btnEliminar);
    }

    
    public void setListener(EliminarListener listener){
        this.listener = listener;
    }
}
