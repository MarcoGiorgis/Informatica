/*
author: Marco Giorgis
date: 05/10/2023
es. prova verifica
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LUNG 20

void calcoloMedia(char nomeFile[]){
    char data[LUNG];
    char professore[LUNG];
    char tipoVerifica[LUNG];
    char nome[LUNG];
    float voto;
    float somma = 0;
    int cont = 0;
    float media;
    FILE *fp;
    fp = fopen(nomeFile, "r");
    if(fp == NULL){
        printf("file non presente");
    } else {
        while(fscanf(fp, "%s %s %s %s %f", data, professore, tipoVerifica, nome, &voto)!=EOF){
            somma = somma + voto;
            cont ++;
        }
        fclose(fp);
    }
    media = somma / cont;
    printf("Nella classe 4B ROB sono stati raccolti %d voti con voto medio %f", cont, media);
}
void calcoloMediaSingolo(char nomeFile[]){
    char data[LUNG];
    char professore[LUNG];
    char tipoVerifica[LUNG];
    char nome[LUNG];
    char nomeAlunno[LUNG];
    float voto;
    float somma = 0;
    int cont = 0;
    float media;
    FILE *fp;
    printf("\ninserire il nome: ");
    scanf("%s", nomeAlunno);
    fp = fopen(nomeFile, "r");
    if(fp == NULL){
        printf("file non presente");
    } else {
        while(fscanf(fp, "%s %s %s %s %f", data, professore, tipoVerifica, nome, &voto)!=EOF && cont < 2){
            if(strcmp(nome, nomeAlunno)==0){
                somma = somma + voto;
                cont ++;
            }
        }
        fclose(fp);
    }
    media = somma / cont;
    printf("Alunno %s media: %d", nomeAlunno, media);
}
main(){
    char nomeFile[LUNG];
    printf("inserire il nome del file: ");
    scanf("%s", nomeFile);
    calcoloMedia(nomeFile);
    calcoloMediaSingolo(nomeFile);
}
