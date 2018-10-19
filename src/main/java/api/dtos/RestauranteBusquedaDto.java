package api.dtos;

import api.entities.Restaurante;

public class RestauranteBusquedaDto {

    private String id;

    private String nombre;

    public RestauranteBusquedaDto() {
    }

    public RestauranteBusquedaDto(Restaurante restaurante) {
        this.id = restaurante.getId();
        this.nombre = restaurante.getNombre();
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
}
