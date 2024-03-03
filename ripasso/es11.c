/*
author: Marco Giorgis
date: 14/09/2023
es. 11
testo
*/

#include <stdio.h>
#include <stdlib.h>

void CRESCENTI(int *x, int *y, int *z){
    int temp;
        if (*x > *y) {
        temp = *x;
        *x = *y;
        *y = temp;
    }
    if (*y > *z) {
        temp = *y;
        *y = *z;
        *z = temp;
    }
    if (*x > *y) {
        temp = *x;
        *x = *y;
        *y = temp;
    }
}
main(){
    int x, y, z;
    printf("inserire il valore dei tre numeri da inserire: \n");
    scanf("%d %d %d", &x, &y, &z);
    CRESCENTI(&x, &y, &z);
    printf("%d %d %d", x, y, z);
}
