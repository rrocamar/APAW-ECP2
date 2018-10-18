package api.entities;

import java.time.LocalDateTime;

public class Empleado {

    private String id;

    private String nombre;

    private LocalDateTime fechaContratacion;

    private double salarioBrutoAnual;

    public Empleado() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDateTime fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalarioBrutoAnual() {
        return salarioBrutoAnual;
    }

    public void setSalarioBrutoAnual(double salarioBrutoAnual) {
        this.salarioBrutoAnual = salarioBrutoAnual;
    }
}
