package org.example;

import java.util.*;

public class RomanNumberStringifier extends AbstractStringifier {
    private final Map<Integer, String> romaOnesPlace = new HashMap<>() {
        {
            put(1, "I");
            put(2, "II");
            put(3, "III");
            put(4, "IV");
            put(5, "V");
            put(6, "VI");
            put(7, "VII");
            put(8, "VIII");
            put(9, "IX");
        }
    };
    private final Map<Integer, String> romaTensPlace = new HashMap<>() {
        {
            put(1, "X");
            put(2, "XX");
            put(3, "XXX");
            put(4, "XL");
            put(5, "L");
            put(6, "LX");
            put(7, "LXX");
            put(8, "LXXX");
            put(9, "XC");
        }
    };
    private final Map<Integer, String> romaHundredsPlace = new HashMap<>() {
        {
            put(1, "C");
            put(2, "CC");
            put(3, "CCC");
            put(4, "CD");
            put(5, "D");
            put(6, "DC");
            put(7, "DCC");
            put(8, "DCCC");
            put(9, "CM");
        }
    };
    private final Map<Integer, String> romaThousandsPlace = new HashMap<>() {
        {
            put(1, "M");
            put(2, "MM");
            put(3, "MMM");
        }
    };

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
                                    arr.add(this.romaOnesPlace.get(key));
                                    break;
                                case 1:
                                    arr.add(this.romaTensPlace.get(key));
                                    break;
                                case 2:
                                    arr.add(this.romaHundredsPlace.get(key));
                                    break;
                                case 3:
                                    arr.add(this.romaThousandsPlace.get(key));
                            }
                            return arr;
                        }, (arr1, arr2) -> null
                ).stream().filter(Objects::nonNull).toList();
        return chineseStrList;
    }
}
