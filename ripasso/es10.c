/*
author: Marco Giorgis
date: 14/09/2023
es. 10
testo
*/

#include <stdio.h>
#include <stdlib.h>

/*
simulazione
num = 123
cifra 3 2 1
ris 0 3 32 321
num 123 12 1 0
*/

int INVERTI(int num){
    int risultato = 0;
    while (num > 0) {
        int cifra = num % 10; // Estrae l'ultima cifra
        risultato = risultato * 10 + cifra; // Aggiunge la cifra invertita al risultato
        num = num / 10; // Rimuove l'ultima cifra dal numero originale
    }

    return numeroInvertito;
}
main(){
    int num, inversione;
    printf("inserire il numero: ");
    scanf("%d", &num);
    inversione = INVERTI(num);
    printf("%d", inversione);
}
