import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class StudentData {

    public static void generateStudentDataFile(String fileName, int numberOfStudents) {
        try {
            // Create a FileWriter to write to the specified text file
            // FileWriter is a Java standard class for writing data to text files
            FileWriter fileWriter = new FileWriter(fileName);

            // Random number generator
            Random random = new Random();

            // Generate student data
            for (int i = 0; i < numberOfStudents; i++) {
                // Generate random first name and last name using the uinames.com API
                String[] randomName = generateRandomName();
                String firstName = randomName[0];
                String lastName = randomName[1];

                int creditHours = random.nextInt(61) + 20; // Random credit hours between 20 and 80
                int qualityPoints = creditHours * (random.nextInt(3) + 2); // Random quality points
                String yearOrDegree = generateYearOrDegree(random);

                // Write student data to the file
                fileWriter.write(lastName + "," + firstName + " " + creditHours + " " + qualityPoints + " "
                        + yearOrDegree + "\n");
            }

            // Close the FileWriter
            fileWriter.close();

            System.out.println("Student data generated successfully in '" + fileName + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] generateRandomName() {
        try {
            // Create a URL object to access the uinames.com API
            // URL is a Java class used to represent and manipulate Uniform Resource
            // Locators (URLs)
            URL url = new URL("https://uinames.com/api/?amount=1"); // API to generate names
                                                                    // (https://github.com/thm/uinames)

            // Open a connection to the URL
            // HttpURLConnection is a Java class for making HTTP requests and handling HTTP
            // connections
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response from the API
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            // JSON (JavaScript Object Notation) is a lightweight data interchange format
            // JSON parsing is required to extract specific data from the JSON response
            // received from the API
            // Parse the JSON response to extract the first name and last name
            String json = response.toString();
            String firstName = json.split("\"first\":\"")[1].split("\"")[0];
            String lastName = json.split("\"last\":\"")[1].split("\"")[0];

            return new String[] { firstName, lastName };
        } catch (IOException e) {
            e.printStackTrace();
            return new String[] { "John", "Doe" }; // Default values in case of API failure
        }
    }

    private static String generateYearOrDegree(Random random) {
        // Generate random year for undergraduate or "Masters" for graduate
        if (random.nextBoolean()) {
            String[] years = { "Freshman", "Sophomore", "Junior", "Senior" };
            return years[random.nextInt(years.length)];
        } else {
            return "Masters";
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Generate student data and save it to a text file named "students.txt" with
        // 100 students
        generateStudentDataFile("students.txt", 100);
    }
}
