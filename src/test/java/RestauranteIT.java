import api.apiControllers.CartaApiController;
import api.apiControllers.EmpleadoApiController;
import api.apiControllers.RestauranteApiController;
import api.dtos.CartaDto;
import api.dtos.EmpleadoDto;
import api.dtos.RestauranteDto;
import api.entities.Cocina;
import api.entities.Restaurante;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

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

    private void asignarCartaARestauranteAPIRest(String idRestaurante, String nombreCarta) {
        HttpRequest request = HttpRequest.builder(RestauranteApiController.RESTAURANTES).path(RestauranteApiController.ID_ID)
                .expandPath(idRestaurante).path(RestauranteApiController.CARTA).body(nombreCarta).post();
        new Client().submit(request);
    }

    private void asignarEmpleadoARestauranteAPIRest(String idRestaurante, String nombreEmpleado) {
        HttpRequest request = HttpRequest.builder(RestauranteApiController.RESTAURANTES).path(RestauranteApiController.ID_ID)
                .expandPath(idRestaurante).path(RestauranteApiController.EMPLEADOS).body(nombreEmpleado).post();
        new Client().submit(request);
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

    @Test
    void testAsignarCartaARestaurante() {
        String nombre = "Restaurante Tres";
        String id = this.crearRestauranteAPIRest(nombre, null, Cocina.PIZZERIA, null);
        RestauranteDto restauranteDto = this.obtenerRestauranteAPIRest(id);
        assertNull(restauranteDto.getIdCarta());
        this.asignarCartaARestauranteAPIRest(id, "Mi nueva carta");
        restauranteDto = this.obtenerRestauranteAPIRest(id);
        assertNotNull(restauranteDto.getIdCarta());
    }

    @Test
    void testAsignarEmpleadoARestaurante() {
        String nombre = "Restaurante Cuatro";
        String id = this.crearRestauranteAPIRest(nombre, null, Cocina.PIZZERIA, null);
        RestauranteDto restauranteDto = this.obtenerRestauranteAPIRest(id);
        assertEquals(0, restauranteDto.getIdsEmpleados().size());
        this.asignarEmpleadoARestauranteAPIRest(id, "Pepe Roriguez");
        restauranteDto = this.obtenerRestauranteAPIRest(id);
        assertTrue(restauranteDto.getIdsEmpleados().size() > 0);
    }
}
