import api.apiControllers.EmpleadoApiController;
import api.daos.DaoFactory;
import api.dtos.EmpleadoDto;
import api.entities.Empleado;
import api.exceptions.NotFoundException;
import http.Client;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoIT {

    @Test
    void testCrear() {
        EmpleadoDto empleadoDto = new EmpleadoDto();
        empleadoDto.setNombre("Pepe");
        empleadoDto.setSalarioBrutoAnual(24507.45);
        HttpRequest request = HttpRequest.builder(EmpleadoApiController.EMPLEADOS).body(empleadoDto).post();
        HttpResponse response = new Client().submit(request);
        String id = (String) response.getBody();
        Empleado empleado = DaoFactory.getFactory().getEmpleadoDao().read(id)
                .orElseThrow(() -> new NotFoundException("Empleado (" + id + ")"));
        assertEquals(empleadoDto.getNombre(), empleado.getNombre());
        assertEquals(empleadoDto.getSalarioBrutoAnual(), empleado.getSalarioBrutoAnual(), 10e-5);
    }

}
