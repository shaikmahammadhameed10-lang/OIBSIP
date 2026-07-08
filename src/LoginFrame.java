import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginFrame() {
        loginButton = new JButton("Login");

        setTitle("Online Examination System");
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(80,100,100,30);
        add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setBounds(180,100,180,30);
        add(usernameField);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(80,150,100,30);
        add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(180,150,180,30);
        add(passwordField);
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(180,220,100,35);
        add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if (username.equals("admin") && password.equals("1234")) {

                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new ProfileFrame();

                    dispose();

                }


                else {

                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");

                }
                JOptionPane.showMessageDialog(
                        null,
                        "Username : " + username + "\nPassword : " + password
                );}
        });

        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        JLabel title = new JLabel("ONLINE EXAMINATION SYSTEM");
        title.setBounds(110,40,300,30);
        add(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

}