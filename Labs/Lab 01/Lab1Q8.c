#include <stdio.h>

int main () {

    int num, lastDigit;
    int reversedNum = 0;

    printf("Enter a number to reverse: ");
    scanf("%d",&num);


    while (num >0)
    {

        lastDigit = num%10; // gets the last digit
        reversedNum = (reversedNum * 10)+ lastDigit;
        num/=10; // divides by 10 to remove a digit.

    }

    printf("Reversed Number is: %d", reversedNum);


}
