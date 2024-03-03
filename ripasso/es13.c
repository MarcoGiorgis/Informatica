/*
author: Marco Giorgis
date: 16/09/2023
es. 13
testo
*/

#include <stdio.h>
#include <stdlib.h>

#define DIM 100

int chiediDim(int dim_max){
    int x;
    do{
        printf("inserire la dimensione del vettore: ");
        scanf("%d", &x);
    } while(x < 0 || x > dim_max);
    return x;
}
void caricaVettore(float vett[], int n){
    for(int k = 0; k < n; k++){
        printf("inserire il valore in posizione [%d]", k);
        scanf("%f", &vett[k]);
    }
}
void calcoloVettore(float vett[], int n, float *sommaP, float *sommaD){ //procedura per somma elementi in posizione pari e dispari
    for(int k = 0; k < n; k++){
        if(k%2 == 0)
            *sommaP = *sommaP + vett[k];
        else
            *sommaD = *sommaD + vett[k];
    }
}
main(){
    float vett[DIM];
    int dim = chiediDim(DIM);
    float sommaPari = 0, sommaDispari = 0;
    caricaVettore(vett, dim);
    calcoloVettore(vett, dim, &sommaPari, &sommaDispari);
    printf("somma pari: %f\n", sommaPari);
    printf("somma dispari: %f", sommaDispari);
}
