package com.library.management.rezerwacje.factroy;

import com.library.management.rezerwacje.stretegies.RezerwacjaStrategy;
import com.library.management.rezerwacje.stretegies.Typ;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DefaultRezerwacjaStrategyFactory implements RezerwacjaStrategyFactory{
    private final Map<Typ, RezerwacjaStrategy> startegyMap;

    public DefaultRezerwacjaStrategyFactory(List<RezerwacjaStrategy> rezerwacjaStrategies) {
        startegyMap = rezerwacjaStrategies.stream().collect(Collectors.toUnmodifiableMap(RezerwacjaStrategy::getTyp,
                Function.identity()));
    }

    public RezerwacjaStrategy getRezerwacjaStrategy(Typ typ) {
        return Optional.ofNullable(startegyMap.get(typ))
                .orElseThrow(() -> new IllegalArgumentException("Strategia rezerwacji nie mogla zostac utworzona"));
    }
}
