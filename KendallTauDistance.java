
import java.util.*;

//Kendall Tau Distance computer, still a work in progress
public class KendallTauDistance {

    static Scanner scan = new Scanner(System.in);
    //Original arrays
    static int[] a = new int[5];
    static int[] b = new int[5];
    //Arrays for pairs and their distance
    static Integer[] aPairsAndDistance = new Integer[100];
    static Integer[] bPairsAndDistance = new Integer[100];
    static Integer[] aPairsAndDistanceNoNulls = new Integer[100];
    static Integer[] bPairsAndDistanceNoNulls = new Integer[100];
    //Final Array of mismatch pairs
    static int[] pairs = new int[50];
    //Variables to count distance
    static int positionA1 = 0;
    static int positionA2 = 0;
    static int positionB1 = 0;
    static int positionB2 = 0;
    static int distance = 0;
    //Counter variable for manipulating array node position in the for loops
    static int counterA = 0;
    static int counterB = 0;

    //Fills arrays with pairs and their distance; original arrays are used as arguments
    public static void distance(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i){
                    positionA1 = j;
                    for (int k = 0; k < a.length; k++) {
                        aPairsAndDistance[counterA] = i;
                        aPairsAndDistance[counterA+1] = a[k];
                        positionA2 = k;
                        distance = positionA2-positionA1;
                        aPairsAndDistance[counterA+2] = distance;
                        counterA+=3;

                    }
                }
                if (b[j] == i){
                    positionB1 = j;
                    for (int k = 0; k < a.length; k++) {
                        bPairsAndDistance[counterB] = i;
                        bPairsAndDistance[counterB+1] = b[k];
                        positionB2 = k;
                        distance = positionB2-positionB1;
                        bPairsAndDistance[counterB+2] = distance;
                        counterB+=3;

                    }
                }
            }
        }
    }
    //Eliminates duplicate pairs; use a/bPairsAndDistance as arguments
    public static void eliminateDuplicates(Integer[] a, Integer[] b){
        for (int i = 0; i < a.length - 3; i+=3) {
            if (a[i] == a[i+1]){
                a[i] = a[i+1] = a[i+2] = null;
            }
            if (b[i] == b[i+1]){
                b[i] = b[i+1] = b[i+2] = null;
            }
        }
    }
    public static void eliminateNulls(Integer[] a, Integer[] b){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                aPairsAndDistanceNoNulls[count] = aPairsAndDistance[i];
                count++;
            }
        }
        count = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null){
                bPairsAndDistanceNoNulls[count] = bPairsAndDistance[i];
                count++;
            }
        }
    }
    //Compares distances of numbers pairs, if one distance is negative and the other positive then that pair is included in the final arrays.
    public static void findPairs(Integer[] a, Integer[] b) throws NullPointerException{
        int counter= 0;
        for (int i = 0; i < a.length - 3; i+=3) {
                try{
                    if (a[i] == 0 && a[i+1] == 0){
                    break;
                    }
                    if ((a[i+2] >= 1 && b[i+2] <= -1) || (a[i+2] <= -1 && b[i+2] >= 1)) {
                        pairs[counter] = a[i];
                        pairs[counter+1] = a[i+1];
                        counter+=2;

                    }
                }catch(NullPointerException e){

                }
        }
    }

    public static void print(int[] a){
        System.out.print("The following pairs are mismatches: ");
        try{
            for (int i = 0; i < a.length; i+=2) {
                if (a[i] == 0 && a[i + 1] == 0) {
                    break;
                }
                System.out.print(a[i] + "-" + a[i + 1] + ", ");
            }
        }catch (NullPointerException e){

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
        distance(a, b);
        eliminateDuplicates(aPairsAndDistance, bPairsAndDistance);
        eliminateNulls(aPairsAndDistance, bPairsAndDistance);
        findPairs(aPairsAndDistanceNoNulls, bPairsAndDistanceNoNulls);
        print(pairs);
    }
}
