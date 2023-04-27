package Feliks.ALLSecDb.Repository;

import Feliks.ALLSecDb.Model.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Override
    Optional<Room> findById(Integer integer);
}
