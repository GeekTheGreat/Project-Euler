/*
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 21000?
 */
package pe_016;

public class PE_016 {

    public static void main(String[] args) {
        int [] array = new int [320];
        array [0] = 1;
        for(int i = 0; i <= 999; i++){
            array = Multiply(array);
        }
        
        int sum = 0;
        for(int j = 0; j <= 319; j++){
            sum += array[j];
        }
        System.out.println(sum);
    }
    
    public static int [] Multiply (int [] array){
        int rest = 0;
        for(int i = 0; i <= 319; i++){
            array[i] = array[i] * 2 + rest;
            rest = (int) array[i]/10;
            array[i] = array[i] - rest*10;
        }
        return array;
    }
    
}
