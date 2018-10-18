package api.businessController;

import api.daos.DaoFactory;
import api.dtos.RestauranteDto;
import api.entities.Carta;
import api.entities.Restaurante;
import api.exceptions.NotFoundException;

public class RestauranteBusinessController {

    public String create(RestauranteDto restauranteDto) {
        /*
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(restauranteDto.getNombre());
        restaurante.setDireccion(restauranteDto.getDireccion());
        restaurante.setTipo(restauranteDto.getTipo());
        */
        restauranteDto.getCartaId();
        Carta carta = null;
        if (restauranteDto.getUserId() != null) {
            carta = DaoFactory.getFactory().getCartaDao().read(restauranteDto.getCartaId())
                    .orElseThrow(() -> new NotFoundException("Carta (" + restauranteDto.getCartaId() + ")"));
        }

        DaoFactory.getFactory().getRestauranteDao().save(restaurante);
        return restaurante.getId();
    }

}
