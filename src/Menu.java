import javax.swing.*;
import java.util.List;

public class Menu extends JFrame {
    private JButton registerButton;
    private JButton visualizeButton;
    private JPanel MenuPanel;


    public Menu(List<Student> students){
        setContentPane(MenuPanel);
        setTitle("42");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        registerButton.addActionListener(_ -> {
            setVisible(false);
            Register register = new Register(Menu.this, students);
            register.setVisible(true);
        });
        visualizeButton.addActionListener(_ -> {
            setVisible(false);
            Visualize visualize = new Visualize(Menu.this, students);
            visualize.setVisible(true);
        });
    }
}
