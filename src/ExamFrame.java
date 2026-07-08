import javax.swing.*;

public class ExamFrame extends JFrame {

    // Labels
    JLabel timerLabel;
    JLabel questionLabel;

    // Radio Buttons
    JRadioButton option1;
    JRadioButton option2;
    JRadioButton option3;
    JRadioButton option4;

    ButtonGroup group;

    // Buttons
    JButton previousButton;
    JButton nextButton;
    JButton submitButton;

    // Question Data
    QuestionBank bank = new QuestionBank();

    int currentQuestion = 0;

    int[] selectedAnswers = new int[3];

    int score = 0;

    public ExamFrame() {

        setTitle("Online Examination");

        setSize(700, 500);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Timer Label
        timerLabel = new JLabel("Time Left : 30:00");
        timerLabel.setBounds(520, 20, 150, 30);
        add(timerLabel);

        // Question Label
        questionLabel = new JLabel();
        questionLabel.setBounds(50, 70, 500, 30);
        add(questionLabel);

        // Options
        option1 = new JRadioButton();
        option1.setBounds(80, 130, 300, 30);
        add(option1);

        option2 = new JRadioButton();
        option2.setBounds(80, 170, 300, 30);
        add(option2);

        option3 = new JRadioButton();
        option3.setBounds(80, 210, 300, 30);
        add(option3);

        option4 = new JRadioButton();
        option4.setBounds(80, 250, 300, 30);
        add(option4);

        // Button Group
        group = new ButtonGroup();

        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        // Previous Button
        previousButton = new JButton("Previous");
        previousButton.setBounds(80, 350, 110, 35);
        add(previousButton);

        // Next Button
        nextButton = new JButton("Next");
        nextButton.setBounds(240, 350, 100, 35);
        add(nextButton);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(400, 350, 110, 35);
        add(submitButton);

        // Initialize answers
        for (int i = 0; i < selectedAnswers.length; i++) {
            selectedAnswers[i] = -1;
        }

        loadQuestion();

        // Next Button
        nextButton.addActionListener(e -> {

            saveAnswer();

            if (currentQuestion < bank.questions.size() - 1) {

                currentQuestion++;

                loadQuestion();

            }

        });

        // Previous Button
        previousButton.addActionListener(e -> {

            saveAnswer();

            if (currentQuestion > 0) {

                currentQuestion--;

                loadQuestion();

            }

        });

        // Submit Button
        submitButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(

                    this,

                    "Are you sure you want to submit?",

                    "Confirm",

                    JOptionPane.YES_NO_OPTION

            );

            if (choice == JOptionPane.YES_OPTION) {

                saveAnswer();

                calculateScore();

                new ResultFrame(score, bank.questions.size());

                dispose();

            }

        });

        setVisible(true);

    }

    // Load Current Question
    public void loadQuestion() {

        Question q = bank.questions.get(currentQuestion);

        questionLabel.setText(q.question);

        option1.setText(q.option1);

        option2.setText(q.option2);

        option3.setText(q.option3);

        option4.setText(q.option4);

        group.clearSelection();

        if (selectedAnswers[currentQuestion] == 0)

            option1.setSelected(true);

        else if (selectedAnswers[currentQuestion] == 1)

            option2.setSelected(true);

        else if (selectedAnswers[currentQuestion] == 2)

            option3.setSelected(true);

        else if (selectedAnswers[currentQuestion] == 3)

            option4.setSelected(true);

    }

    // Save Selected Answer
    public void saveAnswer() {

        if (option1.isSelected())

            selectedAnswers[currentQuestion] = 0;

        else if (option2.isSelected())

            selectedAnswers[currentQuestion] = 1;

        else if (option3.isSelected())

            selectedAnswers[currentQuestion] = 2;

        else if (option4.isSelected())

            selectedAnswers[currentQuestion] = 3;

    }

    // Calculate Score
    public void calculateScore() {

        score = 0;

        for (int i = 0; i < bank.questions.size(); i++) {

            Question q = bank.questions.get(i);

            if (selectedAnswers[i] == q.correctAnswer) {

                score++;

            }

        }

    }

}