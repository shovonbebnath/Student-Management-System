
import java.util.ArrayList;
import java.util.Scanner;

public class FindTopper {
    ArrayList <Student> list = StudentDataEntry.getStudentsList();
    Scanner scanner = new Scanner(System.in);
    
    public void findTopperInSemester(){

        System.out.println("\n=========================================================");
        System.out.println("                   FIND TOPPER IN SEMESTER               ");
        System.out.println("=========================================================");
        
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
            System.out.print("Enter your choice (1-8): ");
            String semChoice = scanner.nextLine().trim();

            switch (semChoice) {
                case "1": semester = 1.1; break;
                case "2": semester = 1.2; break;
                case "3": semester = 2.1; break;
                case "4": semester = 2.2; break;
                case "5": semester = 3.1; break;
                case "6": semester = 3.2; break;
                case "7": semester = 4.1; break;
                case "8": semester = 4.2; break;
                default:
                    System.out.println("\nInvalid semester. Please try again.");
                    continue;
            }
            break;
        }

        int topperIndex = -1;
        double highestScore = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSemester() == semester) {
                double score = list.get(i).getOverallPerformance();
                if (score > highestScore) {
                    highestScore = score;
                    topperIndex = i;
                }
            }
        }

        if (topperIndex != -1) {
            System.out.println("\n================ TOPPER OF SEMESTER "+semester+" ================");
            list.get(topperIndex).displayIndividualInfo();
            System.out.println("=========================================================");
        }
        else {
            System.out.println("\nNo student found in semester " + semester + ".");
        }
    }

    public void findTopperInSection(){

        System.out.println("=========================================================");
        System.out.println("           FIND TOPPER IN SECTION OF A SEMESTER          ");
        System.out.println("=========================================================");

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
            System.out.print("Enter your choice (1-8): ");
            int semChoice = scanner.nextInt();
            scanner.nextLine();

            switch (semChoice) {
                case 1: semester = 1.1; break;
                case 2: semester = 1.2; break;
                case 3: semester = 2.1; break;
                case 4: semester = 2.2; break;
                case 5: semester = 3.1; break;
                case 6: semester = 3.2; break;
                case 7: semester = 4.1; break;
                case 8: semester = 4.2; break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }
            break;
        }

        String section;
        while (true) {
            System.out.println("\nSelect Section:");
            System.out.println("1. A");
            System.out.println("2. B");
            System.out.println("3. C");
            System.out.println("4. D");
            System.out.print("Enter your choice (1-4): ");
            int sectionChoice = scanner.nextInt();
            scanner.nextLine();

            switch (sectionChoice) {
                case 1: section = "A"; break;
                case 2: section = "B"; break;
                case 3: section = "C"; break;
                case 4: section = "D"; break;
                default:
                    System.out.println("\nInvalid section. Please try again.");
                    continue;
            }
            break;
        }

        int topperIndex = -1;
        double highestScore = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSemester() == semester && list.get(i).getSection().equals(section)) {
                double score = list.get(i).getOverallPerformance();
                if (score > highestScore) {
                    highestScore = score;
                    topperIndex = i;
                }
            }
        }

        if (topperIndex != -1) {
            System.out.println("\n========== TOPPER of SEMESTER "+semester+", SECTION "+section+" ==========");
            list.get(topperIndex).displayIndividualInfo();
            System.out.println("=========================================================");
        }
        else {
            System.out.println("\nNo student found in Semester "+semester+" Section "+section);
        }
    }
}
