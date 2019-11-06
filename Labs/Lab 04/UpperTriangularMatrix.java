import Matrix;

public class UpperTriangularMatrix implements Matrix {
    private int matSize; 
    private int matVal[]; 
    
    public UpperTriangularMatrix(int n) {
        
        if (n <= 0){
            n = 1;
        }
        this.matSize = n;
        Matrix mat = new Matrix(this.matSize,this.matSize);
    }

    public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException{
        
    }

    public int getDim(){
        return this.matSize;
    }

    public int getElement(int i, int j) throws IndexOutOfBoundsException {
        try {
            return this.mat[i][j]; // CURRENTLY WRONG
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid Indexes");
            return -1;
        }

        
        
    }

    public boolean setElement(int x, int i, int j){
        if (this.numRow > i || this.numRow > j){ // make sure ij does not exceed reference dimension
            return false;
        }
        else {
            this.mat[i][j] = x;
            return true;
        }

    }

    public Matrix fullMatrix (){
        return null;
    }

    public void print1DArray(){
        int matValLen = matVal.length();
        for (int i = 0; i < matValLen; i++){
            System.out.printf("%d  ", this.matVal[i]);
        }
        
    }

    public String toString(){
        Matrix mat = new Matrix(this);
        String matOut = "";
        for (int i = 0; i < this.numRow; i++){
            for (int j = 0; j < this.numCol; j++){
                matOut = ((this.getElement(i, j)).toString + " " + matOut);
            }
        }
        matOut += "\n";
    }


    }

    public int getDet(){
        Matrix mat = new Matrix(this);
        int det;
        for (int i = 0; i < this.matSize; i++){
            for (int j = 0; i < this.matSize; j++){
                if (i==j){
                    det *= mat.getElement(i, j);
                }
            }
        }
        return det;
    }

    public double[] effSolve(double[] b) throws IllegalArgumentException{

    }
}