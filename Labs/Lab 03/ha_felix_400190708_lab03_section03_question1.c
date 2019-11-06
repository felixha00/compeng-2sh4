#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *my_strcat(const char * const str1, const char * const str2)
{
    int totalLength = 0;
    int lenStr1 = 0;
    int lenStr2 = 0;

    for (int i = 0; str1[i] != '\0'; i++){ // get length of str1
        lenStr1++;
        totalLength++;
    }

    for (int i = 0; str2[i] != '\0'; i++){ // get length of str2
        lenStr2++;
        totalLength++;
    }

    printf("Total length of concatenated string: %d\n", totalLength);

    char *combinedString = malloc(totalLength* sizeof(char)); // sets the length of the combined character to be the total length * the size of a character.

        for (int k = 0; str1[k] != '\0'; k++){
            combinedString[k] = str1[k]; // add the first string to the array
        }
        for (int k = 0; str2[k] != '\0'; k++){
            combinedString[k+lenStr1] = str2[k]; //starts concatenating the 2nd string
        }

        combinedString[totalLength] = '\0'; // adds the null character at the end

    return combinedString;
    }



int main(){


    char str1[500];
    char str2[500];

    printf("Enter str1: ");
    scanf ("%s", &str1);
    printf("Enter str2: ");
    scanf ("%s", &str2);


    printf("Concatenated String: %s\n",my_strcat(str1,str2));
}
