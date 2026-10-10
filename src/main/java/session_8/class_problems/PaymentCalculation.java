import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Payment {
    protected String type;
    protected double amount;

    public Payment(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public String getType() {
        return type;
    }
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super("CARD", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super("WALLET", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }
}

public class PaymentCalculation{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()){                                                                                                    scanner.close();
         return;
        }   
        int n = scanner.nextInt();
                                                                                                                                                                                                                                    
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            if (type.equalsIgnoreCase("CARD")) {
                payments.add(new CardPayment(amount));
            }else if (type.equalsIgnoreCase("WALLET")){
                payments.add(new WalletPayment(amount));
            }else if (type.equalsIgnoreCase("BANKTRANSFER")){
                payments.add(new BankTransferPayment(amount));
            }
        }    
        double grandTotal = 0;
        for (Payment payment : payments) {
            double finalAmount = payment.calculateFinalAmount();
            System.out.printf("%s: %.2f\n", payment.getType(), finalAmount);
            grandTotal += finalAmount;
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        