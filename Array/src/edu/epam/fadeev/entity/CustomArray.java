package edu.epam.fadeev.entity;

import edu.epam.fadeev.service.ReaderInformation;

import java.util.Arrays;

public class CustomArray {
    private int[] array;

    public CustomArray(int length) {
        array = new int[length];
        for (int i = 0; i < length ; i++) {
            array[i] = Double.valueOf(Math.random()).intValue();
        }
    }

    public CustomArray() {
        array = ReaderInformation.read();
    }

    public CustomArray(int min, int max) {
        array = new int[max - min + 1];
        for (int i = 0; i < max - min + 1; i++) {
            array[i] = min + i;
        }
    }

    public CustomArray(int min, int max, int step) {
            array = new int[(max - min) / step + 1];
            for (int i = 0; i * step + min <= max; i++) {
                array[i] = min + i * step;
            }
    }

    public CustomArray(int[] array) {
        this.array = array;
    }

    public int getArrayElement(int index) {
        return array[index];
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setArrayElement(int index, int value){
        array[index] = value;
    }

    public int length() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray array1 = (CustomArray) o;
        return Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "Array{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
