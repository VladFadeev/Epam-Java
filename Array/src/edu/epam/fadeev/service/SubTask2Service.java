package edu.epam.fadeev.service;

import edu.epam.fadeev.entity.CustomArray;

import java.util.Objects;

public class SubTask2Service {

    private int sum(CustomArray array){
        int sum = 0;
        for (int i = 0; i < array.length(); i++) {
            sum+=array.getArrayElement(i);
        }
        return sum;
    }

    private CustomArray[] swap(CustomArray[] jagArray, int index, int step){
        CustomArray a = jagArray[index + step];
        jagArray[index + step] = jagArray[index];
        jagArray[index] = a;
        return jagArray;
    }

    private CustomArray[] sortBySumAsc(CustomArray[] jagArray) {
            boolean flag = true;
            int bound = jagArray.length;
            while (flag) {
                flag = false;
                for (int j = 0; j < bound - 1; j++) {
                    if (sum(jagArray[j]) > sum(jagArray[j + 1])) {
                        jagArray = swap(jagArray, j, 1);
                        flag = true;
                    }
                }
                bound--;
            }
            return jagArray;
    }

    private CustomArray[] sortBySumDesc(CustomArray[] jagArray) {
        boolean flag = true;
        int bound = 0;
        while (flag) {
            flag = false;
            for (int j = jagArray.length - 1; j > bound; j--) {
                if (sum(jagArray[j]) > sum(jagArray[j - 1])) {
                    jagArray = swap(jagArray, j, -1);
                    flag = true;
                }
            }
            bound++;
        }
        return jagArray;
    }

    private CustomArray[] sortByMinElementAsc(CustomArray[] jagArray) {
        boolean flag = true;
        int bound = jagArray.length;
        SearchService s = new SearchService();
        while (flag) {
            flag = false;
            for (int j = 0; j < bound - 1; j++) {
                if (s.minSearch(jagArray[j]) > s.minSearch(jagArray[j + 1])) {
                    jagArray = swap(jagArray, j, 1);
                    flag = true;
                }
            }
            bound--;
        }
        return jagArray;
    }

    private CustomArray[] sortByMinElementDesc(CustomArray[] jagArray) {
        boolean flag = true;
        int bound = 0;
        SearchService s = new SearchService();
        while (flag) {
            flag = false;
            for (int j = jagArray.length - 1; j > bound; j--) {
                if (s.minSearch(jagArray[j]) > s.minSearch(jagArray[j - 1])) {
                    jagArray = swap(jagArray, j, -1);
                    flag = true;
                }
            }
            bound++;
        }
        return jagArray;
    }

    private CustomArray[] sortByMaxElementAsc(CustomArray[] jagArray) {
        boolean flag = true;
        int bound = jagArray.length;
        SearchService s = new SearchService();
        while (flag) {
            flag = false;
            for (int j = 0; j < bound - 1; j++) {
                if (s.maxSearch(jagArray[j]) > s.maxSearch(jagArray[j + 1])) {
                    jagArray = swap(jagArray, j, 1);
                    flag = true;
                }
            }
            bound--;
        }
        return jagArray;
    }

    private CustomArray[] sortByMaxElementDesc(CustomArray[] jagArray) {
        boolean flag = true;
        int bound = 0;
        SearchService s = new SearchService();
        while (flag) {
            flag = false;
            for (int j = jagArray.length - 1; j > bound; j--) {
                if (s.maxSearch(jagArray[j]) > s.maxSearch(jagArray[j - 1])) {
                    jagArray = swap(jagArray, j, -1);
                    flag = true;
                }
            }
            bound++;
        }
        return jagArray;
    }

    public CustomArray[] sortBySum(CustomArray[] jagArray, boolean byAsc) {
        CustomArray[] temp;
        if (byAsc) {
            temp = sortBySumAsc(jagArray);
        } else {
            temp = sortBySumDesc(jagArray);
        }
        return temp;
    }

    public CustomArray[] sortByMinElement(CustomArray[] jagArray, boolean byAsc) {
        CustomArray[] temp;
        if (byAsc) {
            temp = sortByMinElementAsc(jagArray);
        } else {
            temp = sortByMinElementDesc(jagArray);
        }
        return temp;
    }

    public CustomArray[] sortByMaxElement(CustomArray[] jagArray, boolean ... byAsc) {
        boolean tempByAsc = byAsc.length == 0 || byAsc[0];
        CustomArray[] temp;
        if (tempByAsc) {
            temp = sortByMaxElementAsc(jagArray);
        } else {
            temp = sortByMaxElementDesc(jagArray);
        }
        return temp;
    }
}
