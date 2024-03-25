import java.util.Scanner;
//This line declares the starting of a Java class named IJSE.
public class IJSE {

    public static void main(String[] args) {
        // The Scanner class is used for reading input
        Scanner menu = new Scanner(System.in);
        // Declare an array of strings to store student IDs with a capacity of 1000.
        String[] studentId = new String[1000];
// Declare an array of strings to store student names with a capacity of 1000.
        String[] studentName = new String[1000];
// Declare an array of integers to store programming marks for students with a capacity of 1000.
        int[] programmingMarks = new int[1000];
// Declare an array of integers to store DBMS (Database Management System) marks for students with a capacity of 1000.
        int[] dbmsMarks = new int[1000];
// Enter an infinite loop using 'while (true)' to repeatedly prompt for user input.
        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("| Welcome to GDSE Marks Management System |");
            System.out.println("-------------------------------------------");
            System.out.println("[1] Add New Student");
            System.out.println("[2] Add New Student with Marks");
            System.out.println("[3] Add Marks");
            System.out.println("[4] Update Student Details");
            System.out.println("[5] Update Marks");
            System.out.println("[6] Delete Student");


            System.out.println("[7] Print Student Details");
            System.out.println("[8] Print Student Ranks");
            System.out.println("[9] Best in Programming Fundamentals");
            System.out.println("[10] Best in Database Management System");
            System.out.println("[11] Exit");
            System.out.println("Enter an option to continue: ");
            // Read an integer input from the user and store it in the 'choice' variable.
            int choice = menu.nextInt();
            menu.nextLine(); // Consume the newline character
            clearConsole();
            // Process the user's choice using a switch statement
            switch (choice) {
                case 1 -> addNewStudent(studentId, studentName);
                case 2 -> addNewStudentWithMarks(studentId, programmingMarks, dbmsMarks,
                        studentName);
                case 3 -> addMarks(studentId, programmingMarks, dbmsMarks, studentName);
                case 4 -> updateStudentDetails(studentId, studentName);
                case 5 -> updateMarks(studentId, programmingMarks, dbmsMarks, studentName);
                case 6 -> deleteStudent(studentId, programmingMarks, dbmsMarks, studentName);
                case 7 -> printStudentDetails(studentId, programmingMarks, dbmsMarks,
                        studentName);
                case 8 -> printStudentRanks(studentId, programmingMarks, dbmsMarks,
                        studentName);
                case 9 -> BestInProgrammingFundamentals(studentId, programmingMarks,
                        studentName);
                case 10 ->BestInDBMS(studentId, dbmsMarks, studentName);
                case 11 -> {
                    System.out.println("Exited the program. Thank you for using GDSE Marks Management System. Goodbye!");


                    return;
                }
                default -> System.out.println("Invalid choice, Please try again.");
            }
        }
    }
    public static void addNewStudent(String[] studentId, String[] studentName) {
        Scanner add = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("| Add new student |");
        System.out.println("-------------------");
// Declare a boolean variable 'isExistingId' to track whether the entered student ID already exists.
        boolean isExistingId;
        do {
            System.out.println("Enter Student ID: ");
            // Read the input provided by the user and store it in the 'newStudentId' variable.
            String newStudentId = add.nextLine();
            // Initialize 'isExistingId' to false before checking for existing IDs.
            isExistingId = false;
// Iterate through the 'studentId' array to check if 'newStudentId' already exists.
            for (int i = 0; i < studentId.length; i++) {
                // Check if the current array element is not null and equals the 'newStudentId'.
                if (studentId[i] != null && studentId[i].equals(newStudentId)) {
                    // Set 'isExistingId' to true to indicate that the student ID already exists.
                    isExistingId = true;
                    System.out.println("Student ID already exists. Please enter a different Student  ID.");


                    break;
                }
            }
            // Check if 'isExistingId' is false, indicating that the entered student ID is not already in use.
            if (!isExistingId) {
                System.out.println("Enter Student Name: ");
                String newStudentName = add.nextLine();
                System.out.println("Student " + newStudentName + " added successfully!");
                // Iterate through the 'studentId' array to find the first available slot.
                for (int i = 0; i < studentId.length; i++) {
                    // Check if the current slot is empty (null).
                    if (studentId[i] == null) {
                        // Store the new student's ID and name in the current slot.
                        studentId[i] = newStudentId;
                        studentName[i] = newStudentName;
                        // Exit the loop once the data has been added.
                        break;
                    }
                }
            }
            // Enter an infinite loop to repeatedly ask the user if they want to add another student.
            while (true) {
                System.out.println("Do you want to add another student? (Y/N)");
                String addNewStudentChoice = add.nextLine();
                // Check if the user's input, regardless of case, is 'N' (no).
                if (addNewStudentChoice.equalsIgnoreCase("N")) {
                    return; // Exit the function if 'N' is entered


                } else if (addNewStudentChoice.equalsIgnoreCase("Y")) {
                    break; // Continue to add another student if 'Y' is entered
                } else {
                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                }
            }
        } while (true);
    }
    public static void addNewStudentWithMarks(String[] studentId, int[] programmingMarks,
                                              int[] dbmsMarks,String[] studentName) {
        Scanner addMark = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("| Add new student with marks |");
        System.out.println("------------------------------");

        boolean isExistingId;
        do {
            System.out.println("Enter Student ID: ");
            String newStudentId = addMark.nextLine();
            isExistingId = false;

            for (int i = 0; i < studentId.length; i++) {
                if (studentId[i] != null && studentId[i].equals(newStudentId)) {
                    isExistingId = true;
                    System.out.println("Student ID already exists. Please enter a different Student  ID.");
                    break;
                }


            }
            if (!isExistingId) {
                System.out.println("Enter Student Name: ");
                String newStudentName = addMark.nextLine();
                System.out.println("Student " + newStudentName + " added successfully!");

                // Initialize variables for storing marks
                int programmingMarksInput;
                int dbmsMarksInput;
                // Enter a do-while loop that will continue until valid programming marks are entered.
                do {
                    System.out.println("Enter Student Programming Marks: ");
                    try {
                        // Attempt to parse the user's input as an integer and store it in 'programmingMarksInput'.
                                programmingMarksInput = Integer.parseInt(addMark.nextLine());
                        // Check if the entered marks are within the valid range (0 to 100).
                        if (programmingMarksInput < 0 || programmingMarksInput > 100) {
                            // Display an error message for marks outside the valid range.
                            System.out.println("Invalid input. Marks should be between 0 and 100.");
                        } else {
                            // Exit the loop if valid marks are entered.
                            break;
                        }
                    } catch (NumberFormatException e) {
                        // Handle the case where the input cannot be parsed as an integer.
                        System.out.println("Invalid input. Please enter a valid integer.");

                    }
                } while (true);


                do {
                    System.out.println("Enter Student Database Management System Marks: ");
                    try {
                        dbmsMarksInput = Integer.parseInt(addMark.nextLine());
                        if (dbmsMarksInput < 0 || dbmsMarksInput > 100) {
                            System.out.println("Invalid input. Marks should be between 0 and 100.");
                        } else {
                            break; // Valid input, break the loop
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }
                } while (true);
                // Store the entered student information and marks in their respective arrays.

// Iterate through the arrays to find the first available slot.
                for (int i = 0; i < studentId.length; i++) {
                    // Check if the current slot is empty (null).
                    if (studentId[i] == null) {
                        // Store the new student's ID, name, programming marks, and DBMS marks in the current slot.
                                studentId[i] = newStudentId;
                        studentName[i] = newStudentName;
                        programmingMarks[i] = programmingMarksInput;


                        dbmsMarks[i] = dbmsMarksInput;
                        // Exit the loop once the data has been added.
                        break;
                    }
                }

            }
            while (true) {
                System.out.println("Do you want to add another student with marks? (Y/N)");
                String addNewStudentChoice = addMark.nextLine();
                if (addNewStudentChoice.equalsIgnoreCase("N")) {
                    return; // Exit the function if 'N' is entered
                } else if (addNewStudentChoice.equalsIgnoreCase("Y")) {
                    break; // Continue to add another student if 'Y' is entered
                } else {
                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                }
            }
        } while (true);
    }
    public static void addMarks(String[] studentId, int[] programmingMarks, int[] dbmsMarks,
                                String[] studentName) {
        Scanner mark= new Scanner(System.in);
        System.out.println("-------------");
        System.out.println("| Add marks |");
        System.out.println("-------------");
        // Declare a boolean variable 'isExistingId' to track whether the entered student ID exists.
        boolean isExistingId;


        do {
            System.out.println("Enter Student ID to add marks: ");
            String existingStudentId = mark.nextLine();
            // Initialize 'isExistingId' to false before checking for an existing ID.
            isExistingId = false;
            // Initialize 'studentIndex' to -1 to indicate that the student ID hasn't been found yet.
            int studentIndex = -1;

            // Iterate through the 'studentId' array to check if 'existingStudentId' exists.
            for (int i = 0; i < studentId.length; i++) {
                // Check if the current array element is not null and equals 'existingStudentId'.
                if (studentId[i] != null && studentId[i].equals(existingStudentId)) {
                    // Set 'isExistingId' to true to indicate that the student ID exists.
                    isExistingId = true;
                    // Store the index of the found student ID in 'studentIndex'.
                    studentIndex = i;
                    // Exit the loop since the existing ID was found.
                    break;
                }
            }
// Check if the entered student ID exists.
            if (isExistingId) {
                // Check if marks have already been assigned to the student
                if (programmingMarks[studentIndex] != 0 || dbmsMarks[studentIndex] != 0) {
                    System.out.println("Marks have already been assigned to this student.");
                } else {
                    // Retrieve the existing student's name associated with the entered student ID.


                    String existingStudentName = studentName[studentIndex];
                    System.out.println("Student Name: " + existingStudentName + " and ID: " +
                            existingStudentId);

                    int programmingMarksInput;
                    int dbmsMarksInput;

                    // Prompt for programming marks and validate
                    do {
                        System.out.println("Enter Student Programming Marks: ");
                        try {
                            // Read the programming marks input from the user and parse it as an integer.
                                    programmingMarksInput = Integer.parseInt(mark.nextLine());
// Check if the entered programming marks are within the valid range (0 to 100).
                            if (programmingMarksInput < 0 || programmingMarksInput > 100) {
                                // Display an error message for marks outside the valid range.
                                System.out.println("Invalid input. Marks should be between 0 and 100.");
                            } else {
                                // Assign the valid programming marks to the student at 'studentIndex'.
                                programmingMarks[studentIndex] = programmingMarksInput;
                                // Exit the loop since valid marks have been assigned.
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    } while (true);



                    // Prompt for DBMS marks and validate
                    do {
                        System.out.println("Enter Student Database Management System Marks: ");
                        try {
                            dbmsMarksInput = Integer.parseInt(mark.nextLine());
                            if (dbmsMarksInput < 0 || dbmsMarksInput > 100) {
                                System.out.println("Invalid input. Marks should be between 0 and 100.");
                            } else {
                                dbmsMarks[studentIndex] = dbmsMarksInput;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    } while (true);
                }

                while (true) {
                    System.out.println("Do you want to add marks for another student? (Y/N)");
                    String addMarksChoice = mark.nextLine();
                    if (addMarksChoice.equalsIgnoreCase("N")) {
                        return; // Exit the function if 'N' is entered
                    } else if (addMarksChoice.equalsIgnoreCase("Y")) {
                        break; // Continue to add marks for another student if 'Y' is entered
                    } else {
                        System.out.println("Invalid input. Please enter 'Y' or 'N'.");


                    }
                }
            } else {
                System.out.println("Student ID not found. Do you want to continue searching? (Y/N)");
                String continueSearchChoice = mark.nextLine();
                if (continueSearchChoice.equalsIgnoreCase("N")) {
                    return; // Exit the function if 'N' is entered

                }
            }
        } while (true);
    }
    public static void updateStudentDetails(String[] studentId, String[] studentName) {
        Scanner details = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("| Update Student Details |");
        System.out.println("-------------------------");

        boolean isExistingId;
        do {
            System.out.println("Enter Student ID to update details: ");
            String existingStudentId = details.nextLine();
            isExistingId = false;
            int studentIndex = -1; // Initialize with an invalid index

            // Search for the existing student by ID
            for (int i = 0; i < studentId.length; i++) {


                // Check if the current array element is not null and equals 'existingStudentId'.
                if (studentId[i] != null && studentId[i].equals(existingStudentId)) {
                    // Set 'isExistingId' to true to indicate that the student ID exists.
                    isExistingId = true;
                    // Store the index of the found student ID in 'studentIndex'.
                    studentIndex = i;
                    // Exit the loop since the existing ID was found.
                    break;
                }
            }
            if (isExistingId) {
                // Display the current Student Name
                String existingStudentName = studentName[studentIndex];
                System.out.println("Student Name: " + existingStudentName + " and ID: " +
                        existingStudentId);

                // Prompt the user for the new Student Name
                System.out.println("Enter New Student Name: ");
                String newName = details.nextLine();
                //Update the student's name in the 'studentId' array at 'studentIndex'.
                studentName[studentIndex] = newName;
                System.out.println("Student New Name: " + newName + " and ID: " +
                        existingStudentId);
                System.out.println("Student Name updated successfully!");

                while (true) {
                    System.out.println("Do you want to update details for another student? (Y/N)");
                    String updateDetailsChoice = details.nextLine();


                    if (updateDetailsChoice.equalsIgnoreCase("N")) {
                        return; // Exit the function if 'N' is entered
                    } else if (updateDetailsChoice.equalsIgnoreCase("Y")) {
                        break; // Continue to update details for another student if 'Y' is entered
                    } else {
                        System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                    }
                }
            } else {
                System.out.println("Student ID not found. Do you want to continue searching? (Y/N)");
                String continueSearchChoice = details.nextLine();
                if (continueSearchChoice.equalsIgnoreCase("N")) {
                    return; // Exit the function if 'N' is entered
                }
            }
        } while (true);
    }
    public static void updateMarks(String[] studentId, int[] programmingMarks, int[]
            dbmsMarks, String[] studentName) {
        Scanner updateMark = new Scanner(System.in);
        System.out.println("----------------------");
        System.out.println("|    Update Marks    |");
        System.out.println("----------------------");

        boolean isExistingId;
        do {
            System.out.println("Enter Student ID to update marks: ");


            String existingStudentId = updateMark.nextLine();
            isExistingId = false;
            int studentIndex = -1; // Initialize with an invalid index

            // Search for the existing student by ID
            for (int i = 0; i < studentId.length; i++) {
                if (studentId[i] != null && studentId[i].equals(existingStudentId)) {
                    isExistingId = true;
                    studentIndex = i;
                    break;
                }
            }
            // Check if the entered student ID exists.
            if (isExistingId) {
                // Retrieve the existing student's name associated with the entered student ID.
                String existingStudentName = studentName[studentIndex];
                // Check if programming marks and DBMS marks have not been assigned to this student yet.
                if (programmingMarks[studentIndex] == 0 || dbmsMarks[studentIndex] == 0) {
                    System.out.println("Marks have not been assigned to this student yet.");
                } else {
                    // Retrieve the current programming marks and DBMS marks for the student.
                    int currentProgrammingMarks = programmingMarks[studentIndex];
                    int currentDbmsMarks = dbmsMarks[studentIndex];

                    System.out.println("Student " + existingStudentName + " and"+" ID "+existingStudentId);
                            System.out.println("Current Programming Marks: " + currentProgrammingMarks);

                    System.out.println("Current DBMS Marks: " + currentDbmsMarks);

                    int newProgrammingMarks;
                    do {
                        System.out.println("Enter New Programming Marks: ");
                        try {
                            newProgrammingMarks = Integer.parseInt(updateMark.nextLine());
                            if (newProgrammingMarks < 0 || newProgrammingMarks > 100) {
                                System.out.println("Invalid input. Marks should be between 0 and 100.");
                            } else {
                                programmingMarks[studentIndex] = newProgrammingMarks;
                                break; // Valid input, break the loop
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    } while (true);

                    // Prompt for new DBMS marks and validate
                    int newDbmsMarks;
                    do {
                        System.out.println("Enter New DBMS Marks: ");
                        try {
                            newDbmsMarks = Integer.parseInt(updateMark.nextLine());
                            if (newDbmsMarks < 0 || newDbmsMarks > 100) {
                                System.out.println("Invalid input. Marks should be between 0 and 100.");
                            } else {


                                dbmsMarks[studentIndex] = newDbmsMarks;
                                break; // Valid input, break the loop
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    } while (true);
                    System.out.println("Marks updated successfully!");
                }
                while (true) {
                    System.out.println("Do you want to update marks for another student? (Y/N)");
                    String updateMarksChoice = updateMark.nextLine();
                    if (updateMarksChoice.equalsIgnoreCase("N")) {
                        return; // Exit the function if 'N' is entered
                    } else if (updateMarksChoice.equalsIgnoreCase("Y")) {
                        break; // Continue to update marks for another student if 'Y' is entered
                    } else {
                        System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                    }
                }
            } else {
                System.out.println("Student ID not found. Do you want to continue searching? (Y/N)");
                String continueSearchChoice = updateMark.nextLine();
                if (continueSearchChoice.equalsIgnoreCase("N")) {
                    return; // Exit the function if 'N' is entered
                }
            }


        } while (true);
    }
    public static void deleteStudent(String[] studentId, int[] programmingMarks, int[]
            dbmsMarks, String[] studentName) {
        Scanner delete = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("| Delete a Student |");
        System.out.println("--------------------");

        boolean isExistingId;
        do {
            System.out.println("Enter Student ID to delete: ");
            String existingStudentId = delete.nextLine();
            isExistingId = false;
            int studentIndex = -1; // Initialize with an invalid index

            // Search for the existing student by ID
            for (int i = 0; i < studentId.length; i++) {
                if (studentId[i] != null && studentId[i].equals(existingStudentId)) {
                    isExistingId = true;
                    studentIndex = i;
                    break;
                }
            }
            if (isExistingId) {
                System.out.println("Enter Student Name: ");
                // Retrieve the existing student's name associated with the entered student ID.
                String existingStudentName = studentName[studentIndex];


                System.out.println("Student found:");
                System.out.println("Student ID: " + existingStudentId);
                System.out.println("Student Name: " + existingStudentName);
                System.out.println("Programming Marks: " + programmingMarks[studentIndex]);
                System.out.println("DBMS Marks: " + dbmsMarks[studentIndex]);

                // Confirm deletion with the user
                System.out.println("Do you want to delete this student? (Y/N)");
                String deleteConfirmation = delete.nextLine();

                // Check if the user's input, regardless of case, is 'Y' (yes).
                if (deleteConfirmation.equalsIgnoreCase("Y")) {
                    // Delete the student by setting their ID to null and marks to 0.
                    studentId[studentIndex] = null;
                    programmingMarks[studentIndex] = 0;
                    dbmsMarks[studentIndex] = 0;
                    System.out.println("Student deleted successfully!");
                }
            } else {
                System.out.println("Student ID not found. Do you want to continue searching? (Y/N)");
                String continueSearchChoice = delete.nextLine();
                if (continueSearchChoice.equalsIgnoreCase("N")) {
                    return; // Exit the function if 'N' is entered
                }
            }
            while (true) {
                System.out.println("Do you want to delete another student? (Y/N)");


                String deleteAnotherStudentChoice = delete.nextLine();
                if (deleteAnotherStudentChoice.equalsIgnoreCase("N")) {
                    return; // Exit the function if 'N' is entered
                } else if (deleteAnotherStudentChoice.equalsIgnoreCase("Y")) {
                    break; // Continue to delete another student if 'Y' is entered
                } else {
                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                }
            }
        } while (true);
    }
    public static void printStudentDetails(String[] studentId, int[] programmingMarks, int[]
            dbmsMarks, String[] studentName) {
        Scanner print = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("| Print Student Details |");
        System.out.println("-------------------------");
// A boolean variable to track whether an existing student ID has been found.
        boolean isExistingId;
        do {
            System.out.println("Enter Student ID: ");
            // Read the entered student ID as a string.
            String existingStudentId = print.nextLine();
            isExistingId = false;
            int studentIndex = -1; // Initialize with an invalid index

            // Search for the existing student by ID
            for (int i = 0; i < studentId.length; i++) {


                if (studentId[i] != null && studentId[i].equals(existingStudentId)) {
                    // If a matching ID is found:
                    isExistingId = true;
                    studentIndex = i;// Store the index of the existing student ID
                    break;
                }
            }
            if (isExistingId) {
                // If an existing student ID has been found:
                String existingStudentName = studentName[studentIndex];
                System.out.println("Student Details:");
                System.out.println("Student ID: " + existingStudentId);
                System.out.println("Student Name: " +existingStudentName);

                if (programmingMarks[studentIndex] == 0 && dbmsMarks[studentIndex] == 0) {
                    // If both marks are zero, indicate that marks haven't been added yet.
                    System.out.println("Student Marks haven't been added yet.");
                } else {
                    int totalMarks = programmingMarks[studentIndex] + dbmsMarks[studentIndex];
                    double averageMarks = totalMarks / 2.0;
                    int rank = calculateRank(studentIndex, programmingMarks, dbmsMarks);
                    // Calculate the student's rank using a custom function "calculateRank" that takes the student's index,

                    System.out.println("-----------Student Marks-------------");
                    System.out.println("|Programming Marks: |" +
                            programmingMarks[studentIndex]+ "|");
                    System.out.println("|DBMS Marks:        |" + dbmsMarks[studentIndex]+        "|");


                    System.out.println("|Total Marks:       |" + totalMarks+                   "|");
                    System.out.println("|Average Marks:     |" + averageMarks+                 "|");
                    System.out.println("-------------------------------------");

                    String rankText;
                    if (rank == 1) {
                        rankText = "First (1st)";
                    } else if (rank == 2) {
                        rankText = "Second (2nd)";
                    } else if (rank == 3) {
                        rankText = "Third (3rd)";
                    } else {
                        rankText = "Last (" + rank + "th)";
                    }

                    System.out.println("Rank: " + rankText);
                }
            } else {
                System.out.println("Student ID not found. Do you want to continue seeking student details? (Y/N)");
                        String continueChoice = print.nextLine();// Exit the function if 'N' is entered
                if (continueChoice.equalsIgnoreCase("N")) {
                    return;
                }
            }
            while (true) {
                System.out.println("Do you want to print another student? (Y/N)");
                String deleteAnotherStudentChoice = print.nextLine();


                if (deleteAnotherStudentChoice.equalsIgnoreCase("N")) {
                    return; // Exit the function if 'N' is entered
                } else if (deleteAnotherStudentChoice.equalsIgnoreCase("Y")) {
                    break; // Continue to delete another student if 'Y' is entered
                } else {
                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                }
            }

        } while (true);
    }
    private static int calculateRank(int studentIndex, int[] programmingMarks, int[]
            dbmsMarks) {
        int totalMarks = programmingMarks[studentIndex] + dbmsMarks[studentIndex];
        int rank = 1;
        // Initialize the student's rank as 1, assuming they are initially ranked first.

        for (int i = 0; i < programmingMarks.length; i++) {
            // Iterate through all students (represented by array indices).

            if (i != studentIndex && (programmingMarks[i] + dbmsMarks[i]) > totalMarks) {
                // Check if the current student (i) is not the same as the target student (studentIndex),

                // and if their total marks (programming + DBMS) are higher than the target  student's total marks.

                rank++;
                // If the condition is met, increment the rank because the current student has a  higher total score.

            }


        }
        return rank;
    }
    public static void printStudentRanks(String[] studentId, int[] programmingMarks, int[]
            dbmsMarks, String[] studentName) {
        Scanner rank = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("| Print Student Ranks |");
        System.out.println("-----------------------");

        // Check if any students have marks added
        boolean anyStudentsWithMarks = false;
        for (int i = 0; i < studentId.length; i++) {
            if (programmingMarks[i] > 0 || dbmsMarks[i] > 0) {
                anyStudentsWithMarks = true;
                break;
            }
        }
        if (!anyStudentsWithMarks) {
            System.out.println("No students with marks found.");
        } else {
            // Code to print student ranks
            System.out.println("Student Ranks");
            System.out.println("------------------------------------------------------------------");
            System.out.println("| Rank | Student ID | Name         | Total Marks | Average Marks |");
                    System.out.println("------------------------------------------------------------------");



            // Calculate ranks based on total marks
            int[] ranks = calculateRanks(programmingMarks, dbmsMarks);

            // Print student details
            for (int i = 0; i < studentId.length; i++) {
                if (programmingMarks[i] > 0 || dbmsMarks[i] > 0) {
                    System.out.printf("| %-4d | %-11s | %-12s | %-11d | %-13.2f |\n",
                            ranks[i], studentId[i], studentName[i], programmingMarks[i] + dbmsMarks[i],
                            (programmingMarks[i] + dbmsMarks[i]) / 2.0);
                }
            }
            System.out.println("-----------------------------------------------------------------");
        }
        while (true) {
            System.out.println("Do you want to stay in this menu? (Y/N)");
            String continueChoice = rank.nextLine();
            if (!continueChoice.equalsIgnoreCase("Y")) {
                return; // Exit the function if 'N' is entered
            }
        }
    }
    public static int[] calculateRanks(int[] programmingMarks, int[] dbmsMarks) {
        // Create an array to store the total marks for each student.
        int[] totalMarks = new int[programmingMarks.length];
        // Calculate the total marks for each student and store them in the totalMarks array.
        for (int i = 0; i < programmingMarks.length; i++) {
            totalMarks[i] = programmingMarks[i] + dbmsMarks[i];


        }
        // Create an array to store the ranks for each student.
        int[] ranks = new int[programmingMarks.length];
        // Calculate the ranks for each student based on their total marks.
        for (int i = 0; i < totalMarks.length; i++) {
            int rank = 1; // Initialize the rank for the current student to 1.
            // Compare the total marks of the current student with other students.
            for (int j = 0; j < totalMarks.length; j++) {
                if (totalMarks[j] > totalMarks[i]) {
                    // If another student has a higher total mark, increment the rank.
                    rank++;
                }
            }
            // Store the calculated rank for the current student in the ranks array.
            ranks[i] = rank;
        }
        return ranks;
    }

    public static void BestInProgrammingFundamentals(String[] studentId, int[]
            programmingMarks, String[] studentName) {
        Scanner pro = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("| Programming Module Top Performers |");
        System.out.println("-------------------------------------");

        // Check if any students have marks added
        boolean anyStudentsWithMarks = false;


        for (int i = 0; i < studentId.length; i++) {
            if (programmingMarks[i] > 0) {
                anyStudentsWithMarks = true;
                break;
            }
        }
        if (!anyStudentsWithMarks) {
            System.out.println("No students with Programming marks found.");
        } else {
            // Code to print top performers in the Programming module
            System.out.println("Top Performers in Programming Module");
            System.out.println("-------------------------------------------------");
            System.out.println("| Student ID | Name         | Programming Marks |");
            System.out.println("-------------------------------------------------");

            // Sort students based on Programming module marks from high to low
            int[] sortedIndices = sortStudentsByProgrammingMarksDesc(programmingMarks);

            // Print student details
            for (int i = 0; i < studentId.length; i++) {
                int index = sortedIndices[i];
                if (programmingMarks[index] > 0) {
                    System.out.printf("| %-11s | %-12s | %-17d |\n",
                            studentId[index], studentName[index], programmingMarks[index]);
                }
            }
            System.out.println("------------------------------------------------");


        }
        while (true) {
            System.out.println("Do you want to stay in this menu? (Y/N)");
            String continueChoice = pro.nextLine();
            if (!continueChoice.equalsIgnoreCase("Y")) {
                return; // Exit the function if 'N' is entered
            }
        }
    }
    public static int[] sortStudentsByProgrammingMarksDesc(int[] programmingMarks) {
        // Create an array to store the sorted indices of students.
        int[] sortedIndices = new int[programmingMarks.length];
        // Initialize sortedIndices with values 0, 1, 2, ... (initially representing student indices).
        for (int i = 0; i < programmingMarks.length; i++) {
            sortedIndices[i] = i;
        }
        // Sort the indices based on Programming module marks in descending order.
        for (int i = 0; i < programmingMarks.length - 1; i++) {
            for (int j = i + 1; j < programmingMarks.length; j++) {
                // Compare the programming marks of students using their indices.
                if (programmingMarks[sortedIndices[i]] < programmingMarks[sortedIndices[j]]) {
                    // If the programming marks of the student at sortedIndices[i] are lower
                    // than the student at sortedIndices[j], swap their indices.
                    int temp = sortedIndices[i];
                    sortedIndices[i] = sortedIndices[j];
                    sortedIndices[j] = temp;
                }


            }
        }
        return sortedIndices;
    }

    public static void BestInDBMS(String[] studentId, int[] dbmsMarks, String[] studentName) {
        Scanner dbms = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("| Best in Database Management System |");
        System.out.println("--------------------------------------");

        // Check if any students have DBMS marks
        boolean anyStudentsWithMarks = false;
        for (int i = 0; i < studentId.length; i++) {
            if (dbmsMarks[i] > 0) {
                anyStudentsWithMarks = true;
                break;
            }
        }
        if (!anyStudentsWithMarks) {
            System.out.println("No students with DBMS marks found.");
        } else {
            // Code to find the best students in DBMS
            System.out.println("Top Performers in DBMS");
            System.out.println("------------------------------------------");
            System.out.println("| Student ID | Name         | DBMS Marks |");
            System.out.println("------------------------------------------");



            // Sort students based on DBMS marks from high to low
            int[] sortedIndices = sortStudentsByDBMSMarksDesc(dbmsMarks);

            // Print student details
            for (int i = 0; i < studentId.length; i++) {
                int index = sortedIndices[i];
                if (dbmsMarks[index] > 0) {
                    System.out.printf("| %-11s | %-12s | %-11d |\n",
                            studentId[index], studentName[index], dbmsMarks[index]);
                }
            }
            System.out.println("-----------------------------------------");
        }
        while (true) {
            System.out.println("Do you want to stay in this menu? (Y/N)");
            String continueChoice = dbms.nextLine();
            if (!continueChoice.equalsIgnoreCase("Y")) {
                return; // Exit the function if 'N' is entered
            }
        }
    }
    public static int[] sortStudentsByDBMSMarksDesc(int[] dbmsMarks) {
        // Create an array to store the sorted indices of students.
        int[] sortedIndices = new int[dbmsMarks.length];
        // Initialize sortedIndices with values 0, 1, 2, ... (initially representing student indices).
        for (int i = 0; i < dbmsMarks.length; i++) {


            sortedIndices[i] = i;
        }
        // Sort the indices based on DBMS marks in descending order.
        for (int i = 0; i < dbmsMarks.length - 1; i++) {
            for (int j = i + 1; j < dbmsMarks.length; j++) {
                // Compare the DBMS marks of students using their indices.
                if (dbmsMarks[sortedIndices[i]] < dbmsMarks[sortedIndices[j]]) {
                    // If the DBMS marks of the student at sortedIndices[i] are lower
                    // than the student at sortedIndices[j], swap their indices.
                    int temp = sortedIndices[i];
                    sortedIndices[i] = sortedIndices[j];
                    sortedIndices[j] = temp;
                }
            }
        }
        return sortedIndices;
    }

    public  static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }


        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
}