import java.util.Scanner;

public class bonus_quiz5 {

    public static void main(String args[]){
        int N,M; 
        
        System.out.println("Hello");
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter N:");
        N = input.nextInt();  
        System.out.println("\nEnter M:");
        M = input.nextInt(); 

        int[][] mat = new int [N][M]; 
        for (int n = 0; n < N; n++){
            for (int m = 0; m < M; m++){
                System.out.printf("Enter number for [%d][%d]: ",n, m);
                mat[n][m] = input.nextInt(); 
            }
        }

        // transpose

        int[][] transpose = new int[M][N];

        for (int n = 0; n < N; n++){
            for (int m = 0; m < M; m++){
               
                transpose[m][n] = mat[n][m];
                
            }
        }
        
        System.out.println("TRANSPOSED");
        for (int m = 0; m < M; m++){
            for (int n = 0; n < N; n++){
               
                System.out.printf("%d ", transpose[m][n]);
                
            }
            System.out.println("\n");
        }

    }
}