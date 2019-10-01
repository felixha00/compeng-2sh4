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

  l2norm = sqrt(scalar_prod(vector1, vector2 , n)); // l2 norm of vector using scalar_prod()

  return l2norm;
}

int main(void){

  double vectorx[] = {2,4,6};
  double vectory[] = {0,1,2};
  double vectorsum[] = {0,0,0};
  double c;

  print_vector(vectorx, 3);
  add_vectors(vectorx, vectory, vectorsum, 3);


  printf("%f",scalar_prod(vectorx, vectory, 3));

  return 0;

}
