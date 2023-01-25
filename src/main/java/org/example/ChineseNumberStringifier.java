package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChineseNumberStringifier extends AbstractStringifier {
    private final int n;
    public ChineseNumberStringifier(int n) {
        this.n = n;
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

    public String stringify() {
        String str = Integer.valueOf(this.n).toString();
        List<String> strList = reversal(Arrays.asList(str.split("")));
        List<String> chineseStrList = strList.stream()
            .reduce(
                new ArrayList<String>(),
                (arr, s) -> {
                    int i = arr.size();
                    String chineseNum = chineseNumMap.get(Integer.parseInt(s));
                    if(s.equals("0")) {
                        arr.add(null);
                    } else if (i == 0) {
                        arr.add(chineseNum);
                    } else {
                        arr.add(chineseNum + chineseRankMap.get(i));
                    }
                    return arr;
                }, (arr1, arr2) -> null
            ).stream().filter(Objects::nonNull).toList();
        List<String> fixedStrList = reversal(chineseStrList);

        return String.join("", fixedStrList);
    };

    private List<String> reversal(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(0, s);
        }
        return newList;
    };
}
