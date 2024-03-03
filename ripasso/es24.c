/*
author: Marco Giorgis
date: 21/09/2023
es. 24
testo
*/

#include <stdio.h>
#include <stdlib.h>
#define NR 2
#define NC 3

int matriceFile(int matrice[][NC], int nRighe, int nColonne) {
    int r = 0, c;

    FILE *fp;
    fp = fopen("matrici.txt", "r");
    if (fp == NULL) {
        printf("Errore nell'apertura del file.\n");
    } else {
        r =0;
        while (r < nRighe && fscanf(fp, "%d", &matrice[r][0]) != EOF) {
            for (int c = 1; c < nColonne; c++)
                fscanf(fp, "%d", &matrice[r][c]);
            r++;
        }
        fclose(fp);
    }
    return r;
}

void stampaMatrice(int matrice[][NC], int nr, int nc) {
    for (int x = 0; x < nr; x++) {
        for (int y = 0; y < nc; y++) {
            printf("%3d  ", matrice[x][y]);
        }
        printf("\n");
    }
}

void sommaColonne(int matrice[][NC], int vettore[], int nRighe, int nColonne) {
    for (int c = 0; c < nColonne; c++) {
        vettore[c] = 0;
        for (int r = 0; r < nRighe; r++) {
            vettore[c] += matrice[r][c];
        }
    }
}

void stampaVett(int vet[], int lim) {
    for (int c = 0; c < lim; c++) {
        printf("%d  ", vet[c]);
    }
    printf("\n");
}

int main () {
    int matrice[NR][NC];
    int riga[NC];
    int nRighe =  matriceFile(matrice, NR, NC);
    stampaMatrice(matrice, nRighe, NC);
    sommaColonne(matrice, riga, nRighe, NC);
    printf("La somma delle colonne e': \n");
    stampaVett(riga, NC);

    return 0;
}
