
package view;

import javax.swing.*;
import java.awt.*;

public class ParticipantFormView extends JFrame {
    public JTextField nameField = new JTextField(20);
    public JTextField phoneField = new JTextField(20);
    public JTextField emailField = new JTextField(20);
    public JTextField addressField = new JTextField(20);
    public JComboBox<String> genderCombo = new JComboBox<>(new String[]{"Male","Female","Other"});
    public JTextField dobField = new JTextField(10);  // yyyy-mm-dd
    public JComboBox<String> degreeCombo = new JComboBox<>(new String[]{"BSSE","MIT","PgIT"});
    public JTextField pictureField = new JTextField(20);
    public JButton browseButton = new JButton("Browse...");
    public JTextField positionField = new JTextField(15);
    public JCheckBox interDeptCheckbox = new JCheckBox("Has inter-dept experience");
    public JTextArea experienceArea = new JTextArea(5,20);
    public JButton submitButton = new JButton("Submit");

    public ParticipantFormView() {
        setTitle("IITDU Football League Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] labels = {
                "Name:", "Phone:", "Email:", "Address:", "Gender:",
                "Date of Birth (yyyy-mm-dd):", "Degree:", "Photo:", "Position:", "Experience:"
        };
        JComponent[] comps = {
                nameField, phoneField, emailField, addressField, genderCombo,
                dobField, degreeCombo, pictureField, positionField, new JScrollPane(experienceArea)
        };

        for(int i=0;i<labels.length;i++) {
            gbc.gridx = 0; gbc.gridy = i;
            form.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1;
            form.add(comps[i], gbc);
        }
        gbc.gridx = 2; gbc.gridy = 7;
        form.add(browseButton, gbc);

        gbc.gridx = 1; gbc.gridy = labels.length;
        form.add(interDeptCheckbox, gbc);

        add(form, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }
}
