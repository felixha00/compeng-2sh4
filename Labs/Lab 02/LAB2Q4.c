#include <stdio.h>

void letter_freq(const char word[], int freq[]){

    const int caseDiff = 32; // declares the difference between the cases
    const int startNum = 65; // start number

    for (int a = 0; a<26; a++){ // initializes all letters to be a count of 0
        freq[a] = 0;
    }

    size_t n = sizeof(word)/sizeof(word[0]); // get size of array
    for (int i = 0; i < n; i++){

        for (int alphabet = startNum; alphabet<startNum+26; alphabet++){


        if ((int)word[i] == alphabet || (int)word[i] == alphabet+caseDiff){
            freq[alphabet-65] += 1;
        }
    }
    }

    char lower = 0;
    char upper = 0;
    for (int i = 0; i<26; i++){

        upper = i+65; // lowercase
        lower = i+97; // uppercase
        printf("The count of %c and %c is: %d\n",lower,upper,freq[i]);
    }






}

int main(){

    char word[] = {'z','Z','A','A','A','A','A','A','A','A','A','A'};
    int freq[26];

    letter_freq(word, freq);
}
