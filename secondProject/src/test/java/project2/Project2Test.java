package project2;

/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 2
 * Date: February 6, 2024
 * Description: This file contains JUnit test cases for testing the
 * functionality of the Project2 class.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Project2Test {
    private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // Redirect console output to capture it
        System.setOut(new PrintStream(consoleOutput));
    }

    @Test
    public void testReadStudentsFromFile() {
        // Path to your test data file, adjust as necessary
        String testFilePath = "target/generated-sources/students.txt";
        // Call the method to read students from the file
        Project2.readStudentsFromFile(testFilePath);
        // Assuming the Project2 class maintains a list of students
        // and provides a method to access it
        assertEquals(102, Project2.getStudents().size()); // Assuming 3 students in the test file
    }

    @Test
    public void testComputeAverageGpa() {
        // Create a list of students with known GPAs
        List<Student> students = Arrays.asList(
                new Student("Student One", 30, 120), // GPA: 4.0
                new Student("Student Two", 30, 90), // GPA: 3.0
                new Student("Student Three", 30, 105) // GPA: 3.5
        );

        // Call computeAverageGpa and check the result
        double averageGpa = Project2.computeAverageGpa(students);
        assertEquals(3.5, averageGpa, 0.01); // Expect average GPA of 3.5
    }

    @Test
    public void testSetAndDisplayGpaThreshold() {
        // Set a known threshold value
        double threshold = 3.6;
        Project2.setAndDisplayGpaThreshold(threshold);

        // Normalize newlines and trim output for comparison
        String actualOutput = consoleOutput.toString().replace("\r\n", "\n").trim();
        String expectedOutput = "GPA Threshold: 3.60";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDisplayEligibleStudentsReport() {
        // Set the GPA threshold for testing
        Student.setGpaThreshold(3.5);

        // Add students with known eligibility status
        Project2.addStudent(new Student("John Doe", 36, 144)); // GPA to meet threshold
        Project2.addStudent(new Undergraduate("Alice Smith", 48, 160, "Junior")); // GPA: 3.33

        // Call the method to display the eligible students report
        Project2.displayEligibleStudentsReport();

        // Normalize newlines and trim output for comparison
        // Normalize newlines and trim output for comparison
        String actualOutput = consoleOutput.toString().replace("\r\n", "\n").trim();
        String expectedOutput = "Eligible Students:\n\nJohn Doe";

        assertEquals(expectedOutput, actualOutput);
    }

}
