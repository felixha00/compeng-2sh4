import java.util.Scanner;

public class ha_felix_400190708_lab04_section03_question1 {

public static void main (String[] args){
    
    
    int table[][] = {{1,2,3},{4,5,6},{7,8,9}};
    int addingTable[][] = {{1,2,3},{4,5,6},{7,8,9}};
    Matrix m = new Matrix(table);
    Matrix adding = new Matrix(addingTable);
    int x = m.getElement(0,1);
    int y = m.getElement(9,1);
    
    System.out.printf("Element x: %d, Element y: %d", x, y);

    System.out.printf("\n%s, %d",m.setElement(99, 0, 1), m.getElement(0,1));
    
    System.out.printf("\n%s", m.MatToString());
    
    // COPY MATRIX
    Matrix mcopy = m.copy();

    // ADD MCOPY TO MATRIX M 
    m.addTo(mcopy);
    System.out.printf("mcopy added to m: \n%s", m.MatToString());
    

    // THROWS INVALID OPERATION
    m.addTo(adding);
    System.out.printf("adding added to m: \n%s", m.MatToString());

    // SUBMATRIX 
    Matrix submat = m.subMatrix(2, 2);
    System.out.printf("2x2 Submatrix of m: \n%s", submat.MatToString());

    int upp[][] = {{1,1,1}, {0,1,1}}; // matrix to check upper triangularness
    Matrix uppTrMat = new Matrix(upp);

    System.out.printf("Upper Triangular Matrix: \n%s", uppTrMat.MatToString());
    System.out.printf("Upper Triangular:%s", uppTrMat.isUpperTr());

    // MATRIX ARRAY
    int mat1t[][] = {{1,2},{3,4}};
    Matrix mat1 = new Matrix(mat1t);
    int mat2t[][] = {{5,6},{7,8}};
    Matrix mat2 = new Matrix(mat2t);  
    int mat3t[][] = {{9,10},{11,12}};
    Matrix mat3 = new Matrix(mat3t);  

    Matrix matArray[] = {mat1,mat2,mat3};
    /*
    Matrix sumArray = sum(matArray);

    System.out.printf("Summed Matrix \n%s", sumArray.MatToString());
    */
    /*
    ==================
    UPPER TRIANGULAR MATRIX
    ==================
    */

    UpperTriangularMatrix uppTr = new UpperTriangularMatrix(3);

    uppTr.print1DArray();
    }   
}