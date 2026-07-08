
import java.util.ArrayList;
public class QuestionBank {

    ArrayList<Question> questions = new ArrayList<>();

    public QuestionBank() {

        questions.add(
                new Question(
                        "What is Java?",
                        "Operating System",
                        "Programming Language",
                        "Database",
                        "Browser",
                        1
                )
        );

        questions.add(
                new Question(
                        "What does JVM stand for?",
                        "Java Variable Machine",
                        "Java Virtual Machine",
                        "Java Version Manager",
                        "Java Visual Model",
                        1
                )
        );

        questions.add(
                new Question(
                        "Who developed Java?",
                        "Microsoft",
                        "Google",
                        "Sun Microsystems",
                        "Apple",
                        2
                )
        );
    }
}