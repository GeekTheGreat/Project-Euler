/*
 * The sum of the squares of the first ten natural numbers is, 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers 
 * and the square of the sum is 3025 − 385 = 2640. 
 * Find the difference between the sum of the squares of the first 
 * one hundred natural numbers and the square of the sum.
 *
 * SOLUTIONS
 * Count sum of the squares using loop. Then count square of the sum using formula
 * sum = n * (n + 1) / 2.
 *
 * RESULT: 25164150
 */
package pe_006;

public class PE_006 {

    public static void main(String[] args) {
        int number1 = 0, number2 = 0;
        
        for(int i = 1; i <= 100; i++){
            number1 += Math.pow(i, 2);
        }
        
        int sum = 100 * (100 + 1) / 2;
        number2 += Math.pow(sum, 2);
        System.out.println("Difference is " + (number2 - number1));
    }
    
}
