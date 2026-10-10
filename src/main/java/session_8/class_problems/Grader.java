
import java.util.*;

abstract class Question {
    String text, correctAnswer, studentAnswer;
    double points;

    Question(String text, String correctAnswer, String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String t, String c, String s, double p) {
        super(t, c, s, p);
    }

    double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }
}

class TF extends Question {
    TF(String t, String c, String s, double p) {
        super(t, c, s, p);
    }

    double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String t, String c, String s, double p) {
        super(t, c, s, p);
    }

    double grade() {
        String[] keywords = correctAnswer.split(",");
        int matched = 0;

        for (String word : keywords) {
            if (studentAnswer.toLowerCase().contains(word.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2)
            return points * 0.75;
        else if (matched == 1)
            return points * 0.50;
        else
            return 0;
    }
}

class Grader{
    public static void main(String[] args) {
        Question[] questions = {
            new MCQ("What is the capital of France?", "Paris", "Paris", 10),
            new TF("The Earth is flat?", "False", "True", 5),
            new Essay("Name two primary OOP principles.",
                    "Inheritance, Polymorphism, Encapsulation",
                    "Polymorphism is one.", 20),
            new Essay("Describe abstraction and composition",
                    "Abstraction, Composition",
                    "I talked about abstraction.", 15)
        };

        double total = 0;

        for (Question q : questions) {
            double score = q.grade();
            System.out.printf("%s: %.2f%n",
                    q.getClass().getSimpleName().toUpperCase(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
