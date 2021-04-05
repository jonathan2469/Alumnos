/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.*;
import java.awt.Image;
import javax.swing.*;
/**
 *
 * @author jonat
 */
public class AcercaDe extends JDialog{
    
    private JPanel pnls;
    private JPanel pnla;
    private JLabel lbl3;
    
    public AcercaDe(JFrame parent){
        super(parent,true);
        super.setSize(300, 400);
        super.setLocationRelativeTo(null);
        super.setLayout(new FlowLayout());
        
        pnls = new JPanel();
        pnls.setLayout(new BorderLayout());        
        
        pnla = new JPanel();
        pnla.setLayout(new BorderLayout());
        lbl3 = new JLabel(" Derechos reservados ");
        pnla.add(lbl3, BorderLayout.SOUTH);
        
        super.add(pnls);
        super.add(pnla);
        super.pack();
    }
}