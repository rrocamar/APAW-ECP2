import api.apiControllers.RestauranteApiController;
import api.dtos.RestauranteDto;
import api.entities.Cocina;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestauranteIT {

    private String crearRestauranteAPIRest(String nombre, String direccion, Cocina tipo) {
        RestauranteDto restauranteDto = new RestauranteDto();
        restauranteDto.setNombre(nombre);
        restauranteDto.setDireccion(direccion);
        restauranteDto.setTipo(tipo);
        HttpRequest request = HttpRequest.builder(RestauranteApiController.RESTAURANTES).body(restauranteDto).post();
        HttpResponse response = new Client().submit(request);
        return (String) response.getBody();
    }

    @Test
    void testCrearRecuperar() {
        String nombre = "Restaurante Uuno";
        String id = this.crearRestauranteAPIRest(nombre, null, Cocina.HAMBURGUESERIA);
    }
}
