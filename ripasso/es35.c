/*
author: Marco Giorgis
date: 03/10/2023
es. 35
testo
*/

#include <stdio.h>
#include <stdlib.h>

#define LUNG 20

main(){
    FILE *fp;
    char carattere;
    char parola[LUNG];
    char nomeFile[LUNG];
    int cont = 0;
    int contParole = 0;
    printf("inserire il nome del file di input: ");
    scanf("%s", nomeFile);
    fp = fopen(nomeFile, "r");
    if(fp == NULL){
        printf("file non presente");
    } else {
        while(fscanf(fp, "%c", &carattere)!=EOF){
            if(carattere != ' '){
                parola[cont] = carattere;
                cont ++;
            } else {
                contParole ++;
                cont = 0;
            }
        }
        fclose(fp);
    }
    printf("\nnumero di parole: %d", contParoles);
}
