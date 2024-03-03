/*
author: Marco Giorgis
date: 05/10/2023
es. prova verifica
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DIM 100
#define LUNG 20

typedef struct {
    char data[LUNG];
    char professore[LUNG];
    char tipoVerifica[LUNG];
    char nome[LUNG];
    float voto;
} Struttura;

typedef struct {
    char studente[LUNG];
    float voto_media;
} Studente;

typedef struct {
    char studente[LUNG];
    float voto_media;
} Studenti;

int caricaMatriceCalcoloMedia(Struttura registro[]) {
    float somma = 0;
    float media;
    int cont = 0;
    char nomeFile[LUNG];
    FILE *fp;
    printf("inserire il nome del file di input: ");
    scanf("%s", nomeFile);
    fp = fopen(nomeFile, "r");
    if(fp == NULL) {
        printf("file non presente");
    } else {
        while(fscanf(fp, "%s %s %s %s %f", registro[cont].data, registro[cont].professore,
                     registro[cont].tipoVerifica, registro[cont].nome, &registro[cont].voto)!=EOF) {
            somma = somma + registro[cont].voto;
            cont ++;
        }
        fclose(fp);
    }
    media = somma / cont;
    printf("Nella classe 4B ROB sono stati raccolti %d voti con voto medio %f\n", cont, media);
    return cont;
}
void stampaStruttura(Struttura registro[], int n) {
    for(int k = 0; k < n; k++) {
        printf("%s %s %s %s %.2f\n", registro[k].data, registro[k].professore,
               registro[k].tipoVerifica, registro[k].nome, registro[k].voto);
    }
}
int ricercaNome(char nomeRicerca[], Struttura registro[], float *somma, int n) {
    int k = 0;
    int tro = 0;
    printf("inserire il nome da ricercare: ");
    scanf("%s", nomeRicerca);
    while ((k < n) && (tro != 2)) {
        if(strcmp(nomeRicerca, registro[k].nome) == 0) {
            *somma = *somma + registro[k].voto;
            tro ++;
            k++;
        } else {
            k++;
        }
    }
    return tro;
}
void calcoloMediaSingolo(Struttura registro[], int n, Studente valutazione) { //calcolo la singola media
    char nomeRicerca[LUNG];
    int tro = 0, k = 0;
    float media, somma = 0;
    do {
        tro = ricercaNome(nomeRicerca, registro, &somma, n);
        if(tro == 0)
            printf("nome ricercato non presente\n");
        else
            media = somma / tro;
    } while (tro == 0);
    strcpy(valutazione.studente, nomeRicerca);
    valutazione.voto_media = media;
    char nomeFile[LUNG];
    FILE *fp;
    printf("inserire il file di output: ");
    scanf("%s", nomeFile);
    fp = fopen(nomeFile, "w");
    if(fp == NULL) {
        printf("file non presente");
    } else {
        fprintf(fp, "%s %f", valutazione.studente, valutazione.voto_media);
        fclose(fp);
        printf("file caricato con successo\n");
    }
    //printf("Alunno [%s] media: [%.2f]", nomeRicerca, media);
}
void calcoloMedie(Struttura registro[], Studenti valutazioni[], int n) {
    int j = 0;
    for(int j = 0; j < n; j++) {
        float somma = 0, media = 0;
        int cont = 1;
        strcpy(valutazioni[j].studente, registro[j].nome);
        somma = somma + registro[j].voto;
        for(int k = j+1; k < n; k++) {
            if(strcmp(registro[j].nome, registro[k].nome) == 0) {
                somma = somma + registro[k].voto;
                cont ++;
            } else {
                k++;
            }
        }
        valutazioni[j].voto_media = somma / cont;
    }
}
void stampaStrutturaValutazioni(Studenti valutazioni[], int n) {
    for(int k = 0; k < n/2; k++) {
        printf("%s %f\n", valutazioni[k].studente, valutazioni[k].voto_media);
    }
}
void caricaFile3(Studenti valutazioni[], int n) {
    char nomeFile[LUNG];
    FILE *fp;
    printf("inserire il file di output: ");
    scanf("%s", nomeFile);
    fp = fopen(nomeFile, "w");
    if(fp == NULL) {
        printf("file non presente");
    } else {
        for(int k = 0; k < n/2; k++) {
            fprintf(fp, "%s %f\n", valutazioni[k].studente, valutazioni[k].voto_media);
        }
        fclose(fp);
        printf("file caricato con successo\n");
    }
}
int main() {
    Struttura registro[DIM];
    Studente valutazione;
    Studenti valutazioni[DIM];
    int dim = caricaMatriceCalcoloMedia(registro);
    stampaStruttura(registro, dim);
    calcoloMediaSingolo(registro, dim, valutazione);
    calcoloMedie(registro, valutazioni, dim);
    caricaFile3(valutazioni, dim);
    stampaStrutturaValutazioni(valutazioni, dim);
    return 0;
}
