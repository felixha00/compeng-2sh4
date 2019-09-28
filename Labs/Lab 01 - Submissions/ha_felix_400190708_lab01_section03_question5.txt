#include <stdio.h>

int main ()
{
    double valueOfPi = 4.0;
    double denominator = 3.0;
    double termToAdd;

    int numTerms;
    printf("Enter number of terms: ");
    scanf("%d", &numTerms);

    printf("%f\n", valueOfPi); // prints out the value of pi initially

    // starts at 1 for the first term to be subtracted, add 1 to the number of terms so it accounts for the 1
    for (int i=1; i<numTerms; i++) {


        termToAdd = 4.0/denominator; // sets the next term to add

        // check every odd term
        if (i%2 == 1) {
            termToAdd *= -1;
        }

        valueOfPi += termToAdd; // adds the term

        printf("%f\n",valueOfPi);
        denominator+= 2.0; // add 2 to the denominator on the next iteration.

    }

    return 0;
}
