package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChineseNumberStringifier extends AbstractStringifier {
    public ChineseNumberStringifier(int n) {
        super(n);
    }
    private final Map<Integer, String> chineseNumMap = new HashMap<>() {
        {
            put(1, "壱");
            put(2, "弐");
            put(3, "参");
            put(4, "肆");
            put(5, "伍");
            put(6, "陸");
            put(7, "漆");
            put(8, "捌");
            put(9, "玖");
        }
    };
    private final Map<Integer, String> chineseRankMap = new HashMap<>() {
        {
            put(1, "拾");
            put(2, "佰");
            put(3, "阡");
            put(4, "萬");
        }
    };

    public List<String> respectivelyMethod(List<String> strList) {
        List<String> chineseStrList = strList.stream()
                .reduce(
                        new ArrayList<String>(),
                        (arr, s) -> {
                            int i = arr.size();
                            String chineseNum = this.chineseNumMap.get(Integer.parseInt(s));
                            if(s.equals("0")) {
                                arr.add(null);
                            } else if (i == 0) {
                                arr.add(chineseNum);
                            } else {
                                arr.add(chineseNum + this.chineseRankMap.get(i));
                            }
                            return arr;
                        }, (arr1, arr2) -> null
                ).stream().filter(Objects::nonNull).toList();
        return chineseStrList;
    }
}
