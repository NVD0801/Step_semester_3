
import java.util.*;

interface SaverMode {
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double getUnits() {
        return getPower() * hours / 1000;
    }

    double getCost() {
        return getUnits() * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    boolean saver;

    AC(double hours, boolean saver) {
        super(hours);
        this.saver = saver;
    }

    double getPower() {
        return 1500;
    }

    double getUnits() {
        double units = super.getUnits();
        return saver ? units * SAVER_FACTOR : units;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    boolean saver;

    Washer(double hours, boolean saver) {
        super(hours);
        this.saver = saver;
    }

    double getPower() {
        return 500;
    }

    double getUnits() {
        double units = super.getUnits();
        return saver ? units * SAVER_FACTOR : units;
    }
}

public class HomeAppliance{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");

            if (saver) {
                sc.next();
            }

            Appliance a = null;

            switch (type) {
                case "FRIDGE":
                    if (saver) {
                        System.out.println("FRIDGE: saver mode not supported");
                        continue;
                    }
                    a = new Fridge(hours);
                    break;

                case "AC":
                    a = new AC(hours, saver);
                    break;

                case "TV":
                    if (saver) {
                        System.out.println("TV: saver mode not supported");
                        continue;
                    }
                    a = new TV(hours);
                    break;

                case "WASHER":
                    a = new Washer(hours, saver);
                    break;
            }

            double units = a.getUnits();
            double cost = a.getCost();

            System.out.printf("%s: Units %.2f Cost=%.2f%n",
                    type, units, cost);

            total += cost;
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
