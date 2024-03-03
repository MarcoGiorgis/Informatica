/*
author: Marco Giorgis
date: 03/10/2023
es. 34
testo
*/

#include <stdio.h>
#include <stdlib.h>

#define LUNG 20
#define DIM 100


main(){
    char nomeFile[LUNG];
    float somma = 0;
    float x, media, cont = 0;
    float max, min;
    FILE *fp;
    FILE *fp1;
    printf("inserire il nome del file: ");
    scanf("%s", nomeFile);
    fp = fopen(nomeFile, "r");
    if(fp == NULL){
        printf("file non presente");
    } else {
        while(fscanf(fp, "%f", &x)!=EOF){
            if(cont == 0){
                max = x;
                min = x;
            }
            if(x > max){
                max = x;
            }
            if(x < min){
                min =x;
            }
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
        fprintf(fp1, "media: %.2f maggiore: %.2f minore: %.2f", media, max, min);
    }
    fclose(fp1);
}
