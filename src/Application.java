import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Menu menu = new Menu(students);
        menu.setVisible(true);
    }
}