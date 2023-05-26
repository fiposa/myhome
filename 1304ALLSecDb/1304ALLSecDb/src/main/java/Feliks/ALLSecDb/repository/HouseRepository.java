package Feliks.ALLSecDb.repository;

import Feliks.ALLSecDb.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HouseRepository extends JpaRepository<House, Integer> {
    @Override
    Optional<House> findById(Integer integer);

    @Override
    List<House> findAll();

    Optional<House> findHouseByHouseName (String houseName);


}
