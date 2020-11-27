package edu.epam.fadeev.service;

import edu.epam.fadeev.entity.CustomArray;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class InitializationTest {

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
