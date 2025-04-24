package org.example.kursovaya.service;


import org.example.kursovaya.model.Authority;
import org.example.kursovaya.model.Client;
import org.example.kursovaya.repo.ClientRepo;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final ClientRepo clientRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(ClientRepo clientRepo,
                       PasswordEncoder passwordEncoder) {
        this.clientRepo = clientRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public UserDetails loadUserByUsername(String username)  {
        Client user=this.clientRepo.findByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("Пользователь"+username+" не найден"));
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities().stream()
                        .map(Authority::getAuthority)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));

    }
    public Client findByUsername(String username) {
        return this.clientRepo.findByUsername(username).orElse(null);
    }

    public void addUser(Client user) {
        Client vetUser=this.clientRepo.findByUsername(user.getUsername())
                .orElse(null);
        if (vetUser!=null){
            throw new BadCredentialsException("Пользователь уже существует");
        }
        Authority auth = new Authority();
        auth.setId(2);
        auth.setAuthority("ROLE_USER");
        user.addAuthorities(auth);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.clientRepo.save(user);
    }
    public void updateUser(Client user) {
        this.clientRepo.save(user);
    }
}
