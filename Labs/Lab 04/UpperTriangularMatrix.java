
public class UpperTriangularMatrix {
    private int matSize;
    private int matVal[];

    public UpperTriangularMatrix(int n) {

        if (n <= 0) {
            n = 1;
        }
        this.matSize = n;
        this.matVal = new int[n * (n + 1) / 2];
    }

    

    public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException {

        if (upTriM.isUpperTr() == true) {
            int count = 0;
            int i = 0,j = 0, k =0;
            this.matSize = upTriM.getRows();
            this.matVal = new int[this.matSize * (this.matSize + 1) / 2];
            
            // algorithm for organizing the rows in efficient form
            while (i != upTriM.getRows()) { 
                   for (k = i; k < upTriM.getRows(); k++){
                    this.matVal[count] = upTriM.getElement(i, k);
                    count++;
                   }
                   i++;
            }


        } else {
            throw new IllegalArgumentException("The matrix is not upper triangular");
        }

    }

    public int getDim() {
        return this.matSize;
    }

    public int getElement(int i, int j) throws IndexOutOfBoundsException {

            if (i >= 0 && i < this.matSize && j >= 0 && j < this.matSize) {
                int l = 0; int count = 0;
                while (l != this.matSize) {
                    for (int k = l; k < this.matSize; k++){
                     if (l==i && k==j){
                        return this.matVal[count];
                     }
                     count++;
                    }
                    l++;
                }
                return 0; // returns zero if not found
                
            }
            

            else {
            System.out.println("Error: Invalid Indexes");
            return -1;
            }
          

    }

    public void setElement(int x, int i, int j) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (i >= j && x != 0) { // make sure ij does not exceed reference dimension
            throw new IllegalArgumentException("Error: i,j references under the diagonal");
        } else if (i >= 0 && i <= this.matSize && j >= 0 && j <= this.matSize) {
            int l = 0; int count = 0;
                while (l != this.matSize) {
                    for (int k = l; k < this.matSize; k++){ // checks every next column with one over at the start.
                     if (l==i && k==j){
                        this.matVal[count] = x; 
                     }
                     count++;
                    }
                    l++;
                }

        } else {
            throw new IndexOutOfBoundsException("Error: Invalid Indexes");
        }

    }

    public Matrix fullMatrix() {
        int i = 0, k = 0, count=0;
        Matrix fullMat = new Matrix(this.matSize, this.matSize);

        while (i != this.matSize) {
            for (k = i; k < this.matSize; k++){
             fullMat.setElement(this.matVal[count], i, k);
             count++;
            }
            i++;
        }
        return fullMat;
    }

    public void print1DArray() {
        int matValLen = matVal.length;
        for (int i = 0; i < matValLen; i++) {
            System.out.printf("%d  ", this.matVal[i]);
        }

    }

    public String toString() {
        Matrix mat = fullMatrix();
        String matOut = "";
        for (int i = 0; i < this.matSize; i++) {
            for (int j = 0; j < this.matSize; j++) {
                matOut += (mat.getElement(i, j)) + "\t";
            }
            matOut += "\n";
        }
        return matOut;
    }

    public int getDet() {
        Matrix mat = fullMatrix();
        int det = 1;
        for (int i = 0; i < this.matSize; i++) {
            for (int j = 0; j < this.matSize; j++) {
                if (i == j) {
                    det *= mat.getElement(i, j);
                }
            }
        }
        return det;
    }

    public double[] effSolve(double[] b) throws IllegalArgumentException {
        double x[] = new double[this.matSize];
        if (this.getDet() == 0 || b.length != this.matSize){ throw new IllegalArgumentException("Determinant is 0 or b is incorrect size");}
        else {
            // x1 = b1/a1,1
            
            for (int o = 0; o < this.matSize; o++){
                x[o] = b[o]/this.getElement(o, o);
            }
            
            // http://mathfaculty.fullerton.edu/mathews/n2003/BackSubstitutionMod.html
            for (int i = this.matSize-1; i >= 0; i--){
                double sum = 0;
                for (int j = i+1; j < this.matSize; j++){
                    sum += this.getElement(i, j)*x[j];
                }
                x[i] = (b[i] - (sum))/this.getElement(i, i);
            }
        }
        return x; 
    }
}