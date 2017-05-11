/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 * RESULT: 142913828922
 */
package pe_010;

public class PE_010 {
    public static int primes[] = new int[1000000];
    public static int j = 2;

    public static void main(String[] args) {
        primes[0] = 2;
        primes[1] = 3;
        long sum = 2 + 3;
        for(int i = 5; i < 2000000; i += 2){
            if(TestPrime(i)){
                sum += i;
                j++;
            }
        }
        System.out.print("Sum of primes is " + sum +".");
    }
    
    public static boolean TestPrime (int number){
        for(int i = 0; primes[i] <= Math.sqrt(number); i++){
            if(number % primes[i] == 0 && primes[i] != 0)
                return false;
        }
        primes[j] = number;
        return true;
    }
}
