//Counting all primes upto 200000
public class Prime {
    private static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[] primes = new int[18000];
        int count = 0;
        for (int i = 0; i < 200000; i++) {
            if (isPrime(i) == true) {
                primes[count] = i;
                count++;
            }

        }
        int totalPrime = 0;
        for (int i = 0; i < primes.length ; i++) {
            totalPrime += primes[i];
        }
        System.out.println(totalPrime);
    }
}
