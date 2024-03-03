/*
author: Marco Giorgis
date: 21/09/2023
es. 22
testo
*/

#include <stdio.h>
#include <stdlib.h>

#define DIM 10

int chiediDim(int dim_max) {
    int n;
    do {
        printf("inserire la dimensione: ");
        scanf("%d", &n);
    } while (n < 0 || n > dim_max);
    return n;
}
void caricaMatrice(int mat[][DIM], int n){
    for(int k = 0; k < n; k++){
        for(int j = 0; j < n; j++){
            printf("inserire il valore in posizione [%d][%d]", k, j);
            scanf("%d", &mat[k][j]);
        }
    }
}
void stampaMatrice(int mat[][DIM], int n){
    for(int k = 0; k < n; k++){
        for(int j = 0; j < n; j++){
            printf("%d ", mat[k][j]);
        }
        printf("\n");
    }
}
void calcoloDiagonali(int mat[][DIM], int n, int *sp, int *sd){
    int j = n-1;
    for(int k = 0; k < n; k++){
        *sp = *sp + mat[k][k];
        *sd = *sd + mat[k][j--];
    }
}
main(){
    int mat[DIM][DIM];
    int dim = chiediDim(DIM);
    int sommaDP = 0, sommaDS = 0; //somma diagonale principale e secondaria
    caricaMatrice(mat, dim);
    stampaMatrice(mat, dim);
    calcoloDiagonali(mat, dim, &sommaDP, &sommaDS);
    printf("somma diagonale principale: %d\n somma diagonale secondaria: %d", sommaDP, sommaDS);
}
