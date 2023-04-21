package me.day05.practice;

import java.util.List;

public class ArrayUtil {

    static <T> T[] listToArray(List<T> list) {
        T[] resultArray = (T[]) new Object[list.size()];

        for (int i = 0; i < resultArray.length; i++)
            resultArray[i] = list.get(i);

        return resultArray;
    }
}
