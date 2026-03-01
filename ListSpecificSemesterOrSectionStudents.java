import java.util.ArrayList;
import java.util.Scanner;

public class ListSpecificSemesterOrSectionStudents {
    ArrayList<Student> list = StudentDataEntry.getStudentsList();
    Scanner scanner = new Scanner(System.in);

    public void listSpecificSemesterStudents(){

        System.out.println("\n=========================================================");
        System.out.println("                LIST STUDENTS SEMESTER-WISE              ");
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

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(semester == list.get(i).getSemester()){
                count++;
                list.get(i).displaySpecificList();
                System.out.println(line);
            }
        }
        if(count == 0){
            System.out.println("\nNO SUCH RECORD FOUND!");
        }
        else{
            System.out.println("Total Students in Semester "+semester+": "+count);
        }
    }

    public void listSpecificSectionStudent(){

        System.out.println("\n=========================================================");
        System.out.println("                LIST STUDENTS SECTION-WISE               ");
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
        String section;
        while (true) {
            System.out.println("\nSelect Section:");
            System.out.println("1. A");
            System.out.println("2. B");
            System.out.println("3. C");
            System.out.println("4. D");
            System.out.print("Enter your choice (1-4): ");
            String sectionChoice = scanner.nextLine().trim();

            switch (sectionChoice) {
                case "1": section = "A"; break;
                case "2": section = "B"; break;
                case "3": section = "C"; break;
                case "4": section = "D"; break;
                default:
                    System.out.println("\nInvalid section. Please try again.");
                    continue;
            }
            break;
        }

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

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getSemester() == semester && list.get(i).getSection().equals(section)){
                count++;
                list.get(i).displaySpecificList();
                System.out.println(line);
            }
        }
        if(count == 0){
            System.out.println("\nNO SUCH RECORD FOUND!");
        }
        else {
            System.out.println("Total Students in Semester "+semester+", Section "+section+": "+count);
        }
    }
}
