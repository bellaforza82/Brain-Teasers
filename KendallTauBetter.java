
import java.util.*;

//Replaced triple forloop that ranked pairs with a double forloop, Integers[] replaced with ints[], fewer methods, better, correct output.
public class KendallTauBetter {

    static Scanner scan = new Scanner(System.in);
    //Original arrays
    static int[] a = new int[5];
    static int[] b = new int[5];
    //Arrays for pairs and their distance
    static int[] aPairsAndDistance = new int[a.length * a.length * 3];
    static int[] bPairsAndDistance = new int[a.length * a.length * 3];
    //Final Array of mismatch pairs
    static int[] pairs = new int[a.length * a.length];
    //Variables to count distance


    //Fills arrays with pairs and their distance; original arrays are used as arguments
    public static void parisAndDistance(int[] a, int[] b){
        int countA = 0;
        int countB = 0;
        int distance = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++){
                if (a[i] == a[j]){
                    continue;
                }
                aPairsAndDistance[countA] = a[i];
                aPairsAndDistance[countA+1] = a[j];
                distance = j - i;
                aPairsAndDistance[countA+2] = distance;
                countA+=3;
            }
            for (int j = 0; j < a.length; j++){
                if (b[i] == b[j]){
                    continue;
                }
                bPairsAndDistance[countB] = b[i];
                bPairsAndDistance[countB+1] = b[j];
                distance = j - i;
                bPairsAndDistance[countB+2] = distance;
                countB+=3;
            }
        }
        findPairs(aPairsAndDistance,bPairsAndDistance);
    }
    public static void findPairs(int[] a, int[] b){
        int count = 0;
        for (int i = 0; i < a.length; i+=3) {
            for (int j = 0; j < a.length; j+=3) {
                if (a[i] == 0 && a[i+1] == 0){
                    break;
                }
                if (a[i] == b[j+1] && a[i+1] == b[j]){
                    if (a[i + 2] >= 1 && b[j + 2] >= 1 || a[i + 2] <= 0 && b[j+2] <= 0) {
                        pairs[count] = a[i];
                        pairs[count+1] = a[i+1];
                        count+=2;
                    }
                }
            }
        }
        print(pairs);
    }
    public static void print(int[] a){
        System.out.print("The pairs that are mismatches are: ");
        for (int i = 0; i < a.length; i+=2) {
            if (a[i] == 0 && a[i+1] == 0){
                break;
            }
            System.out.print(a[i] + " - " + a[i + 1] + " ");
        }
    }
    public static void main(String[] args){
        int i = 0;
        System.out.println("Enter numbers 0-4 in any order with a space in between them.");
        while (scan.hasNext()){
            a[i] = scan.nextInt();
            i++;
            if (i == 5){
                break;
            }
        }
        System.out.println("Now do it again.");
        i = 0;
        while (scan.hasNext()){
            b[i] = scan.nextInt();
            i++;
            if (i == 5){
                break;
            }
        }
        parisAndDistance(a,b);
    }
}
