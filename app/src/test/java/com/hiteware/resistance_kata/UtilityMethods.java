package com.hiteware.resistance_kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4/17/16.
 */
public class UtilityMethods {
    public static List<Integer> construct_list(Integer... args) {
        List<Integer> list = new ArrayList<>();
        for (Integer arg : args) {
            list.add(arg);
        }
        return list;
    }

    public static Integer[] construct_array(Integer... args) {
        List<Integer> list = construct_list(args);
        Integer[] array = new Integer[args.length];
        list.toArray(array);
        return array;
    }
}
