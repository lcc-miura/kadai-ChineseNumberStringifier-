package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractStringifier {
    public int n;
    public abstract List<String> respectivelyMethod(List<String> strList);

    public AbstractStringifier(int n) {
        this.n = n;
    }

    public final void display() {
        System.out.println(stringify());
    }

    public String stringify() {
        String str = Integer.valueOf(this.n).toString();
        List<String> strList = reversal(Arrays.asList(str.split("")));
        List<String> chineseStrList = this.respectivelyMethod(strList);
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
