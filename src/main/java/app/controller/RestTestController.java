package app.controller;

import app.entity.Notes;
import app.entity.User;
import app.repo.NotesRepo;
import app.repo.UserRepo;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

//@RefreshScope
@RestController
@RequestMapping
public class RestTestController {

    public UserRepo userRepo;
    public NotesRepo notesRepo;

    public RestTestController(UserRepo userRepo, NotesRepo notesRepo) {
        this.userRepo = userRepo;
        this.notesRepo = notesRepo;
    }

    @GetMapping("/notes")
    public Collection<Notes> getNotesList(){
        Collection<Notes> g = notesRepo.findAll();
        return g;
    }

    @GetMapping("/users")
    public Collection<User> getUsersList(){
        Collection<User> f = userRepo.findAll();
        return f;
    }
    @GetMapping("/users/{id}")
    public Optional<User> getUserListById(@PathVariable Long id){
        Optional<User> f = userRepo.findById(id);
        f.get().setNotes(notesRepo.getChildNotes(id));
        return f;
    }



    @GetMapping("/fetch")
    public Collection<User> getUserByFetchRequest() {
        return userRepo.getUserByFetch();
    }

    @GetMapping("/fetch/{id}")
    public User getUserByFetchIdRequest(@PathVariable Long id) {
        return userRepo.getUserFetchByUserId(id);
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
