package org.example.simpleuserap.controller;
import lombok.RequiredArgsConstructor;
import org.example.simpleuserap.exceptionHandler.DublicateEmailException;
import org.example.simpleuserap.exceptionHandler.EmailNotFound;
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
    public ResponseEntity<String> addUser(@RequestBody User user) throws DublicateEmailException {
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
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/users/email/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
    @GetMapping("/users/email/{email}")
    public ResponseEntity<?> getUserById(@PathVariable String email) throws EmailNotFound {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
        }
}
