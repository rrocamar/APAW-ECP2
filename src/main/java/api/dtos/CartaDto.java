package api.dtos;

import api.entities.Carta;

import java.time.LocalDateTime;

public class CartaDto {

    private String id;

    private LocalDateTime validezDesde;

    private String nombre;

    public CartaDto() {
    }

    public CartaDto(Carta carta) {
        this.id = carta.getId();
        this.nombre = carta.getNombre();
        this.validezDesde = carta.getValidezDesde();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getValidezDesde() {
        return validezDesde;
    }

    public void setValidezDesde(LocalDateTime validezDesde) {
        this.validezDesde = validezDesde;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
