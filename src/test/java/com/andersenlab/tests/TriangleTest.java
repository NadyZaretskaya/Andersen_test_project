package com.andersenlab.tests;

import com.andersenlab.triangle.Triangle;
import com.andersenlab.triangle.TriangleException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private static Logger log = LoggerFactory.getLogger(TriangleTest.class);
    private Triangle triangle;

    @Test
    void area() throws TriangleException {
        triangle = new Triangle(3, 3, 3);
        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
        assertEquals(decimalFormat.format((Math.sqrt(3) / 4) * 9),
                decimalFormat.format(triangle.area()));
    }

    @Test
    void testInputWrongData() {
        triangle = new Triangle(0, 3, 3);
        try {
            triangle.area();
            fail("Sorry, it's might be not a triangle");
        } catch (TriangleException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Wrong work the method area()");
        }
    }

    @Test
    void checkIsTriangle() {
        int lengthSize = 4;
        assertAll("check if the triangle exists",
                () -> assertTrue(new Triangle(lengthSize, 3, 6).checkTriangle()),
                () -> assertFalse(new Triangle(lengthSize, 3, 7).checkTriangle())
        );
    }

    @Test
    void checkTriangleMin() {
        int[] lengthSize = {-1, 0, 1};
        assertAll("check the boundary values min",
                () -> assertFalse(new Triangle(lengthSize[0], 1, 1).checkTriangle()),
                () -> assertFalse(new Triangle(lengthSize[1], 1, 1).checkTriangle()),
                () -> assertTrue(new Triangle(lengthSize[2], 1, 1).checkTriangle())
        );
    }

    @Test
    void checkThrowException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, ()
                -> {
            throw new UnsupportedOperationException("Sorry, it's might be not a triangle");
        });
        assertEquals(exception.getMessage(), "Sorry, it's might be not a triangle");
    }
}
