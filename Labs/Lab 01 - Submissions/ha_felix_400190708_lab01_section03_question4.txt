#include <stdio.h>

int main () {

    float stuAvg;
    // get student average
    printf("Enter a student's average: ");
    scanf("%f",&stuAvg);

    // if and else if conditions
    printf("The student's GPA is: ");

    if (stuAvg <= 100 && stuAvg >= 90) {
        printf("4");
    }
    else if (stuAvg <= 89 && stuAvg >= 80) {
        printf("3");
    }
    else if (stuAvg <= 79 && stuAvg >= 70) {
        printf("2");
    }
    else if (stuAvg <= 69 && stuAvg >= 60) {
        printf("1");
    }
    else if (stuAvg <= 59 && stuAvg >= 0) {
        printf("0");
    }
    else {
        printf("Invalid input");
    }

    return 0;
}
