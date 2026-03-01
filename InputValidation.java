public class InputValidation {

    public void nameValidate(String name) throws InvalidNameException{
        if(name == null || name.trim().isEmpty()){
            throw new InvalidNameException("\nName Cannot Be EMPTY!");
        }
        if(!name.matches("[a-zA-Z\\s\\-]+")){
            throw new InvalidNameException("\nName must contain only letters, spaces, or hyphens.");
        }
    }
    public void validateId(int id) throws InvalidIdException{
        if (id < 10000000 || id > 99999999) {
            throw new InvalidIdException("\nStudent ID must be exactly 8 digits and no leading 0 (If entered)");
        }
    }
    public void validateContinuousAssessment(double continuousAssessment) throws InvalidContinuousAssessmentException{
        if (continuousAssessment < 0 || continuousAssessment > 20) {
            throw new InvalidContinuousAssessmentException("\nContinuous Assessment marks must be between 0 and 20.");
        }
    }
    public void validateProjectScore(double projectScore) throws InvalidProjectScoreException {
        if (projectScore < 0 || projectScore > 10) {
            throw new InvalidProjectScoreException("\nProject Score must be between 0 and 10.");
        }
    }
    public void validateMidtermAssessment(double midtermAssessment) throws InvalidMidAssessmentException {
        if (midtermAssessment < 0 || midtermAssessment > 20) {
            throw new InvalidMidAssessmentException("\nMidterm Assessment marks must be between 0 and 20.");
        }
    }
    public void validateFinalAssessment(double finalAssessment) throws InvalidFinalAssessmentException {
        if (finalAssessment < 0 || finalAssessment > 50) {
            throw new InvalidFinalAssessmentException("\nFinal-term Assessment marks must be between 0 and 50.");
        }
    }
}
