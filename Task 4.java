import javax.swing.JOptionPane;
import java.util.Scanner;

class Quiz {
    private String question;
    private String answer;
    private String options[];
    Quiz() {
        question = null;
        answer = null;
        options = new String[3];
    }
    Quiz(String question, String answer, String options[]) {
        this.question = question;
        this.answer = answer;
        this.options = options;
    }
    public void displayQuestion() {
        System.out.println(question);
    }
    public void displayOptions() {
        for(int i=0; i<options.length; i++) {
            System.out.println(options[i]);
        }
    }
    public String getAnswer() {
        return answer;
    }
}
public class Solution{

    private static Quiz[] quiz = {new Quiz("Which planet is known as the \"Red Planet\"?", "B) Mars", new String[]{"A) Venus", "B) Mars", "C) Jupiter"}), new Quiz("Who wrote the famous play \"Romeo and Juliet\"?", "A) William Shakespeare", new String[]{"A) William Shakespeare", "B) Jane Austen", "C) Charles Dickens"}), new Quiz("What is the chemical symbol for water?", "A) H2O", new String[]{"A) H2O", "B) CO2", "C) NaCl"})};

    private volatile static String answer = "";
    private volatile static int count;
    static int points = 0;

    static class UserThread extends Thread {
        private String operation = null;
        private boolean flag = true;

        UserThread(String operation) {
            this.operation = operation;
        }

        public void setFlag() {
            flag = false;
        }
        @Override
        public void run() {
            count = 0;
            flag = true;
            if(operation.equals("timer")) {
                while(flag) {
                    try {
                        Thread.sleep(1000);
                        count++;
                        if(count == 10) {
                            flag = false;
                        }
                    }
                    catch(InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else {
                System.out.print("Enter answer = ");
                answer = new Scanner(System.in).nextLine();
            }
        }
    }

    public static void menu() {
        System.out.println("1. Play Quiz\n2. Exit");
    }

    public static void play() {
        points = 0;
        for(int i=0; i<quiz.length; i++) {
            answer = "";
            quiz[i].displayQuestion();
            quiz[i].displayOptions();
            UserThread timer = new UserThread("timer");
            UserThread input = new UserThread("answer");
            timer.start();
            input.start();
            while(true) {
                if(answer.length() > 0) {
                    timer.setFlag();
                    break;
                }
                if(count == 10) {
                    input.interrupt();
                    break;
                }
            }
            timer.setFlag();
            input.interrupt();
            System.out.println("Correct Answer = " + quiz[i].getAnswer());
            if(quiz[i].getAnswer().charAt(0) == answer.toUpperCase().charAt(0)) {
                points += 10;
            }
            System.gc();
        }
        System.out.println(STR."You got \{points} points out of 30!!");
    }
    public static void main(String[] args) {
        int choice = 0;

        do {
            
            menu();
            choice = Integer.parseInt(JOptionPane.showInputDialog("Enter choice"));
            switch(choice) {
                case 1: {
                    play();
                    try {
                        Thread.sleep(1500);
                    }
                    catch(InterruptedException e) {}
                    break;
                }
                case 2: return;
                default: System.out.println("Invalid choice");
            }
        }
        while(true);
    }
}