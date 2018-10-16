package api.businessController;

import api.dtos.EmpleadoDto;
import api.entities.Empleado;

public class EmpleadoBusinessController {

    public String create(EmpleadoDto empleadoDto) {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setSalarioBrutoAnual(empleadoDto.getSalarioBrutoAnual());
        return empleado.getId();
    }
}
