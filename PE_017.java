/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
 * how many letters would be used?
 */
package pe_017;

public class PE_017 {

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 1000; i++){
            sum += Count(i);
        }
        System.out.println(sum);
    }
    
    public static int Count (int number){
        int result = 0;
        if(number == 1000){
            result = 11;
            return result;
        }
        
        int third = (int) number / 100;
        int second = (number - third * 100) / 10;
        int first = number - third * 100 - second * 10;
        
        //  numbers 11 - 19
        if(second == 1){
            switch(first){
                case 0:
                    result += 3;
                    break;
                case 1:
                    result += 6;
                    break;
                case 2:
                    result += 6;
                    break;
                case 3:
                    result += 8;
                    break;
                case 4:
                    result += 8;
                    break;
                case 5:
                    result += 7;
                    break;
                case 6:
                    result += 7;
                    break;
                case 7:
                    result += 9;
                    break;
                case 8:
                    result += 8;
                    break;
                case 9:
                    result += 8;
                    break;
            }
        }
        
        // numbers from 1 to 9
        else{
            switch(first){
                case 1:
                    result += 3;
                    break;
                case 2:
                    result += 3;
                    break;
                case 3:
                    result += 5;
                    break;
                case 4:
                    result += 4;
                    break;
                case 5:
                    result += 4;
                    break;
                case 6:
                    result += 3;
                    break;
                case 7:
                    result += 5;
                    break;
                case 8:
                    result += 5;
                    break;
                case 9:
                    result += 4;
            }
        }
        
        switch(second){
            case 2:
                result += 6;
                break;
            case 3:
                result += 6;
                break;
            case 4:
                result += 5;
                break;
            case 5:
                result += 5;
                break;
            case 6:
                result += 5;
                break;
            case 7:
                result += 7;
                break;
            case 8:
                result += 6;
                break;
            case 9:
                result += 6;
                break;
        }
        
        switch(third){
            case 1:
                result += 10;
                break;
            case 2:
                result += 10;
                break;
            case 3:
                result += 12;
                break;
            case 4:
                result += 11;
                break;
            case 5:
                result += 11;
                break;
            case 6:
                result += 10;
                break;
            case 7:
                result += 12;
                break;
            case 8:
                result += 12;
                break;
            case 9:
                result += 11;
                break;
        }
        if(third != 0 && number % 100 != 0)
            result += 3;
        
        return result;
    }
}
