package api.daos.memory;

import api.daos.EmpleadoDao;
import api.entities.Empleado;

public class EmpleadoDaoMemory extends GenericDaoMemory<Empleado> implements EmpleadoDao {

    @Override
    public String getId(Empleado empleado) {
        return empleado.getId();
    }

    @Override
    public void setId(Empleado empleado, String id) {
        empleado.setId(id);
    }
}
