#include <stdio.h>

int main()
{
  int num;
  int sumOfFactors = 0;
  printf ("Please enter an integer: ");
  scanf ("%d",&num);

  for (int j = 2; j < num; j++){ // all numbers less than the number
    for (int i = 1; i < j; i++){ // brute forces all possible factors fo the num

    if ((j%i) == 0){ //  mod each factor, to see which numbers are a factor of j
    sumOfFactors = sumOfFactors + i;
    }

    }

    if (sumOfFactors == j){ // checks if sum of factors is equal to j
        printf("%d is a perfect number\n",j);
        sumOfFactors = 0;
    }
    else {
        sumOfFactors = 0; // resets the factor sums when changing to next integer.
    }
    }
  }







