/*
author: Marco Giorgis
date:
es.
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define LUNG_MAX 100

void upper(char s[],int lunghezza) {
    char m[lunghezza+1];
    for(int k=0; k<lunghezza; k++) {
        m[k]=s[k]-32;
    }
    printf("Stringa convertita: %s \n",m);
}

int main() {
    char s[LUNG_MAX];
    int lunghezza;
    printf("Inserisci una stringa: ");
    fflush(stdin);
    gets(s);
    lunghezza=strlen(s);
    printf("Stringa base: %s \n",s);
    upper(s,lunghezza);
}
