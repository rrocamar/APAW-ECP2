package entities;

import java.time.LocalDateTime;

public class Carta {

    private String id;

    private LocalDateTime validezDesde;

    private String nombre;

    //Coleccion de platos.. o menus..

    public Carta() {

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
