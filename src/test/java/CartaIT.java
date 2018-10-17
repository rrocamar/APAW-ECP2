
import api.apiControllers.CartaApiController;
import api.daos.DaoFactory;
import api.dtos.CartaDto;
import api.entities.Carta;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartaIT {

    @Test
    void testRecuperarCarta() {
        HttpRequest.builder(CartaApiController.CARTAS).post();
        Carta carta = new Carta();
        carta.setNombre("Carta menu de Restaurante...");
        carta.setValidezDesde(LocalDateTime.now());
        DaoFactory.getFactory().getCartaDao().save(carta);
        String id = carta.getId();

        HttpRequest request = HttpRequest.builder(CartaApiController.CARTAS).expandPath(CartaApiController.ID_ID).path(id).get();
        HttpResponse response = new Client().submit(request);
        CartaDto cartaDto = (CartaDto) response.getBody();
        assertEquals(carta.getNombre(), cartaDto.getNombre());
        assertEquals(carta.getValidezDesde(), cartaDto.getValidezDesde());
    }
}
