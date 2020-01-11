package controller.DAO;

import model.Company;
import model.Format;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class FormatDAO extends BaseDAO<Format> {

    public FormatDAO(EntityManager em){
        super(em);
    }

    @Override
    public List<Format> getAll() {
        Query query = super.em.createQuery("FROM Format ");
        return (List<Format>) query.getResultList();
    }

    @Override
    public Format findById(int id) {
        Optional<Format> formatFound = Optional.ofNullable(em.find(Format.class, id));

        if(formatFound.isPresent()){
            return formatFound.get();
        }

        return null;
    }

    public void create(Format format){
        super.create(format);
    }

    public void delete(Format format){
        super.delete(format);
    }
}
