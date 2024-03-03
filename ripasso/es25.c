/*
author: Marco Giorgis
date: 26/09/2023
es. 25
testo
*/

#include <stdio.h>
#include <stdlib.h>
#define M 4
#define N 2

void caricaMat(int mat[][N]){
    for(int k=0;k<M;k++){
        for(int j=0;j<N;j++){
            printf("Inserire il valore per la posizione [%d][%d]\n",k,j);
            scanf("%d",&mat[k][j]);
        }
    }
}

void visMat(int mat[][N]){
    for(int k=0;k<M;k++){
        for(int j=0;j<N;j++){
            printf("%d ",mat[k][j]);
        }
        printf("\n");
    }
}

int asseVert(int mat[][N]){
    int cont=0;
    for(int k=0;k<M;k++) {
        for(int j=0;j<N/2;j++) {
            if (mat[k][j] == mat[k][N-1-j]) {
                cont++;
            }
        }
    }
    return cont;
}

int main(){
    int mat[M][N];
    int cont;
    caricaMat(mat);
    visMat(mat);
    cont=asseVert(mat);
    printf("I numeri simmetrici rispetto all'asse verticale sono: %d",cont);
}

