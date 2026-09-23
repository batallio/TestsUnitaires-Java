package com.angelbatalla.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void add_devrait_calculer_la_somme_de_deux_int() {
        // GIVEN
        Calculator calc = new Calculator();
        int opG = 2;
        int opD = 5;
        int resultat_attendu = opG + opD;

        // WHEN
        int resultat_class = calc.add(opG, opD);

        // THEN
        assertThat(resultat_class).isNotNull()
                .isEqualTo(resultat_attendu);
    }

    @Test
    void add_devrait_calculer_la_division_de_deux_int() {
        // GIVEN
        Calculator calc = new Calculator();
        int opG = 10;
        int opD = 5;
        int resultat_attendu = opG / opD;

        // WHEN
        int resultat_class = calc.divide(opG, opD);

        // THEN
        assertThat(resultat_class).isNotNull()
                .isEqualTo(resultat_attendu);
    }
}