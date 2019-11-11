public class Matrix {
    private int numRow;
    private int numCol;
    private int mat[][];

    public Matrix(int row, int col) {

        if (row <= 0 || col <= 0) {
            this.numRow = 3;
            this.numCol = 3;
            this.mat = new int[3][3];
        } else {
            this.numRow = row;
            this.numCol = col;
            this.mat = new int[row][col];
        }

    }

    public Matrix(int[][] table) {
        this.numRow = table.length;
        this.numCol = table[0].length;
        this.mat = table;

    }

    public int getElement(int i, int j) throws IndexOutOfBoundsException { // works
        try {
            return this.mat[i][j]; // return element at ij

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid Indexes");
            return -1;
        }

    }

    public boolean setElement(int x, int i, int j) { // works
        if (i > this.numRow || j > this.numCol) { // make sure ij does not exceed reference dimension
            return false;
        } else {
            this.mat[i][j] = x;
            return true;
        }

    }

    public Matrix copy() {

        Matrix matcpy = new Matrix(this.numRow, this.numCol);
        for (int i = 0; i < this.numRow; i++) {
            for (int j = 0; j < this.numCol; j++) {
                matcpy.setElement(this.getElement(i, j), i, j); // copies reference matrix values into new matrix
            }
        }
        return matcpy;
    }

    public void addTo(Matrix m) throws ArithmeticException {

        if (this.numRow != m.numRow || this.numCol != m.numCol) { // checks if the two matrix arent the same dimension
            throw new ArithmeticException("Invalid Operation");
        }
        try {
            for (int i = 0; i < this.numRow; i++) {
                for (int j = 0; j < this.numCol; j++) {
                    int elemVal = this.getElement(i, j) + m.getElement(i, j); // adds elements together
                    this.setElement(elemVal, i, j);
                }
            }

        } catch (ArithmeticException e) { // catch errors
            System.out.println("Invalid Operation");
        }
    }

    public Matrix subMatrix(int i, int j) throws ArithmeticException {

        try {
            if (i >= this.numRow || j >= this.numCol) { // check that the submatrix i j parameters smaller than the
                                                        // original matrix
                throw new ArithmeticException("Submatrix not defined");
            }
            Matrix submatrix = new Matrix(i, j); // creates new matrix
            for (int row = 0; row < i; row++) {
                for (int col = 0; col < j; col++) {
                    submatrix.setElement(this.getElement(row, col), row, col); // sets the element at ij to be the
                                                                               // reference element's value
                }
            }
            return submatrix;
        } catch (ArithmeticException e) { // catch arithmetic exception
            System.out.println("Submatrix not defined");
            throw e;

        }

    }

    public boolean isUpperTr() {
        for (int i = 0; i < this.numRow; i++) {
            for (int j = 0; j < i; j++) {
                if (this.getElement(i, j) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    

    public static Matrix sum(Matrix[] matArray) throws ArithmeticException {
        rowLen = matArray[0].numRow;
        colLen = matArray[0].numCol;
        Matrix sumMat = new Matrix(rowLen, colLen);
        try {
            for (int i = 0; i < matArray.length; i++) {
                if (matArray[i].numRow != rowLen || matArray[i].numCol != colLen) {
                    throw new ArithmeticException("Matrixes don't have the same dimensions");
                } else

                {
                    for (int j = 0; j < rowLen; j++) {
                        for (int k = 0; k < colLen; k++) {
                            sumMat.setElement(sumMat.getElement(j, k) + matArray[i].getElement(j, k), j,k);
                        }
                    }
                }
            }
            return sumMat;
        } catch (ArithmeticException e) {
            System.out.println("Matrixes don't have the same dimensions");
            return e;
        }
    }

    public String MatToString() {

        String matOut = "";
        for (int i = 0; i < this.numRow; i++) {

            for (int j = 0; j < this.numCol; j++) {
                matOut += Integer.toString(this.getElement(i, j)) + "\t";
            }
            matOut += "\n";
        }

        return matOut;
    }

    public int getRows(){
        return this.numRow;
    }

    public int getCols(){
        return this.numCol;
    }

}
