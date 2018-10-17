package api.apiControllers;

import api.businessController.EmpleadoBusinessController;
import api.dtos.EmpleadoDto;
import api.exceptions.ArgumentNotValidException;

public class EmpleadoApiController {

    public static final String EMPLEADOS = "/empleados";

    public static final String ID_ID = "/{id}";

    private EmpleadoBusinessController empleadoBusinessController = new EmpleadoBusinessController();

    public String create(EmpleadoDto empleadoDto) {
        this.validate(empleadoDto, "empleadoDto");
        this.validate(empleadoDto.getNombre(), "EmpleadoDto nombre");
        return this.empleadoBusinessController.create(empleadoDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
