package com.library.management.uzytkownik.services;

import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.uzytkownik.UzytkownikRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * The type Default uzytkownik service test.
 */
class DefaultUzytkownikServiceTest {

    @Mock
    private UzytkownikRepository uzytkownikRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private DefaultUzytkownikService uzytkownikService;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test rejestracja uzytkownika.
     */
    @Test
    void testRejestracjaUzytkownika() {
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setUsername("testuser");
        uzytkownik.setPassword("password");

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(uzytkownikRepository.save(any(Uzytkownik.class))).thenReturn(uzytkownik);

        Uzytkownik savedUser = uzytkownikService.rejestracjaUzytkownika(uzytkownik);

        assertNotNull(savedUser);
        assertEquals("encodedPassword", savedUser.getPassword());
        assertEquals("ROLE_USER", savedUser.getRole());
        verify(uzytkownikRepository, times(1)).save(any(Uzytkownik.class));
    }

    /**
     * Test find by username user exists.
     */
    @Test
    void testFindByUsernameUserExists() {
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setUsername("testuser");

        when(uzytkownikRepository.findByUsername(anyString())).thenReturn(Optional.of(uzytkownik));

        Uzytkownik foundUser = uzytkownikService.findByUsername("testuser");

        assertNotNull(foundUser);
        assertEquals("testuser", foundUser.getUsername());
        verify(uzytkownikRepository, times(1)).findByUsername(anyString());
    }

    /**
     * Test find by username user not found.
     */
    @Test
    void testFindByUsernameUserNotFound() {
        when(uzytkownikRepository.findByUsername(anyString())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> uzytkownikService.findByUsername("testuser"));
        verify(uzytkownikRepository, times(1)).findByUsername(anyString());
    }

    /**
     * Test load user by username user exists.
     */
    @Test
    void testLoadUserByUsernameUserExists() {
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setUsername("testuser");
        uzytkownik.setPassword("password");
        uzytkownik.setRole("ROLE_USER");

        when(uzytkownikRepository.findByUsername(anyString())).thenReturn(Optional.of(uzytkownik));

        UserDetails userDetails = uzytkownikService.loadUserByUsername("testuser");

        assertNotNull(userDetails);
        assertEquals("testuser", userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_USER")));
        verify(uzytkownikRepository, times(1)).findByUsername(anyString());
    }

    /**
     * Test load user by username user not found.
     */
    @Test
    void testLoadUserByUsernameUserNotFound() {
        when(uzytkownikRepository.findByUsername(anyString())).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> uzytkownikService.loadUserByUsername("testuser"));
        verify(uzytkownikRepository, times(1)).findByUsername(anyString());
    }
}
