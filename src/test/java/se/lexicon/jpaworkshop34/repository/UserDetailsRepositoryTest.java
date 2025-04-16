package se.lexicon.jpaworkshop34.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpaworkshop34.entity.UserDetails;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserDetailsRepositoryTest {
    @Autowired
    private UserDetailsRepository userDetailsRepository;


    @Test
    void findByName() {
        UserDetails details = new UserDetails();
        details.setName("John");
        details.setEmail("john@example.com");
        userDetailsRepository.save(details);
        List<UserDetails> userDetails = userDetailsRepository.findByName("John");
        Assertions.assertNotNull(userDetails);
    }


    @Test
    void findByEmail() {
    }

    @Test
    void findByNameContaining() {
    }

    @Test
    void findByNameIgnoreCase() {
    }

    @Test
    void findByEmailIgnoreCase() {
    }

    @Test
    void findByNameContainingIgnoreCase() {
    }

    @Test
    void findByBirthday() {
    }
}