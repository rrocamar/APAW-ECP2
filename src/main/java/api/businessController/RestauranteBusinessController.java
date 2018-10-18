package api.businessController;

import api.dtos.RestauranteDto;
import api.entities.Restaurante;

public class RestauranteBusinessController {

    public String create(RestauranteDto restauranteDto) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(restauranteDto.getNombre());
        restaurante.setDireccion(restauranteDto.getDireccion());
        restaurante.setTipo(restauranteDto.getTipo());

        return restaurante.getId();
    }

}
