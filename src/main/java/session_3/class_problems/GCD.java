import java.util.Scanner;

public class GCD{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enetr the second number: ");
        int num2 = sc.nextInt();

        int OrgNum1=num1;
        int OrgNum2=num2;

        while(num2!=0){
            int remainder = num1%num2;
            num1=num2;
            num2=remainder;
        }
        System.out.printf("The GCD of %d and %d is %d",OrgNum1,OrgNum2,num1);
        sc.close();
    }
    
}
