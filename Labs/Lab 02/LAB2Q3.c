#include <stdio.h>
#define N 4

void print_diag(int mat[N][N]){

    for (int row = 0; row<N; row++) {
        for (int col = 0; col<N; col++) {
            printf("%d ", mat[row][col]);
        }
        printf("\n");
    }


    for (int row = 0; row<N; row++){
        for (int col = 0; col<N; col++){

            printf("%d ", mat[row][col]);
            if (col == row ){
                break;
            }
        }
    }
}

int main(){
    int mat[N][N] = {{1,12,13,49},{5,16,17,81},{9,10,11,20},{2,45,19,14}};

    print_diag(mat);
}
