package edu.epam.fadeev.entity;

import edu.epam.fadeev.helper.RandomGeneration;
import edu.epam.fadeev.reader.ReaderInformation;

import java.util.Arrays;

public class CustomArray {
    private int[] array;

    public CustomArray(int length) {
        array = RandomGeneration.generateArray(length);
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
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
