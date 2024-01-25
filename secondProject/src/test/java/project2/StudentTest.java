package project2;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 2
 * Date: February 6, 2024
 * Description: This file contains JUnit test cases for testing the
 * functionality of the Student class.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        // Create a new Student object before each test
        student = new Student("John Doe", 30, 120);
    }

    @Test
    public void testStudentCreation() {
        // Test if the constructor correctly initializes the student's name, credit
        // hours, and quality points
        assertEquals("John Doe", student.getName());
        assertEquals(30, student.getCreditHours());
        assertEquals(120, student.getQualityPoints());
    }

    @Test
    public void testGpaCalculation() {
        // Test the calculation of GPA
        assertEquals(4.0, student.gpa(), 0.01);
    }

    @Test
    public void testEligibilityForHonorSociety() {
        // Test eligibility for honor society membership
        assertTrue(student.eligibleForHonorSociety());
    }

    @Test
    public void testToString() {
        // Test the toString method
        assertEquals("Name: John Doe, GPA: 4.00", student.toString());
    }

    @Test
    public void testSetGpaThreshold() {
        // Test the static method setGpaThreshold
        Student.setGpaThreshold(3.5); // Set a threshold of 3.5
        assertEquals(3.5, Student.getGpaThreshold(), 0.01); // Verify that the threshold is set correctly
    }
}
