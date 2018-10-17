package api.apiControllers;

import api.businessController.EmpleadoBusinessController;
import api.dtos.EmpleadoDto;

public class EmpleadoApiController {

    public static final String EMPLEADOS = "/empleados";

    public static final String ID_ID = "/{id}";

    private EmpleadoBusinessController empleadoBusinessController = new EmpleadoBusinessController();

    public String create(EmpleadoDto empleadoDto) {
        return this.empleadoBusinessController.create(empleadoDto);
    }
}
