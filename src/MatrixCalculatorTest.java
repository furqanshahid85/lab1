import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixCalculatorTest {

	// subtraction test
	@Test
	public void test() {
		MatrixCalculator obj= new MatrixCalculator();
		int a[][]= {{1,1},{1,2}};
		int b[][]={{1,3},{1,2}};
		int c[][]={{2,5},{3,7}};
		assertArrayEquals(c,obj.mulMatrices(a, b));
	}
	@Test
	public void test1() {
		MatrixCalculator obj= new MatrixCalculator();
		int a[][]= {{1,1},{1,2}};
		int b[][]={{1,3},{1,2}};
		int c[][]={{2,4},{2,4}};
		assertArrayEquals(c,obj.addMatrices(a,b));
	}
	@Test
	public void test3() {
		MatrixCalculator obj= new MatrixCalculator();
		int a[][]= {{1,1},{1,2}};
		int b[][]={{1,3},{1,2}};
		int c[][]={{0,-2},{0,0}};
		assertArrayEquals(c,obj.subMatrices(a,b));
	}
	
	@Test
	public void test4() {
		MatrixCalculator obj= new MatrixCalculator();
		int a[][]= {{1,1},{1,2}};
		int b[][]={{1,3},{1,2}};
		int c[][]={{3,3},{3,6}};
		assertArrayEquals(c,obj.scalarMulMatrices(a,3));
	}
	@Test
	public void test5() {
		MatrixCalculator obj= new MatrixCalculator();
		int a[][]= {{1,1},{1,2}};
		int b[][]={{1,3},{1,2}};
		int c[][]={{2,-1},{-1,1}};
		assertArrayEquals(c,obj.inverseMatrices(a));
	}
	
	@Test
	public void test6() {
		MatrixCalculator obj= new MatrixCalculator();
		int a[][]= {{1,1},{1,2}};
		int b[][]={{1,3},{1,2}};
		int c[][]={{1,1},{1,2}};
		assertArrayEquals(c,obj.transposeMatrices(a));
	}

}
