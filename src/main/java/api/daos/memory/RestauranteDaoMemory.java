package api.daos.memory;

import api.daos.RestauranteDao;
import api.entities.Restaurante;

public class RestauranteDaoMemory extends GenericDaoMemory<Restaurante> implements RestauranteDao {

    @Override
    public String getId(Restaurante restaurante) {
        return restaurante.getId();
    }

    @Override
    public void setId(Restaurante restaurante, String id) {
        restaurante.setId(id);
    }
}
