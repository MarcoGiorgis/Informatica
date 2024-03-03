/*
author: Marco Giorgis
date: 14/09/2023
es. 8
testo
*/

#include <stdio.h>
#include <stdlib.h>

void POT2(int *x){ //procedura che eleva alla seconda il parametro
    *x = *x * *x;
}
main(){
    int num;
    printf("inserire un numero: ");
    scanf("%d", &num);
    POT2(&num);
    printf("%d", num);
}
