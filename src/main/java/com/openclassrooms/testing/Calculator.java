package com.openclassrooms.testing;

public class Calculator {

    public int add( int a, int b ) {
        return a + b;
    }

    public int multiply( int a, int b ) {
        // TODO Auto-generated method stub
        return a * b;
    }

    public void longCalcul() {

        try {
            Thread.sleep( 500 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
