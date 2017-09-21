import java.util.ArrayList;
import java.util.Scanner;


@SuppressWarnings("all")
public class MatrixCalculator {

	public static ArrayList <matrix> array= new ArrayList<matrix>(); 
	public static void main(String[] args) {


		Scanner inputVal = new Scanner(System.in);
		//matrix obj=new matrix();
		//matrix obj1=new matrix();
		
		//createMatrix(inputVal,obj);
		//createMatrix(inputVal,obj1);
		
		//first matrix
		
		System.out.println("enter no. of rows of first matrix");
		int row1=inputVal.nextInt();
		
		System.out.println("enter no. of columns of first matrix");
		int col1=inputVal.nextInt();
		
		System.out.println("enter values for first matrix");
		
		int matrix1[][]=new int[row1][col1];
		
		for(int i=0;i<row1;i++) {
			for(int j=0;j<col1;j++) {
				matrix1[i][j]=inputVal.nextInt();
			}	
		}
		System.out.println("2nd matrix is: ");
		for(int i=0;i<row1;i++) {
			for(int j=0;j<col1;j++) {
				System.out.print(matrix1[i][j]+" ");
			}	
			System.out.println();
		}
		//2nd matrix
		
		System.out.println("enter no. of rows of 2nd matrix");
		int row2=inputVal.nextInt();
		
		System.out.println("enter no. of columns of 2nd matrix");
		int col2=inputVal.nextInt();
		
		System.out.println("enter values for 2nd matrix");
		
		int matrix2[][]=new int[row2][col2];
		
		for(int i=0;i<row2;i++) {
			for(int j=0;j<col2;j++) {
				matrix2[i][j]=inputVal.nextInt();
			}	
		}
		System.out.println("2nd matrix is: ");
		for(int i=0;i<row2;i++) {
			for(int j=0;j<col2;j++) {
				System.out.print(matrix2[i][j]+" ");
			}	
			System.out.println();
		}
		int x=1;
		while (x != 0) {
			System.out.println("enter the equation you want to evaluate\n"
					+ "e.g. A + B,spaces need to placeed before and after the operator\n"
					+ "+ for addition\n"
					+ "- for subtraction\n"
					+ "* for multiplication\n"
					+ "/ for scalar multiplication\n"
					+ "^ for transpose\n"
					+ "! for inverse\n");
			String equation = inputVal.nextLine();
			String equation1 = inputVal.nextLine();

			String[] split = equation1.split("\\s");
			for (String s : split) {

				//System.out.println(s.length() + s);
				switch (s.charAt(0)) {
				case '+':
					addMatrices(matrix1, matrix2);
					break;
				case '-':
					subMatrices(matrix1, matrix2);
					break;
				case '*':
					mulMatrices(matrix1, matrix2);
					break;
				case '/':
					System.out.println("enter the scalar you want to multiply the matrix with");
					int scalar=inputVal.nextInt();
					scalarMulMatrices(matrix1,scalar);
					break;
				case '^':
					System.out.println("trans");
					transposeMatrices(matrix1);
					break;
				case '!':
					System.out.println("inverse");
					inverseMatrices(matrix1);
					break;
				default:
					//System.out.println("default");
					break;
				}
			}
			System.out.println("press1 to continue,0 to exit");
			x=inputVal.nextInt();
		}
	}
	
	public static int[][] addMatrices(int[][] m1,int[][] m2){
		int a=m1.length;//rows
		int b=m1[0].length;//columns
		int matrixR[][]=new int[a][b];
		//calculates sum of matrices
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				matrixR[i][j]= m1[i][j] + m2[i][j];
			}	
		}
		//displays the resultant matrix after addition
		System.out.println("sum of matrices is: ");
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(matrixR[i][j]+" ");
			}	
			System.out.println();
		}
		return matrixR;
	}	
	
	
	public static int[][] subMatrices(int[][] m1,int[][] m2){
		int a=m1.length;//rows
		int b=m1[0].length;//columns
		int matrixR[][]=new int[a][b];
		//calculates difference of matrices
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				matrixR[i][j]= m1[i][j] - m2[i][j];
			}	
		}
		//displays the resultant matrix after subtraction
		System.out.println("difference of matrices is: ");
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(matrixR[i][j]+" ");
			}	
			System.out.println();
		}
		return matrixR;
	}	

	public static int[][] mulMatrices(int[][] m1,int[][] m2){
		int a1=m1.length;//rows in obj.matrix
		int b1=m1[0].length;//columns in obj.matrix
		
		int a2=m2.length;//rows in matrix2
		int b2=m2[0].length;//columns in matrix2
		
		if(b1!=a2) {
			System.out.println("matrix multiplication cannot be performed"
					+ "on rectangular matrices");
			return null;
		}
		else {
			int matrixR[][] = new int[a1][b2];

			// calculates product of matrices
			for (int i = 0; i < a1; i++) {
				for (int j = 0; j < b2; j++) {
					for (int k = 0; k < b1; k++) {
						matrixR[i][j] = matrixR[i][j] + m1[i][k] * m2[k][j];
					}
				}
			}
			// displays the resultant matrix after multiplication
			System.out.println("product of matrices is: ");
			for (int i = 0; i < a1; i++) {
				for (int j = 0; j < b2; j++) {
					System.out.print(matrixR[i][j] + " ");
				}
				System.out.println();
			}
			return matrixR;
		}
	}
	
	public static int[][] scalarMulMatrices(int[][] m1,int scalar){
		int a=m1.length;//rows
		int b=m1[0].length;//columns
		int matrixR[][]=new int[a][b];
		
		
		//calculates scalar multiplication of matrices
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				matrixR[i][j]= scalar * m1[i][j];
			}	
		}
		
		//displays the resultant matrix after scalar multiplication
		
		System.out.println("scalar multiplication of matrices is: ");
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(matrixR[i][j]+" ");
			}	
			System.out.println();
		}
		return matrixR;
	}
	
	public static int[][] transposeMatrices(int[][] m1){
		int a=m1.length;//rows
		int b=m1[0].length;//columns
		int matrixR[][]=new int[a][b];
		//calculates transpose of matrices
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				matrixR[j][i]= m1[i][j];
			}	
		}
		//displays the resultant matrix after addition
		System.out.println("transpose of matrices is: ");
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(matrixR[i][j]+" ");
			}	
			System.out.println();
		}
		return matrixR;
	}
	
	public static int[][] inverseMatrices(int[][] m1) {
		int a = m1.length;// rows
		int b = m1[0].length;// columns
		int matrixR[][] = new int[a][b];

		int i;
		int det = (m1[0][0] * m1[1][1]) - (m1[0][1] * m1[1][0]);
		if(det==0) {
			System.out.println("determinat is 0,inverse impossible");
			return null;
		}else {
		matrixR[0][0] = m1[1][1];
		matrixR[0][1] = -1 * m1[0][1];
		matrixR[1][0] = -1 * m1[1][0];
		matrixR[1][1] = m1[0][0];
		for (i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				matrixR[i][j] = (int) (matrixR[i][j]) / det;
			}
		}

		// displays the resultant matrix after inverse
		System.out.println("inverse of matrices is: ");
		for (i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print(matrixR[i][j] + " ");
			}
			System.out.println();
		}
		return matrixR;
		}
	}/**/
}

class matrix{
//public String matrixName;
public int matrix[][];
public int row;
int col;

public void setProperties(String n, int[][] m,int r,int c) {
	//matrixName=n;
	row=r;
	col=c;
	matrix=new int[r][c];
}
}