#include <stdio.h>
#include <stdlib.h>

void main(void)
{
    char *ptr;
    char *ptr2 = malloc(sizeof(ptr));
    // printing the size of double pointer variable
    printf("Size of double pointer is %ld bytes", sizeof(ptr2));
}