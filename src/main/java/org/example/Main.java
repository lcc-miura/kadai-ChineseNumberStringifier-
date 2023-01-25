package org.example;

public class Main {
    public static void main(String[] args) {
        AbstractStringifier cns = new ChineseNumberStringifier(45013);
        cns.display();

        AbstractStringifier rns = new RomanNumberStringifier(1024);
        rns.display();
    }
}