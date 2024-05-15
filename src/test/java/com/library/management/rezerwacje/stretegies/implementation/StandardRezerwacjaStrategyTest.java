package com.library.management.rezerwacje.stretegies.implementation;

import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.ksiazka.repositories.KsiazkaRepository;
import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.uzytkownik.UzytkownikRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class StandardRezerwacjaStrategyTest {


    @Mock
    private UzytkownikRepository uzytkownikRepository;

    @Mock
    private KsiazkaRepository ksiazkaRepository;

    @InjectMocks
    private StandardRezerwacjaStrategy  strategy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateReservationForExistingUserAndBooks() {
        // Given
        int userId = 1;
        List<Integer> bookIds = Arrays.asList(101, 102);
        Uzytkownik user = new Uzytkownik();
        Ksiazka book1 = new Ksiazka();
        Ksiazka book2 = new Ksiazka();

        when(uzytkownikRepository.findById(userId)).thenReturn(Optional.of(user));
        when(ksiazkaRepository.findById(101)).thenReturn(Optional.of(book1));
        when(ksiazkaRepository.findById(102)).thenReturn(Optional.of(book2));

        // When
        Rezerwacja result = strategy.stworzRezerwacje(bookIds, userId);

        // Then
        assertEquals(user, result.getUzytkownik());
        assertTrue(result.getKsiazki().containsAll(Arrays.asList(book1, book2)));
        assertNotNull(result.getStartRezerwacja());
        assertNotNull(result.getKoniecRezerwacja());
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() {
        // Given
        int userId = 999; // non-existent user
        List<Integer> bookIds = Arrays.asList(101, 102);

        when(uzytkownikRepository.findById(userId)).thenReturn(Optional.empty());

        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            // When
            strategy.stworzRezerwacje(bookIds, userId);
        });
    }

    @Test
    void shouldThrowExceptionWhenBookDoesNotExist() {
        // Given
        int userId = 1;
        List<Integer> bookIds = Arrays.asList(999); // non-existent book
        Uzytkownik user = new Uzytkownik();

        when(uzytkownikRepository.findById(userId)).thenReturn(Optional.of(user));
        when(ksiazkaRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            // When
            strategy.stworzRezerwacje(bookIds, userId);
        });
    }
}