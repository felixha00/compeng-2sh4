#include <stdio.h>

int main() {

    int numZeros = 0;
    int numOnes = 0;

    // PROGRAM 1 //
    printf("--- PROGRAM 01 OUTPUT TO output1.txt ---\n");
    FILE *inputFile = fopen("input1.txt", "r"); // opens file "input1.txt" for read
    FILE *outFile = fopen("output1.txt", "w"); // opens file "input1.txt" for read

    int inputNum;
    int numOfNums;

    fscanf(inputFile, "%d", &numOfNums); // stores the number of integers in numOfNums

    for (int i = 0; i < numOfNums; i++){

        fscanf(inputFile, "%d", &inputNum); // scans the 0s and 1s

        if (inputNum == 0) { // check if inputNum is 0
                if (numOnes != 0) { // checks if the number of 1s is not 0
                    printf("%d ",numOnes); // prints the number of 1s
                    fprintf(outFile,"%d ", numOnes); //writes to file
                    numOnes = 0; //resets ones
                }

                    numZeros++;
                }



        else if (inputNum == 1) { // check if inputNum is 1
                if (numZeros != 0) {
                    printf("%d ",numZeros);
                    fprintf(outFile,"%d ", numZeros); //writes to file
                    numZeros = 0;

                }

                    numOnes++;

        }
        // accounts for the cut off number at the end
        if (i == numOfNums-1){ //-1 because of the for loop, it wil always be 1 less than numOfNums
            if (numZeros == 0){
                printf("%d ", numOnes);
                fprintf(outFile,"%d", numOnes);
            }
            else if (numOnes== 0){
                printf("%d", numZeros);
                fprintf(outFile,"%d", numOnes);
            }
        }

    }
    fclose(inputFile);


    // PROGRAM 2 //
    printf("\n--- PROGRAM 02 OUTPUT TO output2.txt---\n");
    int numOfNums2 = 0; // number of integers
    int inputNum2 = 0;
    int outputOfNums = 0;
    FILE *inputFile2 = fopen("input2.txt", "r");
    FILE *outFile2 = fopen("output2.txt", "w");

    // gets the amount of numbers in the set to match input1 format
    fscanf(inputFile2, "%d", &numOfNums2);

    for (int n = 0; n<numOfNums2; n++){
        fscanf(inputFile2, "%d", &inputNum2); // scans for the integer
        outputOfNums += inputNum2; // adds all the numbers together
    }

    fprintf(outFile2, "%d ",outputOfNums);
    printf("%d ",outputOfNums); // outputs the number of numbers ot the window
    rewind(inputFile2); // rewinds the file




    fscanf(inputFile2, "%d", &numOfNums2); // get number of numbers in the set

    for (int o = 0; o < numOfNums2; o++) {

        fscanf(inputFile2, "%d", &inputNum2); // scans the 0s and 1s

        if (o%2 == 0){ // check if number position is even
            for (int x = 0; x<inputNum2; x++){
                printf("0 ");
                fprintf(outFile2, "0 ");
            }
        }

        else { // check if number position is odd (only two choices anyways)
            for (int y = 0; y<inputNum2; y++){
                printf("1 ");
                fprintf(outFile2, "1 ");
            }
        }
    }
    fclose(inputFile2);

    return 0;



}











