
/**
 * Name: Sarah L. Lozier
 * Class: CMSC 215 - 6380
 * Project: Project 2
 * Date: February 6, 2024
 * Description: This file contains JUnit test cases for testing the functionality of the Project2 class.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Project2Test {
    private Project2 project2;
    private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // Create a new Project2 object before each test
        project2 = new Project2();

        // Redirect console output to capture it
        System.setOut(new PrintStream(consoleOutput));
    }

    @Test
    public void testReadStudentsFromFile() {
        // Test reading student information from a sample file
        // Define your test data file 'students.txt' and call the method to read from it
        // You can then assert that the list of students is correctly populated

        // Example assertion:
        // assertEquals(3, project2.getStudents().size()); // Assuming 3 students in the
        // sample file
    }

    @Test
    public void testComputeAverageGpa() {
        // Test computing the average GPA for a list of students
        // Define a list of students with known GPAs and call the method to compute the
        // average
        // You can then assert that the computed average matches the expected value

        // Example assertion:
        // assertEquals(3.5, project2.computeAverageGpa(), 0.01); // Assuming an average
        // GPA of 3.5
    }

    @Test
    public void testSetAndDisplayGpaThreshold() {
        // Test setting and displaying the GPA threshold
        // Set a known threshold value and call the method to set and display it
        // Capture the console output and assert that it matches the expected output

        // Example assertion:
        // project2.setAndDisplayGpaThreshold(3.6);
        // assertEquals("GPA Threshold: 3.6\n", consoleOutput.toString());
    }

    @Test
    public void testDisplayEligibleStudentsReport() {
        // Test displaying the report of eligible students
        // Define a list of students with known eligibility status and call the method
        // to display the report
        // Capture the console output and assert that it matches the expected output

        // Example assertion:
        // Student student1 = new Student("John Doe", 36, 120);
        // Student student2 = new Student("Alice Smith", 48, 160, "Junior");
        // project2.addStudent(student1);
        // project2.addStudent(student2);
        // project2.displayEligibleStudentsReport();
        // assertEquals("Eligible Students:\nJohn Doe\n", consoleOutput.toString());
    }
}

public class Project2Test {

}
