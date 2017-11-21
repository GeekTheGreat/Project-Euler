/*
 * You are given the following information, 
 * but you may prefer to do some research for yourself.
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, 
 * but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during 
 * the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

#include <cstdlib>
#include <iostream>

using namespace std;

int main(int argc, char** argv) {
    int days = 0, sunday;
    for(int i = 1901; i <= 2000; i++){
        for(int j = 1; j <= 12; j++){
            if(j == 2){
                if(i % 4 == 0){
                    days += 29;
                    if((days - 28) % 7 == 6)
                        sunday++;
                }    
                else{
                    days += 28;
                    if((days - 27) % 7 == 6)
                        sunday++;
                }    
            }    
            else if(j == 4 || j == 6 || j == 9 || j == 11){
                days += 30;
                if((days - 29) % 7 == 6)
                    sunday++;
            }    
            else{
                days += 31;
                if((days - 30) % 7 == 6)
                    sunday++;
            }
        }
    }
    cout << sunday << endl;

    return 0;
}

