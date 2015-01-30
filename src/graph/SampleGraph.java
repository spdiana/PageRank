package graph;

import graph.Node;
/**
 * Represents samples of graphs.
 * @author dcc
 *
 */
public class SampleGraph {

	public Graph graph1() {
		Graph gra = new Graph();

		Node a0 = new Node(0);
		Node a1 = new Node(1);
		Node a2 = new Node(2);

		gra.addNode(a0);
		gra.addNode(a1);
		gra.addNode(a2);

		gra.addEdge(a0, a1, 1f);
		gra.addEdge(a1, a2, 2f);
		gra.addEdge(a2, a0, 1f);
		gra.addEdge(a0, a2, 2f);
		return gra;
	}

	public Graph graph2() {
		Graph gra = new Graph();

		Node alpha = new Node(1);
		Node delta = new Node(2);
		Node beta = new Node(3);
		Node gamma = new Node(4);
		Node sigma = new Node(5);
		Node rho = new Node(6);

		gra.addNode(alpha);
		gra.addNode(delta);
		gra.addNode(beta);
		gra.addNode(gamma);
		gra.addNode(sigma);
		gra.addNode(rho);

		gra.addEdge(delta, alpha);
		gra.addEdge(alpha, beta);
		gra.addEdge(alpha, sigma);

		gra.addEdge(sigma, alpha);
		gra.addEdge(beta, delta);
		gra.addEdge(beta, gamma);

		gra.addEdge(gamma, delta);
		gra.addEdge(gamma, sigma);
		gra.addEdge(gamma, rho);

		return gra;
	}

	public Graph graph3() {
		Graph gra = new Graph();


		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(5);

		gra.addNode(a1);
		gra.addNode(a2);
		gra.addNode(a3);
		gra.addNode(a4);
		gra.addNode(a5);


		gra.addEdge(a1, a2);
		gra.addEdge(a1, a4);
		gra.addEdge(a2, a3);
		gra.addEdge(a2, a5);
		gra.addEdge(a3, a2);
		gra.addEdge(a4, a1);
		gra.addEdge(a5, a3);
		gra.addEdge(a5, a1);
		gra.addEdge(a5, a4);
		return gra;
	}

	public Graph graph4() {
		Graph gra = new Graph();

		Node aa = new Node(1);
		Node bb = new Node(2);
		Node cc = new Node(3);
		Node dd = new Node(4);
		Node ee = new Node(5);
		Node ff = new Node(6);

		gra.addNode(aa);
		gra.addNode(bb);
		gra.addNode(cc);
		gra.addNode(dd);
		gra.addNode(ee);
		gra.addNode(ff);


		gra.addEdge(aa, bb);
		gra.addEdge(aa, ee);
		gra.addEdge(bb, cc);
		gra.addEdge(bb, dd);
		gra.addEdge(cc, dd);
		gra.addEdge(cc, ff);
		gra.addEdge(cc, ee);
		gra.addEdge(dd, aa);
		gra.addEdge(ee, aa);

		return gra;
	}
	
	public Graph graph5() {
		Graph graph = new Graph();

		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(5);
		Node a6 = new Node(6);

		graph.addNode(a1);
		graph.addNode(a2);
		graph.addNode(a3);
		graph.addNode(a4);
		graph.addNode(a5);
		graph.addNode(a6);

		graph.addEdge(a2, a1);
		graph.addEdge(a2, a3);
		graph.addEdge(a3, a1);
		graph.addEdge(a3, a2);
		graph.addEdge(a3, a4);
		graph.addEdge(a4, a5);
		graph.addEdge(a4, a6);
		graph.addEdge(a5, a4);
		graph.addEdge(a5, a6);
		graph.addEdge(a6, a4);
		
		return graph;
	}
	
	public Graph graph6() {
		Graph graph = new Graph();

		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);

		graph.addNode(a1);
		graph.addNode(a2);
		graph.addNode(a3);

		graph.addEdge(a1, a2);
		graph.addEdge(a2, a1);
		graph.addEdge(a1, a3);
		graph.addEdge(a3, a1);
		graph.addEdge(a3, a2);
		
		return graph;
	}
	
	public Graph graph7() {
		Graph graph = new Graph();

		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(5);
		Node a6 = new Node(6);
		Node a7 = new Node(7);
		Node a8 = new Node(8);
		Node a9 = new Node(9);
		Node a10 = new Node(10);

		graph.addNode(a1);
		graph.addNode(a2);
		graph.addNode(a3);
		graph.addNode(a4);
		graph.addNode(a5);
		graph.addNode(a6);
		graph.addNode(a7);
		graph.addNode(a8);
		graph.addNode(a9);
		graph.addNode(a10);

		graph.addEdge(a2, a1);
		graph.addEdge(a2, a3);
		graph.addEdge(a3, a1);
		graph.addEdge(a3, a2);
		graph.addEdge(a3, a4);
		graph.addEdge(a4, a5);
		graph.addEdge(a4, a6);
		graph.addEdge(a5, a4);
		graph.addEdge(a5, a6);
		graph.addEdge(a6, a4);
		
		graph.addEdge(a7, a4);
		graph.addEdge(a7, a6);
		graph.addEdge(a2, a7);
		graph.addEdge(a5, a8);
		graph.addEdge(a3, a8);
		graph.addEdge(a9, a5);
		graph.addEdge(a9, a2);
		graph.addEdge(a3, a9);
		graph.addEdge(a6, a10);
		graph.addEdge(a4, a10);
		
		return graph;
	}
	
}
