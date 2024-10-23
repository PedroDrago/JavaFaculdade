import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Visualize extends JFrame {

    public Visualize(Menu menu, List<Student> students) {
        JPanel visualizePanel = new JPanel();
        setContentPane(visualizePanel);
        setTitle("42");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);

        for (Student student : students) {
            System.out.println(student);
            JPanel studentPanel = new JPanel();
            studentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel registrationLabel = new JLabel(student.getRegistration());
            studentPanel.add(registrationLabel);

            JLabel nameLabel = new JLabel(student.getName());
            studentPanel.add(nameLabel);
            // Create the edit button
            JButton editButton = new JButton("Edit");
            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle edit action here
                    System.out.println("Edit button clicked for: " + student.getName());
                }
            });
            studentPanel.add(editButton);

            // Create the delete button
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle delete action here
                    System.out.println("Delete button clicked for: " + student.getName());
                    students.remove(student);
                    menu.setVisible(true);
                    dispose();
                }
            });
            studentPanel.add(deleteButton);
            visualizePanel.add(studentPanel);

        }
        // Refresh the panel to show the new components
        visualizePanel.revalidate();
        visualizePanel.repaint();
    }
}
