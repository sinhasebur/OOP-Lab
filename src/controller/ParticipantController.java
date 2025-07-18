
package controller;

import model.Participant;
import view.ParticipantFormView;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ParticipantController {
    private ParticipantFormView view;

    public ParticipantController(ParticipantFormView view) {
        this.view = view;
        view.browseButton.addActionListener(e -> onBrowse());
        view.submitButton.addActionListener(e -> onSubmit());
    }

    private void onBrowse() {
        JFileChooser chooser = new JFileChooser();
        int ret = chooser.showOpenDialog(view);
        if (ret == JFileChooser.APPROVE_OPTION) {
            view.pictureField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void onSubmit() {
        String name = view.nameField.getText().trim();
        String phone = view.phoneField.getText().trim();
        String email = view.emailField.getText().trim();
        String address = view.addressField.getText().trim();
        String gender = (String)view.genderCombo.getSelectedItem();
        String dob = view.dobField.getText().trim();
        String degree = (String)view.degreeCombo.getSelectedItem();
        String picture = view.pictureField.getText().trim();
        String position = view.positionField.getText().trim();
        String experience = view.experienceArea.getText().trim();
        String interDept = view.interDeptCheckbox.isSelected() ? "Yes" : "No";

        if(name.isEmpty()||phone.isEmpty()||email.isEmpty()||address.isEmpty()||
                dob.isEmpty()||picture.isEmpty()||position.isEmpty()||experience.isEmpty()) {
            JOptionPane.showMessageDialog(view, "⚠️ Please fill in *all* the fields.", "Incomplete form", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Participant p = new Participant(
                name, phone, email, address, gender, dob, degree, picture,
                position, interDept, experience
        );

        saveToFile(p);
        JOptionPane.showMessageDialog(view, "Registration successful!");
        clearForm();
    }

    private void saveToFile(Participant p) {
        try(PrintWriter out = new PrintWriter(new FileWriter("participants.txt", true))) {
            out.println(p.toString());
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(view, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        view.nameField.setText("");
        view.phoneField.setText("");
        view.emailField.setText("");
        view.addressField.setText("");
        view.dobField.setText("");
        view.pictureField.setText("");
        view.positionField.setText("");
        view.experienceArea.setText("");
        view.genderCombo.setSelectedIndex(0);
        view.degreeCombo.setSelectedIndex(0);
        view.interDeptCheckbox.setSelected(false);
    }
}
