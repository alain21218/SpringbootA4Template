package fr.asoumagne.Angular4Project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    String[] users = {"Alain", "Clara"};

    @GetMapping("/users")
    public String[] getAllUsers() {
        return users;
    }

    // Create a new Note

    // Get a Single Note

    // Update a Note

    // Delete a Note
}