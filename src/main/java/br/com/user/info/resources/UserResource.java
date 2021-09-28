package br.com.user.info.resources;

import br.com.user.info.model.User;
import br.com.user.info.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getall() {
        return userRepository.findAll();
    }

    @PostMapping
    public User saveNew(@RequestBody User product) {
        return userRepository.save(product);
    }

    @DeleteMapping
    public void deleteAll() { userRepository.deleteAll(); }
}
