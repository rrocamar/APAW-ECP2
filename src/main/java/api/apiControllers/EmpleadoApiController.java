package api.apiControllers;

import api.businessController.EmpleadoBusinessController;
import api.dtos.EmpleadoDto;
import api.exceptions.ArgumentNotValidException;

public class EmpleadoApiController {

    public static final String EMPLEADOS = "/empleados";

    public static final String ID_ID = "/{id}";

    private EmpleadoBusinessController empleadoBusinessController = new EmpleadoBusinessController();

    public EmpleadoDto read(String id) {
        return this.empleadoBusinessController.read(id);
    }

    public String create(EmpleadoDto empleadoDto) {
        this.validate(empleadoDto, "empleadoDto");
        this.validate(empleadoDto.getNombre(), "EmpleadoDto nombre");
        return this.empleadoBusinessController.create(empleadoDto);
    }

    public void update(String id, EmpleadoDto empleadoDto) {
        this.validate(empleadoDto, "empleadoDto");
        this.validate(empleadoDto.getNombre(), "EmpleadoDto nombre");
        this.empleadoBusinessController.update(id, empleadoDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
