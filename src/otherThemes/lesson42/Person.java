package otherThemes.lesson42;

@Author(name = "Meder", dateOfCreation = 2021)
public class Person {
    private int id;
    private String name;

    public Person() {
        this.id = -1;
        this.name = "No name";
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Person with id: " + this.id + " and name: " + this.name + " says hello!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
