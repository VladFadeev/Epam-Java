package edu.epam.fadeev.service;

import edu.epam.fadeev.entity.CustomArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SearchServiceTest {
    public CustomArray array;
    public SearchService s;
    public SortingService sort;

    @BeforeClass
    public void initService() {
        s = new SearchService();
        sort = new SortingService();
    }

    @BeforeTest
    public void initArray(){
        array = new CustomArray(new int[]{4, 7, 42, 5, 47, 6, 4, 98, 34, 423, 96, 234, 55, 23, 646});
    }

    @Test
    public void testBinarySearch() {
        sort.bubbleSort(array);
        int expected = 8;
        int actual = s.binarySearch(array, 47);
        assertEquals(actual, expected);
    }

    @Test
    public void testMinSearch() {
        int expected = 4;
        int actual = s.minSearch(array);
        assertEquals(actual, expected);
    }

    @Test
    public void testMaxSearch() {
        int expected = 646;
        int actual = s.maxSearch(array);
        assertEquals(actual, expected);
    }

    @Test
    public void testPrimeSearch() {
        int[] expected = new int[]{5,7,23,47};
        int[] actual = s.primeSearch(array);
        assertEquals(actual, expected);
    }

    @Test
    public void testFibonachiSearch() {
        int[] expected = new int[]{5,34,55};
        int[] actual = s.fibonachiSearch(array);
        assertEquals(actual, expected);
    }

    @Test
    public void testThreeDifferentDigitsSearch() {
        int[] expected = new int[]{234,423};
        int[] actual = s.threeDifferentDigitsSearch(array);
        assertEquals(actual, expected);
    }

    @Test
    public void testInitArrayByRandom(){
        CustomArray expected = new CustomArray(1,7);
        CustomArray actual = new CustomArray(7);
        assertEquals(actual.length(), expected.length());
        for (int i = 0; i < expected.length(); i++) {
            assertNotNull(actual.getArrayElement(i));
        }
    }

    @Test
    public void testInitArrayByFile() {
        CustomArray expected = new CustomArray(new int[]{3, 236, 65, 33, 7, 674, 75});
        CustomArray actual = new CustomArray();
        assertEquals(actual, expected);
    }
}