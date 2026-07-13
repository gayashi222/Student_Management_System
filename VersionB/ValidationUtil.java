public class ValidationUtil {

    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isValidAge(int age) {
        if (age >= 15 && age <= 100) {
            return true;
        }
        return false;
    }

    public static boolean isValidCourse(String course) {
        if (course == null || course.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
