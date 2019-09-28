#include <stdio.h>

void string_copy(const char source[], char destination[], int n){


    for (int i = 0; i < n; i++){

        destination[i] = source[i];


    }
    for (int i = 0; i < n; i++){

        printf ("%c", destination[i]);
    }

}


int main(){

    int n = 8;
    const char source[] = {'w','a','t','e','r','b','o','t','t','l','e'};
    char destination[n];
    string_copy(source, destination, n);
}
