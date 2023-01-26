package org.example;

public class Main {
    public static void main(String[] args) {
        AbstractStringifier cns = new ChineseNumberStringifier();
        String result1 = cns.stringify(45013);
        System.out.println(result1);

        AbstractStringifier rns = new RomanNumberStringifier();
        String result2 = rns.stringify(1024);
        System.out.println(result2);
    }
}