package docs;

import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StudentDataTest {

    private final String testFileName = "target/generated-test-sources/test_students.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create a mock file for testing
        try (FileWriter fileWriter = new FileWriter(testFileName)) {
            for (int i = 0; i < 10; i++) {
                // Mock data format: LastName,FirstName CreditHours QualityPoints YearOrDegree
                fileWriter.write("Doe,John 60 180 Sophomore\n");
            }
        }
    }

    @AfterEach
    void tearDown() {
        // Cleanup the test file after each test
        new File(testFileName).delete();
    }

    @Test
    void testStudentDataCreateFile() {
        StudentData.generateStudentDataFile(testFileName, 10);
        assertTrue(new File(testFileName).exists());
    }

    @Test
    void testStudentDataNumberOfLines() throws Exception {
        int numberOfStudents = 10;
        StudentData.generateStudentDataFile(testFileName, numberOfStudents);
        List<String> lines = Files.readAllLines(Paths.get(testFileName));
        assertEquals(numberOfStudents, lines.size());
    }

    @Test
    void testStudentDataFormat() throws Exception {
        StudentData.generateStudentDataFile(testFileName, 10);
        List<String> lines = Files.readAllLines(Paths.get(testFileName));

        for (String line : lines) {
            assertTrue(line.matches("[a-zA-Z]+,[a-zA-Z]+ \\d+ \\d+ (Freshman|Sophomore|Junior|Senior|Masters)"));
        }
    }

    @Test
    void testStudentDataWithInvalidNumberOfStudents() {
        // Delete the file created in setUp
        new File(testFileName).delete();
        // Call the method with an invalid number of students
        StudentData.generateStudentDataFile(testFileName, -1);
        // Assert that the file was not created
        assertFalse(new File(testFileName).exists());
    }

}
