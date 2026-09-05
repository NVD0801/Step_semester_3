import java.util.Scanner;

public class StarPattern{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows to be printed: ");
        int number = sc.nextInt();
        sc.close();

        for(int i=0;i<=number;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        sc.close();
    }
}
