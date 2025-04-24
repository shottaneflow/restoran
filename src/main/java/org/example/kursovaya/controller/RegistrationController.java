package org.example.kursovaya.controller;



import org.example.kursovaya.model.Client;
import org.example.kursovaya.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg-api")
public class RegistrationController {

    private final UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Client user) {
        try {
            this.userService.addUser(user);
            return ResponseEntity.ok().build();
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
