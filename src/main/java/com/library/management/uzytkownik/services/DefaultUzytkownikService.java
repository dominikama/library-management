package com.library.management.uzytkownik.services;

import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.uzytkownik.UzytkownikRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * The type Default uzytkownik service.
 */
@Service
public class DefaultUzytkownikService implements UzytkownikService {

    private UzytkownikRepository uzytkownikRepository;

    private PasswordEncoder passwordEncoder;

    /**
     * Instantiates a new Default uzytkownik service.
     *
     * @param uzytkownikRepository the uzytkownik repository
     * @param passwordEncoder      the password encoder
     */
    public DefaultUzytkownikService(UzytkownikRepository uzytkownikRepository, PasswordEncoder passwordEncoder) {
        this.uzytkownikRepository = uzytkownikRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Uzytkownik rejestracjaUzytkownika(Uzytkownik uzytkownik) {
       uzytkownik.setPassword(passwordEncoder.encode(uzytkownik.getPassword()));
        uzytkownik.setRole("ROLE_USER");
        return uzytkownikRepository.save(uzytkownik);
    }

    @Override
    public Uzytkownik findByUsername(String username) {
        return uzytkownikRepository.findByUsername(username).orElseThrow(() ->
                new NoSuchElementException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Uzytkownik user = uzytkownikRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().substring(5))
                .build();
    }
}
