/*
author: Marco Giorgis
date: 03/10/2023
es. 37
testo
*/

#include <stdio.h>
#include <stdlib.h>

#define LUNG 20
#define DIM 100

typedef struct{
    char nome[LUNG];
    char cognome[LUNG];
    int temp;
} Gara;

int leggiFile(Gara atleta[]){
    int cont = 0;
    char nomeFile[LUNG];
    FILE *fp;
    printf("inserire il nome del file di input: ");
    scanf("%s", nomeFile);
    fp = fopen(nomeFile, "r");
    if(fp == NULL){
        printf("file non presente");
    } else {
        while(fscanf(fp, "%s %s %d", atleta[cont].nome, atleta[cont].cognome, &atleta[cont].temp)!=EOF){
            cont++;
        }
        fclose(fp);
    }
    return cont;
}
void stampaStruttura(Gara atleta[], int n){
    for(int k = 0; k < n; k++){
        printf("%s %s %d\n", atleta[k].nome, atleta[k].cognome, atleta[k].temp);
    }
}
void calcoloMaggiore(Gara atleta[], int n){
    int max = atleta[0].temp;
    int vettIndici[DIM]; //vettore per salvare gli indici di possibili parimeriti
    int cont = 0; //contatore di possibili parimeriti
    for(int k = 1; k < n; k++){
        if(atleta[k].temp > max){ //controllo maggiore
            max = atleta[k].temp;
        }
    }
    for(int j = 0; j < n; j++){
        if(max == atleta[j].temp){ //controllo parimeriti
            vettIndici[cont] = j;
            cont ++;
        }
    }
    for(int w = 0; w < cont; w++){ //stampa
        printf("vincitore: %s %s\n", atleta[vettIndici[w]].nome, atleta[vettIndici[w]].cognome);
    }
}
int main(){
    Gara atleta[DIM];
    int dim = leggiFile(atleta);
    stampaStruttura(atleta, dim);
    calcoloMaggiore(atleta, dim);
    return 0;
}
