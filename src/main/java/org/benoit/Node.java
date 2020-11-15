package org.benoit;

import java.util.AbstractMap;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;

// With jdk8 using functional approach and optional
final public class Node<T> {
    final T value;
    final Optional<Node<T>> left;
    final Optional<Node<T>> right;

    public Node(T value) {
        this(value, Optional.empty(), Optional.empty());
    }

    public Node(T value, Node left) {
        this(value, Optional.of(left), Optional.empty());
    }

    public Node(T value, Node left, Node right) {
        this(value, Optional.of(left), Optional.of(right));
    }

    public Node(T value, Optional<Node<T>> left, Optional<Node<T>> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","(",")");
        sj.add(value.toString());

        Function<Optional<Node<T>>,Object> sjAdd = (n) -> n.map((t) -> sj.add(t.toString()));
        sjAdd.apply(left);
        sjAdd.apply(right);
        return sj.toString();
    }

    Node<AbstractMap.SimpleEntry<Integer,T>> addId(Integer start) {
        Optional<Node<AbstractMap.SimpleEntry<Integer,T>>> newLeft = left.map((n) -> n.addId(start));
        Integer leftIndex = newLeft.map((n) -> n.value.getKey() + 1).orElse(start);
        Optional<Node<AbstractMap.SimpleEntry<Integer,T>>> newRight = right.map((n) -> n.addId(leftIndex));
        Integer rightIndex = newRight.map((n) -> n.value.getKey() + 1).orElse(leftIndex);
        return new Node<AbstractMap.SimpleEntry<Integer,T>>(
                new AbstractMap.SimpleEntry<>(rightIndex, value),
                newLeft,
                newRight);
    }

    Node<AbstractMap.SimpleEntry<Integer, T>> addId() {
        return addId(0);
    }

}
