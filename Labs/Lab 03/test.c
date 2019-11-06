#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *my_strcat(const char * const str1, const char *const str2)
{
    // create a pointer that points to the string
    char *point1=&str1;
    char *point2=&str2;

    // dynamically allocate
    char *final_string=calloc((strlen(str1)+strlen(str2)+1), 1);

    //storing it.
    while(*point1!='\0')
    {
        *final_string=*point1;
        point1++;
        final_string++;
    }

    while(*point2!='\0')
    {
        *final_string=*point2;
        point2++;
        final_string++;
    }

    *final_string='\0';

    return  final_string;

}
