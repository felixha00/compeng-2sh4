#include <stdio.h>
#define N 4

void print_diag(int mat[N][N]){

    for (int i = 0; i<N; i++) {
        int row, col; // initializes the row and col
        col = 0; // sets the column to 0
        row = i; // set the row to i
        while (row >= 0){ // array reads vvvvvvvv
            printf("%d ", mat[row][col]);
            row--; // pulls the row back up
            col++; // shifts the col to right
        }

    }

    for (int i=1; i<N; i++){
        int row2,col2;
        row2 = N-1;  //
        col2 = i; // column increases instead now
        while (col2 < N) { // array reads >>>>>>
            printf ("%d ", mat[row2][col2]);
            row2--; // pulls row back up
            col2++; // shifts col to right
            }
        }
    }

int main(){
    int mat[N][N] = {{1,12,13,49},{5,16,17,81},{9,10,11,20},{2,45,19,14}};

    print_diag(mat);
}
