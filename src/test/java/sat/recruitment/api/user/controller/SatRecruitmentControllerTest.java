package sat.recruitment.api.user.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import sat.recruitment.api.SatRecruitmentApplication;
import sat.recruitment.api.controller.SatRecruitmentController;
import sat.recruitment.api.user.dto.UserDto;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SatRecruitmentApplication.class)
public class SatRecruitmentControllerTest {

    @Autowired
    private SatRecruitmentController controller;

    @Test
    void testCreateDuplicateUser() {
        final UserDto newUser = createDuplicatedUserDto();
        assertThat(controller.createUser(newUser).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateNewUser() {
        final UserDto newUser = createNewUserDto();
        assertThat(controller.createUser(newUser).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    private UserDto createDuplicatedUserDto() {
        final UserDto userDto = new UserDto();
        userDto.setName("Agustina");
        userDto.setEmail("Agustina@gmail.com");
        userDto.setAddress("Garay y Otra Calle");
        userDto.setPhone("+534645213542");
        userDto.setUserType("SuperUser");
        userDto.setMoney(112234d);
        return userDto;
    }

    private UserDto createNewUserDto() {
        final UserDto userDto = new UserDto();
        userDto.setName("Marcela");
        userDto.setEmail("marcela@gmail.com");
        userDto.setAddress("Ayacucho y Junin");
        userDto.setPhone("+343433434");
        userDto.setUserType("Normal");
        userDto.setMoney(234d);
        return userDto;
    }

}
