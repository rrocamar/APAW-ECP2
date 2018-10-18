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

    public Restaurante(String nombre) {
        this();
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

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public static Builder builder(String nombre) {
        return new Builder(nombre);
    }

    public static class Builder {

        private Restaurante restaurante;

        private Builder(String nombre) {
            this.restaurante = new Restaurante(nombre);
        }

        public Builder nombre(String nombre) {
            this.restaurante.setNombre(nombre);
            return this;
        }

        public Builder id(String id) {
            this.restaurante.setId(id);
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

        public Builder carta(Carta carta) {
            this.restaurante.setCarta(carta);
            return this;
        }
        public Restaurante build() {
            return this.restaurante;
        }
    }
}
