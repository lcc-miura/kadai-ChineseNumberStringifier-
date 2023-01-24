package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ChineseNumberStringifier {
    private final Map<String, String> intChineseMap = new HashMap<>() {
        {
            put("1", "壱");
            put("2", "弐");
            put("3", "参");
            put("4", "肆");
            put("5", "伍");
            put("6", "陸");
            put("7", "漆");
            put("8", "捌");
            put("9", "玖");
        }
    };

    String stringify(int n) {
        String str = Integer.valueOf(n).toString();
        List<String> strArr = Arrays.asList(str.split(""));
        Collections.reverse(strArr);

        List<String> chineseStrArr = strArr.stream().map(WithIndex.apply(0, (s, i) -> {
            if(s.equals("0")) return "";
            String chineseStr = intChineseMap.get(s);
            switch(i){
                case 1:
                    chineseStr += "拾";
                    break;
                case 2:
                    chineseStr += "佰";
                    break;
                case 3:
                    chineseStr += "阡";
                    break;
                case 4:
                    chineseStr += "萬";
                    break;
            }
            return chineseStr;
        })).collect(Collectors.toList());

        Collections.reverse(chineseStrArr);
        return String.join("", chineseStrArr);
    };
}
