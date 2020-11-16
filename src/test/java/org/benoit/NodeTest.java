package org.benoit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.AbstractMap;

public class NodeTest {

    AbstractMap.SimpleEntry<Integer,String> pair(Integer i, String s) {
        return new AbstractMap.SimpleEntry<Integer,String>(i,s);
    }

    @Test
    public void addIdTest() {
        Node expected = new Node(pair(4,"a"),
                new Node(pair(0,"b")),
                new Node(pair(3,"c"),
                        new Node(pair(1,"d")),
                        new Node(pair(2,"e"))));
        assertEquals( expected, App.na.addId());
    }
}
