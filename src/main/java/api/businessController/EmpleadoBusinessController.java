package api.businessController;

import api.daos.DaoFactory;
import api.dtos.EmpleadoDto;
import api.entities.Empleado;
import api.exceptions.NotFoundException;

public class EmpleadoBusinessController {

    public String create(EmpleadoDto empleadoDto) {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setSalarioBrutoAnual(empleadoDto.getSalarioBrutoAnual());
        DaoFactory.getFactory().getEmpleadoDao().save(empleado);
        return empleado.getId();
    }

    public EmpleadoDto read(String id) {
        return new EmpleadoDto(DaoFactory.getFactory().getEmpleadoDao().read(id)
                .orElseThrow(() -> new NotFoundException("Empleado (" + id + ")")));
    }

    public void update(String id, EmpleadoDto empleadoDto) {
        Empleado empleado = DaoFactory.getFactory().getEmpleadoDao().read(id)
                .orElseThrow(() -> new NotFoundException("Empleado (" + id + ")"));
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setSalarioBrutoAnual(empleadoDto.getSalarioBrutoAnual());
        DaoFactory.getFactory().getEmpleadoDao().save(empleado);
    }
}
