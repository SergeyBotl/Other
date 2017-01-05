package calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcOfString {
    static List<Integer> intList = new ArrayList<>();

    public static void main(String[] args) {

        String str = "2*12ihi52.414oi4+5oA!@54#$%^&*()_=i/kjlj-jkhlk15-5jhjkh+ll10/2kkll5+3";
        string(str);
    }

    static void string(String str) {
        Pattern pattern = Pattern.compile("[0-9]+[+-/*][0-9]+|[0-9]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
           // System.out.print(matcher.group() + " ");
            calc(matcher.group());
        }
        intList.forEach(System.out::println);
        System.out.println("Max: " + Collections.max(intList));
        System.out.println("Min: " + Collections.min(intList));
    }


    static void calc(String s) {
        String[] operator = {"*", "/", "-", "+", "."};
        for (int i = 0; i < operator.length; i++) {
            if (s.contains(operator[i])) {
                int first = Integer.parseInt(s.substring(0, s.indexOf(operator[i])));
                int last = Integer.parseInt(s.substring(s.indexOf(operator[i]) + 1));
                if (i == 0) first *= last;
                if (i == 1) first /= last;
                if (i == 2) first -= last;
                if (i == 3) first += last;
                if (i == 4) {
                    intList.add(first);
                    intList.add(last);
                    return;
                }
                intList.add(first);
                return;
            }
        }
        intList.add(Integer.parseInt(s));
    }

}
