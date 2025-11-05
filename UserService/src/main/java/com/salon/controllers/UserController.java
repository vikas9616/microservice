package com.salon.controllers;

import com.salon.model.User;
import com.salon.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {

        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) throws Exception {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @GetMapping("/api/users/{userId}")
//    public User getUserById(@PathVariable("userId") Long id) throws Exception {
//    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> UpdateUser(@RequestBody User user, @PathVariable Long id) throws Exception {

        User updatedUser = userService.updateUser(user, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> DeleteById(@RequestBody User user, @PathVariable Long id) throws Exception {

        userService.deleteById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);

    }
}
