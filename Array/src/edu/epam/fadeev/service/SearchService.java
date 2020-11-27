package edu.epam.fadeev.service;

import edu.epam.fadeev.entity.CustomArray;

import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class SearchService {

    public int binarySearch(CustomArray array, int value) {
        int leftindex = 0, rightindex = array.length() - 1, index = 0;
        while ((rightindex - leftindex) / 2 > 0) {
            if (value > array.getArrayElement(leftindex + (rightindex - leftindex) / 2)) {
                leftindex += (rightindex - leftindex) / 2;
            } else if (value <= array.getArrayElement(leftindex + (rightindex - leftindex) / 2)) {
                rightindex -= (rightindex - leftindex) / 2;
            }
        }
        if (value == array.getArrayElement(leftindex)) {
            index = leftindex;
        } else if (value == array.getArrayElement(rightindex)) {
            index = rightindex;
        }
        return index;
    }

    public int minSearch(CustomArray array) {
        int index = 0;
        for (int i = 1; i < array.length(); i++) {
            if (array.getArrayElement(index) > array.getArrayElement(i))
                index = i;
        }
        return array.getArrayElement(index);
    }

    public int maxSearch(CustomArray array) {
        int index = 0;
        for (int i = 1; i < array.length(); i++) {
            if (array.getArrayElement(index) < array.getArrayElement(i))
                index = i;
        }
        return array.getArrayElement(index);
    }

    public int[] primeSearch(CustomArray array) {
        ArrayList<Integer> primeArray = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            if (array.getArrayElement(i) != 2) {
                boolean flag = true;
                for (int j = 2; j <= sqrt(array.getArrayElement(i)); j++) {
                    if (array.getArrayElement(i) % j == 0)
                        flag = false;
                }
                if (flag) {
                    primeArray.add(array.getArrayElement(i));
                }
            } else {
                primeArray.add(array.getArrayElement(i));
            }
        }

        return primeArray.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] fibonachiSearch(CustomArray array) {
        SearchService s = new SearchService();
        int max = s.maxSearch(array);
        ArrayList<Integer> fibonachi = new ArrayList<>();
        ArrayList<Integer> fibArray = new ArrayList<>();
        fibonachi.add(0, 0);
        fibonachi.add(1, 1);
        for (int i = 2; fibonachi.get(i - 1) + fibonachi.get(i - 2) <= max; i++) {
            fibonachi.add(i, fibonachi.get(i - 1) + fibonachi.get(i - 2));
        }
        for (int i = 0; i < array.length(); i++) {
            final int temp = array.getArrayElement(i);
            if (fibonachi.stream().anyMatch(f -> f == temp))
                fibArray.add(temp);
        }
        return fibArray.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] threeDifferentDigitsSearch(CustomArray array){
        ArrayList<Integer> out = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            if (array.getArrayElement(i)>101 && array.getArrayElement(i)<988){
                int[] temp = new int[]{array.getArrayElement(i)%10,(array.getArrayElement(i)/10)%10,array.getArrayElement(i)/100 };
                if (temp[0] != temp[1] && temp[0] != temp[2] && temp[1] != temp[2])
                    out.add(array.getArrayElement(i));
            }
        }
        return out.stream().mapToInt(Integer::intValue).toArray();
    }
}
