package org.example;

import java.util.*;

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
        List<String> chineseStrList = transToChinese(strList, chineseNumMap, chineseRankMap);
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

    private List<String> transToChinese(List<String> list, Map<Integer, String> chineseNumMap, Map<Integer, String> chineseRankMap) {
        List<String> newList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if(s.equals("0")) continue;
            String chineseNum = chineseNumMap.get(Integer.parseInt(s));
            if(i == 0) {
                newList.add(chineseNum);
                continue;
            };
            newList.add(chineseNum + chineseRankMap.get(i));
        }
        return newList;
    }
}
