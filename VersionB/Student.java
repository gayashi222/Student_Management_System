public class Student extends Person implements Printable {

    private String course;

    public Student(int id, String name, int age, String course) {
        super(id, name, age);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Overriding the method from Printable (polymorphism)
    public void printDetails() {
        System.out.println("ID: " + getId() + ", Name: " + getName() + ", Age: " + getAge() + ", Course: " + course);
    }
}
