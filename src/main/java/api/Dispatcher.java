package api;

import api.apiControllers.CartaApiController;
import api.apiControllers.EmpleadoApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.CartaDto;
import api.dtos.EmpleadoDto;
import api.entities.Carta;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    static {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private EmpleadoApiController empleadoApiController = new EmpleadoApiController();

    private CartaApiController cartaApiController = new CartaApiController();

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    this.doGet(request, response);
                    break;
                case PUT:
                    this.doPut(request);
                    break;
                case PATCH:
                    this.doPatch(request);
                    break;
                default: // Unexpected
                    throw new RequestInvalidException("method error: " + request.getMethod());

            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(EmpleadoApiController.EMPLEADOS)) {
            response.setBody(this.empleadoApiController.create((EmpleadoDto) request.getBody()));
        } else if (request.isEqualsPath(CartaApiController.CARTAS))
            response.setBody(this.cartaApiController.create((CartaDto) request.getBody()));
        else {
            throw new RuntimeException("request error: " + request.getMethod() + ' ' + request.getPath());
        }

    }

    private void doGet(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(CartaApiController.CARTAS + CartaApiController.ID_ID)) {
            response.setBody(this.cartaApiController.read((String) request.getPath(1)));
        } else if (request.isEqualsPath(EmpleadoApiController.EMPLEADOS + EmpleadoApiController.ID_ID)) {
            response.setBody(this.empleadoApiController.read((String) request.getPath(1)));
        } else {
            throw new RuntimeException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPut(HttpRequest request) {
        if (request.isEqualsPath(EmpleadoApiController.EMPLEADOS + EmpleadoApiController.ID_ID)) {
            this.empleadoApiController.update(request.getPath(1), (EmpleadoDto) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPatch(HttpRequest request) {
        if (request.isEqualsPath(CartaApiController.CARTAS + CartaApiController.ID_ID)) {
            this.cartaApiController.update(request.getPath(1), (CartaDto) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

}
