package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.model.Agency;
import peaksoft.model.House;
import peaksoft.repository.HouseRepository;

import java.util.List;
@RequiredArgsConstructor
@Repository
@Transactional
public class HouseRepositoryImpl implements HouseRepository {

    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public void saveHouse(Long agencyId, House house) {
        Agency agency = entityManager.find(Agency.class, agencyId);
        agency.getHouses().add(house);
        house.setAgency(agency);
        entityManager.persist(house);
    }

    @Override
    public Agency getHouseById(Long id) {
        return entityManager.find(Agency.class,id);
    }

    @Override
    public List<House> getAllHouses() {
        return entityManager.createQuery("select h from House  h", House.class).getResultList();
    }

    @Override
    public void updateHouse(Long id, House newHouse) {
        House house = entityManager.find(House.class, id);
        house.setHouseType(newHouse.getHouseType());
        house.setPrice(newHouse.getPrice());
        house.setRoom(newHouse.getRoom());
        house.setCountry(newHouse.getCountry());
        house.setDescription(newHouse.getDescription());
        house.setIsBooked(newHouse.getIsBooked());
        house.setImage(newHouse.getImage());
    }

    @Override
    public void deleteHouseById(Long id) {
       //entityManager.remove(entityManager.find(House.class,id));
        House house = entityManager.find(House.class, id);
        Agency agency = house.getAgency();
        agency.getHouses().forEach(a -> a.getAgency().setHouses(null));
        entityManager.remove(house);

    }

}
