package api.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {

    private String id;

    private String nombre;

    private String direccion;

    private Cocina tipo;

    private List<Empleado> empleados;

    private Carta carta;

    public Restaurante() {
        this.empleados = new ArrayList<>();
        this.carta = new Carta();
    }

    public Restaurante(String id, String nombre) {
        this();
        this.id = id;
        this.nombre = nombre;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cocina getTipo() {
        return tipo;
    }

    public void setTipo(Cocina tipo) {
        this.tipo = tipo;
    }

    public static Builder builder(String id, String nombre) {
        return new Builder(id, nombre);
    }

    public static class Builder {

        private Restaurante restaurante;

        private Builder(String id, String nombre) {
            this.restaurante = new Restaurante(id, nombre);
        }

        public Builder nombre(String nombre) {
            this.restaurante.setNombre(nombre);
            return this;
        }

        public Builder direccion(String direccion) {
            this.restaurante.setDireccion(direccion);
            return this;
        }

        public Builder tipo(Cocina tipo) {
            this.restaurante.setTipo(tipo);
            return this;
        }

        public Restaurante build() {
            return this.restaurante;
        }
    }
}
