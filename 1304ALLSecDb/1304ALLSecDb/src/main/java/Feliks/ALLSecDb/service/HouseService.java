package Feliks.ALLSecDb.service;

import Feliks.ALLSecDb.model.House;
import Feliks.ALLSecDb.repository.HouseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HouseService {

    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> viewAllHouses (){
        return houseRepository.findAll();
    }

    public House showConcreteHouse(int id) {
        return viewAllHouses().stream().filter(house -> house.getId()==id).findAny().orElse(null);

    }


}
