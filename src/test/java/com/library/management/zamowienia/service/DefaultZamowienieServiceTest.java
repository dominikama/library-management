package com.library.management.zamowienia.service;

import com.library.management.ksiazka.entities.DaneKsiazki;
import com.library.management.ksiazka.repositories.DaneKsiazkiRepository;
import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.zamowienia.controller.ZamowienieRequest;
import com.library.management.zamowienia.entities.Zamowienie;
import com.library.management.zamowienia.entities.ZamowioneKsiazki;
import com.library.management.zamowienia.repository.ZamowienieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * The type Default zamowienie service test.
 */
class DefaultZamowienieServiceTest {

    @Mock
    private ZamowienieRepository zamowienieRepository;

    @Mock
    private DaneKsiazkiRepository daneKsiazkiRepository;

    @InjectMocks
    private DefaultZamowienieService zamowienieService;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test create zamowienie.
     */
    @Test
    void testCreateZamowienie() {
        ZamowienieRequest zamowienieRequest = new ZamowienieRequest();
        ZamowienieRequest.KsiazkaZamowienie ksiazkaZamowienie = new ZamowienieRequest.KsiazkaZamowienie();
        ksiazkaZamowienie.setDaneKsiazkiId(1);
        ksiazkaZamowienie.setIlosc(2);
        zamowienieRequest.setKsiazki(List.of(ksiazkaZamowienie));

        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setUsername("testuser");

        DaneKsiazki daneKsiazki = new DaneKsiazki();
        daneKsiazki.setDaneKsiazkiId(1);

        when(daneKsiazkiRepository.findById(1)).thenReturn(Optional.of(daneKsiazki));
        when(zamowienieRepository.save(any(Zamowienie.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Zamowienie zamowienie = zamowienieService.createZamowienie(zamowienieRequest, uzytkownik);

        assertNotNull(zamowienie);
        assertEquals(LocalDate.now(), zamowienie.getDataZamowienia());
        assertEquals(uzytkownik, zamowienie.getUzytkownik());
        assertEquals(1, zamowienie.getZamowioneKsiazki().size());

        ZamowioneKsiazki zamowioneKsiazki = zamowienie.getZamowioneKsiazki().iterator().next();
        assertEquals(daneKsiazki, zamowioneKsiazki.getDaneKsiazki());
        assertEquals(2, zamowioneKsiazki.getIlosc());

        verify(daneKsiazkiRepository, times(1)).findById(1);
        verify(zamowienieRepository, times(1)).save(any(Zamowienie.class));
    }

    /**
     * Test create zamowienie invalid book id.
     */
    @Test
    void testCreateZamowienieInvalidBookId() {
        ZamowienieRequest zamowienieRequest = new ZamowienieRequest();
        ZamowienieRequest.KsiazkaZamowienie ksiazkaZamowienie = new ZamowienieRequest.KsiazkaZamowienie();
        ksiazkaZamowienie.setDaneKsiazkiId(1);
        ksiazkaZamowienie.setIlosc(2);
        zamowienieRequest.setKsiazki(List.of(ksiazkaZamowienie));

        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setUsername("testuser");

        when(daneKsiazkiRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> zamowienieService.createZamowienie(zamowienieRequest, uzytkownik));

        verify(daneKsiazkiRepository, times(1)).findById(1);
        verify(zamowienieRepository, times(0)).save(any(Zamowienie.class));
    }

    /**
     * Test get all.
     */
    @Test
    void testGetAll() {
        Zamowienie zamowienie1 = new Zamowienie();
        Zamowienie zamowienie2 = new Zamowienie();

        when(zamowienieRepository.findAll()).thenReturn(Arrays.asList(zamowienie1, zamowienie2));

        List<Zamowienie> zamowienia = zamowienieService.getAll();

        assertEquals(2, zamowienia.size());
        assertTrue(zamowienia.contains(zamowienie1));
        assertTrue(zamowienia.contains(zamowienie2));

        verify(zamowienieRepository, times(1)).findAll();
    }
}
