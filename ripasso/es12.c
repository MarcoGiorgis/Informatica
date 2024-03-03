/*
author: Marco Giorgis
date: 16/09/2023
es. 12
testo
*/

#include <stdio.h>
#include <stdlib.h>

#define DIM 11

void caricaTabellina(int vett[], int num, int n){ //procedura per caricare la tabellina in un vettore
    for(int k = 0; k < n; k++){
        vett[k] = num * k;
    }
}
void stampaVettore(int vett[], int n){
    for(int k = 0; k < n; k++){
        printf("%d ", vett[k]);
    }
}
main(){
    int vett[DIM];
    int num;
    printf("inserire il numero: ");
    scanf("%d", &num);
    caricaTabellina(vett, num, DIM);
    stampaVettore(vett, DIM);
}
