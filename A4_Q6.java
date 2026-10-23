
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class A4_Q6 extends JFrame implements ActionListener {

    JLabel title, nameLabel, fatherLabel, ageLabel;
    JLabel genderLabel, courseLabel, hobbiesLabel, addressLabel;

    JTextField nameField, fatherField, ageField;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JComboBox<String> courseBox;
    JCheckBox drawing, singing, music, others;
    JTextArea addressArea;
    JButton saveButton, clearButton;

    Color bg = new Color(54, 60, 73);

    A4_Q6() {
        setTitle("User Registration Form");
        setSize(840, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(bg);

        // Heading
        title = new JLabel("Registration Form");
        title.setBounds(203, 15, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 21));
        title.setForeground(Color.YELLOW);
        add(title);

        // Name
        nameLabel = createLabel("Name", 202, 62);
        nameField = createTextField(328, 58, 335, 26);

        // Father Name
        fatherLabel = createLabel("Father Name", 202, 104);
        fatherField = createTextField(328, 100, 335, 26);

        // Age
        ageLabel = createLabel("Age", 202, 146);
        ageField = createTextField(328, 142, 335, 26);

        // Gender
        genderLabel = createLabel("Gender", 202, 188);

        male = new JRadioButton("Male");
        male.setBounds(328, 187, 75, 25);
        male.setBackground(bg);
        male.setForeground(Color.WHITE);
        male.setSelected(true);

        female = new JRadioButton("Female");
        female.setBounds(412, 187, 90, 25);
        female.setBackground(bg);
        female.setForeground(Color.WHITE);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        add(male);
        add(female);

        // Course dropdown
        courseLabel = createLabel("Course", 202, 230);

        String[] courses = {
                "Java", "Python", "C", "C++",
                "Web Development", "MCA", "BCA"
        };

        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(328, 226, 335, 25);
        courseBox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(courseBox);

        // Hobbies
        hobbiesLabel = createLabel("Hobbies", 202, 272);

        drawing = createCheckBox("Drawing", 328, 270);
        singing = createCheckBox("Singing", 411, 270);
        music = createCheckBox("Music", 495, 270);
        others = createCheckBox("Others", 579, 270);

        // Address
        addressLabel = createLabel("Address", 202, 314);

        addressArea = new JTextArea();
        addressArea.setFont(new Font("Arial", Font.PLAIN, 15));
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        addressArea.setText(
                "234 - 1d First Street,\nAnna Main Road\nNamakkkal"
        );

        JScrollPane scrollPane = new JScrollPane(addressArea);
        scrollPane.setBounds(328, 310, 335, 85);
        add(scrollPane);

        // Save button
        saveButton = new JButton("Save Details");
        saveButton.setBounds(328, 420, 125, 25);
        saveButton.setBackground(Color.BLUE);
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(this);
        add(saveButton);

        // Clear button
        clearButton = new JButton("Clear All");
        clearButton.setBounds(462, 420, 125, 25);
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.addActionListener(this);
        add(clearButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 25);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setForeground(Color.WHITE);
        add(label);
        return label;
    }

    JTextField createTextField(int x, int y, int w, int h) {
        JTextField field = new JTextField();
        field.setBounds(x, y, w, h);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        add(field);
        return field;
    }

    JCheckBox createCheckBox(String text, int x, int y) {
        JCheckBox box = new JCheckBox(text);
        box.setBounds(x, y, 85, 25);
        box.setBackground(bg);
        box.setForeground(Color.WHITE);
        box.setFont(new Font("Arial", Font.PLAIN, 14));
        add(box);
        return box;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String gender = male.isSelected() ? "Male" : "Female";

            String hobbies = "";
            if (drawing.isSelected()) hobbies += "Drawing, ";
            if (singing.isSelected()) hobbies += "Singing, ";
            if (music.isSelected()) hobbies += "Music, ";
            if (others.isSelected()) hobbies += "Others, ";

            if (hobbies.isEmpty()) {
                hobbies = "None";
            } else {
                hobbies = hobbies.substring(0, hobbies.length() - 2);
            }

            String details =
                    "Registration Successful!\n\n"
                            + "Name: " + nameField.getText() + "\n"
                            + "Father Name: " + fatherField.getText() + "\n"
                            + "Age: " + ageField.getText() + "\n"
                            + "Gender: " + gender + "\n"
                            + "Course: " + courseBox.getSelectedItem() + "\n"
                            + "Hobbies: " + hobbies + "\n"
                            + "Address: " + addressArea.getText();

            JOptionPane.showMessageDialog(
                    this,
                    details,
                    "Registration Details",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            fatherField.setText("");
            ageField.setText("");
            male.setSelected(true);
            courseBox.setSelectedIndex(0);
            drawing.setSelected(false);
            singing.setSelected(false);
            music.setSelected(false);
            others.setSelected(false);
            addressArea.setText("");

            JOptionPane.showMessageDialog(
                    this, "All fields cleared!"
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new A4_Q6());
    }
}
