package com.library.management.ksiazka.services.implementations;

import com.library.management.ksiazka.controller.dtos.KsiazkaRequestDTO;
import com.library.management.ksiazka.controller.dtos.KsiazkaResponseDTO;
import com.library.management.ksiazka.entities.*;
import com.library.management.ksiazka.repositories.AutorRepository;
import com.library.management.ksiazka.repositories.DaneKsiazkiRepository;
import com.library.management.ksiazka.repositories.KsiazkaRepository;
import com.library.management.ksiazka.repositories.WydawnictwoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * The type Default ksiazka service test.
 */
public class DefaultKsiazkaServiceTest {

    @Mock
    private KsiazkaRepository ksiazkaRepository;

    @Mock
    private DaneKsiazkiRepository daneKsiazkiRepository;

    @Mock
    private AutorRepository autorRepository;

    @Mock
    private WydawnictwoRepository wydawnictwoRepository;

    private DefaultKsiazkaService ksiazkaService;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ksiazkaService = new DefaultKsiazkaService(ksiazkaRepository, daneKsiazkiRepository, autorRepository, wydawnictwoRepository);
    }

    /**
     * Test dodaj ksiazke.
     */
    @Test
    void testDodajKsiazke() {
        when(autorRepository.findById(1)).thenReturn(Optional.of(mockAutor(1, "Jan", "Kowalski")));
        when(wydawnictwoRepository.findById(1)).thenReturn(Optional.of(mockWydawnictwo(1, "Test")));
        when(daneKsiazkiRepository.findByTytulAndRokWydaniaAndAutorzyIn(anyString(), anyInt(), any())).thenReturn(Optional.empty());
        when(daneKsiazkiRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
        when(ksiazkaRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        KsiazkaResponseDTO response = ksiazkaService.dodajKsiazke(mockRequest(1, List.of(1), 1));

        assertNotNull(response);
        assertEquals("Sample Book", response.getTytul());
        assertEquals(Status.DOSTEPNA, response.getStatus());
        verify(daneKsiazkiRepository, times(1)).save(any(DaneKsiazki.class));
        verify(ksiazkaRepository, times(1)).save(any(Ksiazka.class));
    }

    /**
     * Test dodaj ksiazki ilosc 5.
     */
    @Test
    void testDodajKsiazkiIlosc5() {
        when(autorRepository.findById(1)).thenReturn(Optional.of(mockAutor(1, "Jan", "Kowalski")));
        when(wydawnictwoRepository.findById(1)).thenReturn(Optional.of(mockWydawnictwo(1, "Test")));
        when(daneKsiazkiRepository.findByTytulAndRokWydaniaAndAutorzyIn(anyString(), anyInt(), any())).thenReturn(Optional.empty());
        when(daneKsiazkiRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
        when(ksiazkaRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        KsiazkaResponseDTO response = ksiazkaService.dodajKsiazke(mockRequest(5, List.of(1), 1));

        assertNotNull(response);
        assertEquals("Sample Book", response.getTytul());
        assertEquals(Status.DOSTEPNA, response.getStatus());
        verify(daneKsiazkiRepository, times(1)).save(any(DaneKsiazki.class));
        verify(ksiazkaRepository, times(5)).save(any(Ksiazka.class));
    }

    /**
     * Test dodaj ksiazke istniejace dane.
     */
    @Test
    void testDodajKsiazkeIstniejaceDane() {
        when(autorRepository.findById(1)).thenReturn(Optional.of(mockAutor(1, "Jan", "Kowalski")));
        when(wydawnictwoRepository.findById(1)).thenReturn(Optional.of(mockWydawnictwo(1, "Test")));
        when(daneKsiazkiRepository.findByTytulAndRokWydaniaAndAutorzyIn(anyString(), anyInt(), any()))
                .thenReturn(Optional.of(mockDaneKsiazki()));
        when(ksiazkaRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        KsiazkaResponseDTO response = ksiazkaService.dodajKsiazke(mockRequest(1, List.of(1), 1));

        assertNotNull(response);
        assertEquals("Sample Book", response.getTytul());
        assertEquals(Status.DOSTEPNA, response.getStatus());
        verify(daneKsiazkiRepository, times(0)).save(any(DaneKsiazki.class));
        verify(ksiazkaRepository, times(1)).save(any(Ksiazka.class));
    }

    /**
     * Test wyswietl ksiazki.
     */
    @Test
    void testWyswietlKsiazki() {
        when(ksiazkaRepository.findAll()).thenReturn(List.of(new Ksiazka()));
        List<Ksiazka> result = ksiazkaService.wyswietlKsiazki();
        assertFalse(result.isEmpty());
        verify(ksiazkaRepository, times(1)).findAll();
    }

    /**
     * Test wyswietl ksiazki status.
     */
    @Test
    void testWyswietlKsiazkiStatus() {
        Ksiazka ksiazka = new Ksiazka();
        ksiazka.setStatus(Status.DOSTEPNA);

        Ksiazka ksiazka2 = new Ksiazka();
        ksiazka2.setStatus(Status.WYDANA);

        when(ksiazkaRepository.findAll()).thenReturn(List.of(ksiazka, ksiazka2));
        List<Ksiazka> result = ksiazkaService.wyswietlKsiazkiOdanymStatusie("DOSTEPNA");
        assertEquals(1, result.size());
        verify(ksiazkaRepository, times(1)).findAll();
    }

    /**
     * Test wydaj ksiazke.
     */
    @Test
    void testWydajKsiazke() {
        Ksiazka ksiazka = new Ksiazka();
        ksiazka.setKsiazkaId(1);
        ksiazka.setStatus(Status.DOSTEPNA);
        ksiazka.setDaneKsiazki(mockDaneKsiazki());
        when(ksiazkaRepository.findById(1)).thenReturn(Optional.of(ksiazka));
        KsiazkaResponseDTO result = ksiazkaService.wydajKsiazke(1);
        assertEquals(Status.WYDANA, result.getStatus());
        verify(ksiazkaRepository).save(ksiazka);
    }

    /**
     * Test odbierz ksiazke.
     */
    @Test
    void testOdbierzKsiazke() {
        Ksiazka ksiazka = new Ksiazka();
        ksiazka.setKsiazkaId(1);
        ksiazka.setStatus(Status.WYDANA);
        ksiazka.setDaneKsiazki(mockDaneKsiazki());
        when(ksiazkaRepository.findById(1)).thenReturn(Optional.of(ksiazka));
        KsiazkaResponseDTO result = ksiazkaService.odbierzKsiazke(1);
        assertEquals(Status.DOSTEPNA, result.getStatus());
        verify(ksiazkaRepository).save(ksiazka);
    }

    private KsiazkaRequestDTO mockRequest(int ilosc, List<Integer> autorzy, int wydawnictwoId) {
        KsiazkaRequestDTO ksiazkaDTO = new KsiazkaRequestDTO();
        ksiazkaDTO.setAutorIds(autorzy);
        ksiazkaDTO.setWydawnictwoId(wydawnictwoId);
        ksiazkaDTO.setTytul("Sample Book");
        ksiazkaDTO.setRokWydania(2020);
        ksiazkaDTO.setIlosc(ilosc);
        return ksiazkaDTO;
    }

    private Autor mockAutor(int id, String imie, String nazwisko) {
        Autor autor = new Autor();
        autor.setImie(imie);
        autor.setNazwisko(nazwisko);
        autor.setAutorId(id);
        return autor;
    }

    private Wydawnictwo mockWydawnictwo(int id, String nazwa) {
        Wydawnictwo wydawnictwo = new Wydawnictwo();
        wydawnictwo.setWydawnictwoId(id);
        wydawnictwo.setWydawnictwoNazwa(nazwa);
        return wydawnictwo;
    }

    private DaneKsiazki mockDaneKsiazki() {
        DaneKsiazki daneKsiazki = new DaneKsiazki();
        daneKsiazki.setAutorzy(Set.of(mockAutor(1, "Jan", "Kowalski")));
        daneKsiazki.setWydawnictwo(mockWydawnictwo(1, "Test"));
        daneKsiazki.setRokWydania(2020);
        daneKsiazki.setTytul("Sample Book");
        return daneKsiazki;
    }
}
