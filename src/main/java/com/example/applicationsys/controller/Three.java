package com.example.applicationsys.controller;

import java.util.*;

class Product{
    String name;
    Integer price;
    public Product(String name,Integer price){
        this.name=name;
        this.price=price;
    }
}

public class Three {
    public static void main(String[] args) {
        String[] productInfo = {"123456789,유기농 4kg,50000","234578882,배달,3000"};
        String[] dailyProductSales = {"20220810,123456789,5","20220810,234578882,30","20220811,123456789,7"};
        System.out.println(solution(productInfo,dailyProductSales));
    }

    public static String[] solution(String[] productInfo, String[] dailyProductSales){
        Map<String,Product> map = new HashMap<>();
        for(String infos : productInfo){
            String[] info = infos.split(",");
            Product product = new Product(info[1],Integer.parseInt(info[2]));
            map.put(info[0],product);
        }

        System.out.println(map.toString());
        String[] answer = new String[dailyProductSales.length];

        int index = 0;
        for(String sales : dailyProductSales){
            String[] sale = sales.split(",");
            answer[index++] = String.format("%s,%s,%s,%s",sale[0],sale[1],map.get(sale[1]).name,Integer.parseInt(sale[2])*map.get(sale[1]).price);
        }

        return answer;
    }
}
