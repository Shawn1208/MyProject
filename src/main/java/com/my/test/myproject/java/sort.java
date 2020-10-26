package com.my.test.myproject.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Ruixiao.Xu
 * @Date: 26/10/20 11:47 AM
 */
public class sort {


    @Test
    public void sort(){
        List<Integer> list = Arrays.asList(33,2,45,123,678,5);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        list.forEach(System.out::println);
        //System.out.println("");
    }
}
