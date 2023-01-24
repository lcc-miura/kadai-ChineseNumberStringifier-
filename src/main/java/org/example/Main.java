package org.example;

public class Main {
    public static void main(String[] args) {
        ChineseNumberStringifier cns = new ChineseNumberStringifier();
        String result = cns.stringify(45013);

        System.out.println(result);
    }
}