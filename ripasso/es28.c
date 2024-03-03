/*
author: Marco Girgios
date: 27/09/2023
es. 28
testo
*/

//nelle strutture si utilizza l'indirizzo per ritonarnare più risulati e per modificare la variabile
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DIM 20

typedef struct {
    char nomeSquadra[DIM];
    int goalFatti;
    int goalSubiti;
} Squadra;

int chiediDim(int dim_max) {
    int x;
    do {
        printf("inseire il numero di squadre: ");
        scanf("%d", &x);
    } while(x < 0 || x > dim_max);
    return x;
}
void caricaStruttura(Squadra campionato[], int n) {
    for(int k = 0; k < n; k++) {
        printf("inserire il nome della squadra: ");
        scanf("%s", campionato[k].nomeSquadra);
        printf("inserire il numero di goal fatti: ");
        scanf("%d", &campionato[k].goalFatti);
        printf("inserire il numero di goal subiti: ");
        scanf("%d", &campionato[k].goalSubiti);
    }
}
void stampaStruttura(Squadra campionato[], int n) {
    for(int k = 0; k < n; k++) {
        printf("%s %d %d\n", campionato[k].nomeSquadra, campionato[k].goalFatti, campionato[k].goalSubiti);
    }
}
void stampaSquadraGoalMaggiori(Squadra campionato[], int n) {
    printf("Squadra con goal fatti maggiori dei goal subiti: ");
    for(int k = 0; k < n; k++) {
        if(campionato[k].goalFatti > campionato[k].goalSubiti) {
            printf("%s ", campionato[k].nomeSquadra);
        }
    }
}
void ricercaSquadra(Squadra campionato[], int n, char squadra[]) {
    int k = 0;
    int tro = -1;
    while(k < n && tro == -1) {
        if(strcmp(campionato[k].nomeSquadra, squadra) == 0) {
            printf("goal fatti: %d goal subiti: %d", campionato[k].goalFatti, campionato[k].goalSubiti);
            tro = 1;
        } else {
            k++;
        }
    }
    if(tro == -1) {
        printf("squadra ricercata non presente");
    }
}
main() {
    int dim = chiediDim(DIM);
    char nomeSquadra[DIM];
    Squadra campionato[dim];
    caricaStruttura(campionato, dim);
    stampaStruttura(campionato, dim);
    stampaSquadraGoalMaggiori(campionato, dim);
    printf("\ninserire la squadra da ricercare: ");
    scanf("%s", nomeSquadra);
    ricercaSquadra(campionato, dim, nomeSquadra);
}
