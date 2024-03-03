/*
author: Marco Giorgis
date: 23/09/2023
es. 19
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define DIM 100

bool isVocale(char car) {
    return (car == 'a' || car == 'e' || car == 'i' || car == 'o' || car == 'u' ||
            car == 'A' || car == 'E' || car == 'I' || car == 'O' || car == 'U');
}
bool vocaliDispari(char str[]){
    int n = strlen(str);
    bool contVocali = true;
    int cont = 0;
    for(int k = 0; k < n; k++){
        if(isVocale(str[k])==true){
            cont++;
        }
    }
    if(cont%2 == 0){
        contVocali = false;
    }
    return contVocali;
}
int main(){
    char str[DIM];
    printf("inserire la stringa: ");
    scanf("%s", str);
    if(vocaliDispari(str)==true)
        printf("numero di vocali dispari");
    else
        printf("numero di vocali pari");
    return 0;
}
