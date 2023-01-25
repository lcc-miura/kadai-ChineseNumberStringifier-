package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumberStringifier extends AbstractStringifier {
    private final int n;
    public RomanNumberStringifier(int n) {
        this.n = n;
    }
    private final Map<Integer, String> chineseNumMap = new LinkedHashMap<>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };

    public String stringify() {
        String romanized = "";
        int newN = this.n;

        for (Map.Entry<Integer, String> entry : chineseNumMap.entrySet()) {
            while (entry.getKey() <= newN) {
                romanized += entry.getValue();
                newN -= entry.getKey();
            }
        }
        return romanized;
    }
}
