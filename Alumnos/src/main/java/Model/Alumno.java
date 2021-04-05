/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exceptions.ApellidoException;
import Exceptions.CalificacionException;
import Exceptions.CarreraException;
import Exceptions.DoubleException;
import Exceptions.NombreException;
import Exceptions.NumeroException;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jonat
 */
public class Alumno implements Serializable {

    private String noControl;
    private String nombre;
    private String paterno;
    private String materno;
    private Double calificacion;
    private Carrera carrera;

    public Alumno(String noControl, String nombre, String paterno, String materno, Double calificacion, Carrera carrera) throws CalificacionException, NumeroException, NombreException, ApellidoException, CarreraException {
        this.setNoControl(noControl);
        this.setNombre(nombre);
        this.setPaterno(paterno);
        this.materno = materno;
        this.setCalificacion(calificacion);
        this.setCarrera(carrera);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Alumno) {
            Alumno alumno = (Alumno) obj;
            if (this.noControl.compareTo(alumno.getNoControl()) == 0) {
                return true;
            }
        }
        return false;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl(String noControl) throws NumeroException {
        if (!noControl.isEmpty()) {
            this.noControl = noControl;
        } else {
            throw new NumeroException("No tiene numero de control");
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreException {
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new NombreException("Campo NOMBRE vacio");
        }
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) throws ApellidoException {
        if (!paterno.isEmpty()) {
            this.paterno = paterno;
        } else {
            throw new ApellidoException("Campo Apellido Paterno vacio");
        }

    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) throws CalificacionException {
        if ((calificacion >= 0.0) && (calificacion <= 10.0)) {
            this.calificacion = calificacion;
        } else {
            throw new CalificacionException("Calificacion fuera de rango");
        }

    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) throws CarreraException {
        if (carrera != null) {
            this.carrera = carrera;
        } else{
            throw new CarreraException("Ingrese la carrera del alumno");
        }
    }

    public String getString() {
        return String.format("El alumno %s %s %s\nMatricula: %s\nCalificacion: %.2f\nCarrera: %s", nombre, paterno, materno, noControl, calificacion, carrera);
    }
}
