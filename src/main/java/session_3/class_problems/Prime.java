import java.util.Scanner;

public class Prime{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean isPrime = true;

        System.out.print("Enter the number for which has to be checked whether prime or not: ");
        int number = sc.nextInt();
        sc.nextLine();

        int OriginalNum = number;

        for(int i=2;i<number;i++){
            if(number%i==0){
                isPrime=false;
                break;
            }
        }
        if(isPrime){
            System.out.printf("The number %d is not a Prime Number",OriginalNum);
        }else{
            System.out.printf("The number %d is not a Prime Number",OriginalNum);
        }
        sc.close();  
    }    
}
