package com.library.management.rezerwacje.commands.implementation;

import com.library.management.ksiazka.entities.DaneKsiazki;
import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.ksiazka.entities.Status;
import com.library.management.ksiazka.repositories.KsiazkaRepository;
import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.rezerwacje.RezerwacjaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultOdwolajRezerwacjeCommandTest {

    @Mock
    private RezerwacjaRepository rezerwacjaRepository;

    @Mock
    private KsiazkaRepository ksiazkaRepository;

    @InjectMocks
    private DefaultOdwolajRezerwacjeCommand command;

    private Rezerwacja rezerwacja;
    private Set<Ksiazka> ksiazki;

    @BeforeEach
    void setUp() {
        ksiazki = new HashSet<>();
        Ksiazka ksiazka = new Ksiazka();
        DaneKsiazki daneKsiazki = new DaneKsiazki();
        daneKsiazki.setDaneKsiazkiId(1);
        daneKsiazki.setTytul("W pustyni i w puszczy");
        ksiazka.setKsiazkaId(1);
        ksiazka.setDaneKsiazki(daneKsiazki);
        ksiazka.setStatus(Status.ZAREZERWOWANA);
        ksiazki.add(ksiazka);
        rezerwacja = new Rezerwacja();
        rezerwacja.setRezerwacjaId(1);
        rezerwacja.setKsiazki(ksiazki);
    }

    @Test
    void testOdwolajSuccess() {
        when(rezerwacjaRepository.findById(1)).thenReturn(Optional.of(rezerwacja));

        Rezerwacja result = command.odwolaj(1);

        assertNotNull(result);
        assertEquals(1, result.getRezerwacjaId());
        verify(rezerwacjaRepository).delete(rezerwacja);
        ksiazki.forEach(ksiazka -> assertEquals(Status.DOSTEPNA, ksiazka.getStatus()));
        ksiazki.forEach(ksiazka -> verify(ksiazkaRepository).save(ksiazka));
    }

    @Test
    void testOdwolajRezerwacjaNotFound() {
        when(rezerwacjaRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> command.odwolaj(1));

        assertEquals("Rzerewacja nie znaleziona", exception.getMessage());
    }
}