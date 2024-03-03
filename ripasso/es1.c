/*
author: Marco Giorgis
date: 14/09/2023
es. 1
testo
*/

#include <stdio.h>
#include <stdlib.h>

int chiediDim(){ //funzione per chiedere in input il numero di volte
    int x;
    do{
        printf("inserire il numero di volte che deve essere visualizzato il carattere: ");
        scanf("%d", &x);
    } while(x <= 0);
    return x;
}
void ripetiCarattereRighe(int n, char c){ //procedura per ripete il carattere
    for(int k = 0; k < n; k++){
        printf("%c", c);
    }
}
main(){
    char carattere;
    int dim;
    printf("inserire il carattere da ripetere: ");
    fflush(stdin);
    scanf("%c", &carattere);
    dim = chiediDim(); //funzione per chiedere in input il numero di volte
    ripetiCarattereRighe(dim, carattere);
}
