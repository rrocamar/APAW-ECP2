package api.dtos;

import api.entities.Empleado;

public class EmpleadoDto {

    private String id;

    private String nombre;

    private double salarioBrutoAnual;

    public EmpleadoDto(Empleado empleado) {
        this.id = empleado.getId();
        this.nombre = empleado.getNombre();
        this.salarioBrutoAnual = empleado.getSalarioBrutoAnual();
    }

    public EmpleadoDto() {
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

    public double getSalarioBrutoAnual() {
        return salarioBrutoAnual;
    }

    public void setSalarioBrutoAnual(double salarioBrutoAnual) {
        this.salarioBrutoAnual = salarioBrutoAnual;
    }
}
