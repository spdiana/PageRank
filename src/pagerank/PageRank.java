package pagerank;

import graph.Graph;
import graph.SampleGraph;

import java.io.IOException;
/**
 * Unit test.
 * @author dcc
 *
 */
public class PageRank {

	public static void main(String[] args) throws IOException {
		long end = 0, current;
		current = System.currentTimeMillis();
		
		Graph graph = new SampleGraph().graph2();
		
		MatrixPageRank pr = new MatrixPageRank(graph);
		System.out.println("Matrix PageRank: \n");
		pr.printMatrix();
		
		System.out.println("\nVector PageRank: ");
		VectorPageRank.markovChain(pr.getMatrixPR());
		
		end += System.currentTimeMillis() - current;
		System.out.println("\n\nTemp: " + end + " ms");
	}
}
