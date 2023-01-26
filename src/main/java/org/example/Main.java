package org.example;

public class Main {
    public static void main(String[] args) {
        NumberStringifierOperator cns = new NumberStringifierOperator(new StrategyChineseNumberStringifier());
        String result1 = cns.stringify(45013);
        System.out.println(result1);

        NumberStringifierOperator rns = new NumberStringifierOperator(new StrategyRomanNumberStringifier());
        String result2 = rns.stringify(1024);
        System.out.println(result2);
    }
}