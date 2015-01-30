package pagerank;

import JamaSparseMatrix.SparseMatrixCompressedRS;

/**
 * MarkovChain to compute vector pageRank
 * See http://introcs.cs.princeton.edu/java/95linear/MarkovChain.java.html
 * @author dcc
 *
 */
public class VectorPageRank {


	public static void markovChain(SparseMatrixCompressedRS matrixPageRank) {
		int N = matrixPageRank.getRowDimension();

		SparseMatrixCompressedRS A = matrixPageRank.transpose();

		double[] vector = new double[N];

		for (int i = 0; i < vector.length; i++) {
			vector[i]=  1.0 / N;
		}

		SparseMatrixCompressedRS B =  A.minus(SparseMatrixCompressedRS.identity(N, N));
		for (int j = 0; j < N; j++) {
			B.set(0, j, 1.0);
		}

		double[] b = new double[N];
		b[0] = 1.0;
		vector = B.solve(b);

		for (int i = 0; i < vector.length; i++) {
			//BigDecimal big = new BigDecimal(vector[i], MathContext.DECIMAL128);
			System.out.printf("\n["+ "%.10f" +"]" + " ",  vector[i]);
			//System.out.println(big);
		}
	}

}

