package api.daos.memory;

import api.daos.CartaDao;
import api.daos.DaoFactory;
import api.daos.EmpleadoDao;

public class DaoMemoryFactory extends DaoFactory {

    private EmpleadoDao empleadoDao;

    private CartaDao cartaDao;

    public DaoMemoryFactory() {
    }

    @Override
    public EmpleadoDao getEmpleadoDao() {
        if (this.empleadoDao == null) {
            this.empleadoDao = new EmpleadoDaoMemory();
        }
        return this.empleadoDao;
    }

    @Override
    public CartaDao getCartaDao() {
        if (this.cartaDao == null) {
            this.cartaDao = new CartaDaoMemory();
        }
        return this.cartaDao;
    }
}
