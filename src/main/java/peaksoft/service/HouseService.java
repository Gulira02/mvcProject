package peaksoft.service;

import peaksoft.model.Agency;
import peaksoft.model.House;

import java.util.List;

public interface HouseService {
    void saveHouse(Long agencyId, House house);
    Agency getHouseById(Long id);
    List<House> getAllHouses();
    void updateHouse(Long id, House newHouse);
    void deleteHouseById(Long id);
}
