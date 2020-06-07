package app.controller;

import app.entity.User;
import app.repo.UserRepo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(path = "/users")
public class RestTestController {

    public UserRepo userRepo;

    public RestTestController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public Iterable<User> getUsersList(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUsersById(@PathVariable Long id){
        return userRepo.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User setUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User putUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User patchUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id){
        User user = userRepo.findById(id).get();
        userRepo.delete(user);
    }

}
