import javax.swing.*;
import java.awt.*;
import java.awt.Cursor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResultFrame extends JFrame {

    public ResultFrame(int score, int totalQuestions) {

        setTitle("Result");
        setSize(450, 450);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(245, 248, 255));


        JLabel title = new JLabel("RESULT");
        title.setBounds(160, 20, 200, 40);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(0, 70, 140));
        add(title);

        int correctAnswers = score;
        int wrongAnswers = totalQuestions - score;
        double percentage = (score * 100.0) / totalQuestions;

        String status;
        if (percentage >= 40) {
            status = "PASS";
        } else {
            status = "FAIL";
        }


        JLabel message;

        if (status.equals("PASS")) {
            message = new JLabel("Congratulations!");
            message.setForeground(Color.GREEN);
        } else {
            message = new JLabel("Better Luck Next Time!");
            message.setForeground(Color.RED);
        }

        message.setBounds(120, 70, 250, 30);
        message.setFont(new Font("Arial", Font.BOLD, 18));
        add(message);


        JLabel scoreLabel = new JLabel("Your Score : " + score + " / " + totalQuestions);
        scoreLabel.setBounds(120, 120, 250, 25);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 15));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(scoreLabel);


        JLabel totalLabel = new JLabel("Total Questions : " + totalQuestions);
        totalLabel.setBounds(120, 150, 250, 25);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 15));
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(totalLabel);

        JLabel correctLabel = new JLabel("Correct Answers : " + correctAnswers);
        correctLabel.setBounds(120, 180, 250, 25);
        correctLabel.setFont(new Font("Arial", Font.BOLD, 15));
        correctLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(correctLabel);


        JLabel wrongLabel = new JLabel("Wrong Answers : " + wrongAnswers);
        wrongLabel.setBounds(120, 210, 250, 25);
        wrongLabel.setFont(new Font("Arial", Font.BOLD, 15));
        wrongLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(wrongLabel);


        JLabel percentageLabel = new JLabel(
                String.format("Percentage : %.2f%%", percentage)
        );
        percentageLabel.setBounds(120, 240, 250, 25);
        percentageLabel.setFont(new Font("Arial", Font.BOLD, 15));
        if(percentage >= 40)
        {
            percentageLabel.setForeground(new Color(0,128,0));
        }
        else
        {
            percentageLabel.setForeground(Color.RED);
        }
        percentageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(percentageLabel);


        JLabel statusLabel = new JLabel("Status : " + status);
        statusLabel.setBounds(120, 270, 250, 25);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));

        if (status.equals("PASS")) {
            statusLabel.setForeground(Color.GREEN);
        } else {
            statusLabel.setForeground(Color.RED);
        }
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(statusLabel);
        DateTimeFormatter dtf =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        JLabel dateLabel =
                new JLabel("Date : " + dtf.format(LocalDateTime.now()));

        dateLabel.setBounds(100,300,250,25);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(dateLabel);


        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(150, 330, 120, 40);
        logoutButton.setBackground(new Color(33, 150, 243));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);

        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        logoutButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if(choice == JOptionPane.YES_OPTION)
            {
                dispose();
                new LoginFrame();
            }

        });
        JLabel footer = new JLabel("Online Examination System");
        footer.setBounds(100,390,250,20);
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setForeground(Color.GRAY);
        add(footer);

        add(logoutButton);

        setVisible(true);
    }
}