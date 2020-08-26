package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalcuslatorTest {

    private Calculator     calculator;
    private int            numeroTest;
    private static Instant debut;

    @BeforeEach
    public void initCalculatorTest() {
        calculator = new Calculator();
    }

    @AfterEach
    public void endTest() {
        System.out.println( "fin test " + numeroTest );
    }

    @BeforeAll
    public static void initTemps() {
        System.out.println( "Lancé avant tous les tests" );
        debut = Instant.now();

    }

    @AfterAll
    public static void dureeTest() {
        System.out.println( "Lancé après tous les tests\"" );
        Instant fin = Instant.now();
        long dureeTest = Duration.between( debut, fin ).toMillis();
        System.out.println( MessageFormat.format( "Durée : {0} ms", dureeTest ) );

    }

    public void setNumeroTest( int numeroTest ) {
        this.numeroTest = numeroTest;
    }

    @Test
    public void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int somme = calculator.add( a, b );
        setNumeroTest( 1 );

        // Assert
        assertEquals( 5, somme );
    }

    @Test
    public void multiplyTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int produit = calculator.multiply( a, b );
        setNumeroTest( 2 );

        // Assert
        assertEquals( 6, produit );
    }

    @ParameterizedTest( name = "un nombre * 0 est toujours égal à 0" )
    @ValueSource( ints = { 1, 2, 1000 } )
    public void multiplieParZero( int argument ) {
        int produit = calculator.multiply( argument, 0 );
        assertEquals( 0, produit );
    }

    @ParameterizedTest( name = "Verifier somme " )
    @CsvSource( { "1, 2, 3", "3,3,6" } )
    public void somme( int argument1, int argument2, int resultat ) {

        assertEquals( resultat, argument1 + argument2 );
    }

    @Test
    @Timeout( 1 )
    public void testLongCalcul() {
        calculator.longCalcul();
    }

}
