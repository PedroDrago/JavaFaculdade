import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit extends JFrame {

    private JPanel EditPanel;
    private JTextField nameField;
    private JTextField emailField;

    public Edit(Menu menu, Student student) {
        EditPanel = new JPanel();
        EditPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setTitle("Edit Student");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        EditPanel.add(new JLabel("Name:"), gbc);
        nameField = new JTextField(20);
        nameField.setText(student.getName());
        gbc.gridx = 1;
        EditPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        EditPanel.add(new JLabel("Email:"), gbc);
        emailField = new JTextField(20);
        emailField.setText(student.getEmail());
        gbc.gridx = 1;
        EditPanel.add(emailField, gbc);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update student details
                student.setName(nameField.getText());
                student.setEmail(emailField.getText());
                menu.setVisible(true);
                dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        EditPanel.add(saveButton, gbc);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(true);
                dispose();
            }
        });
        gbc.gridx = 1;
        EditPanel.add(cancelButton, gbc);

        setContentPane(EditPanel);
    }
}