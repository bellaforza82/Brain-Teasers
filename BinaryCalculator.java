import java.util.Scanner;

//Binary Calculator up to 256, easily expandable to higher numbers
public class BinaryCalculator {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int binary = 256;
        int count = 0;
        for (int i = 0; i <= 7; i++){
            if (N == 1){
                System.out.print(1);
                break;
            }
            if (count == 4){
                System.out.print(" ");
            }
            if (N <= binary){
                System.out.print(0);
                binary /= 2;
                count++;
            }else{
                System.out.print(1);
                N -= binary;
                binary /= 2;
                count++;
            }
        }
    }
}
