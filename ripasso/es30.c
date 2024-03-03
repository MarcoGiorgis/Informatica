/*
author: Marco Giorgis
date: 26/09/2023
es. 30
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define LUNG 20
#define DIM 100
#define DIMPUNT 3

typedef struct {
    char nome[LUNG];
    int punteggi[DIMPUNT];
    int totale;
} Concorso;

int chiediDim(int dim_max) {
    int x;
    do {
        printf("inserire il numero di partecipanti: ");
        scanf("%d", &x);
    } while (x < 0 || x > dim_max);
    return x;
}
int caricaStruttura(Concorso gara[], int nPartecipanti, int nPunteggi) {
    for(int k = 0; k < nPartecipanti; k++) {
        printf("inserire il nome del concorrente [%d]: ", k);
        fflush(stdin);
        scanf("%s", gara[k].nome);
        for(int j = 0; j < nPunteggi; j++) {
            printf("inserire il valore del punteggio [%d]: ", j);
            scanf("%d", &gara[k].punteggi[j]);
        }
    }
}
void sommaPunteggi(Concorso gara[], int n, int nPunteggi) {
    for(int k = 0; k < n; k++) {
        gara[k].totale = 0;
        for(int j = 0; j < nPunteggi; j++) {
            gara[k].totale = gara[k].totale + gara[k].punteggi[j];
        }
    }
}
void stampaStruttura(Concorso gara[], int n, int nPunteggi) {
    for(int k = 0; k < n; k++) {
        printf("%s :", gara[k].nome);
        for(int j = 0; j < nPunteggi; j++) {
            printf("%d ", gara[k].punteggi[j]);
        }
        printf("%d ", gara[k].totale);
        printf("\n");
    }
}
void maggioreProva(Concorso gara[], int n, int nPunteggi) {
    int max;
    char vincitore[DIM];
    for(int k = 0; k < nPunteggi; k++) {
        max = gara[0].punteggi[k];
        strcpy(vincitore, gara[0].nome);
        for(int j = 1; j < n; j++) {
            if(gara[j].punteggi[k] > max) {
                max = gara[j].punteggi[k];
                strcpy(vincitore, gara[j].nome);à
            }
        }
        printf("\nProva [%d] vincitore [%s] punteggio [%d]", k, vincitore, max);
    }
}
void scambio(Concorso *a, Concorso *b){
    Concorso temp;
    temp = *a;
    *a = *b;
    *b = temp;
}
void calcolaClassifica(Concorso gara[], int n) {
    int k,sup,sca;
    sup= n-1 ;
    while ( sup>0 ) {
        sca=0 ;
        for (k = 0; k < sup ; k++) {
            if (gara[k].totale < gara[k+1].totale){
                scambio(&gara[k], &gara[k+1]);
                sca=k ;
            }
        }
        sup=sca ;
    }
}
void stampaClassifica(Concorso gara[], int n){
    printf("\n");
    printf("CLASSIFICA: \n");
    for(int k = 0; k < n; k++){
        printf("[%s][%d]\n", gara[k].nome, gara[k].totale);
    }
}
main() {
    Concorso gara[DIM];
    int dim = chiediDim(DIM);
    caricaStruttura(gara, dim, DIMPUNT);
    sommaPunteggi(gara, dim, DIMPUNT);
    stampaStruttura(gara, dim, DIMPUNT);
    maggioreProva(gara, dim, DIMPUNT);
    calcolaClassifica(gara, dim);
    stampaClassifica(gara, dim);
}
