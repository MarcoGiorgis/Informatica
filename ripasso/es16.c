/*
author: Marco Giorgis
date: 20/09/2023
es. 16
testo
*/

#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define LIM_MIN 32
#define LIM_MAX 126
#define DIM 100

int main(){
    srand(time(NULL));
    char s[DIM];
    int n;
    printf("Inserisci n: \n");
    scanf("%d",&n);
    for(int k = 0;k < n;k++){
        s[k]= LIM_MIN + rand()%(LIM_MAX-LIM_MIN+1);
    }
    puts(s);
    return 0;
}

