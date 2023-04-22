package sat.recruitment.api.user.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sat.recruitment.api.SatRecruitmentApplication;
import sat.recruitment.api.user.UserRepository;
import sat.recruitment.api.user.model.User;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest(classes = SatRecruitmentApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void testReadUsers() {
        final List<User> users = repository.read();
        assertThat(users).isNotNull();
    }
}
