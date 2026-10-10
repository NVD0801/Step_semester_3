
import java.util.*;

interface Insurable {
    double getInsurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double getCharge();

    double getInsurance() {
        return 0;
    }

    double getTotal() {
        return getCharge() + getInsurance();
    }
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    public double getInsurance() {
        return value * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight + 50;
    }

    public double getInsurance() {
        return value * 0.02;
    }
}

public class ParcelShipping{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        String[] types = new String[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            switch (types[i]) {
                case "STANDARD":
                    parcels[i] = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcels[i] = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcels[i] = new Fragile(weight, value);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            double charge = parcels[i].getCharge();
            double insurance = parcels[i].getInsurance();
            double amount = parcels[i].getTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                types[i], charge, insurance, amount
            );

            grandTotal += amount;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
