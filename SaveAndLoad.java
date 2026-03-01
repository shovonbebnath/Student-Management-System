
import java.io.*;
import java.util.ArrayList;

public class SaveAndLoad {
    ArrayList<Student> list = StudentDataEntry.getStudentsList();
    String saveFile = "savedRecords.txt";

    public void saveToFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));

            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i).toString());
                writer.newLine();
            }

            System.out.println("\nRecords saved successfully to "+saveFile+" (Project Folder)");
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Error saving records: "+e.getMessage());
        }
    }

    public void loadFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(saveFile));
            String line;

            while((line = reader.readLine()) != null){
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

                    Student student = new Student(name, id, section, semester, gender, department,
                            continuousAssessment, projectScore, midtermAssessment, finalAssessment, overallPerformance, status);

                    StudentDataEntry.getStudentsList().add(student);
                }
            }
            System.out.println("Records loaded successfully from "+saveFile+" (Project Folder)");
        }
        catch (FileNotFoundException e) {
            System.err.println("\nFile Not Found");
            System.err.println("Possible reasons for this Exception...");
            System.err.println("-> File Does Not Exist");
            System.err.println("-> File may have been moved to another directory");
            System.err.println("-> The filename or path is misspelled or wrongly specified");
            System.err.println("Suggested Actions:");
            System.err.println("-> Ensure the file is located in the correct directory.");
            System.err.println("-> Double-check the file name and its extension");
            System.err.println("\nException Message: " + e.getMessage());
            System.out.println("\n# If using the program for the first time OR using it in a different machine...");
            System.out.println("  'IGNORE THIS EXCEPTION'");
        }
        catch (IOException e) {
            System.err.println("Error loading records: "+e.getMessage());
        }
    }
}
