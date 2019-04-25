package com.holger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Holger
 * @date 2019/4/4
 */
public class Main {
    public static void main(String[] args) {
        List test = new ArrayList<>();
        test.add("aaaa");
        test.add("bbbb");
        test.add("cccc");
        
        Map<String,String> map = new HashMap();
        map.put("aa","aa");
        map.put("bb","bb");
        System.out.println(map.entrySet().stream()
                .map(e -> e.getKey()+"="+e.getValue()).reduce(";;;",String::concat));
        System.out.println(test.stream().collect(Collectors.joining(",")));
        
        System.out.println(2.0D/0);
        String all = String.join(" / ", "S", "M", "L", "XL");
        System.out.println(all);
        Integer a = 1;
        Integer b = 2;
        swap(a,b);
        System.out.println(a+" "+b);
        change(a,b);
        System.out.println(a+" "+b);
    }
    
    private static void swap (Integer a,Integer b){
        Integer temp = a;
        a = b;
        b =temp;
    }

    private static void change (Integer a,Integer b){
        a = a+1;
        b++;
    }
}

class Person {
    private int age;
    
}
