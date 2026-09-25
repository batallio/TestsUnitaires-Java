package com.angelbatalla.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
    void divide_devrait_calculer_la_division_de_deux_int() {
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

    @Test
    void divide_devrait_lancer_exception_div_entre_zero() {
        // GIVEN
        int opG = 10;
        int opD = 0;

        // WHEN & THEN
        assertThatThrownBy(() -> calc.divide(opG, opD))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Division entre zero.");
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

    @Test
    void ensembleChiffres_devrait_retourner_set_avec_chiffres_composant_un_int_positive () {
        // GIVEN
        int monInt = 7679;
        Set<Integer> resultat_attendu = Set.of(6, 9, 7);

        // WHEN
        Set<Integer> resultat_class = calc.ensembleChiffres(monInt);

        // THEN
        assertThat(resultat_class).isNotNull()
                .isEqualTo(resultat_attendu);
    }

    @Test
    void ensembleChiffres_devrait_retourner_set_avec_chiffres_composant_un_int_negative () {
        // GIVEN
        int monInt = -11;
        Set<Integer> resultat_attendu = Set.of(1);

        // WHEN
        Set<Integer> resultat_class = calc.ensembleChiffres(monInt);

        // THEN
        assertThat(resultat_class).isNotNull()
                .isEqualTo(resultat_attendu);
    }
}