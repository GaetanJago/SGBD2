package controller.DAO;

import model.Company;
import model.Video;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class VideoDAO extends BaseDAO<Video> {

    public VideoDAO(EntityManager em){
        super(em);
    }

    @Override
    public List<Video> getAll() {
        Query query = super.em.createQuery("FROM Video ");
        return (List<Video>) query.getResultList();
    }

    @Override
    public Video findById(int id) {
        Optional<Video> videoFound = Optional.ofNullable(em.find(Video.class, id));

        if(videoFound.isPresent()){
            return videoFound.get();
        }
        return null;
    }

    public void create(Video video){
        super.create(video);
    }
}
