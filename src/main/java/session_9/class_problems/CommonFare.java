
import java.util.*;

abstract class Ticket {
    double distance;
    static final double BOOKING_FEE = 50;

    Ticket(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double totalFare() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Ticket {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends Ticket {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends Ticket {
    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }
}

public class CommonFare{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Ticket[] tickets = new Ticket[n];
        String[] modes = new String[n];

        for (int i = 0; i < n; i++) {
            modes[i] = sc.next();
            double distance = sc.nextDouble();

            switch (modes[i]) {
                case "BUS":
                    tickets[i] = new Bus(distance);
                    break;
                case "TRAIN":
                    tickets[i] = new Train(distance);
                    break;
                case "FLIGHT":
                    tickets[i] = new Flight(distance);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%s: %.2f%n",
                modes[i], tickets[i].totalFare());
        }

        sc.close();
    }
}
