package sat.recruitment.api.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sat.recruitment.api.SatRecruitmentApplication;
import sat.recruitment.api.user.dto.UserDto;
import sat.recruitment.api.user.model.UserBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SatRecruitmentApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserBuilder userBuilder;

    @Test
    void testCreateDuplicateName() {
        assertThat(userService.isDuplicated(userBuilder.build(createDuplicatedUserDto()))).isTrue();
    }

    @Test
    void testCreateDuplicateEmail() {
        assertThat(userService.isDuplicated(userBuilder.build(createDuplicatedEmailUserDto()))).isTrue();
    }

    @Test
    void testCreateDuplicatePhone() {
        assertThat(userService.isDuplicated(userBuilder.build(createDuplicatedPhoneUserDto()))).isTrue();
    }

    @Test
    void testCreateNewUser() {
        assertThat(userService.isDuplicated(userBuilder.build(createNewUserDto()))).isFalse();
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

    private UserDto createDuplicatedEmailUserDto() {
        final UserDto userDto = new UserDto();
        userDto.setName("Marcelo");
        userDto.setEmail("Agustina@gmail.com");
        userDto.setAddress("Garay y Otra Calle");
        userDto.setPhone("+534645213542");
        userDto.setUserType("SuperUser");
        userDto.setMoney(112234d);
        return userDto;
    }

    private UserDto createDuplicatedPhoneUserDto() {
        final UserDto userDto = new UserDto();
        userDto.setName("Marcelo");
        userDto.setEmail("marcelo@gmail.com");
        userDto.setAddress("Garay y Otra Calle");
        userDto.setPhone("+534645213542");
        userDto.setUserType("SuperUser");
        userDto.setMoney(112234d);
        return userDto;
    }

    private UserDto createNewUserDto() {
        final UserDto userDto = new UserDto();
        userDto.setName("jose");
        userDto.setEmail("jose@gmail.com");
        userDto.setAddress("Ayacucho y Junin");
        userDto.setPhone("+534343433542");
        userDto.setUserType("SuperUser");
        userDto.setMoney(1124d);
        return userDto;
    }
}
