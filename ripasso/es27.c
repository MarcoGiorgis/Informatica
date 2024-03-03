/*
author: Marco Giorgis
date: 26/09/2023
es. 27
testo
*/

#include <stdio.h>
#include <stdlib.h>
#define DIM_MAX 10


int chiediDim(int dim_max) {
    int x;
    do {
        printf("Inserire una dimensione: \n");
        scanf("%d",&x);
    } while(x < 0 || x > dim_max);
    return x;
}

void caricaMat(int mat[][DIM_MAX], int r, int c) {
    for(int k = 0; k < r; k++) {
        for(int j = 0; j < c; j++) {
            printf("Inserire il valore per la posizione [%d][%d]\n",k,j);
            scanf("%d",&mat[k][j]);
        }
    }
}

void visMat(int mat[][DIM_MAX], int r, int c) {
    for(int k = 0; k < r; k++) {
        for(int j = 0; j < c; j++) {
            printf("%d ",mat[k][j]);
        }
        printf("\n");
    }
}


int minMat(int mat[][DIM_MAX],int r, int c) {
    int min=mat[0][0];
    for(int k = 0; k < r; k++) {
        for(int j = 1; j <= c; j++) {
            if(min>mat[k][j]) {
                min=mat[k][j];
            }
        }
    }
    return min;
}

int maxMat(int mat[][DIM_MAX],int r, int c) {
    int max=mat[0][0];
    for(int k = 0; k < r; k++) {
        for(int j = 1; j < c; j++) {
            if(max<mat[k][j]) {
                max=mat[k][j];
            }
        }
    }
    return max;
}


float mediaMat(int mat[][DIM_MAX], int r, int c) {
    float media=0;
    int n=r*c;
    for(int k=0; k<r; k++) {
        for(int j=0; j<c; j++) {
            media=media+mat[k][j];
        }
    }
    media=media/n;
    return media;
}

int main() {
    int mat[DIM_MAX][DIM_MAX];
    int r=chiediDim(DIM_MAX);
    int c=chiediDim(DIM_MAX);
    int min;
    int max;
    float media;
    caricaMat(mat,r,c);
    visMat(mat,r,c);
    min=minMat(mat,r,c);
    max=maxMat(mat,r,c);
    media=mediaMat(mat,r,c);
    printf("Il valore minimo e': %d \n",min);
    printf("Il valore massimo e': %d \n",max);
    printf("La media vale: %.2f",media);
}
