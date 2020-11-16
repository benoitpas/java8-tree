package org.benoit;

public class App {

    public static final Node na = new Node("a",
            new Node("b"),
            new Node("c",
                    new Node("d"),
                    new Node("e")));

    public static void main( String[] args ) {

        System.out.println(na);
        System.out.println(na.addId());
    }
}
