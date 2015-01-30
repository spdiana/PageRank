package pagerank;

import graph.Graph;
import graph.Node;
import JamaSparseMatrix.SparseMatrixCompressedRS;

/**
 * PageRank is an algorithm used by Google Search to rank websites in their search engine results.
 * http://introcs.cs.princeton.edu/java/16pagerank/
 * 
 * This class provides simplification to calculate the transition matrix computation
 * @author dcc
 *
 */
public class MatrixPageRank {

	private int N;
	private Graph graph;
	private SparseMatrixCompressedRS matrixPR;


	public MatrixPageRank(Graph graph) {
		this.graph = graph;
		this.N = graph.getNumNodes();
		matrixPR = new SparseMatrixCompressedRS(N, N);
		computeMatrixPageRank();
	}


	private SparseMatrixCompressedRS computeMatrixPageRank() {
		SparseMatrixCompressedRS adjMatrix = graph.getAdjacencyMatrix();

		float teleporting = 1f/N;

		float alpha = 0.85f;
		float dumpingFactor = (1-alpha);

		float initialRank =  1f/N;

		for (int i = 0; i < N; i++) {
			float outlink = 0;
			float vvalue = 0;
			float mQET =0;
			float rank = 0;
			Node node = graph.getNodes().get(i);
			outlink = node.getOutgoingEdges().size();

			if (outlink == 0) {
				mQET = initialRank;	
			} 

			if (outlink != 0) {
				vvalue = 1f/outlink;
			}

			for (int j = 0; j < N; j++) {
				float mQ =0;
				float mR = 0;
				if (adjMatrix.exists(i, j)){
					mQ = vvalue;
				}

				float value = alpha *( mQ + mQET);

				mR = dumpingFactor * teleporting;

				rank = value + mR;
				matrixPR.set(i, j, rank);
			}
		}
		return matrixPR;
	}

	public SparseMatrixCompressedRS getMatrixPR() {
		return matrixPR;
	}


	public void printMatrix() { 
		System.out.print ("     ");
		for (int i = 0; i <= N-1; i++) {
			System.out.print (i + "     "); 
		}
		System.out.println ();
		for (int i = 0; i < N; i++) { 
			System.out.print (i  + "  ");
			for (int j = 0; j < N; j++) {
				if (matrixPR.exists(i, j)) {
					System.out.printf("["+ "%.5f" +"]" + " ",  matrixPR.get(i, j));
				} 	else {
					System.out.print ("["+ 0.0 +"]" + " ");
				}
			}
			System.out.println ();
		}
		System.out.println("--------------------------------");
	}
}
