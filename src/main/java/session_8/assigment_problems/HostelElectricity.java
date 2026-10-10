
import java.util.*;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Single extends Room {
    Single(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8;
    }
}

class Shared extends Room {
    int occupants;

    Shared(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6) / occupants;
    }
}

class AC extends Room {
    AC(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 10 + 200;
    }
}

class HostelElectricity{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Room[] rooms = new Room[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = sc.next().toUpperCase();
            int units = sc.nextInt();

            switch (types[i]) {
                case "SINGLE":
                    rooms[i] = new Single(units);
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    rooms[i] = new Shared(units, occupants);
                    break;

                case "AC":
                    rooms[i] = new AC(units);
                    break;
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            double bill = rooms[i].calculateBill();
            System.out.printf("%s: %.2f%n", types[i], bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
