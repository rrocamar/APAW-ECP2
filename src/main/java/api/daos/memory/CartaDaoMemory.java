package api.daos.memory;

import api.daos.CartaDao;
import api.entities.Carta;

public class CartaDaoMemory extends GenericDaoMemory<Carta> implements CartaDao {

    @Override
    public String getId(Carta carta) {
        return carta.getId();
    }

    @Override
    public void setId(Carta carta, String id) {
        carta.setId(id);
    }
}
