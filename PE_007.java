/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * 
 * RESULT: 104743
 */
package pe_007;

public class PE_007 {

    public static void main(String[] args) {
        int counter = 2;
        for(int number = 5; counter < 10002; number += 2){
            if(TestPrime(number))
                counter++;
            if(counter == 10001){
                System.out.println("10 001st prime number is " + number + ".");
                break;
            }    
        }
    }
    
    public static boolean TestPrime (int number){
        for(int i = 3; i <= number / 2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
