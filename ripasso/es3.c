/*
author: Marco Giorgis
date: 14/09/2023
es. 3
testo
*/

#include <stdio.h>
#include <stdlib.h>

int chiediDim() { //funzione per chiedere in input l'altezza del triangolo
    int x;
    do {
        printf("inserire l'altezza del triangolo: ");
        scanf("%d", &x);
    } while(x <= 0);
    return x;
}
void ripetiCarattereRighe(int n, char c) { //procedura per ripete il carattere sulla riga
    for(int k = 0; k < n; k++) {
        printf("%c", c);
    }
}
void stampaTriangolo(int n, char c){ //procedura per stampare un triangolo
    for(int k = 1; k < n+1; k++){
        ripetiCarattereRighe(k, c);
        printf("\n");
    }
}
main(){
    char carattere;
    int dim;
    printf("inserire il carattere da ripetere: ");
    fflush(stdin);
    scanf("%c", &carattere);
    dim = chiediDim(); //funzione per chiedere in input il numero di volte
    stampaTriangolo(dim, carattere); //procedura per stampare un triangolo
}
