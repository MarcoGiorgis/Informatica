/*
author: Marco Giorgis
date: 14/09/2023
es. 4
testo
*/

#include <stdio.h>
#include <stdlib.h>

int chiediDim() { //funzione per chiedere in input l'altezza del triangolo
    int x;
    do {
        printf("inserire il valore: ");
        scanf("%d", &x);
    } while(x <= 0);
    return x;
}
void ripetiCarattereRighe(int n, char c) { //procedura per ripete il carattere sulla riga
    for(int k = 0; k < n; k++) {
        printf("%c", c);
    }
    printf("\n");
}
void stampaCarattere(int n, char c){
    for(int k = 0; k < n; k++){
        ripetiCarattereRighe(n, c);
    }
}
void stampaStriscie(int n, int lung, char c1, char c2){
    for(int k = 0; k < n; k++){
        if(k%2 == 0){
            stampaCarattere(lung, c1);
        } else{
            stampaCarattere(lung, c2);
        }
    }
}
main(){
    char carattere1;
    char carattere2;
    int n, lung;
    printf("inserire il carattere da ripetere: ");
    fflush(stdin);
    scanf("%c", &carattere1);
    printf("inserire il carattere da ripetere: ");
    fflush(stdin);
    scanf("%c", &carattere2);
    n = chiediDim(); //funzione per chiedere quante volte deve essere ripetuta la striscia
    lung = chiediDim(); //funzione per chiedere per quante volte deve essere
    stampaStriscie(n, lung, carattere1, carattere2);
}
