
import java.util.ArrayList;
import java.util.Scanner;

public class SpecificStudentAverage {
    ArrayList<Student> list = StudentDataEntry.getStudentsList();
    Scanner scanner = new Scanner(System.in);
    InputValidation validation = new InputValidation();

    public void calculateSpecificStudentAverage() {
        //while (true) {
            try {

                System.out.println("\n=========================================================");
                System.out.println("              CALCULATE SPECIFIC STUDENT AVERAGE         ");
                System.out.println("=========================================================");

                System.out.println("\nEnrolled Students...");
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).studentPreview();
                }

                System.out.print("\nEnter Student ID to Get Average: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                validation.validateId(id);

                boolean found = false;

                for (int i = 0; i < list.size(); i++) {
                    if (id == list.get(i).getId()) {
                        found = true;
                        list.get(i).displayIndividualInfo();

                        double weightedAverage = list.get(i).getOverallPerformance();
                        double simpleAverage =
                                (list.get(i).getContinuousAssessment() +
                                        list.get(i).getProjectScore() +
                                        list.get(i).getMidtermAssessment() +
                                        list.get(i).getFinalAssessment()) / 4;

                        System.out.println("\n[Performance of Student ID " + id + " - " + list.get(i).getName() + "]");
                        System.out.println("-> Weighted Average (%): " + weightedAverage + "%");
                        System.out.println("-> Simple Average per Assessment: " + simpleAverage);
                        return;
                    }
                }

                if (!found) {
                    System.out.println("\nStudent with ID " + id + " NOT FOUND...Try Again!");
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
