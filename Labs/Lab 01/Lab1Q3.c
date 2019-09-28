#include <stdio.h>

int main() {

    int inputNum;
    int numDigits = 0;
    int enteredZero = 0;

    // Input integer
    while (enteredZero == 0){


    printf("\nEnter an integer (0 to end): ");
    scanf("%d", &inputNum);

    // checks if entered number is 0
    if (inputNum == 0) {
        printf("\nThanks for using my program!");
        break;
    }

    int originalNum = inputNum; // remembers the original number
    while (inputNum != 0) { // uses integer division to get rid of the last digit in a number.
        inputNum /= 10;

        numDigits++;
    }

    // if number of digits is 5
    if (numDigits == 5) {
        printf("\nYour input of %d is a five-digit number.",originalNum);

    }
    // resets digits
    numDigits=0;
    }

    return 0;
}
