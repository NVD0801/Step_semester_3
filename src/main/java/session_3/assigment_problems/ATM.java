import java.util.Scanner;

public class ATM{

    static void atmPinRetry(String correctPin, String[] attempts) {

        int attempt = 0;
        boolean success = false;

        while (attempt < attempts.length && !success) {

            if (attempts[attempt].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }

            attempt++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctPin = sc.nextLine();
        int n = sc.nextInt();

        String[] attempts = new String[n];

        for (int i = 0; i < n; i++) {
            attempts[i] = sc.next();
        }

        atmPinRetry(correctPin, attempts);

        sc.close();
    }
}