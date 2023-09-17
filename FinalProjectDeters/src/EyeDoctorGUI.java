/**  
 * River Deters - mddeters  
 * CIS171 22149
 * July 24th, 2023
 * Windows 10 Operating System Eclipse Version - 2023-03
 */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EyeDoctorGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JRadioButton newPatientButton;
    private JRadioButton existingPatientButton;
    private JRadioButton wearsContactsButton;
    private JRadioButton notWearsContactsButton;
    private JButton submitButton;
    private JLabel totalCostLabel;

    // Custom JPanel for drawing the eye
    private class EyePanel extends JPanel {
        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Set the color for drawing the white background
            g.setColor(Color.WHITE);

            // Draw the white background (an ellipse)
            int eyeWidth = 100;
            int eyeHeight = 60;
            int x = (getWidth() - eyeWidth) / 2;
            int y = (getHeight() - eyeHeight) / 2;
            g.fillOval(x, y, eyeWidth, eyeHeight);

            // Set the color for drawing the black circle (pupil)
            g.setColor(Color.BLACK);

            // Draw the black circle (pupil) in the middle
            int pupilDiameter = 40;
            int pupilX = (getWidth() - pupilDiameter) / 2;
            int pupilY = (getHeight() - pupilDiameter) / 2;
            g.fillOval(pupilX, pupilY, pupilDiameter, pupilDiameter);
        }
    }

    public EyeDoctorGUI() {
        frame = new JFrame("Eye Doctor Cost Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 500));

        mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // EyePanel to display the eye drawing
        EyePanel eyePanel = new EyePanel();
        mainPanel.add(eyePanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 columns, with 10 pixels gap
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Title and subtitle labels with custom alignment
        JLabel titleLabel = new JLabel("Cost Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel("Please fill out all of the following fields");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Panel to hold title and subtitle labels
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.add(titleLabel);
        titlePanel.add(subtitleLabel);

        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // First name field and label
        inputPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField(15);
        inputPanel.add(firstNameField);

        // Last name field and label
        inputPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField(15);
        inputPanel.add(lastNameField);

        // New Patient radio buttons
        inputPanel.add(new JLabel("New Patient?"));
        newPatientButton = new JRadioButton("Yes");
        existingPatientButton = new JRadioButton("No");
        ButtonGroup patientGroup = new ButtonGroup();
        patientGroup.add(newPatientButton);
        patientGroup.add(existingPatientButton);
        JPanel patientPanel = new JPanel();
        patientPanel.add(newPatientButton);
        patientPanel.add(existingPatientButton);
        inputPanel.add(patientPanel);

        // Wears Contacts radio buttons
        inputPanel.add(new JLabel("Wears Contacts?"));
        wearsContactsButton = new JRadioButton("Yes");
        notWearsContactsButton = new JRadioButton("No");
        ButtonGroup contactsGroup = new ButtonGroup();
        contactsGroup.add(wearsContactsButton);
        contactsGroup.add(notWearsContactsButton);
        JPanel contactsPanel = new JPanel();
        contactsPanel.add(wearsContactsButton);
        contactsPanel.add(notWearsContactsButton);
        inputPanel.add(contactsPanel);

        // Label to display the total cost
        totalCostLabel = new JLabel("");
        inputPanel.add(totalCostLabel);

        // Panel to hold the Submit and Clear buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.add(buttonsPanel);

        // Submit button and its action listener
        submitButton = new JButton("Submit");
        buttonsPanel.add(submitButton);

        // Clear button and its action listener
        JButton clearButton = new JButton("Clear");
        buttonsPanel.add(clearButton);

        submitButton.addActionListener(new SubmitButtonListener());
        clearButton.addActionListener(new ClearButtonListener());
    }

    public void showGUI() {
        frame.pack();
        frame.setVisible(true);
    }

    // Action listener for the Submit button
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Get and trim the first name and last name from the text fields
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();

                // Input validation for first name and last name
                if (firstName.isEmpty() || lastName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter both first name and last name.");
                    return;
                }

                // Check if the New Patient and Wears Contacts options are selected
                boolean isNewPatient = newPatientButton.isSelected();
                boolean wearsContacts = wearsContactsButton.isSelected();

                // Input validation for radio button selection
                if (!isNewPatient && !existingPatientButton.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Please select whether the patient is new or existing.");
                    return;
                }

                if (!wearsContacts && !notWearsContactsButton.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Please select whether the patient wears contacts or not.");
                    return;
                }

                // Calculate the total cost and display it in the label
                double examCost = eyeDoctorCalculator.calculateExamCost(isNewPatient);
                double contactCost = eyeDoctorCalculator.calculateContactCost(wearsContacts);
                double totalCost = eyeDoctorCalculator.calculateTotalCost(examCost, contactCost);
                totalCostLabel.setText(String.format("Total cost for %s %s: $%.2f", firstName, lastName, totalCost));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number of people.");
            }
        }
    }

    // Action listener for the Clear button
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear all input fields and reset radio button selections
            firstNameField.setText("");
            lastNameField.setText("");
            newPatientButton.setSelected(false);
            existingPatientButton.setSelected(false);
            wearsContactsButton.setSelected(false);
            notWearsContactsButton.setSelected(false);
            totalCostLabel.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EyeDoctorGUI gui = new EyeDoctorGUI();
            gui.showGUI();
        });
    }
}
