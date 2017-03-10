/*
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * SOLUTION
 * We will test products of 2 two-digit numbers for palindromes. We will count them downwards because
 * there is higher probability that program will find large palindrom and we can stop checking  
 * numbers when their product is starting to be too small.
 *
 * RESULT: 906609
 */
package pe_004;

public class PE_004 {

    public static void main(String[] args) {
        int number = 0, largestPalindrome = 0;
        for(int a = 999; a >= 100; a--){
            for(int b = 999; b >= 100; b--){
                number = a * b;
                int reverse = reverse(number);
                if(number < largestPalindrome)
                    break;
                if(testPalindrome(number, reverse) == true)
                    largestPalindrome = number;
            }
        }
        System.out.println("Largest palindrome: " + largestPalindrome);
    }
    
    public static int reverse (int number){
        int reverse = 0;
        while(number != 0){
            reverse = reverse * 10;
            reverse = reverse + number % 10;
            number /= 10;
        }
        return reverse;
    }
    
    public static boolean testPalindrome (int number, int reverse){
        if(reverse == number)
            return true;
        return false;
    }
}
