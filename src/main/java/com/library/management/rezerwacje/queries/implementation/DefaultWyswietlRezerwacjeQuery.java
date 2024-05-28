package com.library.management.rezerwacje.queries.implementation;

import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.rezerwacje.RezerwacjaRepository;
import com.library.management.rezerwacje.queries.WyswietlRezerwacjeQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Default wyswietl rezerwacje query.
 */
@Component
public class DefaultWyswietlRezerwacjeQuery implements WyswietlRezerwacjeQuery {

    private RezerwacjaRepository rezerwacjaRepository;

    /**
     * Instantiates a new Default wyswietl rezerwacje query.
     *
     * @param rezerwacjaRepository the rezerwacja repository
     */
    public DefaultWyswietlRezerwacjeQuery(RezerwacjaRepository rezerwacjaRepository) {
        this.rezerwacjaRepository = rezerwacjaRepository;
    }

    @Override
    public List<Rezerwacja> wyswietl() {
        return rezerwacjaRepository.findAll();
    }
}
