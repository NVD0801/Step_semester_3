
import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, String startDate) {
        this.name = name;
        this.startDate = LocalDate.parse(startDate);
    }

    abstract int getValidity();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidity());
    }
}

class Basic extends Plan {
    Basic(String name, String date) {
        super(name, date);
    }

    int getValidity() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, String date) {
        super(name, date);
    }

    int getValidity() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, String date) {
        super(name, date);
    }

    int getValidity() {
        return 365;
    }
}

class StreamingPlan{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Plan[] plans = new Plan[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            String date = sc.next();

            switch (type) {
                case "BASIC":
                    plans[i] = new Basic(name, date);
                    break;

                case "STANDARD":
                    plans[i] = new Standard(name, date);
                    break;

                case "PREMIUM":
                    plans[i] = new Premium(name, date);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(plans[i].name + ": " +
                    plans[i].getRenewalDate());
        }

        sc.close();
    }
}
