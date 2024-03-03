/*
author: Marco Giorgis
date: 19/09/2023
es. 14
testo
*/

#include <stdio.h>
#include <stdlib.h>
#define DIM 100


int chiediDim(int dim_max) {
    int x;
    do {
        printf("inserire la dimensione [%d]: ", dim_max);
        scanf("%d", &x);
    } while (x < 0 || x > dim_max);
    return x;
}
void caricaVettore(int vett[], int n) {
    for(int k = 0; k < n; k++) {
        printf("Inserisci un numero in posizione [%d]: ", k);
        scanf("%d", &vett[k]);
    }
}
void visualizzaVet(int vett[],int n) {
    for(int k=0; k<n; k++) {
        printf(" %d ",vett[k]);
    }
    printf("\n");
}


void calcoloVettore(int vett[], int n) {
    int pari[DIM];
    int disp[DIM];
    int n_pari=0;
    int n_disp=0;
    for(int k = 0; k < n; k++) {
        if(k%2 == 0) {
            if(vett[k]%2 != 0) {
                disp[n_disp]=vett[k];
                n_disp++;
            }
        } else {
            if(vett[k]%2 == 0) {
                pari[n_pari]=vett[k];
                n_pari++;
            }
        }
    }
    printf("Vettore pari: \n");
    visualizzaVet(pari,n_pari);
    printf("Vettore dispari: \n");
    visualizzaVet(disp,n_disp);
}


int main() {
    int vett[DIM];
    int dim = chiediDim(DIM);
    caricaVettore(vett, dim);
    calcoloVettore(vett, dim);
}
