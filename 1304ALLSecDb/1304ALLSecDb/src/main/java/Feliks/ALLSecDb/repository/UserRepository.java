package Feliks.ALLSecDb.repository;

import Feliks.ALLSecDb.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);


    void deleteByUsername (String username);

    List<User> findAll ();



}
