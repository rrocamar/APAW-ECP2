package api.dtos;

import api.entities.Cocina;
import api.entities.Restaurante;

public class RestauranteDto {

    private String id;

    private String nombre;

    private String direccion;

    private Cocina tipo;

    public RestauranteDto() {
    }

    public RestauranteDto(Restaurante restaurante) {
        this.id = restaurante.getId();
        this.nombre = restaurante.getNombre();
        this.direccion = restaurante.getDireccion();
        this.tipo = restaurante.getTipo();
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
}
