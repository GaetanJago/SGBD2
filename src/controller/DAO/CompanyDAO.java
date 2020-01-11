package controller.DAO;

import model.Company;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class CompanyDAO extends BaseDAO<Company> {

    public CompanyDAO(EntityManager em){
        super(em);
    }

    @Override
    public List<Company> getAll() {
        Query query = super.em.createQuery("FROM Company ");
        return (List<Company>) query.getResultList();
    }

    @Override
    public Company findById(int id) {
        Optional<Company> companyFound = Optional.ofNullable(em.find(Company.class, id));

        if(companyFound.isPresent()){
            return companyFound.get();
        }
        return null;
    }

    public void create(Company company){
        super.create(company);
    }
}
