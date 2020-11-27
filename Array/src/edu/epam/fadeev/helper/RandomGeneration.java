package edu.epam.fadeev.helper;

public class RandomGeneration {
    public static int[] generateArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = Double.valueOf(Math.random()).intValue();
        }
        return array;
    }
}
