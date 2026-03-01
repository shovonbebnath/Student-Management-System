
import java.util.ArrayList;
import java.util.Scanner;

public class RecordUpdate extends SaveAndLoad{
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> list = StudentDataEntry.getStudentsList();
    InputValidation validation = new InputValidation();

    public void updateStudentRecord() {
        while (true) {
            try {

                System.out.println("\n=========================================================");
                System.out.println("                UPDATE EXISTING INFORMATION              ");
                System.out.println("=========================================================");

                System.out.println("\nEnrolled Students...");
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).studentPreview();
                }

                System.out.print("\nEnter student ID to Update Information: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                validation.validateId(id);

                boolean found = false;
                for (int i = 0; i < list.size(); i++) {
                    if (id == list.get(i).getId()) {
                        found = true;

                        System.out.println("\n======================================");
                        System.out.println("\t\t\tOLD RECORD");
                        System.out.println("======================================");
                        list.get(i).displayIndividualInfo();

                        System.out.println("\n======================================");
                        System.out.println("\t\t\tENTER NEW RECORD");
                        System.out.println("======================================");

                        System.out.print("\nEnter new name: ");
                        String newName = scanner.nextLine();
                        validation.nameValidate(newName);

                        System.out.print("Enter New ID: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        validation.validateId(newId);

                        // ===== Section Menu =====
                        String newSection;
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
                                case 1: newSection = "A"; break;
                                case 2: newSection = "B"; break;
                                case 3: newSection = "C"; break;
                                case 4: newSection = "D"; break;
                                default:
                                    System.out.println("\nInvalid section. Please try again.");
                                    continue;
                            }
                            break;
                        }

                        // ===== Semester Menu =====
                        double newSemester;
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
                                case 1: newSemester = 1.1; break;
                                case 2: newSemester = 1.2; break;
                                case 3: newSemester = 2.1; break;
                                case 4: newSemester = 2.2; break;
                                case 5: newSemester = 3.1; break;
                                case 6: newSemester = 3.2; break;
                                case 7: newSemester = 4.1; break;
                                case 8: newSemester = 4.2; break;
                                default:
                                    System.out.println("\nInvalid semester. Please try again.");
                                    continue;
                            }
                            break;
                        }

                        // ===== Gender Menu =====
                        String newGender;
                        while (true) {
                            System.out.println("\nSelect Gender:");
                            System.out.println("1. Male\n2. Female");
                            System.out.print("Enter your choice (1/2): ");
                            int genderChoice = scanner.nextInt();

                            switch (genderChoice) {
                                case 1: newGender = "MALE"; break;
                                case 2: newGender = "FEMALE"; break;
                                default:
                                    System.out.println("Invalid gender choice. Please try again.");
                                    continue;
                            }
                            break;
                        }

                        // ===== Department Menu =====
                        String newDepartment;
                        while (true) {
                            System.out.println("\nSelect Department:");
                            System.out.println("1. CSE\n2. EEE\n3. L&HR\n4. ENG");
                            System.out.print("Enter your choice (1/2/3/4): ");
                            int deptChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (deptChoice) {
                                case 1: newDepartment = "CSE"; break;
                                case 2: newDepartment = "EEE"; break;
                                case 3: newDepartment = "L&HR"; break;
                                case 4: newDepartment = "ENG"; break;
                                default:
                                    System.out.println("Invalid department choice. Please try again.");
                                    continue;
                            }
                            break;
                        }

                        System.out.print("Enter New Continuous Assessment Score: ");
                        double newContinuousAssessment = scanner.nextDouble();
                        scanner.nextLine();
                        validation.validateContinuousAssessment(newContinuousAssessment);

                        System.out.print("Enter New Project Score: ");
                        double newProjectScore = scanner.nextDouble();
                        scanner.nextLine();
                        validation.validateProjectScore(newProjectScore);

                        System.out.print("Enter New Midterm Assessment Score: ");
                        double newMidtermAssessment = scanner.nextDouble();
                        scanner.nextLine();
                        validation.validateMidtermAssessment(newMidtermAssessment);

                        System.out.print("Enter New Final-Term Assessment Score: ");
                        double newFinalAssessment = scanner.nextDouble();
                        scanner.nextLine();
                        validation.validateFinalAssessment(newFinalAssessment);

                        double newOverallPerformance = newContinuousAssessment + newProjectScore +
                                newMidtermAssessment + newFinalAssessment;

                        list.get(i).setName(newName);
                        list.get(i).setId(newId);
                        list.get(i).setSemester(newSemester);
                        list.get(i).setSection(newSection);
                        list.get(i).setGender(newGender);
                        list.get(i).setDepartment(newDepartment);
                        list.get(i).setContinuousAssessment(newContinuousAssessment);
                        list.get(i).setProjectScore(newProjectScore);
                        list.get(i).setMidtermAssessment(newMidtermAssessment);
                        list.get(i).setFinalAssessment(newFinalAssessment);
                        list.get(i).setOverallPerformance(newOverallPerformance);

                        saveToFile();

                        System.out.println("\nStudent record updated successfully.");
                        return;
                    }
                }

                if (!found) {
                    System.out.println("Student with ID " + id + " not found. Please try again.");
                }

            } catch (InvalidNameException | InvalidIdException |
                     InvalidContinuousAssessmentException | InvalidProjectScoreException |
                     InvalidMidAssessmentException | InvalidFinalAssessmentException e) {

                System.err.println(e.getMessage());

            } catch (Exception e) {
                System.err.println("\nError: Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
    }
}
