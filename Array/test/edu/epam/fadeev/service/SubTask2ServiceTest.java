package edu.epam.fadeev.service;

import edu.epam.fadeev.entity.CustomArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubTask2ServiceTest {
    public SubTask2Service s;
    public CustomArray[] jagArray;

    @BeforeClass
    public void initService(){
        s = new SubTask2Service();
    }

    @BeforeMethod
    public void initArray() {
        jagArray =  new CustomArray[] {new CustomArray(1,4), new CustomArray(2,10), new CustomArray(5,9), new CustomArray(3,7)};
    }

    @Test
    public void testSortBySumAsc() {
        CustomArray[] actual = s.sortBySum(jagArray, true);
        CustomArray[] expected = new CustomArray[] {new CustomArray(1,4), new CustomArray(3,7), new CustomArray(5, 9), new CustomArray(2,10)};
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBySumDesc() {
        CustomArray[] actual = s.sortBySum(jagArray, false);
        CustomArray[] expected = new CustomArray[] {new CustomArray(2,10), new CustomArray(5,9), new CustomArray(3, 7), new CustomArray(1,4)};
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByMinAsc() {
        CustomArray[] actual = s.sortByMinElement(jagArray, true);
        CustomArray[] expected = new CustomArray[] {new CustomArray(1,4), new CustomArray(2,10), new CustomArray(3, 7), new CustomArray(5,9)};
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByMinDesc() {
        CustomArray[] actual = s.sortByMinElement(jagArray, false);
        CustomArray[] expected = new CustomArray[] {new CustomArray(5,9), new CustomArray(3,7), new CustomArray(2, 10), new CustomArray(1,4)};
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByMaxAsc() {
        CustomArray[] actual = s.sortByMaxElement(jagArray);
        CustomArray[] expected = new CustomArray[] {new CustomArray(1,4), new CustomArray(3,7), new CustomArray(5, 9), new CustomArray(2,10)};
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByMaxDesc() {
        CustomArray[] actual = s.sortByMaxElement(jagArray, false);
        CustomArray[] expected = new CustomArray[] {new CustomArray(2,10), new CustomArray(5,9), new CustomArray(3, 7), new CustomArray(1,4)};
        assertEquals(actual, expected);
    }
}