/*
author:
date:
es.
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define LUNG 100
#define DIM 50

typedef struct {
    char nome[LUNG];
    int codice;
    int goalFatti;
    int goalSubiti;
} Struttura;
int caricaCampionato(char nomeFile[], Struttura str[], int dim_max) {
    FILE *fp;
    int n = 0;

    fp = fopen(nomeFile, "r");
    if(fp == NULL) {
        printf("file non esistente");
    } else {
        while(n < dim_max && fscanf(fp, "%s %d %d %d",
                                    str[n].nome, &str[n].codice, &str[n].goalFatti,
                                    &str[n].goalSubiti)!=EOF) {
            n++;
        }
    }
    fclose(fp);
    return n;
}
int menu() {
    int scelta;
    printf("\n0 = esci\n");
    printf("1 = carica dati\n");
    printf("2 = Ordinare la tabella campionato rispetto al nome della squadra e visualizzare i dati\n");
    printf("3 = Stampare a terminale tutti i nomi e codici delle squadre che hanno fatto un numero di goal maggiore del numero dei goal subiti\n");
    printf("4 = stampare a video il nome della squadra, i goal fatti e i goal subiti\n");
    printf("scelta: ");
    scanf("%d", &scelta);
    return scelta;
}
void visualizzaStruttura(Struttura campionato[], int n) {
    for(int k = 0; k < n; k++) {
        printf("%s ", campionato[k].nome);
        printf("%d ", campionato[k].codice);
        printf("%d ", campionato[k].goalFatti);
        printf("%d ", campionato[k].goalSubiti);
        printf("\n");
    }
}
void ordinaSquadre(Struttura campionato[], int n) {
    int k, sup, sca;
    sup = n - 1;
    while (sup > 0) {
        sca = 0;
        for(k = 0; k < sup; k++) {
            if (strcmp(campionato[k].nome, campionato[k + 1].nome) > 0) {
                scambio(&campionato[k], &campionato[k + 1]);
                sca = k;
            }
        }
        sup = sca;
    }
}
void scambio(Struttura *s1, Struttura *s2) {
    Struttura temp;
    temp = *s1;
    *s1 = *s2;
    *s2 = temp;
}
void visMaggioriGoal(Struttura squadra[], int n) {
    for(int k = 0; k < n; k++) {
        if(squadra[k].goalFatti > squadra[k].goalSubiti) {
            printf("%s - %d\n", squadra[k].nome, squadra[k].codice);
        }
    }
}
int ricercaCodice(Struttura squadra[], int n, int x) {
    int tro = -1;
    int k = 0;
    while((k < n) && (tro == -1)) {
        if(x == squadra[k].codice)
            tro = x;
        else
            k++;
    }
    return tro;
}
void visCodiceCompleto(Struttura squadra[], int x) {
    if(x != -1) {
        x = x - 1;
        printf("%s-%d-%d-%d", squadra[x].nome, squadra[x].codice, squadra[x].goalFatti, squadra[x].goalSubiti);
    } else {
        printf("valore ricercato non presente\n");
    }
}
main() {
    int scelta, codice, tro;
    bool caricato = false;
    char nomeFile[LUNG];
    Struttura campionato[DIM];

    do {
        scelta = menu();
        switch (scelta) {
        case 0:
            break;
        case 1:
            printf("inserire il nome del file: ");
            fflush(stdin);
            scanf("%s", nomeFile);
            int dim = caricaCampionato(nomeFile, campionato, DIM);
            visualizzaStruttura(campionato, dim);
            caricato = true;
            break;
        case 2:
            if(caricato == true) {
                ordinaSquadre(campionato, dim);
                visualizzaStruttura(campionato, dim);
            } else {
                printf("caricare prima la struttura\n");
            }
            break;
        case 3:
            if(caricato == true) {
                visMaggioriGoal(campionato, dim);
            } else {
                printf("caricare prima la struttura\n");
            }
            break;
        case 4:
            if(caricato == true) {
                printf("inserire un codice da ricercare: ");
                scanf("%d", &codice);
                tro = ricercaCodice(campionato, dim, codice); //non ordinato disgiunto
                visCodiceCompleto(campionato, tro);
            } else {
                printf("caricare prima la struttura\n");
            }
            break;
        }
    } while(scelta != 0);

}
