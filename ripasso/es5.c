/*
author: Marco Giorgis
date: 14/09/2023
es. 5
testo
*/

#include <stdio.h>
#include <stdlib.h>

int chiediDim(char messaggio[]) { //funzione per chiedere in input l'altezza del triangolo
    int x;
    do {
        printf("%s", messaggio);
        scanf("%d", &x);
    } while(x <= 0);
    return x;
}
void ripetiCarattereRighe(int n, char c) { //procedura per ripete il carattere sulla riga
    for(int k = 0; k < n; k++) {
        printf("%c", c);
    }
}
void stampaRettangolo(int alt, int lung, char c){
        for(int k = 1; k < alt+1; k++){
        ripetiCarattereRighe(lung, c);
        printf("\n");
    }
}
main(){
    char carattere;
    int altezza, lunghezza;
    printf("inserire il carattere da ripetere: ");
    fflush(stdin);
    scanf("%c", &carattere);
    altezza = chiediDim("inserire l'altezza: "); //funzione per chiedere in input il numero di volte
    lunghezza = chiediDim("inserire la lunghezza: ");
    stampaRettangolo(altezza, lunghezza, carattere); //procedura per stampare un triangolo

}
