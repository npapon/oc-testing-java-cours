package com.openclassrooms.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private static Instant startedAt;

    private Calculator     calculatorUnderTest;

    @BeforeEach
    public void initCalculator() {
        System.out.println( "Appel avant chaque test" );
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void undefCalculator() {
        System.out.println( "Appel après chaque test" );
        calculatorUnderTest = null;
    }

    @BeforeAll
    public static void initStartingTime() {
        System.out.println( "Appel avant tous les tests" );
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration() {
        System.out.println( "Appel après tous les tests" );
        Instant endedAt = Instant.now();
        long duration = Duration.between( startedAt, endedAt ).toMillis();
        System.out.println( MessageFormat.format( "Durée des tests : {0} ms", duration ) );
    }

    @Test
    public void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int somme = calculatorUnderTest.add( a, b );

        // Assert
        // assertEquals( 5, somme );
        assertThat( somme ).isEqualTo( 5 );
    }

    @Test
    public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
        // Arrange
        int a = 42;
        int b = 11;

        // Act
        int produit = calculatorUnderTest.multiply( a, b );

        // Assert
        // assertEquals( 462, produit );
        assertThat( produit ).isEqualTo( 462 );
    }

    @ParameterizedTest( name = "{0} x 0 doit être égal à 0" )
    @ValueSource( ints = { 1, 2, 42, 1011, 5089 } )
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers( int arg ) {
        // Arrange -- Tout est prêt !

        // Act -- Multiplier par zéro
        int actualResult = calculatorUnderTest.multiply( arg, 0 );

        // Assert -- ça vaut toujours zéro !
        // assertEquals( 0, actualResult );
        assertThat( actualResult ).isEqualTo( 0 );
    }

    @ParameterizedTest( name = "{0} + {1} doit être égal à {2}" )
    @CsvSource( { "1,1,2", "2,3,5", "42,57,99" } )
    public void add_shouldReturnTheSum_ofMultipleIntegers( int arg1, int arg2, int expectResult ) {
        // Arrange -- Tout est prêt !

        // Act
        int actualResult = calculatorUnderTest.add( arg1, arg2 );

        // Assert
        // assertEquals( expectResult, actualResult );

        assertThat( actualResult ).isEqualTo( expectResult );
    }

    @Timeout( 1 )
    @Test
    public void longCalcul_shouldComputeInLessThan1Second() {
        // Arrange

        // Act
        calculatorUnderTest.longCalculation();

        // Assert
        // ...
    }

    @Test
    public void testRetourneLeDetailDesChiffresDuNombre() {
        // GIVEN
        int nombre = 56565;
        // WHEN
        Set<Integer> chiffres = calculatorUnderTest.retourneLeDetailDesChiffresDuNombre( nombre );
        // THEN
        // On peut utiliser directement une méthode d'assertJ pour vérifier
        // que la collection contient ces chiffres dans n'importe quel ordre
        assertThat( chiffres ).containsExactlyInAnyOrder( 5, 7, 8, 9 );

    }

}
