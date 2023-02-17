package com.example.applicationsys.controller;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Two {
    public static void main(String[] args) {
        /*String[] leftArray = {"a","b","c"};
        String[] rightArray = {"b","c","d"};*/

        String[] leftArray = {"a","b","b"};
        String[] rightArray = {"b","c","d"};
        System.out.println(solution(leftArray,rightArray));
    }

    public static String solution(String[] leftArray, String[] rightArray){
        Set<String> set = new TreeSet<>();
        Set<String> distinctSet = new TreeSet<>();
        for(String l : leftArray){
            set.add(l);
        }
        for(String r : rightArray){
            if(set.contains(r)){
                distinctSet.add(r);
            }
        }

        StringBuilder answer = new StringBuilder();
        Iterator<String> it = distinctSet.iterator();
        if(it.hasNext()){
            answer.append(it.next());
        }else{
            return "";
        }
        while (it.hasNext()) {
            answer.append(","+it.next());
        }
        return answer.toString();
    }
}
