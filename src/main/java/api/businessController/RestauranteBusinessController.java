package api.businessController;

import api.daos.DaoFactory;
import api.dtos.RestauranteDto;
import api.entities.Carta;
import api.entities.Empleado;
import api.entities.Restaurante;
import api.exceptions.NotFoundException;

public class RestauranteBusinessController {

    public String create(RestauranteDto restauranteDto) {
        Carta carta = null;
        if (restauranteDto.getIdCarta() != null) {
            carta = DaoFactory.getFactory().getCartaDao().read(restauranteDto.getIdCarta())
                    .orElseThrow(() -> new NotFoundException("Carta (" + restauranteDto.getIdCarta() + ")"));
        }
        Restaurante restaurante = Restaurante.builder(restauranteDto.getNombre()).tipo(restauranteDto.getTipo()).
                direccion(restauranteDto.getDireccion()).carta(carta).build();
        DaoFactory.getFactory().getRestauranteDao().save(restaurante);
        return restaurante.getId();
    }

    public void createCarta(String idRestaurante, String nombreCarta) {
        Restaurante restaurante = DaoFactory.getFactory().getRestauranteDao().read(idRestaurante)
                .orElseThrow(() -> new NotFoundException("Restaurante (" + idRestaurante + ")"));
        Carta carta = new Carta();
        carta.setNombre(nombreCarta);
        DaoFactory.getFactory().getCartaDao().save(carta);
        restaurante.setCarta(carta);
        DaoFactory.getFactory().getRestauranteDao().save(restaurante);
    }

    public void addNewEmpleadoToRestaurante(String idRestaurante, String nombreEmpleado) {
        Restaurante restaurante = DaoFactory.getFactory().getRestauranteDao().read(idRestaurante)
                .orElseThrow(() -> new NotFoundException("Restaurante (" + idRestaurante + ")"));
        Empleado empleado = new Empleado();
        empleado.setNombre(nombreEmpleado);
        DaoFactory.getFactory().getEmpleadoDao().save(empleado);
        restaurante.getEmpleados().add(empleado);
        DaoFactory.getFactory().getRestauranteDao().save(restaurante);
    }

    public RestauranteDto read(String id) {
        return new RestauranteDto(DaoFactory.getFactory().getRestauranteDao().read(id)
                .orElseThrow(() -> new NotFoundException("Restaurante (" + id + ")")));
    }
}
