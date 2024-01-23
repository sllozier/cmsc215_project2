
/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 2
 * Date: February 6, 2024
 * Description: This file contains JUnit test cases for testing the functionality of the Undergraduate class.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UndergraduateTest {
    private Undergraduate undergraduate;

    @BeforeEach
    public void setUp() {
        // Create a new Undergraduate object before each test
        undergraduate = new Undergraduate("Alice Smith", 48, 160, "Junior");
    }

    @Test
    public void testConstructor() {
        // Test if the constructor correctly initializes the student's name, credit
        // hours, quality points, and year
        assertEquals("Alice Smith", undergraduate.getName());
        assertEquals(48, undergraduate.getCreditHours());
        assertEquals(160, undergraduate.getQualityPoints());
        assertEquals("Junior", undergraduate.getYear());
    }

    @Test
    public void testEligibilityForHonorSociety() {
        // Test eligibility for honor society membership
        assertTrue(undergraduate.eligibleForHonorSociety()); // GPA is 3.33, and the year is "Junior"
    }

    @Test
    public void testToString() {
        // Test the overridden toString method
        assertEquals("Name: Alice Smith, GPA: 3.33, Year: Junior", undergraduate.toString());
    }
}
