/*
author: Marco Giorgis
date: 03/10/2023
es. 33
testo
*/

#include <stdio.h>
#include <stdlib.h>

#define LUNG 20

main(){
    char nomeFile[LUNG];
    float somma = 0;
    float x, media, cont = 0;
    FILE *fp;
    FILE *fp1;
    printf("inserire il nome del file: ");
    scanf("%s", nomeFile);
    fp = fopen(nomeFile, "r");
    if(fp == NULL){
        printf("file non presente");
    } else {
        while(fscanf(fp, "%f", &x)!=EOF){
            somma = somma + x;
            cont ++;
        }
        fclose(fp);
    }
    media = somma / cont;
    printf("inserire il nome del secondo file: ");
    scanf("%s", nomeFile);
    fp1 = fopen(nomeFile, "w");
    if(fp == NULL){
        printf("file non presente");
    } else {
        fprintf(fp1, "%.2f", media);
    }
    fclose(fp1);
}
