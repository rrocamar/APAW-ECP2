import api.apiControllers.CartaApiController;
import api.dtos.CartaDto;
import api.entities.Carta;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartaIT {

    private String crearCartaAPIRest(String nombre, LocalDateTime fecha) {
        CartaDto cartaDto = new CartaDto();
        cartaDto.setNombre(nombre);
        cartaDto.setValidezDesde(fecha);
        HttpRequest request = HttpRequest.builder(CartaApiController.CARTAS).body(cartaDto).post();
        HttpResponse response = new Client().submit(request);
        return (String) response.getBody();
    }

    private CartaDto obtenerCartaAPIRest(String id) {
        HttpRequest request = HttpRequest.builder(CartaApiController.CARTAS).path(CartaApiController.ID_ID)
                .expandPath(id).body(null).get();
        HttpResponse response = new Client().submit(request);
        return (CartaDto) response.getBody();
    }

    private void actualizarParcialmenteCartaAPIRest(String id, CartaDto cartaDto) {
        HttpRequest request = HttpRequest.builder(CartaApiController.CARTAS).path(CartaApiController.ID_ID)
                .expandPath(id).body(cartaDto).patch();
        new Client().submit(request);
    }

    @Test
    void testCrearRecuperarCarta() {
        String nombre = "Carta menu de Restaurante...";
        LocalDateTime fecha = LocalDateTime.now();
        String id = this.crearCartaAPIRest(nombre, fecha);
        CartaDto cartaDto = this.obtenerCartaAPIRest(id);
        assertEquals(nombre, cartaDto.getNombre());
        assertEquals(fecha, cartaDto.getValidezDesde());
    }

    @Test
    void testActualizarCarta() {
        String nombre = "Carta menu de Restaurante...";
        LocalDateTime fecha = LocalDateTime.now();
        String id = this.crearCartaAPIRest(nombre, fecha);
        CartaDto cartaDto = this.obtenerCartaAPIRest(id);
        nombre = "Nueva Carta Menu";
        cartaDto.setNombre(nombre);
        this.actualizarParcialmenteCartaAPIRest(id, cartaDto);
        cartaDto = this.obtenerCartaAPIRest(id);
        assertEquals(nombre, cartaDto.getNombre());
        assertEquals(fecha, cartaDto.getValidezDesde());
    }

}
