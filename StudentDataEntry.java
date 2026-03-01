
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDataEntry extends SaveAndLoad{
    private static ArrayList<Student> studentsList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    InputValidation validation = new InputValidation();

    public static ArrayList<Student> getStudentsList(){
        return studentsList;
    }


    public void enrollStudent() {

        System.out.println("\n=========================================================");
        System.out.println("                       ENROLL STUDENT                    ");
        System.out.println("=========================================================");

        while (true) {
            String name;
            while (true) {
                try {
                    System.out.print("\nEnter Student Name: ");
                    name = scanner.nextLine();
                    validation.nameValidate(name);
                    break;
                } catch (InvalidNameException e) {
                    System.err.println(e.getMessage());
                }
            }

            int id;
            while (true) {
                try {
                    System.out.print("Enter Registration Number: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    validation.validateId(id);
                    break;
                } catch (InvalidIdException e) {
                    System.err.println(e.getMessage());
                    scanner.nextLine();
                }
            }

            // ======Gender Menu======
            String gender;
            while (true) {
                System.out.println("\nSelect Gender:");
                System.out.println("1. Male");
                System.out.println("2. Female");
                System.out.println("0. Return to Main Menu");
                System.out.print("Enter your choice (0-2): ");
                int genderChoice = scanner.nextInt();
                scanner.nextLine();

                switch (genderChoice) {
                    case 1: gender = "MALE"; System.out.println("\nYou have chosen: "+gender); break;
                    case 2: gender = "FEMALE"; System.out.println("\nYou have chosen: "+gender); break;
                    case 0: System.out.println("\nReturning to main menu"); return;
                    default:
                        System.out.println("Invalid gender choice. Please try again.");
                        continue;
                }
                break;
            }

            // ===== Department Menu =====
            String department;
            while (true) {
                System.out.println("\nSelect Department:");
                System.out.println("1. CSE");
                System.out.println("2. EEE");
                System.out.println("3. L&HR");
                System.out.println("4. ENG");
                System.out.println("0. Return to Main Menu");
                System.out.print("Enter your choice (0-4): ");
                int deptChoice = scanner.nextInt();
                scanner.nextLine();

                switch (deptChoice) {
                    case 1: department = "CSE"; System.out.println("\nYou have chosen: '"+department+"' department"); break;
                    case 2: department = "EEE"; System.out.println("\nYou have chosen: '"+department+"' department"); break;
                    case 3: department = "L&HR"; System.out.println("\nYou have chosen: '"+department+"' department"); break;
                    case 4: department = "ENG"; System.out.println("\nYou have chosen: '"+department+"' department"); break;
                    case 0: System.out.println("\nReturning to main menu"); return;
                    default:
                        System.out.println("Invalid department choice. Please try again.");
                        continue;
                }
                break;
            }


            // ====== Semester Menu =======
            double semester;
            while (true) {
                System.out.println("\nSelect Semester:");
                System.out.println("1. 1.1");
                System.out.println("2. 1.2");
                System.out.println("3. 2.1");
                System.out.println("4. 2.2");
                System.out.println("5. 3.1");
                System.out.println("6. 3.2");
                System.out.println("7. 4.1");
                System.out.println("8. 4.2");
                System.out.println("0. Return to Main Menu");
                System.out.print("Enter your choice (0-8): ");
                int semChoice = scanner.nextInt();
                scanner.nextLine();

                switch (semChoice) {
                    case 1: semester = 1.1; System.out.println("\nYou have chosen semester: "+semester); break;
                    case 2: semester = 1.2; System.out.println("\nYou have chosen semester: "+semester); break;
                    case 3: semester = 2.1; System.out.println("\nYou have chosen semester: "+semester); break;
                    case 4: semester = 2.2; System.out.println("\nYou have chosen semester: "+semester); break;
                    case 5: semester = 3.1; System.out.println("\nYou have chosen semester: "+semester); break;
                    case 6: semester = 3.2; System.out.println("\nYou have chosen semester: "+semester); break;
                    case 7: semester = 4.1; System.out.println("\nYou have chosen semester: "+semester); break;
                    case 8: semester = 4.2; System.out.println("\nYou have chosen semester: "+semester); break;
                    case 0: System.out.println("\nReturning to main menu"); return;
                    default:
                        System.out.println("\nInvalid semester. Please try again.");
                        continue;
                }
                break;
            }

            // ===== Section Menu =====
            String section;
            while (true) {
                System.out.println("\nSelect Section:");
                System.out.println("1. A");
                System.out.println("2. B");
                System.out.println("3. C");
                System.out.println("4. D");
                System.out.println("0. Return to Main Menu");
                System.out.print("Enter your choice (0-4): ");
                int sectionChoice = scanner.nextInt();
                scanner.nextLine();

                switch (sectionChoice) {
                    case 1: section = "A"; System.out.println("\nYou have chosen section: "+section); break;
                    case 2: section = "B"; System.out.println("\nYou have chosen section: "+section); break;
                    case 3: section = "C"; System.out.println("\nYou have chosen section: "+section); break;
                    case 4: section = "D"; System.out.println("\nYou have chosen section: "+section); break;
                    case 0: System.out.println("\nReturning to main menu"); return;
                    default:
                        System.out.println("\nInvalid section. Please try again.");
                        continue;
                }
                break;
            }

            String status = "NULL";
            double continuousAssessment = 0.0;
            double projectScore = 0.0;
            double midtermAssessment = 0.0;
            double finalAssessment = 0.0;
            double overallPerformance= 0.0;

            Student student = new Student(name, id, section, semester, gender, department,
                    continuousAssessment, projectScore, midtermAssessment, finalAssessment, overallPerformance, status);

            studentsList.add(student);
            saveToFile();

            System.out.println("Student enrolled successfully in " + department + " department.\n");

            System.out.print("Do you want to add another student in " + department + "? (Y/N): ");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (!choice.equals("Y")) {
                System.out.println("Returning to main menu...\n");
                break;
            }
        }
    }


    public void deEnrollStudent() {
        //while (true) {
            try {

                System.out.println("\n=========================================================");
                System.out.println("                     DE-ENROLL STUDENT                   ");
                System.out.println("=========================================================");

                if (studentsList.isEmpty()) {
                    System.out.println("\nNo students enrolled yet.");
                    return;
                }

                System.out.println("\nEnrolled Students...");
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).studentPreview();
                }

                System.out.print("\nEnter the Registration Number of the student to de-enroll: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                validation.validateId(id);

                boolean found = false;
                for (int i = 0; i < studentsList.size(); i++) {
                    if (studentsList.get(i).getId() == id) {
                        String studentName = studentsList.get(i).getName();
                        studentsList.remove(i);
                        saveToFile();
                        System.out.println("\n" + studentName + " with Reg. Number " + id + " has been de-enrolled successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("\nStudent with Reg. Number " + id + " not found.");
                }
                //break;

            } catch (InvalidIdException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("\nError: Something Went Wrong...Please try again.");
                scanner.nextLine();
            }
        //}
    }


    public void allClear() {

        System.out.println("\n=========================================================");
        System.out.println("                    CLEAR ENTIRE RECORD                  ");
        System.out.println("=========================================================");

        System.out.println("\n\nAre you sure you want to clear the entire record? (1 - 2)");
        System.out.println("1. Proceed");
        System.out.println("2. Return to Main Menu...");
        System.out.print("Enter choice (1-2): ");
        int response = scanner.nextInt();
        scanner.nextLine();

        switch (response) {
            case 1:
                System.out.println("\n\nTHIS ACTION IS IRREVERSIBLE!");
                System.out.println("\nAre you absolutely sure? (1-2)");
                System.out.println("1. YES! YES!! YES!!!");
                System.out.println("2. NO!!! Take Me Back!");
                System.out.print("Enter choice: ");
                int doubleSure = scanner.nextInt();
                scanner.nextLine();

                switch (doubleSure) {
                    case 1:
                        studentsList.clear();
                        saveToFile();
                        System.out.println("\nAll record has been CLEARED!");
                        break;
                    case 2:
                        System.out.println("\nReturning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid input. Returning to Main Menu...");
                }
                break;

            case 2:
                System.out.println("Returning to Main Menu...");
                break;

            default:
                System.out.println("Invalid input. Returning to Main Menu...");
        }
    }

    public void displayInfo() {

        System.out.println("\n=========================================================");
        System.out.println("              DISPLAY ALL STUDENT INFORMATION            ");
        System.out.println("=========================================================");

        System.out.println("\n+-----------------------------+");
        System.out.println("| Continuous Assessment -> 20 |");
        System.out.println("| Project Score ->         10 |");
        System.out.println("| Midterm Assessment ->    20 |");
        System.out.println("| Final Assessment ->      50 |");
        System.out.println("| --------------------------- |");
        System.out.println("| Overall Performance ->  100 |");
        System.out.println("+-----------------------------+\n");

        String line = "+----------------------+------------+----------+----------+--------+------------+-------------+-------------+-------------+-------------+-------------+----------+";
        System.out.println(line);

        System.out.printf("| %-20s | %-10s | %-8s | %-8s | %-6s | %-10s | %-11s | %-11s | %-11s | %-11s | %-11s | %-8s |\n",
                "Name", "Reg.No", "Section", "Semester", "Gender", "Department",
                "Continuous", "Project", "Midterm", "Final", "Overall", "Remark");

        System.out.printf("| %-20s | %-10s | %-8s | %-8s | %-6s | %-10s | %-11s | %-11s | %-11s | %-11s | %-11s | %-8s |\n",
                "", "", "", "", "", "", "Assessment", "Score", "Assessment", "Assessment", "Performance", "");

        System.out.println(line);

        for (int i = 0; i < studentsList.size(); i++) {
            studentsList.get(i).displayInfo();

            System.out.println(line);
        }
        System.out.println("Total Students: " + studentsList.size());
    }
}
