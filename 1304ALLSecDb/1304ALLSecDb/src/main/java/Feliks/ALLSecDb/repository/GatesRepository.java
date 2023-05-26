package Feliks.ALLSecDb.repository;

import Feliks.ALLSecDb.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface GatesRepository extends JpaRepository <Gate, Integer> {
    @Override
    List<Gate> findAll();
}
