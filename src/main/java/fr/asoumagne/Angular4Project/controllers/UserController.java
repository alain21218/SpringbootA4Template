package fr.asoumagne.Angular4Project.controllers;

import fr.asoumagne.Angular4Project.models.User;
import fr.asoumagne.Angular4Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create
    @PostMapping("/users")
    public User createUsers(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    // Get specific
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    // Update
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {
        User user = userRepository.findOne(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setId(userDetails.getId());
        user.setName(userDetails.getName());

        User updatedNote = userRepository.save(user);
        return ResponseEntity.ok(updatedNote);
    }

    // Delete
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userId) {
        User note = userRepository.findOne(userId);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}