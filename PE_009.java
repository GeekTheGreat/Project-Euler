/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a2 + b2 = c2
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * RESULT: 31875000
*/
package pe_009;

public class PE_009 {

    public static void main(String[] args) {
        for(int a = 1; a <= 333; a++){
            for(int b = 1; b <= 499; b++){
                int c = 1000 - a - b;
                if(a*a + b*b == c*c)
                    System.out.println("Product is "  + a*b*c);
            }
        }
    }
    
}
