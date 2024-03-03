/*
author:
date:
es.
testo
*/

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isVocale(char car) {
    return (car == 'a' || car == 'e' || car == 'i' || car == 'o' || car == 'u' ||
            car == 'A' || car == 'E' || car == 'I' || car == 'O' || car == 'U');
}

void rimuoviVocali(char *stringa) {
    int len = strlen(stringa);
    int i, j = 0;
    for (i = 0; i < len; i++) {
        if (!isVocale(stringa[i])) {
            stringa[j++] = stringa[i];
        }
    }
    stringa[j] = '\0';
}

int main() {
    char stringa[100];
    printf("Inserisci una stringa: ");
    scanf("%s", stringa);
    rimuoviVocali(stringa);
    printf("Stringa senza vocali: %s\n", stringa);
    return 0;
}

