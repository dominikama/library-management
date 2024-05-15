package com.library.management.rezerwacje.commands;

import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.rezerwacje.RezerwacjaRequest;
import com.library.management.rezerwacje.stretegies.Typ;

public interface RezerwujKsiazkeCommand {
    Rezerwacja rezerwuj(RezerwacjaRequest rezerwacjaRequest);
}
