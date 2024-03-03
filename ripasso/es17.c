/*
author: Marco Giorgis
date: 19/09/2023
es. 17
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define DIM 100

int isVocale(char car) {
    return (car == 'a' || car == 'e' || car == 'i' || car == 'o' || car == 'u' ||
            car == 'A' || car == 'E' || car == 'I' || car == 'O' || car == 'U');
}
void rimuoviVocale(char *str){
    int j = 0;
    int cont = strlen(str);
    for(int k = 0; k < cont; k++){
        if(isVocale(str[k])==false){
                str[j++] = str[k];
        }
    }
    str[j] = "\0";
}
int main(){
    char str[DIM]; //stringa iniziale e stringa finale
    int j = 0;
    printf("inserire una stringa: ");
    scanf("%s", str);
    rimuoviVocale(str);
    printf("%s", str);
    return 0;
}
