package se.lexicon.jpaworkshop34.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.jpaworkshop34.entity.UserDetails;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer> {
    List<UserDetails> findByName(String name);
    Optional<UserDetails> findByEmail(String email);
    List<UserDetails>findByNameContaining(String name);
    List<UserDetails>findByNameIgnoreCase(String name);
    List<UserDetails>findByEmailIgnoreCase(String email);
    List<UserDetails>findByNameContainingIgnoreCase(String name);
    List<UserDetails>findByBirthday(LocalDate birthday);

}
