package api.businessController;

import api.daos.DaoFactory;
import api.dtos.CartaDto;
import api.exceptions.NotFoundException;

public class CartaBusinessController {

    public CartaDto read(String id) {
        return new CartaDto(DaoFactory.getFactory().getCartaDao().read(id)
                .orElseThrow(() -> new NotFoundException("Carta (" + id + ")")));
    }
}
