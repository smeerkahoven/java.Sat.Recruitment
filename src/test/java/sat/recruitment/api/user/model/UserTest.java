package sat.recruitment.api.user.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sat.recruitment.api.user.dto.UserDto;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserBuilder builder;

    private UserDto createUserDto(final String userType, final Double money) {
        final UserDto userDto = new UserDto();
        userDto.setName("Jose");
        userDto.setEmail("jose@mail.com");
        userDto.setAddress("Avenue 123");
        userDto.setPhone("45454545");
        userDto.setUserType(userType);
        userDto.setMoney(money);
        return userDto;
    }

    @Test
    public void testUserCreate() {
        final User user = builder.build(createUserDto("normal", 90d));
        assertThat(user).isNotEqualTo(null);
    }

    @Test
    public void testUserNormalUserMaxMoney() {
        final User user = builder.build(createUserDto("normal", 200d));
        assertThat(user.getMoney()).isEqualTo(224.0d);
    }

    @Test
    public void testUserNormalUserMinMoney() {
        final User user = builder.build(createUserDto("normal", 30d));
        assertThat(user.getMoney()).isEqualTo(54.0d);
    }

    @Test
    public void testUserSuperMoney() {
        final User user = builder.build(createUserDto("superUser", 110d));
        assertThat(user.getMoney()).isEqualTo(132.0d);
    }

    @Test
    public void testUserPremiumMoney() {
        final User user = builder.build(createUserDto("premium", 200d));
        assertThat(user.getMoney()).isEqualTo(600.0d);
    }
}
