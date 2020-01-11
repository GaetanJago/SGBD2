package controller.DAO;

import model.Codec;
import model.Company;
import model.Player;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class PlayerDAO extends BaseDAO<Player> {

    public PlayerDAO(EntityManager em){
        super(em);
    }

    @Override
    public List<Player> getAll() {
        Query query = super.em.createQuery("FROM Player ");
        return (List<Player>) query.getResultList();
    }

    @Override
    public Player findById(int id) {
        Optional<Player> playerFound = Optional.ofNullable(em.find(Player.class, id));

        if(playerFound.isPresent()){
            return playerFound.get();
        }
        return null;
    }

    public void create(Player player){
        super.create(player);
    }

    public void delete(Player player){
        for (Codec codec: player.getCodecs()) {
            codec.getPlayers().remove(player);
        }
        super.delete(player);
    }
}
