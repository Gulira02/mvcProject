package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.model.Agency;
import peaksoft.model.House;
import peaksoft.repository.HouseRepository;
import peaksoft.service.HouseService;
import java.util.List;
@RequiredArgsConstructor
@Service
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;
    @Override
    public void saveHouse(Long agencyId, House house) {
        houseRepository.saveHouse(agencyId,house);
    }

    @Override
    public Agency getHouseById(Long id) {

        return houseRepository.getHouseById(id);
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.getAllHouses();
    }

    @Override
    public void updateHouse(Long id, House newHouse) {
        houseRepository.updateHouse(id,newHouse);
    }

    @Override
    public void deleteHouseById(Long id) {
        houseRepository.deleteHouseById(id);

    }
}
