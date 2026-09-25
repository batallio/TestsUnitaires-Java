package com.angelbatalla.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calc = null;
    }

    @Test
    void add_devrait_calculer_la_somme_de_deux_int() {
        // GIVEN
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
        int opG = 10;
        int opD = 5;
        int resultat_attendu = opG / opD;

        // WHEN
        int resultat_class = calc.divide(opG, opD);

        // THEN
        assertThat(resultat_class).isNotNull()
                .isEqualTo(resultat_attendu);
    }

    // https://docs.junit.org/5.14.1/writing-tests/parameterized-classes-and-tests.html
    @ParameterizedTest
    @CsvSource({    "0,1,1",
                    "1,2,3",
                    "-2,2,0",
                    "0,0,0",
                    "-1,-2,-3"
    })
    void add_devrait_calculer_la_sum_de_diff_additions(int opG, int opD, int resultat_attendu) {

        // WHEN
        int resultat_class = calc.add(opG, opD);

        // THEN
        assertThat(resultat_class).isNotNull()
                .isEqualTo(resultat_attendu);
    }
}