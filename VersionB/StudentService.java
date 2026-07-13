import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {

        if (findStudentById(student.getId()) != null) {
            return false;
        }
        students.add(student);
        return true;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public Student findStudentById(int id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }
        return null;
    }

    public boolean updateStudent(int id, String name, int age, String course) {

        Student student = findStudentById(id);
        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        return true;
    }

    public boolean deleteStudent(int id) {

        Student student = findStudentById(id);
        if (student == null) {
            return false;
        }
        students.remove(student);
        return true;
    }
}
