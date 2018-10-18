package api.apiControllers;

import api.businessController.RestauranteBusinessController;
import api.dtos.RestauranteDto;
import api.entities.Restaurante;
import api.exceptions.ArgumentNotValidException;

public class RestauranteApiController {

    public static final String RESTAURANTES = "/restaurantes";

    public static final String ID_ID = "/{id}";

    private RestauranteBusinessController restauranteBusinessController = new RestauranteBusinessController();

    public String create(RestauranteDto restauranteDto) {
        this.validate(restauranteDto, "restauranteDto");
        this.validate(restauranteDto.getNombre(), "RestauranteDto nombre");
        return this.restauranteBusinessController.create(restauranteDto);
    }

    public RestauranteDto read(String id) {
        return this.restauranteBusinessController.read(id);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
