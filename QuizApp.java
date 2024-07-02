import java.util.*;

public class QuizApp {
    private static List<Question> questions = new ArrayList<>();
    private static int score = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeQuestions();
        runQuiz();
        showResults();
        scanner.close(); // Close the scanner
    }

    private static void initializeQuestions() {
        // Add some sample questions
        questions.add(new Question("What's the capital of France?", new String[]{"London", "Berlin", "Paris", "Madrid"}, 2));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 1));
        // Add more questions here...
    }

    private static void displayQuestion(Question q) {
        System.out.println("\n" + q.getQuestion());
        for (int i = 0; i < q.getOptions().length; i++) {
            System.out.println((i + 1) + ". " + q.getOptions()[i]);
        }
    }

    private static void runQuiz() {
        for (Question q : questions) {
            displayQuestion(q);
            int answer = getAnswer(q);
            checkAnswer(q, answer);
        }
    }

    private static int getAnswer(Question q) {
        long startTime = System.currentTimeMillis();
        System.out.print("Your answer (1-" + q.getOptions().length + "): ");
        String input = scanner.nextLine().trim();
        long endTime = System.currentTimeMillis();

        if ((endTime - startTime) > 10000) { // 10 seconds
            System.out.println("\nTime's up!");
            return -1;
        }

        try {
            if (input.isEmpty()) {
                return -1; // Return -1 for no input
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            return getAnswer(q); // Prompt again
        }
    }

    private static void checkAnswer(Question q, int answer) {
        if (answer == -1) {
            System.out.println("No answer provided. The correct answer was: " + q.getOptions()[q.getCorrectAnswer()]);
        } else if (answer == q.getCorrectAnswer() + 1) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer was: " + q.getOptions()[q.getCorrectAnswer()]);
        }
    }

    private static void showResults() {
        System.out.println("\n--- Quiz Results ---");
        System.out.println("Your score: " + score + " out of " + questions.size());
        System.out.println("Percentage: " + (score * 100 / questions.size()) + "%");
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
