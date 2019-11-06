#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char **read_words(const char *input_filename, int *nPtr)
{
    int numWords = 0;
    char word[99];
    int singleStringLength = 0;

    FILE *wordsfile = fopen(input_filename, "r");
    fscanf(wordsfile, "%d", &*nPtr); // stores number of words in nPtr

    char** wordArray = malloc(*nPtr*sizeof(word)); // array of buffered word lengths (128)

     for (int i = 0; i < *nPtr; i++){

        fscanf(wordsfile, "%s", &word);
        for (int j = 0; word[j] != '\0'; j++){
            singleStringLength++; // count length of single string
        }

        //printf("%d ", singleStringLength);
        char* wordLine = malloc(singleStringLength * sizeof(char)); // allocate enough memory for the string

        strcpy(wordLine, word); // copies the word into the correct sized string
        //printf(wordLine);

        wordArray[i] = wordLine;
        singleStringLength = 0; //reset string length



    }
    fclose(wordsfile);

    return wordArray;
}

char **sort_words(char **wordArray, int *nPtr){

    int i, j;
    char* refStr;
    int charNum = 0;

    for (i = 1; i < *nPtr; i++) {
        refStr = wordArray[i]; // gets the first string
        j = i - 1; // left of wordArray

        while (j >= 0 && (int)(wordArray[j][charNum]) > (int)(refStr[charNum])) { // check if the first char in string is greater
            wordArray[j + 1] = wordArray[j];
            j--; // decreases the index until j is at 0
        }
        wordArray[j + 1] = refStr; // moves the reference str to the next element.
    }

    /*
    // SORT ALL CHARACTERS OTHER THAN THE FIRST ONE
    char* tempStr;
    for (int n = 0; n < (*nPtr-1); n++){
        if ((int)wordArray[n][charNum] == (int)wordArray[n+1][charNum]){
            while (wordArray[n][charNum] != '\0' || wordArray[n+1][charNum] != '\0'){
            if ((int)wordArray[n][charNum+1] > (int)wordArray[n+1][charNum+1]){
                tempStr = wordArray[n];
                wordArray[n] = wordArray[n+1];
                wordArray[n+1] = tempStr;
                charNum=0;
            }
            else {
                charNum++;
            }

            }
        charNum=0;
        }
        else {
            charNum++;
        }

    }
    */

    return wordArray;
}

char **sort_words2(char **wordArray, int *nPtr){

    /* BUBBLE SORT
    Runs through each element in the array, checking if the current element is greater than the
    */
    int i, j;
    char* tempStr;
    int charNum = 0;

    for (i = 0; i < (*nPtr-1); i++) { // -1 so doesnt compare over the index of the array
        for (int j = 0; j < (*nPtr-1-i); j++){ // left side will already be swapped so -1 and -i
            if ((int)wordArray[j][charNum] > (int)wordArray[j+1][charNum])
            {
                // swap values
                tempStr = wordArray[j];
                wordArray[j] = wordArray[j+1];
                wordArray[j+1] = tempStr;
            }
        }
    }


    return wordArray;
}


void output_words(char** wordArray, int *nPtr){
    for (int i = 0; i < *nPtr; i++){
        printf("%s\n", wordArray[i]);
    }
}
int main(){
    char* input_filename = "input.txt";
    int nPtr;

    // USING BUBBLE SORT
    printf("\nBUBBLE SORT\n");
    char** wordArray2 = read_words(input_filename, nPtr);
    wordArray2 = sort_words2(wordArray2, nPtr);
    output_words(wordArray2, nPtr);


    //USING INSERTION SORT
    printf("\nINSERTION SORT\n");
    char** wordArray = read_words(input_filename, nPtr);
    wordArray = sort_words(wordArray, nPtr);
    output_words(wordArray, nPtr);




    return 0;
}
