package org.example.simpleuserap.controller;
import lombok.RequiredArgsConstructor;
import org.example.simpleuserap.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.simpleuserap.service.UserService;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        for (User user1 : userService.getUsers()) {
            if (user1.getEmail().equals(user.getEmail()))
                return new ResponseEntity<>("User with email " + user.getEmail() + " already exists", HttpStatus.BAD_REQUEST);

        }
        userService.addUser(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {

        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    @PutMapping("/users")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        try {
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @DeleteMapping("/users/email/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        try {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/users/email/{email}")
    public ResponseEntity<?> getUserById(@PathVariable String email) {

        if(userService.getUserByEmail(email) != null)
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
        else
            return new ResponseEntity<>("User with email " + email + "not found", HttpStatus.NOT_FOUND);
    }
}
