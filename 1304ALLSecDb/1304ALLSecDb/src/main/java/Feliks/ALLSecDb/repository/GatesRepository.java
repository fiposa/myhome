package Feliks.ALLSecDb.repository;

import Feliks.ALLSecDb.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.lang.NonNullApi;

import java.util.List;

@Repository

public interface GatesRepository extends JpaRepository <Gate, Integer> {

}
