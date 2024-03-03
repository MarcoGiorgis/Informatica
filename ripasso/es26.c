/*
author: Marco Giorgis
date: 26/09/2023
es. 26
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define DIM_MAX 10


int chiediDim(int n_max) {
    int x;
    do {
        printf("Inserire una dimensione: \n");
        scanf("%d",&x);
    } while(x<0||x>n_max);
    return x;
}

void caricaMat(int mat[][DIM_MAX], int r, int c) {
    for(int k=0; k<r; k++) {
        for(int j=0; j<c; j++) {
            printf("Inserire il valore per la posizione [%d][%d]\n",k,j);
            scanf("%d",&mat[k][j]);
        }
    }
}

void visMat(int mat[][DIM_MAX], int r, int c) {
    for(int k=0; k<r; k++) {
        for(int j=0; k<c; k++) {
            printf("%d ",mat[k][j]);
        }
        printf("\n");
    }
}

bool eSpeculare(int mat[][DIM_MAX], int r, int c) {
    bool speculare=true;
    int k = 0, j = 0;
    while (k < r && speculare == true) {
        while (j < c / 2 && speculare == true) {
            if (mat[k][j] != mat[k][c - 1 - j]){
                speculare = false;
            }
            j++;
        }
        k++;
    }
    return speculare;
}


int main() {
    int mat[DIM_MAX][DIM_MAX];
    int r=chiediDim(DIM_MAX);
    int c=chiediDim(DIM_MAX);
    bool spec;
    caricaMat(mat,r,c);
    visMat(mat,r,c);
    spec=eSpeculare(mat,r,c);
    if(spec==true){
        printf("La matrice e' speculare rispetto all'asse verticale\n");
    }else{
        printf("La matrice non e' speculare rispetto all'asse verticale\n");
    }
    return 0;
}

