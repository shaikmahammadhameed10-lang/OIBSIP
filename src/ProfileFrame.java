import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ProfileFrame extends JFrame {

    JTextField displayNameField;
    JPasswordField passwordField;
    JButton saveButton;
    JButton startExamButton;

    public ProfileFrame() {

        setTitle("Profile Update");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("PROFILE UPDATE");
        title.setBounds(170, 30, 200, 30);
        add(title);

        JLabel displayLabel = new JLabel("Display Name");
        displayLabel.setBounds(60, 90, 120, 30);
        add(displayLabel);

        displayNameField = new JTextField();
        displayNameField.setBounds(180, 90, 180, 30);
        add(displayNameField);

        JLabel passwordLabel = new JLabel("New Password");
        passwordLabel.setBounds(60, 150, 120, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 150, 180, 30);
        add(passwordField);

        saveButton = new JButton("Save");
        saveButton.setBounds(100, 240, 100, 35);
        add(saveButton);
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String displayName = displayNameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if (displayName.isEmpty() || password.isEmpty()) {

                    JOptionPane.showMessageDialog(null,
                            "Please fill all fields.");

                }
                else {

                    JOptionPane.showMessageDialog(null,
                            "Profile Updated Successfully!");

                }
            }

        });
        startExamButton = new JButton("Start Exam");
        startExamButton.setBounds(230, 240, 130, 35);
        add(startExamButton);
        startExamButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new ExamFrame();

                dispose();

            }

        });
        setVisible(true);
    }
}