/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * SOLUTION: Firstly, we create list of primes smaller than 20. Then we get for every number from 2 to 20 
 * prime factorization.
 * 
 * RESULT: 232792560
 */
package pe_005;

public class PE_005 {
    public static final int listOfPrimes[] = {2,3,5,7,11,13,17,19};
    public static int power[] = new int[8];

    public static void main(String[] args) {
        int result = 1;
        
        for(int i = 2; i <= 20; i++){
            int numberpower[] = getPrimes(i);
            for(int j = 0; j < 8; j++){
                if(numberpower[j] > power[j])
                    power[j] = numberpower[j];
            }
        }
        for(int i = 0; i < 8; i++){
            result *= Math.pow(listOfPrimes[i], power[i]);
        }
        System.out.println("Smallest number: " + result);
    }
    
    public static int[] getPrimes(int n){
        int numberpower[] = new int[8];
        for(int j = 0; j < 8; j++){
            if(n % listOfPrimes[j] == 0){
                numberpower[j]++;
                n /= listOfPrimes[j];
                j--;
            }
        }
        return numberpower;
    }
}
