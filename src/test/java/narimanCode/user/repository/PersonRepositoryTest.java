package narimanCode.user.repository;

import narimanCode.user.entity.Person;
import narimanCode.user.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void testSaveAndFindByUsername() {
        // Arrange
        Role role = Role.builder()
                .name("USER")
                .build();
        roleRepository.save(role);

        Person person = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .username("johndoe")
                .email("john.doe@example.com")
                .password("encodedPassword")
                .phoneNumber("1234567890")
                .accountLocked(false)
                .role(role)
                .build();

        // Act
        personRepository.save(person);
        Optional<Person> foundPerson = personRepository.findByUsername("johndoe");

        // Assert
        assertThat(foundPerson).isPresent();
        assertThat(foundPerson.get().getUsername()).isEqualTo("johndoe");
        assertThat(foundPerson.get().getEmail()).isEqualTo("john.doe@example.com");
    }
}