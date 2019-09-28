#include <stdio.h>

int main() {

    int numOfInputs = 0;
    int inputNum;
    int smallestNum;

    // get the amount of integers entered
    do
    {
    printf("Please enter the amount of integers: ");
    scanf("%d", &numOfInputs); // gets number of inputs

    if (numOfInputs <= 0) { // checks if the number of numbers is +ve
        printf("\nPlease enter a positive or non-zero integer\n");
        }
    }
    while (numOfInputs <= 0);

    for (int i=0; i<numOfInputs; i++) {

    printf("\nEnter integer %d: ", i+1);
    scanf("%d", &inputNum);


    // set the first number to be the smallest number by default
    if (i==0) {
        smallestNum = inputNum;
    }

    // check if the inputted number is smaller than the smallest number
    if (inputNum <= smallestNum){
        smallestNum = inputNum;
    }


    }

    printf("\nThe smallest integer is: %d", smallestNum);



    return 0;



}
