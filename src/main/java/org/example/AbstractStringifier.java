package org.example;

public abstract class AbstractStringifier {
    public abstract String stringify();

    public final void display() {
        System.out.println(stringify());
    }
}
