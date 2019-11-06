#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int studentNum; // student number
    char fName[15]; // first name, max 15 char
    char lName[15]; // last name, max 15 char
    int p1_grade; // project 1 grade
    int p2_grade; // project 2 grade
    float fGrade; // final grade

} student ;

struct student **create_class_list( char *filename, int *sizePtr)
{
    int numStudents = 0;

    FILE *studentListFile = fopen(filename, "r");
    fscanf(studentListFile, "%d", &(*sizePtr)); // reads the first line to get number of students

    printf("Number of students in the class: %d\n",*sizePtr);
    student **studentList = calloc(*sizePtr, sizeof(student*)); // holds numStudents of students in an array.


    for (int i = 0; i < *sizePtr; i++){
        studentList[i] = calloc(1, sizeof(student));
        fscanf(studentListFile, "%d %s %s", &studentList[i]->studentNum, &studentList[i]->fName, &studentList[i]->lName); // reads one line, puts the 3 values separated by spaces into the
       // studentList[i].p1_grade = 0;
       // studentList[i].p2_grade = 0;
       // studentList[i].fGrade = 0.0;
    }
    printf("\n");

    printf("=== [CLASS LIST] ===\n");
    for (int i = 0; i < *sizePtr; i++){ // print the list of students in the class
        printf("%d ", studentList[i]->studentNum);
        printf("%s ", studentList[i]->fName);
        printf("%s ", studentList[i]->lName);
        printf("\n");
    }
    printf("====================\n");
    fclose(studentListFile);
    return studentList;
}

int find (int idNo, student **list, int size)
{
    for (int i = 0; i < size; i++){ // print the list of students in the class
        if (list[i]->studentNum == idNo)
        {
            return i;
        }
    }

    return -1; // return -1 if not found
}

void input_grades (char *filename, student **list, int size)
{

    FILE *gradesfile = fopen(filename, "r");
    int p1_mark_file = 0;
    int p2_mark_file = 0;
    int idNo;

    for (int i = 0; i < size; i++){
        fscanf(gradesfile, "%d %d %d", &idNo, &p1_mark_file, &p2_mark_file); // get the 3 values on one line

        int foundIndex = find(idNo,list,size); // calls find() function to find the index of where the student is in the list
        list[foundIndex]->p1_grade = p1_mark_file;
        list[foundIndex]->p2_grade = p2_mark_file;

    }

    /*
    printf("\nMARKS ADDED\n---\n");
    for (int i = 0; i < size; i++){ // print the list of students in the class
        printf("%d ", list[i]->studentNum);
        printf("%s ", list[i]->fName);
        printf("%s ", list[i]->lName);
        printf("%d ", list[i]->p1_grade);
        printf("%d ", list[i]->p2_grade);
        printf("\n");
    }
    */

    fclose(gradesfile);
}

void compute_final_course_grades(student **list, int size){

    for (int i = 0; i < size; i++){

        float avg = (list[i]->p1_grade+list[i]->p2_grade)/2;
        list[i]->fGrade = avg;
    }

}

void output_final_course_grades(char* gradesOutputName, student **list, int size)
{
    FILE *gradesOutputFile = fopen(gradesOutputName, "w"); // opens file for writing
    fprintf(gradesOutputFile, "%d\n", size); // first line is the size

    for (int i = 0; i < size; i++)
    {
        fprintf(gradesOutputFile, "%d %0.2f\n", list[i]->studentNum, list[i]->fGrade);
    }
    fclose(gradesOutputFile);

}

void print_list(student **list, int size)
{
    printf("\n");
    for (int i = 0; i < size; i++){ // print the list of students in the class
        printf("(STUDENT NUMBER):%d\t", list[i]->studentNum);
        printf("(NAME):%s ", list[i]->fName);
        printf("%s\t", list[i]->lName);
        printf("(PROJECT 1 GRADE):%d\t", list[i]->p1_grade);
        printf("(PROJECT 2 GRADE):%d\t", list[i]->p2_grade);
        printf("(FINAL GRADE):%.2f", list[i]->fGrade); // print final grade to 2 decimal places
        printf("\n");
    }
}



void withdraw(int idNo, student **list, int *sizePtr)
{

    int removeLocation = find(idNo, list, *sizePtr); // get student to withdraw
    if (removeLocation == -1)
    {
        printf("\nStudent with (%d) not found. Error withdrawing from class (-1)\n", idNo);
    }
    else
    {
        printf("\n==== [%s %s WITHDRAWN FROM CLASS] ====\n", list[removeLocation]->fName, list[removeLocation]->lName);
        free(list[removeLocation]); // removes the student from array of pointers
        for (int i = removeLocation; i < (*sizePtr-1); i++) // -1 so it doesnt overscan at the end of the for loop
        {
            list[i] = list[i+1]; // shifts each pointer to the left in the array so it points to the correct one

        }
        *sizePtr = *sizePtr-1;

        //*sizePtr--; //reduces the size of the array
    }
}

void destroy_list (struct student **list, int *sizePtr)
{
    for (int i = 0; i < *sizePtr; i++)
    {
       free(list[i]); // clears each student element in the list
    }
    *sizePtr = 0; // sets the number of students to be 0.
}


int main() {

    int* sizePtr;
    char* filename = "studentslist.txt";
    student **studentList = create_class_list(filename, sizePtr);

    int idNo = 400190708; // return index for Isaac Newton

    printf("\n");

    int foundIndex = find(idNo, studentList, *sizePtr); // get index of found student



    if (foundIndex != -1)
    {
        printf("(%s %s) with student number (%d) found at index: (%d)\n", studentList[foundIndex]->fName, studentList[foundIndex]->lName,  studentList[foundIndex]->studentNum, foundIndex);
    }
    else {
        printf("Student not found (-1)\n");
    }


    char* gradesfile = "projectgrades.txt";

    input_grades(gradesfile, studentList, *sizePtr);

    compute_final_course_grades(studentList, *sizePtr);

    char* gradesOutputName = "finalgrades.txt";

    output_final_course_grades(gradesOutputName, studentList, *sizePtr);

    print_list(studentList, *sizePtr);
    /*
    //// WITHDRAW ISAAC NEWTON
    withdraw(1200, studentList, sizePtr);
    print_list(studentList, *sizePtr);

    // WITHDRAW ALAN TURING
    withdraw(4580, studentList, sizePtr);
    print_list(studentList, *sizePtr);

    // WITHDRAW ELVIS PRESLEY
    withdraw(9000, studentList, sizePtr);
    print_list(studentList, *sizePtr);

    // DESTROY LIST
    */
    destroy_list(studentList, sizePtr);
    printf("\nSize of list after being destroyed: %d",*sizePtr);






}
