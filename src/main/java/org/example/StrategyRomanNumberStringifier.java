package org.example;

import java.util.*;

public class StrategyRomanNumberStringifier implements StrategyNumberStringifier {
    private static final Map<Integer, String> ROMA_ONES_PLACE = Map.of(
            1, "I",
            2, "II",
            3, "III",
            4, "IV",
            5, "V",
            6, "VI",
            7, "VII",
            8, "VIII",
            9, "IX"
    );
    private static final Map<Integer, String> ROMA_TENS_PLACE = Map.of(
            1, "X",
            2, "XX",
            3, "XXX",
            4, "XL",
            5, "L",
            6, "LX",
            7, "LXX",
            8, "LXXX",
            9, "XC"
    );
    private static final Map<Integer, String> ROMA_HUNDREDS_PLACE = Map.of(
            1, "C",
            2, "CC",
            3, "CCC",
            4, "CD",
            5, "D",
            6, "DC",
            7, "DCC",
            8, "DCCC",
            9, "CM"
    );
    private static final Map<Integer, String> ROMA_THOUSANDS_PLACE = Map.of(
            1, "M",
            2, "MM",
            3, "MMM"
    );

    @Override
    public List<String> transMapping(List<String> strList) {
        List<String> chineseStrList = strList.stream()
                .reduce(
                        new ArrayList<String>(),
                        (arr, s) -> {
                            int i = arr.size();
                            Integer key = Integer.parseInt(s);
                            switch(i){
                                case 0:
                                    arr.add(ROMA_ONES_PLACE.get(key));
                                    break;
                                case 1:
                                    arr.add(ROMA_TENS_PLACE.get(key));
                                    break;
                                case 2:
                                    arr.add(ROMA_HUNDREDS_PLACE.get(key));
                                    break;
                                case 3:
                                    arr.add(ROMA_THOUSANDS_PLACE.get(key));
                            }
                            return arr;
                        }, (arr1, arr2) -> null
                ).stream().filter(Objects::nonNull).toList();
        return chineseStrList;
    }
}
