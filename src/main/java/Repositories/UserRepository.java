package Repositories;

import Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByUsername(String username);
    public List<User> findByEmail(String email);
}
