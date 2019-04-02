package graph;

import java.util.List;
/**
 * 
 * @author dcc
 *
 */
public class TestGraph {


	public static void main(String[] args) {

		Node a0 = new Node(0, "Germany");
		Node a1 = new Node(1, "France");
		Node a2 = new Node(2, "Switzerland");

		Graph graph = new Graph();
		graph.addNode(a0);
		graph.addNode(a1);
		graph.addNode(a2);

		graph.addEdge(a0, a1);
		graph.addEdge(a1, a2);
		graph.addEdge(a2, a0);
		graph.addEdge(a0, a2);

		System.out.println("Number of nodes: " + graph.getNumNodes());
		System.out.println("Number of edges: " + graph.getNumEdges());
		System.out.println("Out-degree of node: " + graph.getNumOutDegreeNode(a0));
		System.out.println("In-degree of nodes: " + graph.getNumInDegreeNode(a0));

		Node nn = graph.getOpposite(a0, new Edge(a0, a1));
		System.out.println(nn.getLabel() + " opposite");

		List<Node> ln = graph.getNeighbors(a0);
		for (Node node : ln) {
			System.out.println("Neighborhood: "+node.getLabel());
		}

		List<Node> lin = graph.getInDegreeNodes(a0);
		for (Node node : lin) {
			System.out.println("Nodes in: "+node.getLabel());
		}

		List<Edge> ed = graph.getOutEdgesNode(a0);
		for (Edge edge : ed) {
			System.out.println("Out Edge: "+ edge.getFrom().getLabel() + " "+ edge.getTo().getLabel());
		}

		List<Edge> edd = graph.getInEdgesNode(a0);
		for (Edge edge : edd) {
			System.out.println("In Edge: "+ edge.getFrom().getLabel() + " "+ edge.getTo().getLabel());
		}
	}
}
