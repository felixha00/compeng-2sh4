#include <stdio.h>
#include <math.h>


void print_vector(double array[], int size)
{
  for (int i=0; i<size;i++)
  {
    printf("Component %d: %f\n",i+1,array[i]); // prints out the value of the component
  }
}

void add_vectors(double vector1[],double vector2[],double vector3[], int n)
{
    printf("---- add_vectors ----\n");
  for (int i = 0; i < n; i++){
    vector3[i] = vector1[i]+vector2[i]; // adds component
    printf ("%f\n",vector3[i]); // print vector
  }

}

double scalar_prod(double vector1[], double vector2[], int n){

  double scal_prod=0;
   for (int i = 0; i < n; i++){
     scal_prod += vector1[i]*vector2[i]; // multiplies vector
   }
   return scal_prod;
}

double norm2 (double vector1[], double vector2[], int n){

  double l2norm = 0;

  l2norm = sqrt(scalar_prod(vector1, vector1 , n)); // l2 norm of vector using scalar_prod() l2 norm square roots the scalar prod.

  return l2norm;
}

int main(void){

  double vectorx[] = {1,2,3};
  double vectory[] = {4,5,6};
  double vectorsum[] = {0,0,0};

  print_vector(vectorx, 3);
  add_vectors(vectorx, vectory, vectorsum, 3);

  printf("---- scalar_prod ----\n");
  printf("%f\n",scalar_prod(vectorx, vectory, 3));
  printf("---- norm2 ----\n");
  printf("%f", norm2(vectorx,vectory,3));
  return 0;

}
