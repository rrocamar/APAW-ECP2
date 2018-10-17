package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.EmpleadoDao;

public class DaoMemoryFactory extends DaoFactory {

    private EmpleadoDao empleadoDao;

    @Override
    public EmpleadoDao getEmpleadoDao() {
        if (this.empleadoDao == null) {
            this.empleadoDao = new EmpleadoDaoMemory();
        }
        return this.empleadoDao;
    }
}
