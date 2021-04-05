/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exceptions.AlumnoException;
import Exceptions.ArchivoException;
import Exceptions.CargarException;
import Exceptions.GuardarException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Alumno;

/**
 *
 * @author jonat
 */
public class Controller implements Serializable {

    private ArrayList<Alumno> lista;

    public Controller() throws CargarException, ArchivoException {
        cargar();
    }

    public Boolean add(Alumno alumno) throws AlumnoException {
        if (lista.contains(alumno)) {
            throw new AlumnoException("El numero de control ya ha sido asignado");
        } else {
            return lista.add(alumno);
        }
    }

    public Integer catidadAlumnos() {
        return lista.size();
    }

    public Alumno getAlumno(int index) {
        return lista.get(index);
    }

    public ArrayList<Alumno> getAlumno() {
        return lista;
    }

    public Boolean eliminarAlumno(Alumno alum) {
        if(lista.contains(alum)){
            return lista.remove(alum);            
        }else{
            return false;
        }
    }

    public Alumno buscar(String noControl) {
        for (Alumno alumno : lista) {
            if (alumno.getNoControl().equals(noControl)) {
                return alumno;
            }
        }
        return null;
    }

    public void guardar() throws GuardarException {
        try {
            File file = new File("alumnos.dat");
            FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);

            writer.writeObject(lista);

            writer.close();
            output.close();
        } catch (IOException ex) {
            throw new GuardarException("Hubo un error en disco");
        }
    }

    private void cargar() throws CargarException, ArchivoException {
        File file = new File("alumnos.dat");
        if (file.exists()) {
            try {
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);

                lista = (ArrayList<Alumno>) reader.readObject();

                reader.close();
                input.close();
            } catch (IOException ex) {
                throw new CargarException("Error al cargar el archivo");
            } catch (ClassNotFoundException ex) {
                throw new ArchivoException("Archivo de origen ha sido corrompido");
            }
        }else{
            lista = new ArrayList<>();
        }

    }

}
