import java.util.ArrayList;
import java.util.Scanner;

public class FindStudentByID {
    ArrayList<Student> list = StudentDataEntry.getStudentsList();
    Scanner scanner = new Scanner(System.in);
    InputValidation validation = new InputValidation();

    public void findSpecificStudentByID() {
        //while (true) {
            try {

                System.out.println("\n=========================================================");
                System.out.println("                   VIEW STUDENT BY ID                    ");
                System.out.println("=========================================================");

                System.out.println("\nEnrolled Students...");
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).studentPreview();
                }

                System.out.print("\nEnter Student ID to View Details: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                validation.validateId(id);

                boolean found = false;

                for (int i = 0; i < list.size(); i++) {
                    if (id == list.get(i).getId()) {
                        found = true;
                        list.get(i).displayIndividualInfo();
                        return;
                    }
                }

                if (!found) {
                    System.out.println("\nStudent with ID: "+id+" NOT FOUND...Try again!");
                }

            } catch (InvalidIdException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("\nError: Invalid input. Please enter a valid integer ID.");
                scanner.nextLine();
            }
        //}
    }
}