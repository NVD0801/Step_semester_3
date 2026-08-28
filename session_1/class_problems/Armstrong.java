import java.util.Scanner;

public class Armstrong{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number to be checked: ");
        int number = sc.nextInt();
        sc.nextLine();

        int OrgNum=number;
        int sum = 0;

        while(number!=0){
            int digit = number%10;
            sum = sum + (digit*digit*digit);
            number = number/10;
        }
        if(sum == OrgNum){
            System.out.printf("The number %d is a Armstrong number",OrgNum);
        }else{
            System.out.printf("The number %d is not a Armstrong number",OrgNum);
        }
        sc.close();
    }
}
