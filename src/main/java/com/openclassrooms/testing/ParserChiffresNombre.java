package com.openclassrooms.testing;

import java.util.HashSet;
import java.util.Set;

public class ParserChiffresNombre {

    private int nombre;

    public Set<Integer> donneNombreEtRetourneSetChiffres( int nombre ) {
        this.nombre = nombre;
        String nombreFormatString = Integer.toString( nombre );

        Integer longueurString = nombreFormatString.length();

        Set<Integer> setStockantLesChiffres = new HashSet<Integer>();

        for ( int i = 0; i < longueurString; i++ ) {

            Integer chiffre = Integer.parseInt( nombreFormatString.substring( i, i + 1 ) );
            setStockantLesChiffres.add( chiffre );

        }

        System.out.println( "chiffres stockee dans le set :" + setStockantLesChiffres );
        return setStockantLesChiffres;
    }

}
