package net.breezeware.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.breezeware.dao.UserRepository;
import net.breezeware.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public String createUser(User user) {

        if (user.getFirstName() == null || user.getFirstName().isBlank() || user.getEmail() == null || user.getEmail().isBlank()) {
            return "Invalid Inputs";
        }
        if (!isValidEmail(user.getEmail())) {
            return "Invalid Email";
        }
        user.setCreatedOn(Instant.now());
        user.setModifiedOn(Instant.now());
        userRepository.save(user);
        return "User created successfully";
    }

    private boolean isValidEmail(String email) {
        // Email regex pattern
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Transactional
    public String updateUser(long userId, User user) {
        if (user.getFirstName() == null || user.getFirstName().isBlank() || user.getEmail() == null || user.getEmail().isBlank()) {
            return "Invalid Inputs";
        }
        if (!isValidEmail(user.getEmail())) {
            return "Invalid Email";
        }
        val retrievedUser = userRepository.findById(userId).orElseThrow();
        retrievedUser.setFirstName(user.getFirstName());
        retrievedUser.setLastName(user.getLastName());
        retrievedUser.setEmail(user.getEmail());
        retrievedUser.setPhoneNumber(user.getPhoneNumber());
        retrievedUser.setModifiedOn(Instant.now());
        userRepository.save(user);
        return "User updated successfully";
    }

    @Transactional
    public String deleteUser(long userId) {
        userRepository.findById(userId).orElseThrow();
        userRepository.deleteById(userId);
        return "User deleted successfully";
    }
}
