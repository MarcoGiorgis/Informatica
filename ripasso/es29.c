/*
author: Marco Giorgis
date:26/09/2023
es. 29
testo
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define LUNG 20
#define MAX_GIORNI 7
#define DIM 20
#define PERC 10

typedef struct{
    char nome[LUNG];
    float valori[MAX_GIORNI];
}Quotazioni;


int caricaVett(Quotazioni vett[], int ngiorni, int nAzioni){
    char nomefile[LUNG];
    int numAzioni = 0;
    FILE *fp;
    printf("inserisci il nome del file: ");
    fflush(stdin);
    scanf("%s", nomefile);
    fp = fopen(nomefile, "r");
    if(fp ==  NULL){
        printf("file non trovato");
    }else{
        while(numAzioni < nAzioni && fscanf(fp, "%s", &vett[numAzioni].nome) != EOF){
            for(int k = 0; k < ngiorni; k++){
                fscanf(fp, "%f", &vett[numAzioni].valori[k]);
            }
            numAzioni ++;
        }
    }
    fclose(fp);
    return numAzioni;
}

int caloAzioni(Quotazioni vett[], int n, int ngiorni, int calo){
    int cont, i;
    float dif;
    int naziende = 0;
    for(int k = 0; k < n; k++){
        cont = 0;
        i = 1;
        while(i < ngiorni && cont == 0){
            dif = vett[k].valori[i - 1] - vett[k].valori[i];
            if((dif * 100 / vett[k].valori[i - 1]) > calo){
                cont ++;
            }
            i++;
        }
        if(cont != 0){
            printf("l'azienda %s ha avuto un calo maggiore del %d%%\n", vett[k].nome, calo);
            naziende ++;
        }

    }
    return naziende;
}

void visAzioni(Quotazioni vett[], int n, int ngiorni){
    for(int k = 0; k < n; k++){
        printf("%s: ", vett[k].nome);
        for(int j = 0; j < ngiorni; j++){
            printf("%.2f   ", vett[k].valori[j]);
        }
        printf("\n");
    }
}

int cercaValoreMagg(Quotazioni vett[], int n, int g){
    float max = vett[g].valori[0];
    int indMax;
    for(int k = 1; k < n; k++) {
        if(vett[g].valori[k] > max) {
            max = vett[g].valori[k];
            indMax = k;
        }
    }
    return indMax;
}

main(){
    Quotazioni vett[DIM];
    int dim = caricaVett(vett, MAX_GIORNI, DIM);
    int naziende, max_val;
    int ng = 0;

    visAzioni(vett, dim, MAX_GIORNI);
    naziende = caloAzioni(vett, dim, MAX_GIORNI, PERC);
    printf("le aziende che hanno avuto un calo maggiore del %d%% sono state %d\n", PERC, naziende);
}
