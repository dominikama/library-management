package com.library.management.rezerwacje.commands;

import com.library.management.rezerwacje.Rezerwacja;

public interface OdwolajRezerwacjeCommand {
    Rezerwacja odwolaj(int rezerwacjaId);
}
