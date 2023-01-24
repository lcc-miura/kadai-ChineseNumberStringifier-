package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class ChineseNumberStringifier {
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

    String stringify(int n) {
        String str = Integer.valueOf(n).toString();
        List<String> strList = reversal(Arrays.asList(str.split("")));
        List<String> chineseStrList = IntStream
                .range(0, strList.size())
                .mapToObj(i -> {
                    String s = strList.get(i);
                    if(s.equals("0")) return "";
                    String chineseNum = chineseNumMap.get(Integer.parseInt(s));
                    if(i == 0) return chineseNum;
                    return chineseNum + chineseRankMap.get(i);
                })
                .toList();
        List<String> fixedStrList = reversal(chineseStrList);
        return String.join("", fixedStrList);
    };

    private List<String> reversal(List<String> list) {
        List<String> newList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            newList.add(0, list.get(i));
        }
        return newList;
    };
}
