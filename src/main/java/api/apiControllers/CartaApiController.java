package api.apiControllers;

import api.businessController.CartaBusinessController;
import api.dtos.CartaDto;
import api.exceptions.ArgumentNotValidException;

public class CartaApiController {

    public static final String CARTAS = "/cartas";

    public static final String ID_ID = "/{id}";

    private CartaBusinessController cartaBusinessController = new CartaBusinessController();

    public CartaDto read(String id) {
        return this.cartaBusinessController.read(id);
    }

    public String create(CartaDto cartaDto) {
        this.validate(cartaDto, "cartaDto");
        this.validate(cartaDto.getNombre(), "CartaDto nombre");
        this.validate(cartaDto.getValidezDesde(), "CartaDto fechaValidez");
        return this.cartaBusinessController.create(cartaDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
