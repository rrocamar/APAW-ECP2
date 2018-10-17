import api.apiControllers.EmpleadoApiController;
import api.dtos.EmpleadoDto;
import http.Client;
import http.HttpRequest;
import org.junit.jupiter.api.Test;

public class EmpleadoIT {

    @Test
    void testCrear() {
        EmpleadoDto empleadoDto = new EmpleadoDto();
        empleadoDto.setNombre("Pepe");
        empleadoDto.setSalarioBrutoAnual(24507.45);
        HttpRequest request = HttpRequest.builder(EmpleadoApiController.EMPLEADOS).body(empleadoDto).post();
        new Client().submit(request);
    }

}
