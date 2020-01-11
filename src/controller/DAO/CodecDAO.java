package controller.DAO;

import model.Codec;
import model.Company;
import model.Player;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class CodecDAO extends BaseDAO<Codec> {

    public CodecDAO(EntityManager em){
        super(em);
    }

    @Override
    public List<Codec> getAll() {
        Query query = super.em.createQuery("FROM Codec ");
        return (List<Codec>) query.getResultList();
    }

    @Override
    public Codec findById(int id) {
        Optional<Codec> codecFound = Optional.ofNullable(em.find(Codec.class, id));

        if(codecFound.isPresent()){
            return codecFound.get();
        }
        return null;
    }

    public void create(Codec codec){
        /*for (Player player: codec.getPlayers()
             ) {
            player.addCodec(codec);
        }*/

        super.create(codec);
        /*if(codec.getFormat() != null){
            codec.getFormat().addCodec(codec);
        }
        if(codec.getCompany() != null){
            codec.getCompany().addCodec(codec);
        }*/
    }
}
