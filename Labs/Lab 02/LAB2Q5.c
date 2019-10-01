#include <stdio.h>

void string_copy(const char source[], char destination[], int n){


    for (int i = 0; i < n; i++){

        destination[i] = source[i];


    }
    for (int i = 0; i < n; i++){

        printf ("%c", destination[i]);
    }
    destination[n] = "\0";

}


int main(){

    int n = 8;
    const char source[] = {"waterbottle"};
    char destination[n];
    string_copy(source, destination, n);
}
