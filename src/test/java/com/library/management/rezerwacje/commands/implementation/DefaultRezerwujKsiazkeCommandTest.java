package com.library.management.rezerwacje.commands.implementation;

import com.library.management.rezerwacje.RezerwacjaRepository;
import com.library.management.rezerwacje.RezerwacjaRequest;
import com.library.management.rezerwacje.factroy.DefaultRezerwacjaStrategyFactory;
import com.library.management.rezerwacje.stretegies.RezerwacjaStrategy;
import com.library.management.rezerwacje.stretegies.Typ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultRezerwujKsiazkeCommandTest {
    @Mock
    private RezerwacjaRepository rezerwacjaRepository;

    @Mock
    private RezerwacjaStrategy rezerwacjaStrategy;

    @Mock
    private DefaultRezerwacjaStrategyFactory rezerwacjaStrategyFactory;

    @InjectMocks
    private DefaultRezerwujKsiazkeCommand command;

    @BeforeEach
    void setUp() {
        when(rezerwacjaStrategyFactory.getRezerwacjaStrategy(Typ.STANDARD)).thenReturn(rezerwacjaStrategy);
    }


    @Test
    void testRezerwujKsiazke() {
        RezerwacjaRequest request = new RezerwacjaRequest();
        request.setTyp(Typ.STANDARD);
        request.setListaKsiazek(new ArrayList<>());
        request.setUzytkownik(1);

        command.rezerwuj(request);

        verify(rezerwacjaStrategy).stworzRezerwacje(any(), eq(1));
        verify(rezerwacjaRepository).save(any());
    }
}