import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Register extends JFrame {

    private JTextField Name;
    private JPasswordField Password;
    private JTextField Email;
    private JComboBox StatusB;
    private JButton submitButton;
    private JPanel RegisterPanel;
    private JLabel cpf;
    private JTextField cpfText;
    private JLabel StatusL;
    private JTextField age;
    private Menu menu;


    public Register(Menu menu, List<Student> students) {
        setContentPane(RegisterPanel);
        setTitle("42");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        submitButton.addActionListener(_ -> {
            // here needs to validate fields (use regexes)
            String email = Email.getText();
            String cpf = cpfText.getText();
            String name = Name.getText();
            String password = String.valueOf(Password.getPassword());
            String age = Register.this.age.getText();
            String status = Objects.requireNonNull(StatusB.getSelectedItem()).toString();
            try {
                Student student = new Student(1, name, age, cpf, email, password, status.equals("Accepted") ? Status.APPROVED : Status.REJECTED);
                students.add(student);
                menu.setVisible(true);
                dispose();
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        });
    }
}
