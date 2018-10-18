import api.apiControllers.CartaApiController;
import api.apiControllers.RestauranteApiController;
import api.dtos.CartaDto;
import api.dtos.RestauranteDto;
import api.entities.Cocina;
import api.entities.Restaurante;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RestauranteIT {

    private String crearRestauranteAPIRest(String nombre, String direccion, Cocina tipo, String idCarta) {
        RestauranteDto restauranteDto = new RestauranteDto();
        restauranteDto.setNombre(nombre);
        restauranteDto.setDireccion(direccion);
        restauranteDto.setTipo(tipo);
        restauranteDto.setIdCarta(idCarta);
        HttpRequest request = HttpRequest.builder(RestauranteApiController.RESTAURANTES).body(restauranteDto).post();
        HttpResponse response = new Client().submit(request);
        return (String) response.getBody();
    }

    private RestauranteDto obtenerRestauranteAPIRest(String id) {
        HttpRequest request = HttpRequest.builder(RestauranteApiController.RESTAURANTES).path(RestauranteApiController.ID_ID)
                .expandPath(id).body(null).get();
        HttpResponse response = new Client().submit(request);
        return (RestauranteDto) response.getBody();
    }

    private String crearCartaAPIRest(String nombre, LocalDateTime fecha) {
        CartaDto cartaDto = new CartaDto();
        cartaDto.setNombre(nombre);
        cartaDto.setValidezDesde(fecha);
        HttpRequest request = HttpRequest.builder(CartaApiController.CARTAS).body(cartaDto).post();
        HttpResponse response = new Client().submit(request);
        return (String) response.getBody();
    }

    @Test
    void testCrearRecuperar() {
        String nombre = "Restaurante Uuno";
        String id = this.crearRestauranteAPIRest(nombre, null, Cocina.HAMBURGUESERIA, null);
        RestauranteDto restauranteDto = this.obtenerRestauranteAPIRest(id);
        assertEquals(nombre, restauranteDto.getNombre());
        assertEquals(Cocina.HAMBURGUESERIA, restauranteDto.getTipo());
        assertNull(restauranteDto.getIdCarta());
        assertNull(restauranteDto.getDireccion());
    }

    @Test
    void testCrearRecuperarConCarta() {
        String nombre = "Restaurante Dos";
        String idCarta = this.crearCartaAPIRest("Carta De mi Restaurante Dos", LocalDateTime.now());
        String id = this.crearRestauranteAPIRest(nombre, null, Cocina.HAMBURGUESERIA, idCarta);
        RestauranteDto restauranteDto = this.obtenerRestauranteAPIRest(id);
        assertEquals(nombre, restauranteDto.getNombre());
        assertEquals(Cocina.HAMBURGUESERIA, restauranteDto.getTipo());
        assertEquals(idCarta, restauranteDto.getIdCarta());
        assertNull(restauranteDto.getDireccion());
    }
}
