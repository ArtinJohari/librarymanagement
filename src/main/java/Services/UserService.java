package Services;

import Entities.Role;
import Entities.User;
import Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        user.setPassword(user.getPassword());
        user.setRole(user.getRole() != null ? user.getRole() : Role.USER);
        return userRepository.save(user);
    }

    public List<User> getUserByUsername(String username) {
        return new ArrayList<>(userRepository.findByUsername(username));
    }
}
