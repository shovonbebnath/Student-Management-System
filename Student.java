
public class Student extends Person{

    private double semester;
    private String section;
    private String department;
    private double continuousAssessment;
    private double projectScore;
    private double midtermAssessment;
    private double finalAssessment;
    private double overallPerformance;
    private String status;

    Student(String name, int id, String section, double semester, String gender, String department,
            double continuousAssessment , double projectScore, double midtermAssessment, double finalAssessment, double overallPerformance, String status) {
        super(name, id, gender);
        this.section = section;
        this.semester = semester;
        this.department = department;
        this.status = status;
        this.continuousAssessment  = continuousAssessment ;
        this.projectScore = projectScore;
        this.midtermAssessment = midtermAssessment;
        this.finalAssessment = finalAssessment;
        this.overallPerformance = overallPerformance;
    }

    //===============GETTERS===============

    public double getSemester() {
        return semester;
    }
    public String getSection() {
        return section;
    }
    public String getDepartment() {
        return department;
    }
    public double getContinuousAssessment() {
        return continuousAssessment ;
    }
    public double getProjectScore() {
        return projectScore;
    }
    public double getMidtermAssessment() {
        return midtermAssessment;
    }
    public double getFinalAssessment() {
        return finalAssessment;
    }
    public double getOverallPerformance() {
        return overallPerformance;
    }
    public String getStatus() {
        return status;
    }

    //===============SETTERS===============

    public void setDepartment(String department) {
        this.department = department;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public void setSemester(double semester) {
        this.semester = semester;
    }
    public void setContinuousAssessment(double continuousAssessment) {
        this.continuousAssessment  = continuousAssessment ;
    }
    public void setProjectScore(double projectScore) {
        this.projectScore = projectScore;
    }
    public void setMidtermAssessment(double midtermAssessment) {
        this.midtermAssessment = midtermAssessment;
    }
    public void setFinalAssessment(double finalAssessment) {
        this.finalAssessment = finalAssessment;
    }
    public void setOverallPerformance(double overallPerformance) {
        this.overallPerformance = overallPerformance;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void displayInfo() {
        System.out.printf("| %-20s | %-10d | %-8s | %-8.1f | %-6s | %-10s | %-11.1f | %-11.1f | %-11.1f | %-11.1f | %-11.1f | %-8s |\n",
                getName(), getId(), getSection(), getSemester(), getGender(), getDepartment(),
                getContinuousAssessment(), getProjectScore(), getMidtermAssessment(), getFinalAssessment(), getOverallPerformance(), getStatus());
    }



    public void displayIndividualInfo(){
        System.out.println("\nStudent ID                  : "+getId());
        System.out.println("Student Name                : "+getName());
        System.out.println("Section                     : "+getSection());
        System.out.println("Semester                    : "+getSemester());
        System.out.println("Department                  : "+getDepartment());
        System.out.println("Gender                      : "+getGender());
        System.out.println("Continuous Assessment       : "+getContinuousAssessment());
        System.out.println("Project Score               : "+getProjectScore());
        System.out.println("Mid-Term Assessment Score   : "+getMidtermAssessment());
        System.out.println("Final-Term Assessment Score : "+getFinalAssessment());
        System.out.println("Overall Performance         : "+getOverallPerformance());
    }

    public void displaySpecificList(){
        System.out.printf("| %-20s | %-10d | %-8s | %-8.1f | %-6s | %-10s | %-11.1f | %-11.1f | %-11.1f | %-11.1f | %-11.1f | %-8s |\n",
                getName(), getId(), getSection(), getSemester(), getGender(), getDepartment(),
                getContinuousAssessment(), getProjectScore(), getMidtermAssessment(), getFinalAssessment(), getOverallPerformance(), getStatus());
    }

    public String toString() {
        return getName()+","+getId()+","+getSection()+","+getSemester()+","+getGender()+","+getDepartment()+","+
                getContinuousAssessment()+","+getProjectScore()+","+getMidtermAssessment()+","+ getFinalAssessment()+","+
                getOverallPerformance()+","+getStatus();
    }

    public String toStringForFile() {

        return String.format("| %-20s | %-10s | %-8s | %-8s | %-6s | %-10s | %-11.2f | %-11.2f | %-11.2f | %-11.2f | %-11.2f | %-8s |",
                getName(), getId(), getSection(), getSemester(), getGender(), getDepartment(), getContinuousAssessment(),
                getProjectScore(), getMidtermAssessment(), getFinalAssessment(), getOverallPerformance(), getStatus()
        );
    }

    public void studentPreview() {
        System.out.printf("%-10s %-20s %n", getId(), getName());
    }

}
