package by.drozdovskaya.ft.service.impl;

import by.drozdovskaya.ft.entity.CustomArray;
import by.drozdovskaya.ft.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayServiceImplTest {
    private CustomArrayServiceImpl service;
    private CustomArray sampleArray;

    @BeforeEach
    void setUp() {
        service = new CustomArrayServiceImpl();
        sampleArray = new CustomArray(new int[]{10, -5, 20, 0});
    }

    @Test
    void testFindMin() throws ArrayException {
        assertEquals(-5, service.findMin(sampleArray));
    }

    @Test
    void testCalculateSum() throws ArrayException {
        assertEquals(25, service.calculateSum(sampleArray));
    }

    @Test
    void testSortBubble() throws ArrayException {
        int[] expected = {-5, 0, 10, 20};
        service.sortBubble(sampleArray);
        assertArrayEquals(expected, sampleArray.getElements());
    }
}