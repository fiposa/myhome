package Feliks.ALLSecDb.Repository;

import Feliks.ALLSecDb.Model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HouseRepository extends JpaRepository<House, Integer> {
    @Override
    Optional<House> findById(Integer integer);

    Optional<House> findHouseByHouseName (String houseName);
}
