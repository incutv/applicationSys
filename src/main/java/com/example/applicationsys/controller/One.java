package com.example.applicationsys.controller;


import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class One {
    public static void main(String[] args) {
        System.out.println(DateTimeFormat.forPattern("yyyyMMddHH0000").print(System.currentTimeMillis()));
        String[] parmas = {"aaaa","dssss","aaad"};
        System.out.println(solution(parmas));
    }

    public static String solution(String[] parmas){
        List<String> list = Arrays.asList(parmas);
        String answer = list.stream()
                            .filter(l -> l.length()>=5 && l.length()<=10 )
                            .findFirst().orElse("없음");
        return answer.toUpperCase();
    }
}
