/*
author: Marco Giorgis
date:
es.
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
bool isTriangolo(float x, float y, float z) {
    bool verificato = false;
    if(x < y+z && y < x+z && z < x+y) {
        verificato = true;
    }
    return verificato;
}
bool isIsoscele(float a, float b, float c) {
    bool eIsoscele = false;
    if(isTriangolo(a, b, c)== true) {
        if((a==b) || (c==a) || (c==b)) {
            eIsoscele = true;
        }
    } else {
        printf("non è un triangolo\n");
    }
    return eIsoscele;
}
main() {
    float x,y,z;
    printf("inserire le misure del triangolo: ");
    scanf("%f %f %f", &x, &y, &z);
    if(isIsoscile(x, y, z)==true)
        printf("è un triangolo isoscele");
    else
        printf("non è un triangolo isoscle");
}
