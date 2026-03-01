import java.io.*;
import java.util.ArrayList;

public class FileWriting {
    String allStudentDataOutput = "All Student Data.txt";
    String getAllStudentDataToGradeOutput = "All Student Data to Grade.txt";
    String inputFile = "savedRecords.txt";
    ArrayList<Student> list = StudentDataEntry.getStudentsList();

    public void writeAllStudentData(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(allStudentDataOutput));
            String line = "+----------------------+------------+----------+----------+--------+------------+-------------+-------------+-------------+-------------+-------------+----------+\n";
            writer.write(line);

            String header1 = String.format("| %-20s | %-10s | %-8s | %-8s | %-6s | %-10s | %-11s | %-11s | %-11s | %-11s | %-11s | %-8s |\n",
                    "Name", "Reg.No", "Section", "Semester", "Gender", "Department", "Continuous", "Project", "Midterm",
                    "Final", "Overall", "Remark");

            String header2 = String.format("| %-20s | %-10s | %-8s | %-8s | %-6s | %-10s | %-11s | %-11s | %-11s | %-11s | %-11s | %-8s |\n",
                    "", "", "", "", "", "", "Assessment", "Score", "Assessment", "Assessment", "Performance", "");

            writer.write(header1);
            writer.write(header2);
            writer.write(line);

            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i).toStringForFile());
                writer.newLine();
                writer.write(line);
            }
            writer.close();

            System.out.println("\n=========================================================");
            System.out.println("                   WRITE RECORD TO FILE                  ");
            System.out.println("=========================================================");

            System.out.println("\nFile has been written to '"+ allStudentDataOutput +"' successfully\n");
        }
        catch (IOException e) {
            System.err.println("Error saving records: "+e.getMessage());
        }
    }

    public void convertToGrade() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(getAllStudentDataToGradeOutput));

            writer.write("+-------------------------+-------+\n");
            writer.write("| Overall Performance     | Grade |\n");
            writer.write("+-------------------------+-------+\n");
            writer.write("| 80 and above            |   A   |\n");
            writer.write("+-------------------------+-------+\n");
            writer.write("| 70 – 79.99              |   B   |\n");
            writer.write("+-------------------------+-------+\n");
            writer.write("| 60 – 69.99              |   C   |\n");
            writer.write("+-------------------------+-------+\n");
            writer.write("| 50 – 59.99              |   D   |\n");
            writer.write("+-------------------------+-------+\n");
            writer.write("| 40 – 49.99              |   E   |\n");
            writer.write("+-------------------------+-------+\n");
            writer.write("| Below 40                |   F   |\n");
            writer.write("+-------------------------+-------+\n\n");

            String lineSeparator = "+----------------------+------------+----------+----------+--------+------------+-------------+-------------+-------------+-------------+-------------+-------+----------+\n";

            String header1 = String.format("| %-20s | %-10s | %-8s | %-8s | %-6s | %-10s | %-11s | %-11s | %-11s | %-11s | %-11s | %-5s | %-8s |\n",
                    "Name", "Reg.No", "Section", "Semester", "Gender", "Department", "Continuous", "Project", "Midterm",
                    "Final", "Overall", "Grade", "Remark");

            String header2 = String.format("| %-20s | %-10s | %-8s | %-8s | %-6s | %-10s | %-11s | %-11s | %-11s | %-11s | %-11s | %-5s | %-8s |\n",
                    "", "", "", "", "", "", "Assessment", "Score", "Assessment", "Assessment", "Performance", "", "");

            writer.write(lineSeparator);
            writer.write(header1);
            writer.write(header2);
            writer.write(lineSeparator);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 12) {
                    String name = parts[0];
                    int id = Integer.parseInt(parts[1]);
                    String section = parts[2];
                    double semester = Double.parseDouble(parts[3]);
                    String gender = parts[4];
                    String department = parts[5];
                    double continuousAssessment = Double.parseDouble(parts[6]);
                    double projectScore = Double.parseDouble(parts[7]);
                    double midtermAssessment = Double.parseDouble(parts[8]);
                    double finalAssessment = Double.parseDouble(parts[9]);
                    double overallPerformance = Double.parseDouble(parts[10]);
                    String status = parts[11];

                    String grade;
                    if (overallPerformance >= 80) {
                        grade = "A";
                    } else if (overallPerformance >= 70) {
                        grade = "B";
                    } else if (overallPerformance >= 60) {
                        grade = "C";
                    } else if (overallPerformance >= 50) {
                        grade = "D";
                    } else if (overallPerformance >= 40) {
                        grade = "E";
                    } else {
                        grade = "F";
                    }

                    String formattedRow = String.format("| %-20s | %-10d | %-8s | %-8.1f | %-6s | %-10s | %-11.2f | %-11.2f | %-11.2f | %-11.2f | %-11.2f | %-5s | %-8s |\n",
                            name, id, section, semester, gender, department, continuousAssessment, projectScore,
                            midtermAssessment, finalAssessment, overallPerformance, grade, status);

                    writer.write(formattedRow);
                    writer.write(lineSeparator);
                }
            }

            writer.close();
            reader.close();

            System.out.println("\n=========================================================");
            System.out.println("                    WRITE GRADE TO FILE                  ");
            System.out.println("=========================================================");

            System.out.println("\nRecords written successfully to '"+getAllStudentDataToGradeOutput+"' Successfully\n");

        } catch (FileNotFoundException e) {
            System.err.println("Error reading records: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error saving records: " + e.getMessage());
        }
    }
}
