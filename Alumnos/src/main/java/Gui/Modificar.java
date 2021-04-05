/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Exceptions.ApellidoException;
import Exceptions.CalificacionException;
import Exceptions.CarreraException;
import Exceptions.DoubleException;
import Exceptions.NombreException;
import Exceptions.NumeroException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import Model.Alumno;
import Model.Carrera;

/**
 *
 * @author jonat
 */
public class Modificar extends JDialog {

    private final String[] COMBO = {"", "SISTEMAS", "NUTRICION", "ARQUITECTURA", "CIVIL", "CONTADURIA"};

    private TxtEdit edtNumero;
    private TxtEdit edtNombre;
    private TxtEdit edtPaterno;
    private TxtEdit edtMaterno;
    private TxtEdit2 edtCalificacion;

    private JLabel lblCarrera;
    private JComboBox cbCarrera;
    private JPanel pnlCarrera;

    private JButton btnAceptar;
    private JButton btnCancelar;
    private JPanel pnlBoton;

    private ModificarListener listener;

    public Modificar(JFrame parent) {
        super(parent, true);
        super.setTitle("MODIFICAR");
        super.setSize(350, 500);
        super.setLayout(new GridLayout(7, 1));
        super.setLocationRelativeTo(parent);

        edtNumero = new TxtEdit("No. Control: ");
        edtNombre = new TxtEdit("Nombre: ");
        edtPaterno = new TxtEdit("Apellido parterno: ");
        edtMaterno = new TxtEdit("Apellido Materno: ");
        edtCalificacion = new TxtEdit2("Calificacion: ");

        cbCarrera = new JComboBox(COMBO);
        
        lblCarrera = new JLabel("Carrera: ");
        pnlCarrera = new JPanel();
        pnlCarrera.add(lblCarrera);
        pnlCarrera.add(cbCarrera);

        pnlBoton = new JPanel();
        pnlBoton.setLayout(new FlowLayout());
        btnAceptar = new JButton("Modificar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Alumno al = new Alumno(edtNumero.getValue(),
                            edtNombre.getValue(),
                            edtPaterno.getValue(),
                            edtMaterno.getValue(),
                            edtCalificacion.getValue(),
                            setCarrera(cbCarrera.getSelectedIndex()));
                    listener.modificarClick(al);

                } catch ( NumeroException | NombreException | ApellidoException | CalificacionException | CarreraException | DoubleException ex) {
                    JOptionPane.showMessageDialog(Modificar.this,
                            ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificar.this.setVisible(false);
            }
        });
        pnlBoton.add(btnAceptar);
        pnlBoton.add(btnCancelar);

        super.add(edtNumero);
        super.add(edtNombre);
        super.add(edtPaterno);
        super.add(edtMaterno);
        super.add(edtCalificacion);
        super.add(pnlCarrera);
        super.add(pnlBoton);
    }

    public void setListener(ModificarListener listener) {
        this.listener = listener;
    }

    public Carrera setCarrera(Integer i) {
        switch (i) {
            case 0:
                return null;
            case 1:
                return Carrera.SISTEMAS;
            case 2:
                return Carrera.NUTRICION;
            case 3:
                return Carrera.ARQUITECTURA;
            case 4:
                return Carrera.CIVIL;
            case 5:
                return Carrera.CONTADURIA;
            default:
                return null;
        }
    }

    public void setCar(Integer i){
        cbCarrera.setSelectedIndex(i);
    }
    public static Integer setCarre(String c){
        switch (c) {           
            case "SISTEMAS":
                return 1;
            case "NUTRICION":
                return 2;
            case "ARQUITECTURA":
                return 3;
            case "CIVIL":
                return 4;
            case "CONTADURIA":
                return 5;
            default:
                return 0;
        }
    } 
    private void limpiar() {
        edtNumero.clear();
        edtNombre.clear();
        edtPaterno.clear();
        edtMaterno.clear();
        edtCalificacion.clear();
        cbCarrera.setSelectedIndex(0);
    }
    
    public void setNombre(String nombre){
        edtNombre.setTexto(nombre);
    }
    public void setMatricula(String nombre){
        edtNumero.setTexto(nombre);
    }
    public void setPaterno(String nombre){
        edtPaterno.setTexto(nombre);
    }
    public void setMaterno(String nombre){
        edtMaterno.setTexto(nombre);
    }
    public void setCalificacion(Double nombre){
        edtCalificacion.setCalificacion(nombre);
    }
}
