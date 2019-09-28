#include <stdio.h>


void efficient( const int source[], int val[], int pos[], int size){

    int k = 3; // length of array
    int n = 0;

     for (int x = 0; x < k;  x++){
            val[x] = 0;
    }

    for (int i = 0; i < size; i++){
        if (source[i] != 0){


                if (val[n] == 0){
                    val[n] = source[i];
                    pos[n] = i;
                    n++;
                }
            }
        }


    printf("val: ");
    for (int a = 0; a < k;  a++){
            printf ("%d ", val[a]);

    }
    printf("\npos: ");

     for (int b = 0; b < k;  b++){
            printf ("%d ", pos[b]);

    }
}


void reconstruct(int source[], int m, const int val[], const int pos[], int n){

    int count = 0;
    for (int i = 0; i< m; i++){

            if (pos[count] == i){
                source[i] = val[count];
                count++;

            }
            else{
                source[i] = 0;
            }
    }

    printf("source: ");
    for (int x = 0; x < m;  x++){
            printf ("%d ",source[x]);
    }


}


int main (){

    int source[] = {0,0,23,0,-7,0,0,48};
    int val[3];
    int pos[3];
    int size = 8;
    int m = 8;
    int n = 3;


    efficient(source, val, pos, size);
    printf("\n\n");
    reconstruct(source, m, val, pos, n);

}
