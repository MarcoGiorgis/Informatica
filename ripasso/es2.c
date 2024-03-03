/*
author: Marco Giorgis
date: 14/09/2023
es. 2
testo
*/

#include <stdio.h>
#include <stdlib.h>

int chiediDim() { //funzione per chiedere in input il numero di volte
    int x;
    do {
        printf("inserire il numero di volte che deve essere visualizzato il carattere: ");
        scanf("%d", &x);
    } while(x <= 0);
    return x;
}
void ripetiCarattereRighe(int n, char c) { //procedura per ripete il carattere sulla riga
    for(int k = 0; k < n; k++) {
        printf("%c", c);
    }
}
void ripetiCarattereColonne(int n, char c) { //procedura che ripete il carattere sulle colonne
    for(int k = 0; k < n; k++) {
        ripetiCarattereRighe(n, c);
        printf("\n");
    }
}
main() {
    char carattere;
    int dim;
    printf("inserire il carattere da ripetere: ");
    fflush(stdin);
    scanf("%c", &carattere);
    dim = chiediDim(); //funzione per chiedere in input il numero di volte
    ripetiCarattereColonne(dim, carattere); //procedura che ripete il carattere colonne X righe
}
