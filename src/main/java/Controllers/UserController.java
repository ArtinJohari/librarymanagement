package Controllers;

import Entities.User;
import Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/auth/register")
    public void register(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping("/users/{username}")
    public List<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

}
