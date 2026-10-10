
import java.util.*;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 1.10;
    }
}

class Canteen{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Customer[] bills = new Customer[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            switch (types[i]) {
                case "STUDENT":
                    bills[i] = new Student(amount);
                    break;
                case "STAFF":
                    bills[i] = new Staff(amount);
                    break;
                case "GUEST":
                    bills[i] = new Guest(amount);
                    break;
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            double finalAmount = bills[i].calculateAmount();
            System.out.printf("%s: %.2f%n", types[i], finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
