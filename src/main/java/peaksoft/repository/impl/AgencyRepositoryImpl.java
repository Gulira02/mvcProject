package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.model.Agency;
import peaksoft.repository.AgencyRepository;

import java.util.List;
@RequiredArgsConstructor
@Repository
@Transactional

public class AgencyRepositoryImpl implements AgencyRepository {

    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public void saveAgency(Agency agency) {
        entityManager.persist(agency);

    }

    @Override
    public Agency getAgencyById(Long id) {
        return entityManager.find(Agency.class,id);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return entityManager.createQuery("select a from Agency a ", Agency.class).getResultList();
    }

    @Override
    public void updateAgency(Long id, Agency newAgency) {
        Agency agency = entityManager.find(Agency.class, id);
        agency.setName(newAgency.getName());
        agency.setCountry(newAgency.getCountry());
        agency.setPhoneNumber(newAgency.getPhoneNumber());
        agency.setEmail(newAgency.getEmail());
        agency.setImage(newAgency.getImage());
        entityManager.merge(agency);

    }

    @Override
    public void deleteAgencyById(Long id) {
        entityManager.remove(entityManager.find(Agency.class,id));
}

    @Override
    public List<Agency> search(String word) {
        return entityManager.createQuery("select a from Agency a where a.name ilike :word", Agency.class)
                .setParameter("word","%"+word+"%").getResultList();
    }
}
