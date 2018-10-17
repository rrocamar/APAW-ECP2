package api;

import api.apiControllers.EmpleadoApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.EmpleadoDto;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    static {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private EmpleadoApiController empleadoApiController = new EmpleadoApiController();

    public void submit(HttpRequest request, HttpResponse response) {
        //TODO
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;

            }
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(EmpleadoApiController.EMPLEADOS)) {
            response.setBody(this.empleadoApiController.create((EmpleadoDto) request.getBody()));

        } else {
            throw new RuntimeException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }


}
