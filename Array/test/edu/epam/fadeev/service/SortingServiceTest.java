package edu.epam.fadeev.service;

import edu.epam.fadeev.entity.CustomArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortingServiceTest {
    public CustomArray array;
    public SortingService sort;

    @BeforeClass
    public void initService(){
        array = new CustomArray(new int[]{4, 7, 42, 5, 47, 6, 4, 98, 34, 423, 96, 234, 55, 23, 646});
        sort = new SortingService();
    }

    @BeforeTest
    public void initArray(){
        array = new CustomArray(new int[]{4, 7, 42, 5, 47, 6, 4, 98, 34, 423, 96, 234, 55, 23, 646});
        sort = new SortingService();
    }

    @Test
    public void testBubbleSort() {
        CustomArray actual = sort.bubbleSort(array);
        CustomArray expected = new CustomArray(new int[]{4,4,5,6,7,23,34,42,47,55,96,98,234,423,646});
        assertEquals(actual, expected);
    }

    @Test
    public void testSelectionSort() {
        CustomArray actual = sort.selectionSort(array);
        CustomArray expected = new CustomArray(new int[]{4,4,5,6,7,23,34,42,47,55,96,98,234,423,646});
        assertEquals(actual, expected);
    }

    @Test
    public void testInsertionSort() {
        CustomArray actual = sort.insertionSort(array);
        CustomArray expected = new CustomArray(new int[]{4,4,5,6,7,23,34,42,47,55,96,98,234,423,646});
        assertEquals(actual, expected);
    }
}