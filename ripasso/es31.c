/*
author: Marco Giorgis
date: 27/09/2023
es. 31
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define LUNG 20
#define ANNO_MAX 2023
#define MAX_PRODOTTI 100

typedef struct {
    int anno;
    int mese;
    int giorno;
} Data;

typedef struct {
    char nome[LUNG];
    int quantita;
    Data data_scadenza;
} Prodotto;

int caricaArchivio(char nomeFile[], Prodotto archivio[], int max_prodotti){
    FILE *fp;
    int nProdotti = 0;

    fp = fopen(nomeFile,"r");

    if(fp == NULL) {
        printf("il file non esiste\n");
    } else {
        while(nProdotti < max_prodotti && fscanf(fp, "%s %d %d %d %d", archivio[nProdotti].nome, &archivio[nProdotti].quantita, &archivio[nProdotti].data_scadenza.anno, &archivio[nProdotti].data_scadenza.mese, &archivio[nProdotti].data_scadenza.giorno) != EOF) {

            nProdotti++;
        }
    }
    fclose(fp);
    return nProdotti;
}

void visProdotti(Prodotto archivio[], int nProdotti) {
    for(int k = 0; k < nProdotti; k++) {
        printf("%s %d %d/%d/%d \n", archivio[k].nome, archivio[k].quantita, archivio[k].data_scadenza.anno, archivio[k].data_scadenza.mese, archivio[k].data_scadenza.giorno);
    }
}
void ordinaProdotti(Prodotto v[], int n) {
    int sup, sca, k;
    sup = n - 1;

    while(sup > 0){
        sca = 0;
        for(k = 0; k < sup; k++){
            if(strcmp(v[k].nome, v[k + 1].nome) > 0){
                scambio(&v[k], &v[k + 1]);
                sca = k;
            }
        }
        sup = sca;
    }
}

void scambio(Prodotto *s1, Prodotto *s2){
    Prodotto temp;

    temp = *s1;
    *s1 = *s2;
    *s2 = temp;
}

int cercaScaduti(Prodotto archivio[], int nProdotti, Data data, FILE *fp){
    int n_scaduti = 0;
    for(int k = 0; k < nProdotti; k++){
        if(archivio[k].data_scadenza.anno < data.anno){
            fprintf(fp, "%s %d %d/%d/%d \n", archivio[k].nome, archivio[k].quantita, archivio[k].data_scadenza.anno, archivio[k].data_scadenza.mese, archivio[k].data_scadenza.giorno);
            n_scaduti++;
        } else if(archivio[k].data_scadenza.anno == data.anno && archivio[k].data_scadenza.mese < data.mese){
            fprintf(fp, "%s %d %d/%d/%d \n", archivio[k].nome, archivio[k].quantita, archivio[k].data_scadenza.anno, archivio[k].data_scadenza.mese, archivio[k].data_scadenza.giorno);
            n_scaduti++;
        } else if(archivio[k].data_scadenza.anno == data.anno && archivio[k].data_scadenza.mese == data.mese && archivio[k].data_scadenza.giorno <= data.giorno){
            fprintf(fp, "%s %d %d/%d/%d \n", archivio[k].nome, archivio[k].quantita, archivio[k].data_scadenza.anno, archivio[k].data_scadenza.mese, archivio[k].data_scadenza.giorno);
            n_scaduti++;
        }
    }
    return n_scaduti;
}

int main() {
    Prodotto archivio[MAX_PRODOTTI];
    Data data;
    char nomeFile[LUNG] = "negozio.dat";

    do{
        printf("Inserisci la data (anno mese giorno): ");
        scanf("%d %d %d", &data.anno, &data.mese, &data.giorno);
    } while(data.anno > ANNO_MAX);

    int nProdotti = caricaArchivio(nomeFile, archivio, MAX_PRODOTTI);
    ordinaProdotti(archivio, nProdotti);
    printf("\nArchivio: \n");
    visProdotti(archivio, nProdotti);

    FILE *fp;
    fp = fopen("scaduti.dat", "w");
    if(fp != NULL){
        int n_scaduti = cercaScaduti(archivio, nProdotti, data, fp);
        printf("\n%d prodotti sono scaduti e sono stati salvati nel file 'scaduti.dat'\n", n_scaduti);
        fclose(fp);
    } else {
        printf("Impossibile aprire il file 'scaduti.dat' per la scrittura.\n");
    }
    return 0;
}
