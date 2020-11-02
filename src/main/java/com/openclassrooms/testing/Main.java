package com.openclassrooms.testing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main( String[] args ) {

        ParserChiffresNombre parserChiffresNombre = new ParserChiffresNombre();
        Set<Integer> setDeChiffresParses = parserChiffresNombre.donneNombreEtRetourneSetChiffres( 1113534 );

        // Créer un stream
        Stream<Integer> stream = Stream.of( 11, 23, 33, 43 );
        Stream<String> stream2 = Stream.of( "A", "B" );

        // Créer une liste et un set à partir d'un stream

        Set<Integer> set = stream.collect( Collectors.toSet() );
        List<String> list = stream2.collect( Collectors.toList() );
        System.out.println( set );
        System.out.println( list );

        Set<Integer> set1 = new HashSet<Integer>();
        set1.add( 3 );
        set1.add( 2 );
        set1.add( 1 );

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add( 2 );
        set2.add( 3 );
        set2.add( 1 );

        System.out.println( set1.equals( set2 ) );

        stream.forEach( System.out::println );

        Iterator<Integer> iterator = setDeChiffresParses.iterator();
        while ( iterator.hasNext() ) {
            Integer chiffre = iterator.next();
            setDeChiffresParses.contains( chiffre );
            System.out.println( chiffre );
        }

    }

}
