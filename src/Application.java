import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Student> students = new ArrayList<Student>();
    public static void main(String[] args) {
        Menu menu = new Menu(students);
        menu.setVisible(true);
    }
}