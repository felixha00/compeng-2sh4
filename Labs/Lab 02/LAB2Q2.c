#include <stdio.h>
#include <math.h>

#define N 3

int is_diag_dom( int mat[N][N]){

    int diagonalIsBigger = 1;
    int diagonalVal = 0;
    int sumOfRow = 0;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            if (i == j){
                diagonalVal = mat[i][j];
            }
            else {
                sumOfRow += fabs(mat[i][j]); // adds the absolute value of the element in the row
            }
        }
        if (diagonalVal < sumOfRow){ // check if the diagonal value is less than the abs sum of the rows
            return 0;
        }

    }
    return 1; // only reaches here if the diagonalValue is always greater than the sum of row
}

int main()
{
    int mat[N][N] = {{67,2,1},{0,30,1},{0,0,99}};

    printf("%d", is_diag_dom(mat));
}
