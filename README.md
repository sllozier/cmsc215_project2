# Academic Honor Society Evaluator


## Description

This Java program is designed to assess and manage student academic records for honor society eligibility. It reads student data (including name, credit hours, quality points, and year or degree) from a generated students.txt file, then creates appropriate Student, Undergraduate, or Graduate objects. The program calculates the average GPA, sets a dynamic threshold for honor society eligibility, and displays a report listing eligible students. It's structured as a Maven project with separate modules for data generation and core functionality, and includes a suite of JUnit tests for validation.

## User Guide

### Option 1: Run Program Without Maven (Using Downloaded Source Files)

Step 1: Download Source Files

1. Navigate to the project's repository.
2. Download the source files as a .zip file and extract them to a local directory.

Step 2: Compile the Java Files

1. Ensure you have Java installed on your system. You can download it from Oracle's Java website.
2. Open a terminal or command prompt.
3. Navigate to the extracted project directory.
4. Compile the Java files using the command: javac project2/*.java.

Step 3: Run the Program

1. Once compiled, run the program using: java project2.Project2.
2. Ensure students.txt is in the correct directory as expected by the program (usually in project2/target/generated-sources/).

### Option 2: Set Up and Run as Maven Build

Step 1: Clone or Download the Repository

1. Clone the repository using Git or download the source code as a .zip file from the project's repository.

Step 2: Install Maven

1. If not already installed, download and install Apache Maven from Maven's official website.
2. Follow the installation instructions provided on the site.

Step 3: Build the Project

1. Open a terminal or command prompt.
2. Navigate to the project's root directory.
3. Run the Maven build command: mvn clean install.
4. This command compiles the project and generates the students.txt file.

Step 4: Run the Program

1. After a successful build, navigate to the target directory within the project.
2. Run the program using: java -cp . project2.Project2.