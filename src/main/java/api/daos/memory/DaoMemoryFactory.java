package api.daos.memory;

import api.daos.CartaDao;
import api.daos.DaoFactory;
import api.daos.EmpleadoDao;
import api.daos.RestauranteDao;

public class DaoMemoryFactory extends DaoFactory {

    private EmpleadoDao empleadoDao;

    private CartaDao cartaDao;

    private RestauranteDao restauranteDao;

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

    @Override
    public RestauranteDao getRestauranteDao() {
        if (this.restauranteDao == null) {
            this.restauranteDao = new RestauranteDaoMemory();
        }
        return this.restauranteDao;
    }
}
