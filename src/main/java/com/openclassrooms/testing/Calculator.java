package com.openclassrooms.testing;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add( int a, int b ) {
        return a + b;
    }

    public int multiply( int a, int b ) {
        return a * b;
    }

    public void longCalculation() {
        try {
            Thread.sleep( 500 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

    public Set<Integer> retourneLeDetailDesChiffresDuNombre( int nombre ) {

        // Une collection de type Set représente une structure
        // qui ne supporte pas les valeurs dupliquées.
        // HashSet qui implémente l'interface Set stocke ses éléments dans une
        // table de hachage
        // les données sont gérées sous la forme clé-valeur.
        // les données sont éparpillées le plus uniformément possible
        // =>Elles sont rangées en fonction d'un critère : leur code de hachage,
        // retourné par la méthode hashcode() de chaque objet.
        //
        Set<Integer> chiffres = new HashSet<Integer>();
        // on transforme le nombre en string
        String representationEnStringDuNombre = String.valueOf( nombre );
        // pour récupérer à chaque tour de boucle les integer qui le compose
        for ( int i = 0; i < representationEnStringDuNombre.length(); i++ ) {
            chiffres.add( Integer.parseInt( representationEnStringDuNombre.substring( i, i + 1 ) ) );
        }
        // et on l'ajoute à la collection
        return chiffres;
    }

}
