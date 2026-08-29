import java.util.Scanner;

public class LoginSim{

    static void simulateLogin(String correctCode, String[] attempts) {

        boolean granted = false;

        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                granted = true;
                break;
            }
        }

        if (!granted) {
            System.out.println("Access denied — all attempts used");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctCode = sc.nextLine();
        int n = sc.nextInt();

        String[] attempts = new String[n];

        for (int i = 0; i < n; i++) {
            attempts[i] = sc.next();
        }

        simulateLogin(correctCode, attempts);

        sc.close();
    }
}