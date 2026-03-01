
import java.util.Scanner;

public class StudentManagementMain {
    public static void main(String[] args) {

        StudentDataEntry studentDataEntry = new StudentDataEntry();
        StudentResultEntry studentResultEntry = new StudentResultEntry();
        RecordUpdate recordUpdate = new RecordUpdate();
        FindStudentByID findStudentByID = new FindStudentByID();
        SpecificStudentAverage specificStudentAverage = new SpecificStudentAverage();
        FindTopper findTopper = new FindTopper();
        ListSpecificSemesterOrSectionStudents listSpecificSemesterOrSectionStudents = new ListSpecificSemesterOrSectionStudents();
        FileWriting fileWriting = new FileWriting();
        SaveAndLoad saveAndLoad = new SaveAndLoad();

        saveAndLoad.loadFile();

        Scanner mainScanner = new Scanner(System.in);
        int option;

        System.out.println(" __        __   _                            _          ");
        System.out.println(" \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___    ");
        System.out.println("  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\   ");
        System.out.println("   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |  ");
        System.out.println("    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/   ");


        System.out.println("=========================================================");
        System.out.println("   S T U D E N T   M A N A G E M E N T   S Y S T E M");
        System.out.println("=========================================================\n");


        do {
            System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                  M E N U                                       ║");
            System.out.println("╠═════════════════════════════════════════════╦══════════════════════════════════╣");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "--- Student Management ---", "--- Performance Analysis ---");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "1. Enroll Student", "9.  Find Topper in Semester");
            System.out.printf("║ %-43s ║ %-30s║%n", "2. Update Existing Information", "10. Topper in Section of Semester");
            System.out.printf("║ %-43s ║ %-30s  ║%n", "3. De-enroll Student", "11. List Students Semester-wise");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "", "12. List Students Section-wise");

            System.out.println("╠═════════════════════════════════════════════╬══════════════════════════════════╣");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "--- Marks Management ---", "--- File Operations ---");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "4. Enter Marks for All Students", "13. Write Records to File");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "5. Enter Marks by Student ID", "14. Write Grades to File");

            System.out.println("╠═════════════════════════════════════════════╬══════════════════════════════════╣");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "--- View & Search ---", "--- Maintenance ---");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "6. Display All Student Info", "15. Clear Entire Records");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "7. View Student by ID", "");
            System.out.printf("║ %-43s ║ %-30s   ║%n", "8. Calculate Student Average", "0. Exit");
            System.out.println("╚═════════════════════════════════════════════╩══════════════════════════════════╝");




            System.out.print("Enter option: ");

            try {
                option = mainScanner.nextInt();
                mainScanner.nextLine();

                System.out.println("------------------------------------------------------------------------------");

                switch (option) {
                    case 1:
                        studentDataEntry.enrollStudent();
                        break;
                    case 2:
                        recordUpdate.updateStudentRecord();
                        break;
                    case 3:
                        studentDataEntry.deEnrollStudent();
                        break;
                    case 4:
                        studentResultEntry.enterMarks();
                        break;
                    case 5:
                        studentResultEntry.enterSpecificIdMarks();
                        break;
                    case 6:
                        studentDataEntry.displayInfo();
                        break;
                    case 7:
                        findStudentByID.findSpecificStudentByID();
                        break;
                    case 8:
                        specificStudentAverage.calculateSpecificStudentAverage();
                        break;
                    case 9:
                        findTopper.findTopperInSemester();
                        break;
                    case 10:
                        findTopper.findTopperInSection();
                        break;
                    case 11:
                        listSpecificSemesterOrSectionStudents.listSpecificSemesterStudents();
                        break;
                    case 12:
                        listSpecificSemesterOrSectionStudents.listSpecificSectionStudent();
                        break;
                    case 13:
                        fileWriting.writeAllStudentData();
                        break;
                    case 14:
                        fileWriting.convertToGrade();
                        break;
                    case 15:
                        studentDataEntry.allClear();
                        break;
                    case 0:
                        System.out.println("Exiting Program...");
                        return;
                    default:
                        System.out.println("No such option found...TRY AGAIN.");
                }
            }
            catch (Exception e) {
                System.err.println("Invalid input. Please enter a number.");
                mainScanner.nextLine();
            }

        } while (true);
    }
}
