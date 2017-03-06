/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * SOLUTION
 * We will test whether huge number is divisible by all primes up to its square root.
 * If it is divisible we will divide huge number by that prime. Then we will continue 
 * testing divisibility up to square root of new value of huge number. 
 * After new value of huge number is no longer divisible by any primes up its square root
 * we know that it is largest prime factor of 600851475143.
 *
 * RESULT: 6857
 */
package pe_003;

public class PE_003 {

    public static void main(String[] args) {
        long prime = 600851475143L;
        for(int a = 3; a <= Math.sqrt(prime); a += 2){
            if(prime % a == 0 && TestPrime(a)){
                prime = prime / a;
            }
        }
        System.out.println("Largest prime factor: " + prime);
    }
    
    public static boolean TestPrime (int number){
        for(int i = 3; i <= Math.sqrt(number); i += 2){
            if(number % i == 0){
                return false;
            }  
        }
        return true;
    }
    
}
