/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.

 * SOLUTION
 * We have to calculate how many numbers below 1000 are divisible by 3 and 5 and
 * subtract those which are divisible by 15 (Inclucion-Exclusion principe).
 * Notice that 3+6+9+12+...+999=3*(1+2+3+4+...+333)=3*((333*(333+1)/2). 
 * Use same principe with 5 and 15.

 * RESULT: 233168
 */

package pe_001;

public class PE_001 {

    public static void main(String[] args) {
        int result = SumMultiples(3) + SumMultiples(5) - SumMultiples(15);
        System.out.println("Sum of multiples: " + result);
    }
    
    static int SumMultiples(int number){
        int max = (int) 999 / number;
        return number * max * (max + 1) / 2;
    }
    
}
