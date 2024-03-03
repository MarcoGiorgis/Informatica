/*
author:
date:
es.
testo
*/

#include <stdio.h>
#include <stdlib.h>
#define DIM 100

int chiediDim(int dim_Max) {
    int n;
    do {
        printf("Numero: ");
        scanf("%d", &n);
    } while (n < 0 || n > dim_Max);
    return n;
}

void caricaVett(float v[], int n) {
    for (int k = 0; k < n; k++) {
        printf("Elemento in posizione [%d]: ", k);
        scanf("%f", &v[k]);
    }
}

float trovaMin(float v[], int n) {
    float min = v[0]; // Inizializza min con il primo elemento
    for (int k = 1; k < n; k++) {
        if (v[k] < min) {
            min = v[k];
        }
    }
    return min;
}

float trovaMax(float v[], int n) {
    float max = v[0]; // Inizializza max con il primo elemento
    for (int k = 1; k < n; k++) {
        if (v[k] > max) {
            max = v[k];
        }
    }
    return max;
}

void bubbleSort(float v[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (v[j] < v[j + 1]) {
                float temp = v[j];
                v[j] = v[j + 1];
                v[j + 1] = temp;
            }
        }
    }
}

void stampaVett(float v[], int n) {
    for (int k = 0; k < n; k++) {
        printf("%.2f ", v[k]);
    }
    printf("\n");
}

int main() {
    float vett[DIM];
    printf("Inserisci la dimensione dell'array: ");
    int dim = chiediDim(DIM);
    caricaVett(vett, dim);
    float min = trovaMin(vett, dim);
    float max = trovaMax(vett, dim);
    bubbleSort(vett, dim);
    printf("Minimo: %.2f\n", min);
    printf("Massimo: %.2f\n", max);
    printf("Algoritmo in ordine decrescente: \n");
    stampaVett(vett, dim);

    return 0;
}
