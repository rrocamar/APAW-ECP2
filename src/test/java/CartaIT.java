import api.apiControllers.CartaApiController;
import api.dtos.CartaDto;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartaIT {

    private String cearCarta(String nombre, LocalDateTime fecha) {
        CartaDto cartaDto = new CartaDto();
        cartaDto.setNombre(nombre);
        cartaDto.setValidezDesde(fecha);
        HttpRequest request = HttpRequest.builder(CartaApiController.CARTAS).body(cartaDto).post();
        HttpResponse response = new Client().submit(request);
        return (String) response.getBody();
    }

    @Test
    void testRecuperarCarta() {
        String nombre = "Carta menu de Restaurante...";
        LocalDateTime fecha = LocalDateTime.now();
        String id = this.cearCarta(nombre, fecha);
        HttpRequest request = HttpRequest.builder(CartaApiController.CARTAS).path(CartaApiController.ID_ID)
                .expandPath(id).body(null).get();
        HttpResponse response = new Client().submit(request);
        CartaDto cartaDto = (CartaDto) response.getBody();
        assertEquals(nombre, cartaDto.getNombre());
        assertEquals(fecha, cartaDto.getValidezDesde());
    }
}
