package org.example.kursovaya.controller;


import org.example.kursovaya.dto.AuthRequest;
import org.example.kursovaya.model.Client;
import org.example.kursovaya.service.UserService;
import org.example.kursovaya.utils.JwtTokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtTokenUtils jwtTokenUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody Client user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Неправильный логин или пароль", HttpStatus.BAD_REQUEST);
        }
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        AuthRequest authRequest = new AuthRequest();
        authRequest.setToken(token);
        authRequest.setRoles(userDetails.getAuthorities());
        return ResponseEntity.ok(authRequest);
    }

}
