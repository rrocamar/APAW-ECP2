package api.businessController;

import api.daos.DaoFactory;
import api.dtos.RestauranteDto;
import api.entities.Carta;
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

    public RestauranteDto read(String id) {
        return new RestauranteDto(DaoFactory.getFactory().getRestauranteDao().read(id)
                .orElseThrow(() -> new NotFoundException("Restaurante (" + id + ")")));
    }
}
