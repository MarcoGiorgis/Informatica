/*
author: Marco Giorgis
date: 14/09/2023
es. 9
testo
*
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void POT2(float *x){ //procedura che eleva alla seconda il parametro
    *x = *x * *x;
}
float IPOTENUSA(float c1, float c2){
    POT2(&c1);
    POT2(&c2);
    return sqrt(c1 + c2);
}
main(){
    float cat1, cat2; //cateto 1 e cateto 2
    float ip; //ipotenusa
    printf("inserire la misura del primo cateto: ");
    scanf("%f", &cat1);
    printf("inserire la misura del secondo cateto: ");
    scanf("%f", &cat2);
    ip = IPOTENUSA(cat1, cat2);
    printf("%f", ip);
}
