package net.breezeware.controller;

import net.breezeware.entity.User;
import net.breezeware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/{user-id}")
    public void updateUser(@PathVariable(name = "user-id") long userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }

    @DeleteMapping("/{user-id}")
    public void deleteUser(@PathVariable(name = "user-id") long userId) {
        userService.deleteUser(userId);
    }
}
