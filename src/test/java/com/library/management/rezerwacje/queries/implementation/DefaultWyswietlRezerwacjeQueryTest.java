package com.library.management.rezerwacje.queries.implementation;

import com.library.management.rezerwacje.RezerwacjaRepository;
import com.library.management.rezerwacje.commands.implementation.DefaultOdwolajRezerwacjeCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DefaultWyswietlRezerwacjeQueryTest {

    @Mock
    private RezerwacjaRepository rezerwacjaRepository;

    @InjectMocks
    private DefaultWyswietlRezerwacjeQuery query;

    @Test
    void wyswietl() {

        query.wyswietl();
        verify(rezerwacjaRepository).findAll();
    }

}