/*
author: Marco Giorgis
date: 28/09/2023
es. 32
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define MIN_FORZA 5
#define MAX_FORZA 10
#define MIN_VITA 0
#define MAX_VITA 100
#define DIM 100
#define LUNG 100


typedef struct {
    char nome[LUNG];
    int forza;
    int vita;
} Mostro;

void setVita(int vita) {

    if (vita < MIN_VITA && vita > MAX_VITA) {
        printf("Valore di vita non valido.\n");
        getVita(vita);
    }
}

void setForza(int forza) {

    if (forza < MIN_FORZA && forza > MAX_FORZA) {
        printf("Valore di forza non valido.\n");
        getForza(forza);
    }
}

void getNome(char nome[]) {
    printf("Inserisci il nome del Mostro: ");
    scanf("%s", nome);
}

int getForza(int forza) {
    printf("Inserisci la forza del Mostro: ");
    scanf("%d", &forza);
    setForza(forza);
    return forza;
}

int getVita(int vita) {
    printf("Inserisci la vita del Mostro: ");
    scanf("%d", &vita);
    setVita(vita);
    return vita;
}

int getLancio(Mostro m) {
    int dado = rand() % 6 + 1;
    printf("%s attacca di %d\n", m.nome, dado * m.forza);
    return dado * m.forza;
}

void combattimento(Mostro mostroScelto, Mostro mostroAtt) {
    mostroScelto.vita=mostroScelto.vita-getLancio(mostroAtt);
    if(mostroScelto.vita< MIN_VITA) {
        printf("il mostro e' morto");
    } else {
        printf("danno arrecato\n a %s rimane %d di vita\n", mostroScelto.nome, mostroScelto.vita);
    }
}

int main() {
    srand(time(NULL));

    Mostro mazzo[DIM];
    Mostro mostroScelto;
    Mostro mostroAtt;
    int numMostri = 0;

    int scelta;
    do {
        printf("Menu:\n");
        printf("0- Esci\n");
        printf("1- Crea Mostro\n");
        printf("2- Gioca (Scegli Mostro)\n");
        printf("3- Stampa Mazzo\n");
        printf("Scelta: ");
        scanf("%d", &scelta);

        switch (scelta) {
        case 1: {
            getNome(mazzo[numMostri].nome);
            mazzo[numMostri].vita = getVita(mazzo[numMostri].vita);
            mazzo[numMostri].forza = getForza(mazzo[numMostri].forza);

            numMostri++;
            printf("Mostro creato e aggiunto al mazzo.\n");
            break;
        }
        case 2: {
            if (numMostri == 0) {
                printf("Nessun Mostro nel mazzo. Crea almeno un Mostro prima di giocare.\n");
            } else {
                int sceltaMostro, sceltaMostroAtt;
                printf("Scegli il Mostro con cui giocare (1-%d): ", numMostri);
                scanf("%d", &sceltaMostroAtt);
                printf("Scegli il Mostro che vuoi attaccare (1-%d-!%d): ", numMostri, sceltaMostroAtt);
                scanf("%d", &sceltaMostro);
                if (sceltaMostro >= 1 && sceltaMostro <= numMostri && sceltaMostroAtt >= 1 && sceltaMostroAtt <= numMostri) {
                    mostroScelto = mazzo[sceltaMostro - 1];
                    mostroAtt = mazzo[sceltaMostroAtt - 1];
                    combattimento(mostroScelto, mostroAtt);
                } else {
                    printf("Scelta non valida. Scegli un Mostro valido.\n");
                }
            }
            break;
        }
        case 3: {
            printf("Mazzo dei Mostri:\n");
            for (int i = 0; i < numMostri; i++) {
                printf("Mostro Nome: %s, Vita: %d, Forza: %d\n", mazzo[i].nome, mazzo[i].vita, mazzo[i].forza);
            }
            break;
        }
        case 0: {
            printf("Uscita dal programma.\n");
            break;
        }
        default: {
            printf("Scelta non valida. Riprova.\n");
            break;
        }
        }
    } while (scelta != 0);

    return 0;
}
