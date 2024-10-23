import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Register register = new Register(Menu.this, students);
                register.setVisible(true);
            }
        });
        visualizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Visualize visualize = new Visualize(Menu.this, students);
                visualize.setVisible(true);
            }
        });
    }
}
