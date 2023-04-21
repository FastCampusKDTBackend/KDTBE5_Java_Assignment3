package me.day05.practice;

import java.util.List;

public class ElectronicArrayUtil {

    static Electronic[] listToArray(List<Electronic> list) {
        Electronic[] resultArray = new Electronic[list.size()];

        for (int i = 0; i < resultArray.length; i++)
            resultArray[i] = list.get(i);

        return resultArray;
    }
}
