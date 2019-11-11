public class UpperTriangularMatrix {
    private int matSize; 
    private int matVal[]; 
    
    public UpperTriangularMatrix(){
        
    }

    public UpperTriangularMatrix(int n) {
        
        if (n <= 0){
            n = 1;
        }
        this.matSize = n;
        this.matVal = new int[(n+1)/2];
        for (int i = 0; i < matVal.length; i++){
            this.matVal[i] = 0;
        }
    }

    public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException{
        try {
            
            if (upTriM.isUpperTr() == false){
                throw new IllegalArgumentException("Error: not upper triangular")
            }
            else {
                this.matSize = upTriM.getRows(); 
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: not upper triangular");
        }
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
        int matValLen = this.matVal.length;
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