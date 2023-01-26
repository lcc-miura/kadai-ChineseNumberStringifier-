package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChineseNumberStringifier extends AbstractStringifier {
    private static final Map<Integer, String> CHINESE_NUM_MAP = Map.of(
            1, "壱",
            2, "弐",
            3, "参",
            4, "肆",
            5, "伍",
            6, "陸",
            7, "漆",
            8, "捌",
            9, "玖"
    );
    private static final Map<Integer, String> CHINESE_RANK_MAP = Map.of(
            1, "拾",
            2, "佰",
            3, "阡",
            4, "萬"
    );

    @Override
    public List<String> transMapping(List<String> strList) {
        List<String> chineseStrList = strList.stream()
                .reduce(
                        new ArrayList<String>(),
                        (arr, s) -> {
                            int i = arr.size();
                            String chineseNum = CHINESE_NUM_MAP.get(Integer.parseInt(s));
                            if(s.equals("0")) {
                                arr.add(null);
                            } else if (i == 0) {
                                arr.add(chineseNum);
                            } else {
                                arr.add(chineseNum + CHINESE_RANK_MAP.get(i));
                            }
                            return arr;
                        }, (arr1, arr2) -> null
                ).stream().filter(Objects::nonNull).toList();
        return chineseStrList;
    }
}
