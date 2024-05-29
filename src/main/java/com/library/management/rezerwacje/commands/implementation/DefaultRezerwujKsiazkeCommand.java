package com.library.management.rezerwacje.commands.implementation;

import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.rezerwacje.RezerwacjaRepository;
import com.library.management.rezerwacje.RezerwacjaRequest;
import com.library.management.rezerwacje.commands.RezerwujKsiazkeCommand;
import com.library.management.rezerwacje.factroy.RezerwacjaStrategyFactory;
import com.library.management.rezerwacje.stretegies.RezerwacjaStrategy;
import org.springframework.stereotype.Component;

/**
 * The type Default rezerwuj ksiazke command.
 */
@Component
public class DefaultRezerwujKsiazkeCommand implements RezerwujKsiazkeCommand {
    private RezerwacjaRepository rezerwacjaRepository;
    private RezerwacjaStrategyFactory rezerwacjaStrategyFactory;

    /**
     * Instantiates a new Default rezerwuj ksiazke command.
     *
     * @param rezerwacjaRepository      the rezerwacja repository
     * @param rezerwacjaStrategyFactory the rezerwacja strategy factory
     */
    public DefaultRezerwujKsiazkeCommand(RezerwacjaRepository rezerwacjaRepository,
                                         RezerwacjaStrategyFactory rezerwacjaStrategyFactory) {
        this.rezerwacjaRepository = rezerwacjaRepository;
        this.rezerwacjaStrategyFactory = rezerwacjaStrategyFactory;
    }

    @Override
    public Rezerwacja rezerwuj(RezerwacjaRequest rezerwacjaRequest) {
        RezerwacjaStrategy rezerwacjaStrategy = rezerwacjaStrategyFactory
                .getRezerwacjaStrategy(rezerwacjaRequest.getTyp());
        return rezerwacjaRepository.save(rezerwacjaStrategy.stworzRezerwacje(rezerwacjaRequest.getListaKsiazek(), rezerwacjaRequest.getUzytkownik()));
    }
}
