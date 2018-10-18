package api.dtos;

import api.entities.Cocina;
import api.entities.Empleado;
import api.entities.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class RestauranteDto {

    private String id;

    private String nombre;

    private String direccion;

    private Cocina tipo;

    private String idCarta;

    private List<String> idsEmpleados;

    public RestauranteDto() {
        this.idsEmpleados = new ArrayList<>();
    }

    public RestauranteDto(Restaurante restaurante) {
        this();
        this.id = restaurante.getId();
        this.nombre = restaurante.getNombre();
        this.direccion = restaurante.getDireccion();
        this.tipo = restaurante.getTipo();
        if (restaurante.getCarta() != null)
            this.idCarta = restaurante.getCarta().getId();
        for (Empleado empleado : restaurante.getEmpleados())
            getIdsEmpleados().add(empleado.getId());
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

    public String getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(String idCarta) {
        this.idCarta = idCarta;
    }

    public List<String> getIdsEmpleados() {
        return idsEmpleados;
    }
}
