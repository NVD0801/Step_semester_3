import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number to be checked: ");
        int number = sc.nextInt();

        int OrgNum=number;
        int RevNum=0;

        while(number!=0){
            int digit = number % 10;
            RevNum=(RevNum*10)+digit;
            number=number/10;
        }

        if(RevNum==OrgNum){
            System.out.println("The entered number is Palindrome");
        }else{
            System.out.println("The entered number is not a Palindrome");
        }
        sc.close();
    }
}
