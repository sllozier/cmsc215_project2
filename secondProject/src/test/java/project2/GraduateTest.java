package project2;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 2
 * Date: February 6, 2024
 * Description: This file contains JUnit test cases for testing the
 * functionality of the Undergraduate class.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraduateTest {
    private Graduate graduate;

    @BeforeEach
    public void setUp() {
        // Create a new Graduate object before each test
        graduate = new Graduate("Mary Adams", 40, 140, "Masters");
        Student.setGpaThreshold(3.0); // Example: setting threshold to 3.0 for testing
    }

    @Test
    public void testGraduateCreation() {
        // Test if the constructor correctly initializes the student's name, credit
        // hours, quality points, and degree sought
        assertEquals("Mary Adams", graduate.getName());
        assertEquals(40, graduate.getCreditHours());
        assertEquals(140, graduate.getQualityPoints());
        assertEquals("Masters", graduate.getDegreeSought());
    }

    @Test
    public void testEligibilityForHonorSociety() {
        // Test eligibility for honor society membership
        assertTrue(graduate.eligibleForHonorSociety()); // GPA is 3.5, and the degree sought is "Master's"
    }

    @Test
    public void testToString() {
        // Test the overridden toString method
        assertEquals("Name: Mary Adams, GPA: 3.50, Degree Sought: Masters",
                graduate.toString());
    }
}
