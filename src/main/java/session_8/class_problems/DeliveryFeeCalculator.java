import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class DeliveryRequest {
    protected double weight;
    protected double distance;

    public DeliveryRequest(double weight, double distance){
        this.weight = weight;
        this.distance = distance;
    }
    public abstract double calculateFee();
    public abstract String getType();
}

class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (weight * 0.50) + (distance * 0.10);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends DeliveryRequest{
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (weight * 1.00) + (distance * 0.20);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends DeliveryRequest {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (weight * 2.00) + (distance * 0.50) + customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            DeliveryRequest request = null;

            if (type.equalsIgnoreCase("STANDARD")) {
                request = new StandardDelivery(weight, distance);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
               request = new ExpressDelivery(weight, distance);
            } else if (type.equalsIgnoreCase("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                request = new InternationalDelivery(weight, distance, customsFee);
            }

            if (request != null) {
                double fee = request.calculateFee();
                System.out.printf("%s: %.2f\n", request.getType(), fee);
                grandTotal += fee;
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            