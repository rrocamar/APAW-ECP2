import api.apiControllers.EmpleadoApiController;
import api.daos.DaoFactory;
import api.dtos.EmpleadoDto;
import api.entities.Empleado;
import api.exceptions.NotFoundException;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoIT {

    private String crearEmpleadoAPIRest(String nombre, double salario) {
        EmpleadoDto empleadoDto = new EmpleadoDto();
        empleadoDto.setNombre(nombre);
        empleadoDto.setSalarioBrutoAnual(salario);
        HttpRequest request = HttpRequest.builder(EmpleadoApiController.EMPLEADOS).body(empleadoDto).post();
        HttpResponse response = new Client().submit(request);
        return (String) response.getBody();
    }

    private EmpleadoDto obtenerEmpleadoAPIRest(String id) {
        HttpRequest request = HttpRequest.builder(EmpleadoApiController.EMPLEADOS).path(EmpleadoApiController.ID_ID)
                .expandPath(id).body(null).get();
        HttpResponse response = new Client().submit(request);
        return (EmpleadoDto) response.getBody();
    }

    private void actualizarEmpleadoAPIRest(String id, EmpleadoDto empleadoDto) {
        HttpRequest request = HttpRequest.builder(EmpleadoApiController.EMPLEADOS).path(EmpleadoApiController.ID_ID)
                .expandPath(id).body(empleadoDto).put();
        new Client().submit(request);
    }

    @Test
    void testCrearRecuperar() {
        String nombre = "Pepe";
        double salario = 24507.45;
        String id = this.crearEmpleadoAPIRest(nombre, salario);
        Empleado empleado = DaoFactory.getFactory().getEmpleadoDao().read(id)
                .orElseThrow(() -> new NotFoundException("Empleado (" + id + ")"));
        assertEquals(nombre, empleado.getNombre());
        assertEquals(salario, empleado.getSalarioBrutoAnual(), 10e-5);
    }

    @Test
    void testActualizar() {
        String nombre = "Antonio";
        double salario = 123057.73;
        String id = this.crearEmpleadoAPIRest(nombre, salario);
        EmpleadoDto empleadoDto = obtenerEmpleadoAPIRest(id);
        nombre = "Maria";
        salario = 23057.73;
        empleadoDto.setNombre(nombre);
        empleadoDto.setSalarioBrutoAnual(salario);
        this.actualizarEmpleadoAPIRest(id, empleadoDto);
        empleadoDto = obtenerEmpleadoAPIRest(id);
        assertEquals(nombre, empleadoDto.getNombre());
        assertEquals(salario, empleadoDto.getSalarioBrutoAnual(), 10e-5);
    }

}
