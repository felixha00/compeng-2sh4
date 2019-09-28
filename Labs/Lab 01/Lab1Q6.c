#include <stdio.h>

int main()
{

    int numOfTriples = 0;

    for (int i = 1; i<=400; i++) { // side one
        for (int j= 1; j <=400; j++) { // side two
                for (int k=1; k <=400; k++)
                {// hypotenuse
            if (i<j){ // check if i is less than j

            if ((i*i)+(j*j) == (k*k)) { //
                printf("\nSIDE01: %d, SIDE02: %d, HYPOTENUSE: %d\n",i,j,k); // prints out hypotenuse
                numOfTriples++; // adds the amount of triples
            }
            }
                }
        }
    }

    printf("There are %d Pythagorean Triples.",numOfTriples);


}
