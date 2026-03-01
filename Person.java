
public abstract class Person {
    private String name;
    private int id;
    private String gender;

    Person(String name, int id, String gender){
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getGender() {
        return gender;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public abstract void displayInfo();
    public abstract void displayIndividualInfo();
    public abstract void displaySpecificList();
    public abstract void studentPreview();

}
