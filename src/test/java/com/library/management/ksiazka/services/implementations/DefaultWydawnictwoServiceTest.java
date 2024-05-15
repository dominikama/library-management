package com.library.management.ksiazka.services.implementations;

import com.library.management.ksiazka.entities.Wydawnictwo;
import com.library.management.ksiazka.repositories.WydawnictwoRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DefaultWydawnictwoServiceTest {

    @Test
    void dodajWydawnictwo() {
        WydawnictwoRepository wydawnictwoRepository = mock(WydawnictwoRepository.class);
        DefaultWydawnictwoService defaultWydawnictwoService = new DefaultWydawnictwoService(wydawnictwoRepository);
        defaultWydawnictwoService.dodajWydawnictwo(mockWydawnictwa("Test"));
        verify(wydawnictwoRepository, times(1)).save(any(Wydawnictwo.class));
    }

    @Test
    void wyswietlWydawnictwa() {
        List<Wydawnictwo> wydawnictwa = List.of(mockWydawnictwa("Test"), mockWydawnictwa("Test 2"));
        WydawnictwoRepository wydawnictwoRepository = mock(WydawnictwoRepository.class);
        DefaultWydawnictwoService defaultWydawnictwoService = new DefaultWydawnictwoService(wydawnictwoRepository);
        when(wydawnictwoRepository.findAll()).thenReturn(wydawnictwa);
        assertEquals(2, defaultWydawnictwoService.wszystkieWydawnictwa().size());
    }

    private Wydawnictwo mockWydawnictwa(String nazwa) {
        Wydawnictwo wydawnictwo = new Wydawnictwo();
        wydawnictwo.setWydawnictwoNazwa(nazwa);
        return wydawnictwo;
    }

}