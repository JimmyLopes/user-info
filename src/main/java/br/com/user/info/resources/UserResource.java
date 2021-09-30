package br.com.user.info.resources;

import br.com.user.info.model.User;
import br.com.user.info.repository.UserRepository;
import br.com.user.info.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public User saveNew(@RequestBody User product) {
        return userService.saveUser(product);
    }

    @DeleteMapping
    public void deleteAll(@PathVariable Long userId) { userService.deleteUser(userId); }
}
