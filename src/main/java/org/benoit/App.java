package org.benoit;

import java.util.Optional;

public class App
{
    public static void main( String[] args )
    {
        Node nd = new Node("d");
        Node nb = new Node("b", nd);
        Node ne = new Node("e");
        Node nc = new Node("c", Optional.empty(), Optional.of(ne));
        Node na = new Node("a", nb, nc);

        System.out.println(na);
        System.out.println(na.addId());
    }
}
