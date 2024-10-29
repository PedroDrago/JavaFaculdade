import javax.swing.*;
import java.awt.*;

public class Edit extends JFrame {

    private final JTextField nameField;
    private final JTextField emailField;
    private final JTextField cpfField;
    private final JTextField ageField;

    public Edit(Menu menu, Student student) {
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setTitle("Edit Student");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        editPanel.add(new JLabel("Name:"), gbc);
        nameField = new JTextField(20);
        nameField.setText(student.getName());
        gbc.gridx = 1;
        editPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        editPanel.add(new JLabel("Email:"), gbc);
        emailField = new JTextField(20);
        emailField.setText(student.getEmail());
        gbc.gridx = 1;
        editPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        editPanel.add(new JLabel("Email:"), gbc);
        cpfField = new JTextField(20);
        cpfField.setText(student.getCpf());
        gbc.gridx = 1;
        editPanel.add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        editPanel.add(new JLabel("Email:"), gbc);
        ageField = new JTextField(20);
        ageField.setText(student.getCpf());
        gbc.gridx = 1;
        editPanel.add(ageField, gbc);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(_ -> {
            // Update student details
            student.setName(nameField.getText());
            student.setEmail(emailField.getText());
            menu.setVisible(true);
            dispose();
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        editPanel.add(saveButton, gbc);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(_ -> {
            menu.setVisible(true);
            dispose();
        });
        gbc.gridx = 5;
        editPanel.add(cancelButton, gbc);

        setContentPane(editPanel);
    }
}