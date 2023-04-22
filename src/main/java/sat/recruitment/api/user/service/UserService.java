package sat.recruitment.api.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sat.recruitment.api.user.UserRepository;
import sat.recruitment.api.user.model.User;

import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isDuplicated(final User user) {
        final List<User> users = userRepository.read();
        return users.stream().anyMatch(exists(user));
    }

    private Predicate<User> exists(final User newUser) {
        return (user ->
                user.getEmail().equals(newUser.getEmail()) ||
                        user.getPhone().equals(newUser.getPhone()) ||
                        (user.getName().equals(newUser.getName()) && user.getAddress().equals(newUser.getAddress())));
    }
}
