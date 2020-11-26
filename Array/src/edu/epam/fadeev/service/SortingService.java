package edu.epam.fadeev.service;

import edu.epam.fadeev.entity.CustomArray;

public class SortingService {

    public CustomArray bubbleSort(CustomArray array) {
        boolean flag = true;
        int len = array.length();
        while (flag) {
            flag = false;
            for (int i = 0; i < len - 1; i++) {
                if (array.getArrayElement(i) > array.getArrayElement(i+1)) {
                    int a = array.getArrayElement(i + 1);
                    array.setArrayElement(i + 1, array.getArrayElement(i));
                    array.setArrayElement(i, a);
                    flag = true;
                }
            }
            len--;
        }
        return array;
    }

    public CustomArray selectionSort(CustomArray array) {
        for (int i = 0; i < array.length(); i++) {
            int index = i;
            for (int j = i + 1; j < array.length(); j++) {
                if (array.getArrayElement(j) < array.getArrayElement(index)) {
                    index = j;
                }
            }
            if (index != i) {
                int a = array.getArrayElement(i);
                array.setArrayElement(i, array.getArrayElement(index));
                array.setArrayElement(index,a);
            }
        }
        return array;
    }

    public CustomArray insertionSort(CustomArray array) {
        for (int i = 1; i < array.length(); i++) {
            int var = array.getArrayElement(i);
            int j = i;
            while (j > 0 && array.getArrayElement(j - 1) > var) {
                array.setArrayElement(j, array.getArrayElement(j - 1));
                j--;
            }
            array.setArrayElement(j, var);
        }
        return array;
    }
}
