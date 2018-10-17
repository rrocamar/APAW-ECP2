package api.apiControllers;

import api.businessController.CartaBusinessController;
import api.dtos.CartaDto;

public class CartaApiController {

    public static final String CARTAS = "/cartas";

    public static final String ID_ID = "/{id}";

    private CartaBusinessController cartaBusinessController = new CartaBusinessController();

    public CartaDto read(String id) {
        return this.cartaBusinessController.read(id);
    }
}
