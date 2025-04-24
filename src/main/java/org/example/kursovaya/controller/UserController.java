package org.example.kursovaya.controller;

import org.example.kursovaya.model.Client;
import org.example.kursovaya.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("/user-api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserInformation(@RequestBody Client vetUser,
                                                   Principal principal) {
        Client user=this.userService.findByUsername(principal.getName());
        if (!Objects.equals(vetUser.getPhone(), "")){
            user.setPhone(vetUser.getPhone());
        }
        if (!Objects.equals(vetUser.getClientName(), "")){
            user.setClientName(vetUser.getClientName());
        }
        this.userService.updateUser(user);
        return ResponseEntity.ok(user);

    }
    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(Principal principal) {
        Client user=this.userService.findByUsername(principal.getName());
        return ResponseEntity.ok(user);
    }


}
