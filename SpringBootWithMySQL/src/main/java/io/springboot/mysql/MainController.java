package io.springboot.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public User addNewUser(@RequestParam String name, @RequestParam String email) {
        User springUser = new User();

        springUser.setName(name);
        springUser.setEmail(email);

        userRepository.save(springUser);

        return springUser;
    }

    @GetMapping(path = "/list")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
 }
