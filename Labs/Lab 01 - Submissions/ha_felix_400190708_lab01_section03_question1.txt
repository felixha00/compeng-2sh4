#include <stdio.h>


int i, j, k;
int sum1, sum2, sum3 = 0;

int main()
{

    // FOR LOOP

    for (i=30; i<=1000; i++){
        if (i%4 == 0){
            sum1 += i;
        }
    }
    printf ("Sum is %d\n",sum1);



    // WHILE LOOP
    j = 30;
    while (j <= 1000) {
        if (j%4 ==0) {
            sum2 += j;
        }
        j++;
    }
     printf ("Sum is %d\n",sum2);

     // DO WHILE

     k = 30;
     do {
        if (k%4 ==0) {
            sum3 += k;
        }
        k++;
     }
     while (k <=1000);
     printf ("Sum is %d\n",sum3);

     return 0;

}



