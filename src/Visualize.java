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
            JButton editButton = new JButton("Edit");
            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    Edit edit = new Edit(menu, student);
                    edit.setVisible(true);
                }
            });
            studentPanel.add(editButton);
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    students.remove(student);
                    menu.setVisible(true);
                    dispose();
                }
            });
            studentPanel.add(deleteButton);
            visualizePanel.add(studentPanel);
        }
        visualizePanel.revalidate();
        visualizePanel.repaint();
    }
}
