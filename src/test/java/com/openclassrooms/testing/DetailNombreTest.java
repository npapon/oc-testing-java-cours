package com.openclassrooms.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class DetailNombreTest {

    ParserChiffresNombre ParserChiffresNombre = new ParserChiffresNombre();

    @Test
    void retourneLesDunChiffrePosiftif() {

        // le nombre qu'on va parser
        int nombrePositif = 123455123;
        // on créé un set à partir de ce nombre depuis un stream contenant les
        // chiffres attendu via la m
        Set<Integer> setChiffresDuNomnre = Stream.of( 1, 2, 3, 4, 5 ).collect( Collectors.toSet() );

        // on va comparer le set du dessus avec le set généré par notre
        // ParserChiffresNombre pour vérifier que les nombres sont bien dans le
        // set créé
        assertEquals( setChiffresDuNomnre, ParserChiffresNombre.donneNombreEtRetourneSetChiffres( nombrePositif ) );

        // avec assetThat on utilise la méthode assert that
        // containsExactlyInAnyOrder
        assertThat( setChiffresDuNomnre ).containsExactlyInAnyOrder( 1, 2, 3, 4, 5 );

    }

}
