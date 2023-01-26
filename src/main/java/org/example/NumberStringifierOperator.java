package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberStringifierOperator {
    private final StrategyNumberStringifier strategyNumberStringifier;

    public NumberStringifierOperator(StrategyNumberStringifier strategy) {
        this.strategyNumberStringifier = strategy;
    }

    public String stringify(int n) {
        String str = Integer.valueOf(n).toString();
        List<String> strList = reversal(Arrays.asList(str.split("")));
        List<String> chineseStrList = strategyNumberStringifier.transMapping(strList);
        List<String> fixedStrList = reversal(chineseStrList);
        return String.join("", fixedStrList);
    }

    private List<String> reversal(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(0, s);
        }
        return newList;
    };
}
