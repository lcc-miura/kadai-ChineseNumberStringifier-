package org.example;

public class Main {
    public static void main(String[] args) {
        AbstractStringifier cns = new ChineseNumberStringifier();
        cns.stringify(45013);

        AbstractStringifier rns = new RomanNumberStringifier();
        cns.stringify(1024);
    }
}