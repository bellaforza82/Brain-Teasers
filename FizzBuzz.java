//Fizzbuzz using while loops
public class FizzBuzz {
    static int i = 0;
    static String fizz = "fizz";
    static String buzz = "buzz";

    public static void main(String[] args){
        while(i < 100){

            while(i%3==0 && i%5==0){
                System.out.println(i + " " + fizz + buzz);
                i++;
                break;
            }
            while(i%3==0){
                System.out.println(i + " " + fizz);
                i++;
                break;
            }
            while(i%5==0) {
                System.out.println(i + " " + buzz);
                i++;
                break;
            }
            System.out.println(i);
            i++;
        }


    }
}
