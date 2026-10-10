
import java.util.*;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return Math.min(2 + 0.10 * distance, 10);
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    double factor;

    Metro(double distance, double factor) {
        super(distance);
        this.factor = factor;
    }

    double calculateFare() {
        return (1.50 + 0.20 * distance) * factor;
    }
}

class TransportFare{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Transport[] journeys = new Transport[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            if (type.equals("BUS")) {
                journeys[i] = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new Train(distance);
            } else if (type.equals("METRO")) {
                double factor = sc.nextDouble();
                journeys[i] = new Metro(distance, factor);
            }
        }

        double total = 0;

        for (Transport t : journeys) {
            double fare = t.calculateFare();
            System.out.printf("%s: %.2f%n",
                    t.getClass().getSimpleName(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
