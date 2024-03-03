/*
author: Marco Giorgis
date: 14/09/2023
es. 6
testo
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool isTriangolo(float x, float y, float z){
    bool verificato = false;
    if(x < y+z && y < x+z && z < x+y){
        verificato = true;
    }
    return verificato;
}
main(){
    float x,y,z;
    printf("inserire le misure del triangolo: ");
    scanf("%f %f %f", &x, &y, &z);
    if(isTriangolo(x, y, z)==true)
        printf("può essere un triangolo");
    else
        printf("non può essere un triangolo");
}
