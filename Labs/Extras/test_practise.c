#include <stdio.h>

int isPrefix (const char* s1, const char* s2){

    if (s1 == ""){
        return 1;
    }
    for (int i = 0; s1[i] != '\0'; i++){
        if ((int)s1[i] != (int)s2[i]){
            return 0;
        }
    }
    return 1;
}

int main() {

    const char* s1 = "Bruh";
    const char* s2 = "Bruh";

    printf("%d", isPrefix(s1, s2));

}
